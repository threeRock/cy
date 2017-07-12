package io.jianxun.source.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ERPSphwphKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263744035917039315L;
	// 药品id
	private String spid;
	// 货位号
	private String hw;
	// 批号
	private String pihao;

	/**
	 * @return the spid
	 */
	public String getSpid() {
		return spid;
	}

	/**
	 * @param spid
	 *            the spid to set
	 */
	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getHw() {
		return hw;
	}

	public void setHw(String hw) {
		this.hw = hw;
	}

	public String getPihao() {
		return pihao;
	}

	public void setPihao(String pihao) {
		this.pihao = pihao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hw == null) ? 0 : hw.hashCode());
		result = prime * result + ((pihao == null) ? 0 : pihao.hashCode());
		result = prime * result + ((spid == null) ? 0 : spid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERPSphwphKey other = (ERPSphwphKey) obj;
		if (hw == null) {
			if (other.hw != null)
				return false;
		} else if (!hw.equals(other.hw))
			return false;
		if (pihao == null) {
			if (other.pihao != null)
				return false;
		} else if (!pihao.equals(other.pihao))
			return false;
		if (spid == null) {
			if (other.spid != null)
				return false;
		} else if (!spid.equals(other.spid))
			return false;
		return true;
	}

}
