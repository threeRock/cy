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
@Table(name = "mchk")
public class ERPMchk {
	private String dwmch;//单位名,
	@Id
	private String dwbh;// 单位编号,
	private String ywy;//业务员,
	private String jingyfw;//经营范围,
	private String shouhdz;//收货地址,
	private String jslx;//结算类型,
	private String xshlx;//销售类型,
	private String khquyu;//客户区域 

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

	public String getYwy() {
		return ywy;
	}

	public void setYwy(String ywy) {
		this.ywy = ywy;
	}

	public String getJingyfw() {
		return jingyfw;
	}

	public void setJingyfw(String jingyfw) {
		this.jingyfw = jingyfw;
	}

	public String getShouhdz() {
		return shouhdz;
	}

	public void setShouhdz(String shouhdz) {
		this.shouhdz = shouhdz;
	}

	public String getJslx() {
		return jslx;
	}

	public void setJslx(String jslx) {
		this.jslx = jslx;
	}

	public String getXshlx() {
		return xshlx;
	}

	public void setXshlx(String xshlx) {
		this.xshlx = xshlx;
	}

	public String getKhquyu() {
		return khquyu;
	}

	public void setKhquyu(String khquyu) {
		this.khquyu = khquyu;
	}
}
