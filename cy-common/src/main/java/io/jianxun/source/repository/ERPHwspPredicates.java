package io.jianxun.source.repository;

import com.querydsl.core.types.Predicate;

import io.jianxun.source.domain.QERPHwsp;

public class ERPHwspPredicates {

	public static Predicate erpSpidPredicate(String spid) {
		QERPHwsp er = QERPHwsp.eRPHwsp;
		return er.id.spid.eq(spid);
	}

}
