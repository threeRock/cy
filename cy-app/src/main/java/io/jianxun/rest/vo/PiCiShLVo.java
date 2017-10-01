package io.jianxun.rest.vo;

import java.math.BigDecimal;

//药品批次数量信息
public class PiCiShLVo {

	public PiCiShLVo(String pihao2, BigDecimal shl, String sxrq) {
		super();
		this.pihao2 = pihao2;
		this.shl = shl;
		this.sxrq = sxrq;

	}

	// 批号
	private String pihao2;

	// 数量
	private BigDecimal shl;

	// 有效期
	private String sxrq;

	public String getPihao2() {
		return pihao2;
	}

	public void setPihao2(String pihao2) {
		this.pihao2 = pihao2;
	}

	public BigDecimal getShl() {
		return shl;
	}

	public void setShl(BigDecimal shl) {
		this.shl = shl;
	}

	public String getSxrq() {
		return sxrq;
	}

	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}

}
