package io.jianxun.web.business.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.jianxun.extend.domain.business.Depart;
import io.jianxun.extend.domain.business.User;
import io.jianxun.extend.service.LocaleMessageSourceService;
import io.jianxun.extend.service.business.DepartService;
import io.jianxun.extend.service.business.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	@Autowired
	private DepartService departService;

	@Autowired
	private LocaleMessageSourceService localeMessageSourceService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final User user = (User) target;
		final String username = user.getUsername();
		final Long id = user.getId();
		if (!userService.validateUsernameUnique(username, id))
			errors.rejectValue("username", "username.unique",
					localeMessageSourceService.getMessage("user.username.isUsed", new Object[] { username }));
		final Depart depart = user.getDepart();
		if (depart == null || depart.getId() == null) {
			errors.rejectValue("depart", "depart.notfound", localeMessageSourceService.getMessage("depart.notfound"));
			return;
		}
		Depart d = departService.findActiveOne(depart.getId());
		if (d == null)
			errors.rejectValue("depart", "depart.notfound", localeMessageSourceService.getMessage("depart.notfound"));
	}

}
