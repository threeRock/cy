package io.jianxun.rest.vo;

import java.math.BigDecimal;

public class PriceVo {

	public PriceVo(String category, String khquyu, BigDecimal zbjg) {
		super();
		this.category = category;
		this.khquyu = khquyu;
		this.zbjg = zbjg;
	}

	// 类别 普药价格、基药价格
	private String category;
	// 区域名称
	private String khquyu;
	// 价格
	private BigDecimal zbjg;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKhquyu() {
		return khquyu;
	}

	public void setKhquyu(String khquyu) {
		this.khquyu = khquyu;
	}

	public BigDecimal getZbjg() {
		return zbjg;
	}

	public void setZbjg(BigDecimal zbjg) {
		this.zbjg = zbjg;
	}

}
