package io.jianxun.source.repository;

import com.querydsl.core.types.Predicate;

import io.jianxun.source.domain.QERPPfCkhz;

public class ERPPfCkhzPredicates {

	private ERPPfCkhzPredicates() {
	}

	//
	public static Predicate dwbhPredicate(String dwbh) {
		QERPPfCkhz ckhz = QERPPfCkhz.eRPPfCkhz;
		return ckhz.dwbh.eq(dwbh);
	}

}
