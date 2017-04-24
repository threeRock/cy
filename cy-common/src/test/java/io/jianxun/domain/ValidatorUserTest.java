package io.jianxun.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Test;

import io.jianxun.extend.domain.business.User;

public class ValidatorUserTest extends AbstractValidator {

	@Test
	public void shouldNotValidateWhenUserNameEmpty() {

		// LocaleContextHolder.setLocale(Locale.ENGLISH);
		User sysUser = new User();
		sysUser.setUsername(" ");
		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(sysUser);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isIn( "username");
		assertThat(violation.getMessage()).isIn("用户名不能为空");
	}

	@Test
	public void shouldValidateWhenUserNameNotEmpty() {
		User sysUser = new User();
		sysUser.setUsername("tttttt");
		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(sysUser);
		assertThat(constraintViolations.size()).isEqualTo(0);
	}

}
