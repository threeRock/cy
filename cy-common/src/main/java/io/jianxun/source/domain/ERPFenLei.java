package io.jianxun.source.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "padfenlei")
public class ERPFenLei {

	@Id
	private String tid;
	
	//名称
	private String tname;
	
	//隶属上级
	private String tfatherid;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTfatherid() {
		return tfatherid;
	}

	public void setTfatherid(String tfatherid) {
		this.tfatherid = tfatherid;
	}
	
	
	

}
