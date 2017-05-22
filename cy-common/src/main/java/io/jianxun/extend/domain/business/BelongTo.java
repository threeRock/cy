package io.jianxun.extend.domain.business;

public enum BelongTo {
	HOTSAIL("热销药"), RECOMMENDATION("推荐药");
	private String name;

	private BelongTo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
