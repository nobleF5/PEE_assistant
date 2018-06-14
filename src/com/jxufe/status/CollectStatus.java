package com.jxufe.status;

import java.io.Serializable;

public class CollectStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int SUCCESS = 0;
	public final static int FAILED = -1;
	
	public final static String SUCCESS_COLLECT_MSG = "收藏成功";
	public final static String FAILURE_COLLECT_MSG = "收藏失败，请稍后重试";
	public final static String SUCCESS_CANCLECOLLECT_MSG = "取消收藏成功";
	public final static String FAILURE_CANCLECOLLECT_MSG = "取消收藏失败";
	
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