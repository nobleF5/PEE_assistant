package com.jxufe.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Cacheable
@Entity
public class AcademyInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,name="Aca_ID")
	private int Aca_ID = 0;
	
	@Column(nullable = true)
	private String Aca_No;
	
	@Column(nullable = true)
	private String Aca_Name;
	
	@Column(nullable = true)
	private boolean Aca_985;
	
	@Column(nullable = true)
	private boolean Aca_211;
	
	@Column(nullable = true)
	private String Aca_city;
	
	@Column(nullable = true)
	private String Dep_Url;

	@OneToOne(optional = false,mappedBy = "academyInfo",fetch=FetchType.LAZY)
	private AcademyRankInfo academyRankInfo;
	
	@OneToMany(mappedBy = "academyInfo")
	private List<DepartmentInfo> departmentInfos;
	
	public AcademyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AcademyInfo(int aca_ID, String aca_No, String aca_Name, boolean aca_985, boolean aca_211, String aca_city) {
		super();
		Aca_ID = aca_ID;
		Aca_No = aca_No;
		Aca_Name = aca_Name;
		Aca_985 = aca_985;
		Aca_211 = aca_211;
		Aca_city = aca_city;
	}


	public AcademyInfo(int aca_ID) {
		super();
		Aca_ID = aca_ID;
	}

	public AcademyInfo(int aca_ID, String aca_No, String aca_Name, boolean aca_985, boolean aca_211, String aca_city,
			String dep_Url, AcademyRankInfo academyRankInfo, List<DepartmentInfo> departmentInfos) {
		super();
		Aca_ID = aca_ID;
		Aca_No = aca_No;
		Aca_Name = aca_Name;
		Aca_985 = aca_985;
		Aca_211 = aca_211;
		Aca_city = aca_city;
		Dep_Url = dep_Url;
		this.academyRankInfo = academyRankInfo;
		this.departmentInfos = departmentInfos;
	}
	public List<DepartmentInfo> getDepartmentInfos() {
		return departmentInfos;
	}
	@JsonIgnore
	public void setDepartmentInfos(List<DepartmentInfo> departmentInfos) {
		this.departmentInfos = departmentInfos;
	}
	public AcademyRankInfo getAcademyRankInfo() {
		return academyRankInfo;
	}
	@JsonIgnore
	public void setAcademyRankInfo(AcademyRankInfo academyRankInfo) {
		this.academyRankInfo = academyRankInfo;
	}
	public String getAca_city() {
		return Aca_city;
	}
	public int getAca_ID() {
		return Aca_ID;
	}
	public void setAca_ID(int aca_ID) {
		Aca_ID = aca_ID;
	}
	public String getDep_Url() {
		return Dep_Url;
	}
	public void setDep_Url(String dep_Url) {
		Dep_Url = dep_Url;
	}
	public String getAca_No() {
		return Aca_No;
	}
	public void setAca_No(String aca_No) {
		Aca_No = aca_No;
	}
	public String getAca_Name() {
		return Aca_Name;
	}
	public void setAca_Name(String aca_Name) {
		Aca_Name = aca_Name;
	}
	public boolean isAca_985() {
		return Aca_985;
	}
	public void setAca_985(boolean aca_985) {
		Aca_985 = aca_985;
	}
	public boolean isAca_211() {
		return Aca_211;
	}
	public void setAca_211(boolean aca_211) {
		Aca_211 = aca_211;
	}
	public String isAca_city() {
		return Aca_city;
	}
	public void setAca_city(String aca_city) {
		Aca_city = aca_city;
	}
	

}
