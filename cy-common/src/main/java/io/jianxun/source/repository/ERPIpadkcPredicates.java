package io.jianxun.source.repository;

import org.apache.commons.lang3.StringUtils;

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

	public static Predicate padflidPredicate(String padflid) {
		QERPIpadkc eIpadkc = QERPIpadkc.eRPIpadkc;
		return eIpadkc.padflid.startsWith(padflid);
	}

	public static Predicate spmchPredicate(String spmch) {
		QERPIpadkc eIpadkc = QERPIpadkc.eRPIpadkc;
		if (StringUtils.isBlank(spmch))
			spmch = "%";
		return eIpadkc.spmch.contains(spmch);
	}

}
