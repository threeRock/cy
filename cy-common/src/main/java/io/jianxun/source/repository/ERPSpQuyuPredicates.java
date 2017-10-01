package io.jianxun.source.repository;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import io.jianxun.source.domain.QERPSpQuyu;

public class ERPSpQuyuPredicates {

	public static Predicate erpSpidPredicate(String spid) {
		QERPSpQuyu er = QERPSpQuyu.eRPSpQuyu;
		return er.id.spid.eq(spid).and(er.beactive.eq("是"));
	}

	public static Predicate erpSpQuyuPredicate(String spQuyu) {
		QERPSpQuyu er = QERPSpQuyu.eRPSpQuyu;
		return er.id.khquyu.contains(spQuyu);
	}

	public static Predicate erpSpidAnderpSpQuyuPredicate(String spid, String spQuyu) {
		return ExpressionUtils.and(erpSpidPredicate(spid), erpSpQuyuPredicate(spQuyu));
	}

}
