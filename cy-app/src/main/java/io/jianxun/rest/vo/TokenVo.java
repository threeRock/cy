package io.jianxun.rest.vo;

import java.io.Serializable;

public class TokenVo implements Serializable {
	private static final long serialVersionUID = 1250166508152483573L;

	private final String token;

	public TokenVo(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

}
