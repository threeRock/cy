package io.jianxun.extend.domain.business;

public enum OrderStatus {

	// 创建 ,提交
	CREATE("创建"), COMMIT("提交");

	private String name;

	private OrderStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
