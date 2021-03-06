package io.jianxun.web.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.jianxun.extend.service.business.DepartService;
import io.jianxun.extend.service.business.UserService;
import io.jianxun.source.repository.ERPHuoweizlRepository;
import io.jianxun.source.repository.ERPMedicamentBatchRepository;
import io.jianxun.source.repository.ERPMedicamentRepository;

@Controller
public class LoginController {

	@Autowired
	private ERPMedicamentRepository erpMedicamentRepository;
	@Autowired
	private ERPMedicamentBatchRepository eRPMedicamentBatchRepository;
	@Autowired
	private ERPHuoweizlRepository eRPHuoweizlRepository;

	@GetMapping(value = "login")
	public String loginForm() {
		System.out.println("__________________"+erpMedicamentRepository.count());
		System.out.println("__________________"+eRPMedicamentBatchRepository.count());
		System.out.println("__________________"+eRPHuoweizlRepository.count());
		userService.createAdminIfInit(departService.initRoot());
		return "login";
	}

	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	@Autowired
	private UserService userService;
	@Autowired
	private DepartService departService;
	

}
