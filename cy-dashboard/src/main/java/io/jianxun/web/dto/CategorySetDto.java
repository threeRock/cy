package io.jianxun.web.dto;

import io.jianxun.extend.domain.business.MedicamentCatetory;
import io.jianxun.source.domain.ERPMedicament;

public class CategorySetDto {

	private ERPMedicament erpMedicament;
	private MedicamentCatetory medicamentCatetory;

	public ERPMedicament getErpMedicament() {
		return erpMedicament;
	}

	public void setErpMedicament(ERPMedicament erpMedicament) {
		this.erpMedicament = erpMedicament;
	}

	public MedicamentCatetory getMedicamentCatetory() {
		return medicamentCatetory;
	}

	public void setMedicamentCatetory(MedicamentCatetory medicamentCatetory) {
		this.medicamentCatetory = medicamentCatetory;
	}

}
