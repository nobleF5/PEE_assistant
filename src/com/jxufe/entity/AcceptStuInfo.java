package com.jxufe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="AcceptStuInfo")
public class AcceptStuInfo extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = true)
	private int Dep_ID;
	
	@Column(nullable = true)
	private int AcceStu_Num;
	
	@Column(nullable = true)
	private int AcceStu_RecommendNu;
	
	@Column(nullable = true)
	private String AcceStu_ExamScop;

	public int getDep_ID() {
		return Dep_ID;
	}

	public void setDep_ID(int dep_ID) {
		Dep_ID = dep_ID;
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
