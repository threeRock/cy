package io.jianxun.extend.service.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.Medicament;
import io.jianxun.extend.domain.business.MedicamentCatetory;
import io.jianxun.extend.repository.business.MedicamentRepository;
import io.jianxun.extend.service.AbstractBaseService;
import io.jianxun.source.domain.ERPMedicament;
import io.jianxun.source.repository.ERPMedicamentPredicates;
import io.jianxun.source.repository.ERPMedicamentRepository;

@Service
public class MedicamentService extends AbstractBaseService<Medicament> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.jianxun.extend.service.AbstractBaseService#findActiveOne(com.querydsl.
	 * core.types.Predicate)
	 */
	@Override
	public Medicament findActiveOne(Predicate predicate) {
		Medicament medicament = super.findActiveOne(predicate);
		if (medicament != null)
			medicament.setErpInfo(getErpMedicament(medicament.getErpSpid()));
		return medicament;
	}

	public Page<Medicament> getPage(Predicate predicate, Pageable pageable) {
		Page<ERPMedicament> p = erprepo.findAll(predicate, pageable);
		List<Medicament> resuts = Lists.newArrayList();
		for (ERPMedicament m : p.getContent()) {
			Medicament temp = new Medicament();
			temp.setErpInfo(m);
			temp.setErpSpid(m.getId().getSpid());
			Medicament x = medrepo.findActiveOne(MedicamentPredicates.erpSpidPredicate(m.getId().getSpid()));
			if (x != null) {
				temp.setMedcategory(x.getMedcategory());
				temp.setMainPic(x.getMainPic());
				temp.setPics(x.getPics());
			}
			resuts.add(temp);
		}

		return new PageImpl<Medicament>(resuts, pageable, p.getTotalElements());
	}

	// 获取erp系统中的药品基本信息
	public ERPMedicament getErpMedicament(String spid) {
		return erprepo.findOne(ERPMedicamentPredicates.erpSpidPredicate(spid));
	}

	// 获取erp系统中的药品信息
	public List<ERPMedicament> getErpMedicaments(String spmch) {
		return (List<ERPMedicament>) erprepo.findAll(ERPMedicamentPredicates.erpSpmchPredicate(spmch),
				new Sort("spmch"));
	}

	// 药品信息
	@Transactional(readOnly = false)
	public void init() {
		List<ERPMedicament> list = (List<ERPMedicament>) erprepo.findAll();
		for (ERPMedicament erpMedicament : list) {
			Medicament medicament = findActiveOne(
					MedicamentPredicates.erpSpidPredicate(erpMedicament.getId().getSpid()));
			if (medicament == null)
				medicament = new Medicament();
			medicament.setErpInfo(erpMedicament);
			medicament.setErpSpid(erpMedicament.getId().getSpid());
			if (erpMedicament.getLeibie().contains("中药饮片")) {
				List<String> pics = medicament.getPics();
				pics.add("zyyp.jpg");
			} else {
				String name = erpMedicament.getSpbh() + ".jpg";
				String name2 = erpMedicament.getSpbh() + ".png";
				try {
					Resource resource = storageService.loadAsResource(name);
					List<String> pics = medicament.getPics();
					pics.add(name);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					Resource resource = storageService.loadAsResource(name2);
					List<String> pics = medicament.getPics();
					pics.add(name2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			save(medicament);
		}
	}

	@Transactional(readOnly = false)
	public void setCategory(ERPMedicament erpMedicament, MedicamentCatetory medicamentCatetory) {
		Medicament medicament;
		if (!exists(MedicamentPredicates.erpSpidPredicate(erpMedicament.getId().getSpid()))) {
			medicament = new Medicament();
			medicament.setErpInfo(erpMedicament);
			medicament.setErpSpid(erpMedicament.getId().getSpid());
		} else
			medicament = findActiveOne(MedicamentPredicates.erpSpidPredicate(erpMedicament.getId().getSpid()));
		medicament.setMedcategory(medicamentCatetory);
		save(medicament);
	}

	@Autowired
	private ERPMedicamentRepository erprepo;

	@Autowired
	private StorageService storageService;

	@Autowired
	private MedicamentRepository medrepo;

}
