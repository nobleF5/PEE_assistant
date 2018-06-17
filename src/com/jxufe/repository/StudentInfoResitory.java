package com.jxufe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jxufe.entity.StudentInfo;

public interface StudentInfoResitory extends JpaRepository<StudentInfo,Integer> {
	
	@Query(value = "select * from student_info stu where stu_mobile = ?1 and stu_password = ?2",nativeQuery = true)
	List<StudentInfo> findStuByMobileAndPsw(String stu_mobile, String stu_password);
	
	@Query(value = "select * from student_info stu where stu_mobile = ?1",nativeQuery = true)
	List<StudentInfo> findStuByMobile(String stu_mobile);
	
	@Query(value = "select new com.jxufe.entity.StudentInfo("
			+ "stu.stuId,stu.Stu_mobile,stu.Stu_name,stu.Stu_password,stu.Stu_sex,stu.Stu_academy,stu.Stu_academy_benke,stu.Stu_profession,stu.Stu_comments)"
			+ " from StudentInfo stu where stu.stuId = ?1")
	StudentInfo findStudentInfoByStuId( int studentInfo_id);
	
}
