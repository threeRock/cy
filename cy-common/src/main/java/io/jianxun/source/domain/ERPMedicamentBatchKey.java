package io.jianxun.source.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * @author Administrator
 *
 */
@Embeddable
public class ERPMedicamentBatchKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8049968223655470529L;
	// 商品id
	private String spid;
	// 批号
	private String pihao;

	// 货位
	private String hw;

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getPihao() {
		return pihao;
	}

	public void setPihao(String pihao) {
		this.pihao = pihao;
	}

	/**
	 * @return the hw
	 */
	public String getHw() {
		return hw;
	}

	/**
	 * @param hw
	 *            the hw to set
	 */
	public void setHw(String hw) {
		this.hw = hw;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hw == null) ? 0 : hw.hashCode());
		result = prime * result + ((pihao == null) ? 0 : pihao.hashCode());
		result = prime * result + ((spid == null) ? 0 : spid.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERPMedicamentBatchKey other = (ERPMedicamentBatchKey) obj;
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
