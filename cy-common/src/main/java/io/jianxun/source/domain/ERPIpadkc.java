package io.jianxun.source.domain;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 药品库存信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "ipadkc")
public class ERPIpadkc {

	@EmbeddedId
	private ERPIpadkcKey id;

	private String spmch;

	// 助记码
	private String zjm;

	//
	private String is_xty;

	private BigDecimal shl;

	private String padflid;

	public ERPIpadkcKey getId() {
		return id;
	}

	public void setId(ERPIpadkcKey id) {
		this.id = id;
	}

	public BigDecimal getShl() {
		return shl;
	}

	public void setShl(BigDecimal shl) {
		this.shl = shl;
	}

	public String getPadflid() {
		return padflid;
	}

	public void setPadflid(String padflid) {
		this.padflid = padflid;
	}

	public String getSpmch() {
		return spmch;
	}

	public void setSpmch(String spmch) {
		this.spmch = spmch;
	}

	public String getZjm() {
		return zjm;
	}

	public void setZjm(String zjm) {
		this.zjm = zjm;
	}

	public String getIs_xty() {
		return is_xty;
	}

	public void setIs_xty(String is_xty) {
		this.is_xty = is_xty;
	}

}
