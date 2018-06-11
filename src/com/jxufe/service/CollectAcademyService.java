package com.jxufe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.entity.CollectAcademyInfo;
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
	
	public List<CollectAcademyInfo> findAll(){
		return collectAcademyInfoRepository.findAll();
	}
	
	@Transactional
	public void collectAcademy(CollectAcademyInfo collectAcademyInfo) {
		collectAcademyInfoRepository.saveAndFlush(collectAcademyInfo);
	}
}
