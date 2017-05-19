package io.jianxun.service.business;

import com.querydsl.core.types.Predicate;

import io.jianxun.domain.business.QMedMainType;



public class MedMainTypePredicates {
	
	private MedMainTypePredicates() {
	}
	
	public static Predicate namePredicate(String name) {
		return nameAndIdNotPredicate(name, null);
	}
	
	public static Predicate nameAndIdNotPredicate(String name, Long id) {
		QMedMainType  maintype = QMedMainType.medMainType;
		if (id == null)
			return maintype.name.eq(name);
		return maintype.id.ne(id).and(maintype.name.eq(name));
	}	
}