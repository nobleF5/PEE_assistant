package com.jxufe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.entity.StudentInfo;
import com.jxufe.repository.StudentInfoResitory;

@Service
public class StudentInfoService {

	@Autowired
	private StudentInfoResitory studentInfoResitory;
	
	@Transactional
	public void save(StudentInfo studentInfo) {
		studentInfoResitory.saveAndFlush(studentInfo);
	}

	public List<StudentInfo> findStuByMobile(String stu_mobile) {
		List<StudentInfo> info = studentInfoResitory.findStuByMobile(stu_mobile);
		return info;
	}
	public boolean isStudentInfo(String stu_mobile, String stu_password) {
		boolean isStu = false;
		List<StudentInfo> stuInfos = studentInfoResitory.findStuByMobileAndPsw(stu_mobile,stu_password);
		if(!stuInfos.isEmpty()) {
			isStu =true;
			System.out.println("查有此人");
		}
		return isStu;
	}
	
	@Transactional
	public StudentInfo getPersonnalCenter( int studentInfo_id) {
		return studentInfoResitory.findStudentInfoByStuId(studentInfo_id);
	}
	
	@Transactional
	public List<StudentInfo> findAll() {
		return studentInfoResitory.findAll();
	}
	
	@Transactional
	public void delete(Integer id){
		studentInfoResitory.delete(id);
	}
	
	@Transactional
	public StudentInfo findOne(Integer id){
		return studentInfoResitory.findOne(id);
	}
	
}
