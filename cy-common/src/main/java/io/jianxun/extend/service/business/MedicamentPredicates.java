package io.jianxun.extend.service.business;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.QMedicament;

/**
 * 
 * 
 * @author Administrator
 *
 */
public class MedicamentPredicates {

	private MedicamentPredicates() {
	}
	
	public static Predicate erpSpidPredicate(String sp) {
		QMedicament med = QMedicament.medicament;
		return med.erpSpid.eq(sp);
	}
}
