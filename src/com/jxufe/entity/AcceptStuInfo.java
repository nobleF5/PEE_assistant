package com.jxufe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AcceptStudentInfo")
public class AcceptStuInfo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,name="AcceStu_ID")
	protected int id = 0;
	
	@OneToOne(optional = false,fetch=FetchType.LAZY)
    @JoinColumn(name = "Dep_ID", referencedColumnName ="Dep_ID")
	private DepartmentInfo departmentInfo;
	
	@Column(nullable = true)
	private int AcceStu_Num;
	
	@Column(nullable = true)
	private int AcceStu_RecommendNu;
	
	@Column(nullable = true)
	private String AcceStu_ExamScop;
	
	public DepartmentInfo getDepartmentInfo() {
		return departmentInfo;
	}

	public void setDepartmentInfo(DepartmentInfo departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	public int getAcceStu_Num() {
		return AcceStu_Num; 	
	}

	public void setAcceStu_Num(int acceStu_Num) {
		AcceStu_Num = acceStu_Num;
	}

	public int getAcceStu_RecommendNu() {
		return AcceStu_RecommendNu;
	}

	public void setAcceStu_RecommendNu(int acceStu_RecommendNu) {
		AcceStu_RecommendNu = acceStu_RecommendNu;
	}

	public String getAcceStu_ExamScop() {
		return AcceStu_ExamScop;
	}

	public void setAcceStu_ExamScop(String acceStu_ExamScop) {
		AcceStu_ExamScop = acceStu_ExamScop;
	}
	
	
}
