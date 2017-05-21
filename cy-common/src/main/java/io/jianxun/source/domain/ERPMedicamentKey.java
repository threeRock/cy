package io.jianxun.source.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ERPMedicamentKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263744035917039315L;
	private String spid;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ERPMedicamentKey other = (ERPMedicamentKey) obj;
		if (spid == null) {
			if (other.spid != null)
				return false;
		} else if (!spid.equals(other.spid))
			return false;
		return true;
	}

}
