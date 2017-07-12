package io.jianxun.source.repository;

import com.querydsl.core.types.Predicate;

import io.jianxun.source.domain.QERPSpQuyu;

public class ERPSpQuyuPredicates {

	public static Predicate erpSpidPredicate(String spid) {
		QERPSpQuyu er = QERPSpQuyu.eRPSpQuyu;
		return er.id.spid.eq(spid).and(er.beactive.eq("是"));
	}

}
