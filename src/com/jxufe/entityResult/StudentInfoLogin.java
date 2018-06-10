package com.jxufe.entityResult;

public class StudentInfoLogin {
	
	private String stu_mobile;
	private String stu_password;
	
	public String getStu_mobile() {
		return stu_mobile;
	}
	public void setStu_mobile(String stu_mobile) {
		this.stu_mobile = stu_mobile;
	}
	public String getStu_password() {
		return stu_password;
	}
	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}
	
	public StudentInfoLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentInfoLogin(String stu_mobile, String stu_password) {
		super();
		this.stu_mobile = stu_mobile;
		this.stu_password = stu_password;
	}
	
}
