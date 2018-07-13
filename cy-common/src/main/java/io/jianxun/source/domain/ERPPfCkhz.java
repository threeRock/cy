package io.jianxun.source.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ipaddjmx")
public class ERPPfCkhz {

	@EmbeddedId
	private ERPPfCkhzKey id;

	private String dwbh;

	private String spid;

	private String rq;

	public ERPPfCkhzKey getId() {
		return id;
	}

	public void setId(ERPPfCkhzKey id) {
		this.id = id;
	}

	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getRq() {
		return rq;
	}

	public void setRq(String rq) {
		this.rq = rq;
	}

}
