package io.jianxun.source.domain;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hwsp")
public class ERPHwsp {

	@EmbeddedId
	private ERPHwspKey id;

	// 货位数量
	private BigDecimal hwshl;

	public ERPHwspKey getId() {
		return id;
	}

	public void setId(ERPHwspKey id) {
		this.id = id;
	}

	public BigDecimal getHwshl() {
		return hwshl;
	}

	public void setHwshl(BigDecimal hwshl) {
		this.hwshl = hwshl;
	}

}
