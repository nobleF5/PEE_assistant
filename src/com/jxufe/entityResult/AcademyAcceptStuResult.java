package com.jxufe.entityResult;

public class AcademyAcceptStuResult {
	private int dep_id;
	private String aca_name;
	private String dep_name;
	private String dep_specialty;
	private String dep_direction;
	private int acce_stu_num;
	private int acce_stu_recommend_nu;
	private String acce_stu_exam_scop;
	
	
	public AcademyAcceptStuResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AcademyAcceptStuResult(int dep_id, String aca_name, String dep_name, String dep_specialty,
			String dep_direction, int acce_stu_num, int acce_stu_recommend_nu, String acce_stu_exam_scop) {
		super();
		this.dep_id = dep_id;
		this.aca_name = aca_name;
		this.dep_name = dep_name;
		this.dep_specialty = dep_specialty;
		this.dep_direction = dep_direction;
		this.acce_stu_num = acce_stu_num;
		this.acce_stu_recommend_nu = acce_stu_recommend_nu;
		this.acce_stu_exam_scop = acce_stu_exam_scop;
	}
	
	
	public int getAcce_stu_num() {
		return acce_stu_num;
	}

	public int getAcce_stu_recommend_nu() {
		return acce_stu_recommend_nu;
	}

	public void setAcce_stu_recommend_nu(int acce_stu_recommend_nu) {
		this.acce_stu_recommend_nu = acce_stu_recommend_nu;
	}

	public void setAcce_stu_num(int acce_stu_num) {
		this.acce_stu_num = acce_stu_num;
	}

	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getAca_name() {
		return aca_name;
	}
	public void setAca_name(String aca_name) {
		this.aca_name = aca_name;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getDep_specialty() {
		return dep_specialty;
	}
	public void setDep_specialty(String dep_specialty) {
		this.dep_specialty = dep_specialty;
	}
	public String getDep_direction() {
		return dep_direction;
	}
	public void setDep_direction(String dep_direction) {
		this.dep_direction = dep_direction;
	}
	public String getAcce_stu_exam_scop() {
		return acce_stu_exam_scop;
	}
	public void setAcce_stu_exam_scop(String acce_stu_exam_scop) {
		this.acce_stu_exam_scop = acce_stu_exam_scop;
	}
	
	
}
