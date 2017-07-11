package io.jianxun.source.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ERPHwspKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263744035917039315L;
	private String spid;
	private String hw;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hw == null) ? 0 : hw.hashCode());
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
		ERPHwspKey other = (ERPHwspKey) obj;
		if (hw == null) {
			if (other.hw != null)
				return false;
		} else if (!hw.equals(other.hw))
			return false;
		if (spid == null) {
			if (other.spid != null)
				return false;
		} else if (!spid.equals(other.spid))
			return false;
		return true;
	}

}
