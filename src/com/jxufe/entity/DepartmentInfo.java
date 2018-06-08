package com.jxufe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DepartmentInfo")
public class DepartmentInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,name="Dep_ID")
	protected int id = 0;
	
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
	
	@OneToOne(optional = false,mappedBy = "departmentInfo")
	private AcceptStuInfo acceptStuInfo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Aca_ID")
	private AcademyInfo academyInfo;
	
	public AcademyInfo getAcademyInfo() {
		return academyInfo;
	}
	public void setAcademyInfo(AcademyInfo academyInfo) {
		this.academyInfo = academyInfo;
	}
	public AcceptStuInfo getAcceptStuInfo() {
		return acceptStuInfo;
	}
	public void setAcceptStuInfo(AcceptStuInfo acceptStuInfo) {
		this.acceptStuInfo = acceptStuInfo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcceStu_Url() {
		return AcceStu_Url;
	}
	public void setAcceStu_Url(String acceStu_Url) {
		AcceStu_Url = acceStu_Url;
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
