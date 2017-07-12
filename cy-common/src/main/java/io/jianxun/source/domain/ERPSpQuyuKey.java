package io.jianxun.source.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ERPSpQuyuKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1547855779836541611L;
	private String spid;
	private String khquyu;

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getKhquyu() {
		return khquyu;
	}

	public void setKhquyu(String khquyu) {
		this.khquyu = khquyu;
	}

}
