package com.jxufe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jxufe.entity.AcademyRankInfo;
import com.jxufe.entity.StudentInfo;

public interface StudentInfoResitory extends JpaRepository<StudentInfo,Integer> {
	
}
