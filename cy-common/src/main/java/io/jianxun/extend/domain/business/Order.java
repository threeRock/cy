package io.jianxun.extend.domain.business;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.collect.Lists;

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

	// ERP数据
	// 单位名称
	@NotBlank(message = "{order.name.notblank}")
	private String dwmch;

	// 单位编号
	private String dwbh;

	// 结算方式
	private String jsfs;

	// ERP数据

	@ElementCollection
	@CollectionTable(name = "jx_cy_order_items", joinColumns = @JoinColumn(name = "order_id"))
	private List<OrderItem> items = Lists.newArrayList();

	// 状态
	private String status = OrderStatus.CREATE.getName();

	public String getDwmch() {
		return dwmch;
	}

	public void setDwmch(String dwmch) {
		this.dwmch = dwmch;
	}

	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public String getJsfs() {
		return jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
