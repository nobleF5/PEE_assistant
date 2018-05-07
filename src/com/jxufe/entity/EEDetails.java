package com.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="details_p")
public class EEDetails {
	private int id;
	private String school;
	private boolean _985;
	private boolean _211;
	private String department;
	private String major;
	private String direction;
	private long zhaosheng_number;
	private long tuimian_number;
	private String example_scope;
	@GeneratedValue
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public boolean is_985() {
		return _985;
	}
	public void set_985(boolean _985) {
		this._985 = _985;
	}
	public boolean is_211() {
		return _211;
	}
	public void set_211(boolean _211) {
		this._211 = _211;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public long getZhaosheng_number() {
		return zhaosheng_number;
	}
	public void setZhaosheng_number(long zhaosheng_number) {
		this.zhaosheng_number = zhaosheng_number;
	}
	public long getTuimian_number() {
		return tuimian_number;
	}
	public void setTuimian_number(long tuimian_number) {
		this.tuimian_number = tuimian_number;
	}
	public String getExample_scope() {
		return example_scope;
	}
	public void setExample_scope(String example_scope) {
		this.example_scope = example_scope;
	}
	
	
}
