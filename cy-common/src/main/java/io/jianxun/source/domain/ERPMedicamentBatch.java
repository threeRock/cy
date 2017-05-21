package io.jianxun.source.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "sphwph")
public class ERPMedicamentBatch {

//	@EmbeddedId
	private ERPMedicamentBatchKey batchKey;
	private BigDecimal gebjj; //成本单价
	private String pihao; //批号内码隐
	private String pihao2; //批号
	private String jwh; //架位号
	private BigDecimal shl; //数量
	private String sxrq; //有效期

	public ERPMedicamentBatchKey getBatchKey() {
		return batchKey;
	}

	public void setBatchKey(ERPMedicamentBatchKey batchKey) {
		this.batchKey = batchKey;
	}

	public BigDecimal getGebjj() {
		return gebjj;
	}

	public void setGebjj(BigDecimal gebjj) {
		this.gebjj = gebjj;
	}

	public String getPihao() {
		return pihao;
	}

	public void setPihao(String pihao) {
		this.pihao = pihao;
	}

	public String getPihao2() {
		return pihao2;
	}

	public void setPihao2(String pihao2) {
		this.pihao2 = pihao2;
	}

	public String getJwh() {
		return jwh;
	}

	public void setJwh(String jwh) {
		this.jwh = jwh;
	}

	public BigDecimal getShl() {
		return shl;
	}

	public void setShl(BigDecimal shl) {
		this.shl = shl;
	}

	public String getSxrq() {
		return sxrq;
	}

	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}
}
