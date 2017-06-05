package io.jianxun.extend.domain.business;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItem {

	// 药品id
	private String spid;
	// 药品名称
	private String spmch;
	// 数量
	private String quantity;

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getSpmch() {
		return spmch;
	}

	public void setSpmch(String spmch) {
		this.spmch = spmch;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "[药品标号：" + spid + ", 药品名称=" + spmch + ", 数量=" + quantity + "]";
	}

}
