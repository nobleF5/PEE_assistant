package com.jxufe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DepartmentInfo")
public class DepartmentInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,name="Dep_ID")
	protected int id = 0;
	
	@Column(nullable = true)
	private int Aca_ID;
	
	@Column(nullable = true)
	private String Dep_No;
	
	@Column(nullable = true)
	private String Dep_Name;
	
	@Column(nullable = true)
	private String Dep_Specialty;
	
	@Column(nullable = true)
	private String Dep_Direction;
	
	@Column(nullable = true)
	private String AcceStu_Url;
	
	
	public String getAcceStu_Url() {
		return AcceStu_Url;
	}
	public void setAcceStu_Url(String acceStu_Url) {
		AcceStu_Url = acceStu_Url;
	}
	public int getAca_ID() {
		return Aca_ID;
	}
	public void setAca_ID(int aca_ID) {
		Aca_ID = aca_ID;
	}
	public String getDep_No() {
		return Dep_No;
	}
	public void setDep_No(String dep_No) {
		Dep_No = dep_No;
	}
	public String getDep_Name() {
		return Dep_Name;
	}
	public void setDep_Name(String dep_Name) {
		Dep_Name = dep_Name;
	}
	public String getDep_Specialty() {
		return Dep_Specialty;
	}
	public void setDep_Specialty(String dep_Specialty) {
		Dep_Specialty = dep_Specialty;
	}
	public String getDep_Direction() {
		return Dep_Direction;
	}
	public void setDep_Direction(String dep_Direction) {
		Dep_Direction = dep_Direction;
	}
	
	
}
