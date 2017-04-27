package io.jianxun.source.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 药品基本信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "spkfk")
public class ERPMedicament {

	// 商品内码
	@Id
	private String spid;
	// 商品编号
	private String spbh;
	// 商品条码
	private String sptm;
	// 商品名称
	private String spmch;
	
	//商品类别
	private String leibie;

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getSpbh() {
		return spbh;
	}

	public void setSpbh(String spbh) {
		this.spbh = spbh;
	}

	public String getSptm() {
		return sptm;
	}

	public void setSptm(String sptm) {
		this.sptm = sptm;
	}

	public String getSpmch() {
		return spmch;
	}

	public void setSpmch(String spmch) {
		this.spmch = spmch;
	}

	public String getLeibie() {
		return leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}
	
	

}
