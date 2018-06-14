package com.jxufe.status;

public class LoginStatus {
	public final static int SUCCESS = 0;
	public final static int FAILED = -1;
	
	public final static String SUCCESS_LOGIN_MSG = "成功登录";
	public final static String ERROR_PASSWORD_MSG = "登录失败,请检查密码后再重新登录";
	public final static String ERROR_ACCOUNT_MSG = "该账号不存在";
	
	private int code;
	private String message;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}