package io.jianxun.source.repository;

import com.querydsl.core.types.Predicate;

import io.jianxun.source.domain.QERPSphwph;

public class ERPSphwphPredicates {

	public static Predicate erpSpidPredicate(String spid) {
		QERPSphwph er = QERPSphwph.eRPSphwph;
		return er.id.spid.eq(spid);
	}

}
