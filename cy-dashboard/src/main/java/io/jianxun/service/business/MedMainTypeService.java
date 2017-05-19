package io.jianxun.service.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.jianxun.domain.business.MedMainType;
import io.jianxun.service.AbstractBaseService;

@Service
public class MedMainTypeService extends AbstractBaseService<MedMainType> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public boolean validateNameUnique(String name, Long id) {
		return 0 == countActiveAll(MedMainTypePredicates.nameAndIdNotPredicate(name, id));
	}

}
