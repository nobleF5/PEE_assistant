package com.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentInfo")
public class StudentInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Stu_Id;
	
	private String Stu_mobile;
	
	private String Stu_name;
	
	private String Stu_password;
	
	private String Stu_sex;
	
	private String Stu_academy;

	public String getStu_name() {
		return Stu_name;
	}

	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}

	public String getStu_password() {
		return Stu_password;
	}

	public void setStu_password(String stu_password) {
		Stu_password = stu_password;
	}

	public String getStu_sex() {
		return Stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		Stu_sex = stu_sex;
	}

	public String getStu_mobile() {
		return Stu_mobile;
	}

	public void setStu_mobile(String stu_mobile) {
		Stu_mobile = stu_mobile;
	}

	public String getStu_academy() {
		return Stu_academy;
	}

	public void setStu_academy(String stu_academy) {
		Stu_academy = stu_academy;
	}

	public int getStu_Id() {
		return Stu_Id;
	}

	public void setStu_Id(int stu_Id) {
		Stu_Id = stu_Id;
	}

}
