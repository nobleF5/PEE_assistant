package com.jxufe.status;

public class LoginStatus {
	public final static int SUCCESS = 0;
	public final static int FAILED = -1;
	
	public final static String SUCCESS_LOGIN_MSG = "�ɹ���¼";
	public final static String ERROR_PASSWORD_MSG = "��¼ʧ��,��������������µ�¼";
	public final static String ERROR_ACCOUNT_MSG = "���˺Ų�����";
	
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
