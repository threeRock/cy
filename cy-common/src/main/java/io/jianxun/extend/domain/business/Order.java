package io.jianxun.extend.domain.business;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import io.jianxun.extend.domain.AbstractBusinessEntity;

/**
 * 订单信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "jx_cy_order")
public class Order extends AbstractBusinessEntity {

	private static final long serialVersionUID = -22082148524081719L;
	@NotBlank(message = "{order.name.notblank}")
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
