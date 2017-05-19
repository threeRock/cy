package io.jianxun.source.domain;

public class ERPMedicamentBatch {

//	@EmbeddedId
	private ERPMedicamentBatchKey batchKey;
	private String hw;
	private String baozhiqi;
	private String dangq;
	
	
	
	

	

	public ERPMedicamentBatchKey getBatchKey() {
		return batchKey;
	}

	public void setBatchKey(ERPMedicamentBatchKey batchKey) {
		this.batchKey = batchKey;
	}

	public String getHw() {
		return hw;
	}

	public void setHw(String hw) {
		this.hw = hw;
	}

	public String getBaozhiqi() {
		return baozhiqi;
	}

	public void setBaozhiqi(String baozhiqi) {
		this.baozhiqi = baozhiqi;
	}

	public String getDangq() {
		return dangq;
	}

	public void setDangq(String dangq) {
		this.dangq = dangq;
	}

}
