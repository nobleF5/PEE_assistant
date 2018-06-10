package com.jxufe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="StudentInfo")
public class StudentInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stu_id")
	private int stuId;
	
	private String Stu_mobile;
	
	private String Stu_name;
	
	private String Stu_password;
	
	private String Stu_sex;
	
	private String Stu_academy;
	
	private String Stu_academy_benke;
	
	private String Stu_profession;
	
	private String Stu_comments;

	@OneToMany(mappedBy = "studentInfo",fetch=FetchType.LAZY)
	private List<CollectAcademyInfo> CollectAcademyInfos;
	
	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentInfo(int stuId, String stu_mobile, String stu_name, String stu_password, String stu_sex,
			String stu_academy, String stu_academy_benke, String stu_profession, String stu_comments) {
		super();
		this.stuId = stuId;
		Stu_mobile = stu_mobile;
		Stu_name = stu_name;
		Stu_password = stu_password;
		Stu_sex = stu_sex;
		Stu_academy = stu_academy;
		Stu_academy_benke = stu_academy_benke;
		Stu_profession = stu_profession;
		Stu_comments = stu_comments;
	}
	
	public List<CollectAcademyInfo> getCollectAcademyInfos() {
		return CollectAcademyInfos;
	}
	public void setCollectAcademyInfos(List<CollectAcademyInfo> collectAcademyInfos) {
		CollectAcademyInfos = collectAcademyInfos;
	}
	public String getStu_academy_benke() {
		return Stu_academy_benke;
	}

	public void setStu_academy_benke(String stu_academy_benke) {
		Stu_academy_benke = stu_academy_benke;
	}

	public String getStu_profession() {
		return Stu_profession;
	}

	public void setStu_profession(String stu_profession) {
		Stu_profession = stu_profession;
	}

	public String getStu_comments() {
		return Stu_comments;
	}

	public void setStu_comments(String stu_comments) {
		Stu_comments = stu_comments;
	}

	public String getStu_name() {
		return Stu_name;
	}

	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}

	public String getStu_password() {
		return Stu_password;
	}

	public void setStu_password(String stu_password) {
		Stu_password = stu_password;
	}

	public String getStu_sex() {
		return Stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		Stu_sex = stu_sex;
	}

	public String getStu_mobile() {
		return Stu_mobile;
	}

	public void setStu_mobile(String stu_mobile) {
		Stu_mobile = stu_mobile;
	}

	public String getStu_academy() {
		return Stu_academy;
	}

	public void setStu_academy(String stu_academy) {
		Stu_academy = stu_academy;
	}

	public int getStu_Id() {
		return stuId;
	}

	public void setStu_Id(int stu_Id) {
		stuId = stu_Id;
	}

}
