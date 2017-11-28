package io.jianxun.extend.domain.business;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.jianxun.extend.domain.AbstractBusinessEntity;
import io.jianxun.source.domain.ERPMedicament;

/**
 * 药品所属
 * 
 * 热销 推荐 等
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "jx_cy_m_belongto")
public class MedicamentBelongTo extends AbstractBusinessEntity {

	private static final long serialVersionUID = 9000912810610089404L;
	// 所属
	private String belongTo;
	// 药品id
	private String spid;
	//药品名称排序用
	private String spmch;
	// *************ERP系统数据
	// 药品信息
	@Transient
	private ERPMedicament erpInfo;

	// 库存信息
	private BigDecimal shl;

	public String getBelongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public ERPMedicament getErpInfo() {
		return erpInfo;
	}

	public void setErpInfo(ERPMedicament erpInfo) {
		this.erpInfo = erpInfo;
	}

	public BigDecimal getShl() {
		return shl;
	}

	public void setShl(BigDecimal shl) {
		this.shl = shl;
	}

	public String getSpmch() {
		return spmch;
	}

	public void setSpmch(String spmch) {
		this.spmch = spmch;
	}
	
	

}
