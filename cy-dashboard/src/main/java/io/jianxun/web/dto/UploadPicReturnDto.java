package io.jianxun.web.dto;

import java.util.List;

public class UploadPicReturnDto {

	private Integer statusCode;
	private String message;
	private List<String> files;

	public UploadPicReturnDto(Integer statusCode, String message, List<String> files) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.files = files;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the files
	 */
	public List<String> getFiles() {
		return files;
	}

	/**
	 * @param files
	 *            the files to set
	 */
	public void setFiles(List<String> files) {
		this.files = files;
	}

}
