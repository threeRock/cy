package io.jianxun.source.repository;

import com.querydsl.core.types.Predicate;

import io.jianxun.source.domain.QERPIpadkc;

public class ERPIpadkcPredicates {

	private ERPIpadkcPredicates() {
	}

	//
	public static Predicate spidPredicate(String spid) {
		QERPIpadkc eIpadkc = QERPIpadkc.eRPIpadkc;
		return eIpadkc.id.spid.eq(spid);
	}

}
