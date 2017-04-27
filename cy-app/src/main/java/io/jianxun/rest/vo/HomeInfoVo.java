package io.jianxun.rest.vo;

import java.util.List;

import com.google.common.collect.Lists;

public class HomeInfoVo {
	private List<String> commonKey = Lists.newArrayList();

	public HomeInfoVo(List<String> commonKey) {
		super();
		this.commonKey = commonKey;
	}

	public List<String> getCommonKey() {
		return commonKey;
	}

	public void setCommonKey(List<String> commonKey) {
		this.commonKey = commonKey;
	}

}
