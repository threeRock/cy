package io.jianxun.extend.service.business;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.Depart;
import io.jianxun.extend.domain.business.QDepart;

/**
 * 角色查询
 * 
 * @author Administrator
 *
 */
public class DepartPredicates {

	private DepartPredicates() {
	}

	// 机构名查询
	public static Predicate namePredicate(String name) {
		return nameAndIdNotPredicate(name, null);
	}

	public static Predicate nameAndIdNotPredicate(String name, Long id) {
		QDepart depart = QDepart.depart;
		if (id == null)
			return depart.name.eq(name);
		return depart.id.ne(id).and(depart.name.eq(name));
	}

	//根据上级机构查询
	public static Predicate parentPredicate(Depart parent) {
		QDepart depart = QDepart.depart;
		return depart.parent.eq(parent);
	}

}
