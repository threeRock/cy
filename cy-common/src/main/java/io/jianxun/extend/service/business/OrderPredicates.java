package io.jianxun.extend.service.business;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.QOrder;

/**
 * 角色查询
 * 
 * @author Administrator
 *
 */
public class OrderPredicates {

	private OrderPredicates() {
	}

	// 单位名称查询
	public static Predicate demcPredicate(String dwmch) {
		QOrder order = QOrder.order;
		return order.dwmch.contains(dwmch);
	}

}
