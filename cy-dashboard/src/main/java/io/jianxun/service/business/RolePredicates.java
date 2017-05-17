package io.jianxun.service.business;

import com.querydsl.core.types.Predicate;

import io.jianxun.domain.business.QRole;

public class RolePredicates {

	private RolePredicates() {
	}
	
	// 角色名查询
	public static Predicate namePredicate(String name) {
		return nameAndIdNotPredicate(name, null);
	}

	public static Predicate nameAndIdNotPredicate(String name, Long id) {
		QRole role = QRole.role;
		if (id == null)
			return role.name.eq(name);
		return role.id.ne(id).and(role.name.eq(name));
	}
}