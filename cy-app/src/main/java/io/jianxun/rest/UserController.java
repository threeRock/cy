package io.jianxun.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jianxun.extend.domain.business.User;
import io.jianxun.extend.service.business.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	@PreAuthorize("hasAuthority('USERLIST')")
	public List<User> list() {
		return userService.findActiveAll();
	}

}
