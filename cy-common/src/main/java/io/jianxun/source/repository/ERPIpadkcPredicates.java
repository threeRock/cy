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

	public static Predicate zjmPredicate(String zjm) {
		QERPIpadkc eIpadkc = QERPIpadkc.eRPIpadkc;
		if (StringUtils.isBlank(zjm))
			zjm = "%";
		return eIpadkc.zjm.contains(zjm);
	}

	public static Predicate searchPredicate(String contant) {
		QERPIpadkc eIpadkc = QERPIpadkc.eRPIpadkc;
		if (StringUtils.isBlank(contant))
			contant = "%";
		return eIpadkc.spmch.contains(contant).or(eIpadkc.zjm.contains(contant));
	}

	public static Predicate sellWellsPredicate() {
		QERPIpadkc eIpadkc = QERPIpadkc.eRPIpadkc;
		return eIpadkc.is_xty.eq("是");
	}

	public static Predicate sellWellsPredicate(String contant) {
		QERPIpadkc eIpadkc = QERPIpadkc.eRPIpadkc;
		Predicate predicate = eIpadkc.is_xty.eq("是");
		if (StringUtils.isNotBlank(contant))
			predicate = eIpadkc.spmch.contains(contant).or(eIpadkc.zjm.contains(contant)).and(predicate);
		return predicate;
	}

}
