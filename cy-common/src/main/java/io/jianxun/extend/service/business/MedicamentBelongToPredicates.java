package io.jianxun.extend.service.business;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.QMedicamentBelongTo;

/**
 * 
 * 
 * @author Administrator
 *
 */
public class MedicamentBelongToPredicates {

	private MedicamentBelongToPredicates() {
	}

	public static Predicate erpSpidPredicate(String sp) {
		QMedicamentBelongTo medicamentBelongTo = QMedicamentBelongTo.medicamentBelongTo;
		return medicamentBelongTo.spid.eq(sp);
	}

	public static Predicate belongToPredicate(String belongTo) {
		QMedicamentBelongTo medicamentBelongTo = QMedicamentBelongTo.medicamentBelongTo;
		return medicamentBelongTo.belongTo.eq(belongTo);
	}
}
