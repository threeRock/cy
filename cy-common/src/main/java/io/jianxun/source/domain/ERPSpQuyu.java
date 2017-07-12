package io.jianxun.source.domain;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sp_quyu")
public class ERPSpQuyu {

	// 商品id
	@EmbeddedId
	private ERPSpQuyuKey id;
	private BigDecimal zbjg;
	private String beactive;

	public ERPSpQuyuKey getId() {
		return id;
	}

	public void setId(ERPSpQuyuKey id) {
		this.id = id;
	}

	public BigDecimal getZbjg() {
		return zbjg;
	}

	public void setZbjg(BigDecimal zbjg) {
		this.zbjg = zbjg;
	}

	public String getBeactive() {
		return beactive;
	}

	public void setBeactive(String beactive) {
		this.beactive = beactive;
	}

}
