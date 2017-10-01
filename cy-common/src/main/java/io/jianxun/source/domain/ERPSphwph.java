package io.jianxun.source.domain;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sphwph")
public class ERPSphwph {

	@EmbeddedId
	private ERPSphwphKey id;

	// 数量
	private BigDecimal shl;
	

	// 批号
	private String pihao2;
	
	//有效期
	private String sxrq;

	public ERPSphwphKey getId() {
		return id;
	}

	public void setId(ERPSphwphKey id) {
		this.id = id;
	}

	public BigDecimal getShl() {
		return shl;
	}

	public void setShl(BigDecimal shl) {
		this.shl = shl;
	}

	public String getPihao2() {
		return pihao2;
	}

	public void setPihao2(String pihao2) {
		this.pihao2 = pihao2;
	}

	public String getSxrq() {
		return sxrq;
	}

	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}
	
	

}
