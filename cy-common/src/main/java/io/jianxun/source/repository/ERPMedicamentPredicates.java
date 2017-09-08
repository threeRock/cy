package io.jianxun.source.repository;

import com.querydsl.core.types.Predicate;

import io.jianxun.source.domain.QERPMedicament;

public class ERPMedicamentPredicates {

	private ERPMedicamentPredicates() {
	}

	public static Predicate erpSpidPredicate(String spid) {
		QERPMedicament er = QERPMedicament.eRPMedicament;
		return er.id.spid.eq(spid);
	}

	public static Predicate erpSpmchPredicate(String spmch) {
		QERPMedicament er = QERPMedicament.eRPMedicament;
		return er.spmch.containsIgnoreCase(spmch);
	}

	public static Predicate fenleiPredicate(String fenleiId) {
		QERPMedicament er = QERPMedicament.eRPMedicament;
		return er.padflid.startsWith(fenleiId);
	}

}
