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

}
