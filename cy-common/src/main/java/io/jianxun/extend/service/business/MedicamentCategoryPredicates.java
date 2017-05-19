package io.jianxun.extend.service.business;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.QMedicamentCatetory;

/**
 * 角色查询
 * 
 * @author Administrator
 *
 */
public class MedicamentCategoryPredicates {

	private MedicamentCategoryPredicates() {
	}

	// 名称查询
	public static Predicate namePredicate(String name) {
		return nameAndIdNotPredicate(name, null);
	}

	public static Predicate nameAndIdNotPredicate(String name, Long id) {
		QMedicamentCatetory medicamentCatetory = QMedicamentCatetory.medicamentCatetory;
		if (id == null)
			return medicamentCatetory.name.eq(name);
		return medicamentCatetory.id.ne(id).and(medicamentCatetory.name.eq(name));
	}

}
