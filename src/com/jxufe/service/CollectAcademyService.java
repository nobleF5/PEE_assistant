package com.jxufe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.entityResult.AcademyResult;
import com.jxufe.repository.CollectAcademyInfoRepository;

@Service
public class CollectAcademyService {
	
	@Autowired
	private CollectAcademyInfoRepository collectAcademyInfoRepository;


	public List<AcademyResult> getByStudentInfoStuId(int stuId){
		List<AcademyResult> findByStudentInfoStuId = collectAcademyInfoRepository.findByStudentInfoStuId(stuId);
		return findByStudentInfoStuId;
	}
}
