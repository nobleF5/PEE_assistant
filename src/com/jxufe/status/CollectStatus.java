package com.jxufe.status;

import java.io.Serializable;

public class CollectStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int SUCCESS = 0;
	public final static int FAILED = -1;
	
	public final static String SUCCESS_COLLECT_MSG = "�ղسɹ�";
	public final static String FAILURE_COLLECT_MSG = "�ղ�ʧ�ܣ����Ժ�����";
	
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
