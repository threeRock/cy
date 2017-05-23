package io.jianxun.rest.vo;

import org.apache.http.HttpStatus;

public class ReturnVo<T> {

	//
	private String result = "";
	private int code = HttpStatus.SC_OK;
	private boolean success = true;
	private T data;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> ReturnVo<T> ok(T data) {
		ReturnVo<T> vo = new ReturnVo<T>();
		vo.setCode(HttpStatus.SC_OK);
		vo.setSuccess(true);
		vo.setData(data);
		return vo;
	}

	public static ReturnVo<ErrorMessage> bindError(String message) {
		return error("请求参数异常", message);
	}

	public static ReturnVo<ErrorMessage> businessError(String message) {
		return error("系统异常", message);
	}

	public static ReturnVo<ErrorMessage> badCredentialsError(String message) {
		return error("用户密码错误", message);
	}

	public static ReturnVo<ErrorMessage> accessError(String message) {
		return error("不允许访问", message);
	}

	public static ReturnVo<ErrorMessage> error(String result, String message) {
		ReturnVo<ErrorMessage> vo = new ReturnVo<ErrorMessage>();
		vo.setCode(HttpStatus.SC_BAD_REQUEST);
		vo.setSuccess(false);
		vo.setResult(result);
		vo.setData(new ErrorMessage(message));
		return vo;
	}

	public static class ErrorMessage {
		String message;

		public ErrorMessage(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}
