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
	
	private String Stu_Name;
	
	private String Stu_Password;
	
	private String Stu_Sex;
	
	private String stu_academy;

	public int getStu_Id() {
		return Stu_Id;
	}

	public void setStu_Id(int stu_Id) {
		Stu_Id = stu_Id;
	}

	public String getStu_Name() {
		return Stu_Name;
	}

	public void setStu_Name(String stu_Name) {
		Stu_Name = stu_Name;
	}

	public String getStu_Password() {
		return Stu_Password;
	}

	public void setStu_Password(String stu_Password) {
		Stu_Password = stu_Password;
	}

	public String getStu_Sex() {
		return Stu_Sex;
	}

	public void setStu_Sex(String stu_Sex) {
		Stu_Sex = stu_Sex;
	}

	public String getStu_academy() {
		return stu_academy;
	}

	public void setStu_academy(String stu_academy) {
		this.stu_academy = stu_academy;
	}
	
	
}
