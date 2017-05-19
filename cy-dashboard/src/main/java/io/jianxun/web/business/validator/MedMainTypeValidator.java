package io.jianxun.web.business.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.jianxun.domain.business.MedMainType;
import io.jianxun.service.LocaleMessageSourceService;
import io.jianxun.service.business.MedMainTypeService;

@Component
public class MedMainTypeValidator implements Validator {

	@Autowired
	private MedMainTypeService mainTypeService;

	@Autowired
	private LocaleMessageSourceService localeMessageSourceService;

	@Override
	public boolean supports(Class<?> clazz) {
		return MedMainType.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final MedMainType mainType = (MedMainType) target;
		final String name = mainType.getName();
		final Long id = mainType.getId();
		if (!mainTypeService.validateNameUnique(name, id))
			errors.rejectValue("name", "name.unique",
					localeMessageSourceService.getMessage("maintype.name.isUsed", new Object[] { name }));

	}

}
