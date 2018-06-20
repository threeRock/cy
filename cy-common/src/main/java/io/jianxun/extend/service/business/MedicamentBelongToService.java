package io.jianxun.extend.service.business;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.BelongTo;
import io.jianxun.extend.domain.business.MedicamentBelongTo;
import io.jianxun.extend.service.AbstractBaseService;
import io.jianxun.source.domain.ERPIpadkc;
import io.jianxun.source.domain.ERPMedicament;
import io.jianxun.source.repository.ERPIpadkcPredicates;
import io.jianxun.source.repository.ERPIpadkcRepository;

@Service
public class MedicamentBelongToService extends AbstractBaseService<MedicamentBelongTo> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override

	public Page<MedicamentBelongTo> findActivePage(Predicate predicate, Pageable pageable) {
		Page<MedicamentBelongTo> page = super.findActivePage(predicate, pageable);
		for (MedicamentBelongTo medicamentBelongTo : page) {
			medicamentBelongTo.setErpInfo(medicamentService.getErpMedicament(medicamentBelongTo.getSpid()));
		}
		return page;
	}

	@Transactional(readOnly = false)
	private void refashStock() {
		List<MedicamentBelongTo> contents = findActiveAll();
		for (MedicamentBelongTo medicamentBelongTo : contents) {
			ERPIpadkc temp = ipadkcRepository.findOne(ERPIpadkcPredicates.spidPredicate(medicamentBelongTo.getSpid()));
			if (temp != null && BigDecimal.ZERO.compareTo(temp.getShl()) < 0) {
				medicamentBelongTo.setShl(temp.getShl());
			}
		}
		save(contents);
		flush();

	}

	// 热销药列表
	@Transactional(readOnly = false)
	public Page<ERPMedicament> getSellwells(Pageable pageable) {
		return getMedicaments(BelongTo.HOTSAIL, pageable);
	}
	
	@Transactional(readOnly = false)
	public Page<ERPMedicament> getOldSellwells(Pageable pageable) {
		return getMedicaments(BelongTo.HOTSAIL, pageable);
	}

	// 推荐药列表
	@Transactional(readOnly = false)
	public Page<ERPMedicament> getRecommendations(Pageable pageable) {
		return getMedicaments(BelongTo.RECOMMENDATION, pageable);
	}

	@Transactional(readOnly = false)
	public Page<ERPMedicament> getMedicaments(BelongTo belongTo, Pageable pageable) {

		// 更新库存
		refashStock();
		Page<MedicamentBelongTo> temp = findActivePage(
				MedicamentBelongToPredicates.belongToPredicate(belongTo.getName()), pageable);
		List<ERPMedicament> medics = Lists.newArrayList();
		for (MedicamentBelongTo m : temp) {
			medics.add(m.getErpInfo());
		}
		return new PageImpl<>(medics, pageable, temp.getTotalElements());
	}

	@Transactional(readOnly = false)
	private void refashSpmch() {
		List<MedicamentBelongTo> contents = findActiveAll();
		for (MedicamentBelongTo medicamentBelongTo : contents) {
			ERPMedicament erp = medicamentService.getErpMedicament(medicamentBelongTo.getSpid());
			if (erp != null ) {
				medicamentBelongTo.setSpmch(erp.getSpmch());
			}
		}
		save(contents);
		flush();
	}

	@Transactional(readOnly = false)
	public void hotsail(MedicamentBelongTo medicamentBelongTo) {
		belongTo(medicamentBelongTo, BelongTo.HOTSAIL);
	}

	@Transactional(readOnly = false)
	public void recommendation(MedicamentBelongTo medicamentBelongTo) {
		belongTo(medicamentBelongTo, BelongTo.RECOMMENDATION);
	}

	private void belongTo(MedicamentBelongTo medicamentBelongTo, BelongTo belongTo) {
		if (!exists(MedicamentBelongToPredicates.erpSpidPredicate(medicamentBelongTo.getSpid()))) {
			medicamentBelongTo.setBelongTo(belongTo.getName());
			ERPMedicament erp = medicamentService.getErpMedicament(medicamentBelongTo.getSpid());
			if(erp!=null){
				medicamentBelongTo.setErpInfo(erp);
				medicamentBelongTo.setSpmch(erp.getSpmch());
			}
			save(medicamentBelongTo);
		}
	}

	@Autowired
	private MedicamentService medicamentService;

	@Autowired
	private ERPIpadkcRepository ipadkcRepository;

}
