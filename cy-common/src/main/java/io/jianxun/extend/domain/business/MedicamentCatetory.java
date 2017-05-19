package io.jianxun.extend.domain.business;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import io.jianxun.extend.domain.AbstractBusinessEntity;

@Entity
@Table(name = "jx_cy_m_category")
public class MedicamentCatetory extends AbstractBusinessEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5134075705341157613L;
	@NotBlank(message="类别名称不能为空")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
