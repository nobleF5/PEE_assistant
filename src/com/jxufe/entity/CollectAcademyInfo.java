package com.jxufe.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="CollectAcademyInfo")
public class CollectAcademyInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, name="Start_ID")
	private int startId = 0;

	@ManyToOne(fetch=FetchType.LAZY, optional = false, targetEntity=com.jxufe.entity.StudentInfo.class)
	@JoinColumn(name="Stu_Id")
	private Collection<StudentInfo> studentInfo;
	
	@ManyToOne(fetch=FetchType.LAZY, optional = false, targetEntity=com.jxufe.entity.AcademyInfo.class)
	@JoinColumn(name="Aca_ID")
	private Collection<AcademyInfo> academyInfo;

	public int getStartId() {
		return startId;
	}

	public void setStartId(int startId) {
		this.startId = startId;
	}

	public Collection<StudentInfo> getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(Collection<StudentInfo> studentInfo) {
		this.studentInfo = studentInfo;
	}

	public Collection<AcademyInfo> getAcademyInfo() {
		return academyInfo;
	}

	public void setAcademyInfo(Collection<AcademyInfo> academyInfo) {
		this.academyInfo = academyInfo;
	}

	
	
}
