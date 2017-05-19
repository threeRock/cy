package io.jianxun.web.business.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.jianxun.extend.domain.business.Depart;
import io.jianxun.extend.domain.business.MedicamentCatetory;
import io.jianxun.extend.service.LocaleMessageSourceService;
import io.jianxun.extend.service.business.MedicamentCategoryService;

@Component
public class MedicamentCategoryValidator implements Validator {

	@Autowired
	private MedicamentCategoryService medicamentCategoryService;

	@Autowired
	private LocaleMessageSourceService localeMessageSourceService;

	@Override
	public boolean supports(Class<?> clazz) {
		return MedicamentCatetory.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final Depart depart = (Depart) target;
		final String name = depart.getName();
		final Long id = depart.getId();
		if (StringUtils.isBlank(name))
			errors.rejectValue("name", "name.notblank",
					localeMessageSourceService.getMessage("medicamentCategory.name.notblank"));
		if (!medicamentCategoryService.validateNameUnique(name, id))
			errors.rejectValue("name", "name.unique",
					localeMessageSourceService.getMessage("medicamentCategory.name.isUsed", new Object[] { name }));

	}

}
