package io.jianxun.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jianxun.config.JwtTokenUtil;
import io.jianxun.extend.domain.business.User;
import io.jianxun.extend.service.business.UserService;
import io.jianxun.rest.vo.LoginVo;
import io.jianxun.rest.vo.ReturnVo;
import io.jianxun.rest.vo.TokenVo;
import io.jianxun.service.AuthService;

@RestController
public class AuthController {

	private static Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthService authService;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	// 登录
	@PostMapping(value = "auth/login")
	public ReturnVo<TokenVo> createAuthenticationToken(@RequestBody LoginVo loginVo) {
		logger.info("登录并获取令牌");
		final String token = authService.login(loginVo.getUsername(), loginVo.getPassword());
		return ReturnVo.ok(new TokenVo(token));
	}

	// 注册 （上线去掉）
	@PostMapping(value = "auth/register")
	public User register(@RequestBody User user) {
		return authService.register(user);
	}

	@PostMapping(value = "auth/refresh")
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User user = (User) userService.loadUserByUsername(username);

		if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshedToken = jwtTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new TokenVo(refreshedToken));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

}
