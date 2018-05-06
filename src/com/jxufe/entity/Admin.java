package com.jxufe.entity;

//@Entity
//@Table(name="admin")
public class Admin {
	private int id;
	
	private String adminname;
	private String password;

	
//	@GeneratedValue
//	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminName) {
		this.adminname = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
