package io.jianxun.extend.service.business;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.QUser;

/**
 * 用户相关查询条件
 * 
 * @author Administrator
 *
 */
public class UserPredicates {

	private UserPredicates() {
	}

	// 用户名查询
	public static Predicate usernamePredicate(String username) {
		QUser user = QUser.user;
		return user.username.eq(username);
	}

	// 用户名及ID查询
	public static Predicate usernameAndIdNotPredicate(String username, Long id) {
		QUser user = QUser.user;
		if (id == null)
			return user.username.eq(username);
		return user.id.ne(id).and(user.username.eq(username));
	}

}