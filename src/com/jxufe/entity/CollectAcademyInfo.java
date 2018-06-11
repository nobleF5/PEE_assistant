package com.jxufe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CollectAcademyInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, name="start_id")
	private int startId = 0;

	@ManyToOne(fetch=FetchType.LAZY, optional = false, targetEntity=com.jxufe.entity.StudentInfo.class)
	@JoinColumn(name="stu_id")
	private StudentInfo studentInfo;
	
	@ManyToOne(fetch=FetchType.LAZY, optional = false, targetEntity=com.jxufe.entity.AcademyInfo.class)
	@JoinColumn(name="aca_id")
	private AcademyInfo academyInfo;

	public int getStartId() {
		return startId;
	}

	public void setStartId(int startId) {
		this.startId = startId;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	@JsonIgnore
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public AcademyInfo getAcademyInfo() {
		return academyInfo;
	}
	
	@JsonIgnore
	public void setAcademyInfo(AcademyInfo academyInfo) {
		this.academyInfo = academyInfo;
	}
	
}
