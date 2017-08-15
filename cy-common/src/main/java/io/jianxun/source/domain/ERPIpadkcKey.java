package io.jianxun.source.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * 药品库存信息Key
 * 
 * @author Administrator
 *
 */
@Embeddable
public class ERPIpadkcKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -73213628855098471L;
	private String spid;

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ERPIpadkcKey other = (ERPIpadkcKey) obj;
		if (spid == null) {
			if (other.spid != null)
				return false;
		} else if (!spid.equals(other.spid))
			return false;
		return true;
	}

}
