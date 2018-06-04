package com.jxufe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jxufe.entity.StudentInfo;

public interface StudentInfoResitory extends JpaRepository<StudentInfo,Integer> {
	
	@Query(value = "select * from student_info stu where stu_mobile = ?1 and stu_password = ?2",nativeQuery = true)
	List<StudentInfo> findStuByMobileAndPsw(String stu_mobile, String stu_password);

}
