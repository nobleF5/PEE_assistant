package com.jxufe.status;

public class LoginStatus {
	public final static int SUCCESS = 0;
	public final static int FAILED = -1;
	
	public final static String SUCCESS_LOGIN_MSG = "成功登录";
	public final static String ERROR_PASSWORD_MSG = "登录失败,请检查密码后再重新登录";
	public final static String ERROR_ACCOUNT_MSG = "该账号不存在";
	public final static String SUCCESS_QQSIGNUP_MSG = "qq用户注册成功";
	public final static String ERROR_QQSIGNUP_MSG = "qq用户注册失败";
	public final static String SUCCESS_QQLOGIN_MSG = "qq用户登录成功";
	public final static String ERROR_QQLOGIN_MSG = "qq用户登录失败";
	
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