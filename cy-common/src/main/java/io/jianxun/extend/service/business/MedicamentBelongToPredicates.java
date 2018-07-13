package io.jianxun.extend.service.business;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

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

	public static Predicate belongToPredicate(String belongTo, String spmch) {

		QMedicamentBelongTo medicamentBelongTo = QMedicamentBelongTo.medicamentBelongTo;

		if (StringUtils.isBlank(spmch))
			spmch = "%";
		return medicamentBelongTo.belongTo.eq(belongTo).and(medicamentBelongTo.shl.isNotNull())
				.and(medicamentBelongTo.shl.goe(BigDecimal.ZERO)).and(medicamentBelongTo.spmch.likeIgnoreCase(spmch));
	}
}
