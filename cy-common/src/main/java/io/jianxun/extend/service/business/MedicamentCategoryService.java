package io.jianxun.extend.service.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.jianxun.extend.domain.business.MedicamentCatetory;
import io.jianxun.extend.service.AbstractBaseService;

@Service
public class MedicamentCategoryService extends AbstractBaseService<MedicamentCatetory> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public boolean validateNameUnique(String name, Long id) {
		return this.repository.count(MedicamentCategoryPredicates.nameAndIdNotPredicate(name, id)) == 0;
	}

}
