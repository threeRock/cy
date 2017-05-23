package io.jianxun.source.repository;

import com.querydsl.core.types.Predicate;

import io.jianxun.source.domain.QERPMchk;

public class ERPMchkPredicates {

	private ERPMchkPredicates() {
	}

	//
	public static Predicate demcPredicate(String dwmch) {
		QERPMchk eRPMchk = QERPMchk.eRPMchk;
		return eRPMchk.dwmch.containsIgnoreCase(dwmch);
	}

	//
	public static Predicate isxsPredicate(String isxs) {
		QERPMchk eRPMchk = QERPMchk.eRPMchk;
		return eRPMchk.isxs.eq(isxs);
	}

}
