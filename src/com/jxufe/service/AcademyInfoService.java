package com.jxufe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.entity.AcademyInfo;
import com.jxufe.repository.AcademyInfoRepository;

@Service
public class AcademyInfoService {
	
	@Autowired
	private AcademyInfoRepository academyInfoRepository;
	
	@Transactional
	public List<AcademyInfo> findAll(){
		return academyInfoRepository.findAll();
	}
	
	@Transactional
	public List<AcademyInfo> findByAca_211(){
		return academyInfoRepository.findByAca_211();
	}
	
	@Transactional
	public List<AcademyInfo> findByAca_985AndAca_211(){
		return academyInfoRepository.findByAca_985AndAca_211();
	}
	
	@Transactional
	public List<AcademyInfo> findByAca_city(String aca_city){
		aca_city = "%" + aca_city + "%";
		return academyInfoRepository.findByAca_city(aca_city);
	}
	
	@Transactional
	public List<AcademyInfo> findByAca_cityAndAca_211(String aca_city){
		aca_city = "%" + aca_city + "%";
		return academyInfoRepository.findByAca_cityAndAca_211(aca_city);
	}
	
	@Transactional
	public List<AcademyInfo> findByAcaNameLike(String acaName){
		acaName = "%" + acaName + "%";
		return academyInfoRepository.findByAcaNameLike(acaName);
	}
	
	@Transactional
	public List<AcademyInfo> findByAca_cityAndAca_985AndAca_211(String aca_city){
		aca_city = "%" + aca_city + "%";
		return academyInfoRepository.findByAca_cityAndAca_985AndAca_211(aca_city);
	}
}
