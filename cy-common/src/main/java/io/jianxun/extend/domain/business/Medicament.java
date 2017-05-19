package io.jianxun.extend.domain.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.common.collect.Lists;

import io.jianxun.extend.domain.AbstractBusinessEntity;
import io.jianxun.source.domain.ERPMedicament;

@Entity
@Table(name = "jx_cy_medicament")
public class Medicament extends AbstractBusinessEntity {

	private static final long serialVersionUID = -6136019239156133020L;

	// *************ERP系统数据
	// 商品内码
	@Transient
	private ERPMedicament erpInfo;
	
	//药品类别
	@ManyToOne
	private MedicamentCatetory medcategory;
	//erp系统中药品管理id用于获取erpInfo
	private String erpSpid;
	// 首显示图片
	private String mainPic;
	// 图片列表
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "jx_cy_medic_pics")
	private List<String> pics = Lists.newArrayList();

	// 直销期
	private LocalDateTime zxq;

	public ERPMedicament getErpInfo() {
		return erpInfo;
	}

	public void setErpInfo(ERPMedicament erpInfo) {
		this.erpInfo = erpInfo;
	}

	public String getMainPic() {
		return mainPic;
	}

	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}

	public List<String> getPics() {
		return pics;
	}

	public void setPics(List<String> pics) {
		this.pics = pics;
	}

	public LocalDateTime getZxq() {
		return zxq;
	}

	public void setZxq(LocalDateTime zxq) {
		this.zxq = zxq;
	}

	public String getErpSpid() {
		return erpSpid;
	}

	public void setErpSpid(String erpSpid) {
		this.erpSpid = erpSpid;
	}

	public MedicamentCatetory getMedcategory() {
		return medcategory;
	}

	public void setMedcategory(MedicamentCatetory medcategory) {
		this.medcategory = medcategory;
	}
	
	

}
