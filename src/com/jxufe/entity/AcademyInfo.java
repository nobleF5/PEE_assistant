package com.jxufe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AcademyInfo")
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
