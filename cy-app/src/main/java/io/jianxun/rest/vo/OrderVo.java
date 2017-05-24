package io.jianxun.rest.vo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import io.jianxun.extend.domain.business.Order;
import io.jianxun.extend.domain.business.OrderItem;

//order vo
public class OrderVo {

	private Long id;
	// 单位名称
	private String dwmch;
	// 单位编号
	private String dwbh;

	private List<OrderItem> items = Lists.newArrayList();

	private UserVo createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate;

	private UserVo lastModifieBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime lastModifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public UserVo getCreateBy() {
		return createBy;
	}

	public void setCreateBy(UserVo createBy) {
		this.createBy = createBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public UserVo getLastModifieBy() {
		return lastModifieBy;
	}

	public void setLastModifieBy(UserVo lastModifieBy) {
		this.lastModifieBy = lastModifieBy;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public static OrderVo toVo(Order order) {
		OrderVo orderVo = new OrderVo();
		BeanUtils.copyProperties(order, orderVo);
		if (order.getCreatedBy() != null) {
			UserVo userVo = new UserVo();
			BeanUtils.copyProperties(order.getCreatedBy(), userVo);
			orderVo.setCreateBy(userVo);
		}
		if (order.getLastModifiedBy() != null) {
			UserVo userVo = new UserVo();
			BeanUtils.copyProperties(order.getLastModifiedBy(), userVo);
			orderVo.setCreateBy(userVo);
		}

		return orderVo;
	}

	public static List<OrderVo> toVo(List<Order> orders) {
		List<OrderVo> result = Lists.newArrayList();
		for (Order order : orders) {
			result.add(toVo(order));
		}
		return result;
	}

}
