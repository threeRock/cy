package io.jianxun.source.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 药品基本信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "huoweizl")
public class ERPHuoweizl {
	@Id
	private String hw;
	private String hwbh; //货位编号隐
	private String huowname; //货位名隐

	public String getHwbh() {
		return hwbh;
	}

	public String getHw() {
		return hw;
	}

	public void setHw(String hw) {
		this.hw = hw;
	}

	public void setHwbh(String hwbh) {
		this.hwbh = hwbh;
	}

	public String getHuowname() {
		return huowname;
	}

	public void setHuowname(String huowname) {
		this.huowname = huowname;
	}
}
