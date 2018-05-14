package com.jxufe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="AcademyInfo")
public class AcademyInfo extends IdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = true)
	private String Aca_No;
	
	@Column(nullable = true)
	private String Aca_Name;
	
	@Column(nullable = true)
	private boolean Aca_985;
	
	@Column(nullable = true)
	private boolean Aca_211;
	
	@Column(nullable = true)
	private boolean Aca_city;
	
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
	public boolean isAca_city() {
		return Aca_city;
	}
	public void setAca_city(boolean aca_city) {
		Aca_city = aca_city;
	}
	

}
