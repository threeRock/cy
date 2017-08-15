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

	private BigDecimal shl;

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

}
