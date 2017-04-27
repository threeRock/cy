package io.jianxun.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("appinfo")
public class AppInfo {

	private String mandatory;
	private String urlpath;
	private boolean Update;

	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	public String getUrlpath() {
		return urlpath;
	}

	public void setUrlpath(String urlpath) {
		this.urlpath = urlpath;
	}

	public boolean isUpdate() {
		return Update;
	}

	public void setUpdate(boolean update) {
		Update = update;
	}

}
