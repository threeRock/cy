package io.jianxun.source.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ERPPfCkhzKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -960687949125463574L;
	private String djbh;

	@Column(name = "dj_sn")
	private String djSn;

	public String getDjbh() {
		return djbh;
	}

	public void setDjbh(String djbh) {
		this.djbh = djbh;
	}

	public String getDjSn() {
		return djSn;
	}

	public void setDjSn(String djSn) {
		this.djSn = djSn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((djSn == null) ? 0 : djSn.hashCode());
		result = prime * result + ((djbh == null) ? 0 : djbh.hashCode());
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
		ERPPfCkhzKey other = (ERPPfCkhzKey) obj;
		if (djSn == null) {
			if (other.djSn != null)
				return false;
		} else if (!djSn.equals(other.djSn))
			return false;
		if (djbh == null) {
			if (other.djbh != null)
				return false;
		} else if (!djbh.equals(other.djbh))
			return false;
		return true;
	}

}
