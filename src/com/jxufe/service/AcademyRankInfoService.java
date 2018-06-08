package com.jxufe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.entity.AcademyRankInfo;
import com.jxufe.repository.AcademyRankInfoRepository;

@Service
public class AcademyRankInfoService {

	@Autowired
	private AcademyRankInfoRepository academyRankInfoRepository;
	
	@Transactional
	public List<AcademyRankInfo> findAcademyInfoByRank(int startRanking, int endRanking){
		System.out.println("---------------------startRanking:"+startRanking+",endRanking:"+endRanking+"----------------------------");
		return academyRankInfoRepository.findAcademyInfoByRank(startRanking, endRanking);
	}
	
	@Transactional
	public List<AcademyRankInfo> findAcademyInfoByAca_city(String Aca_city){
		System.out.println("------------1-------------");
		Aca_city = "%" + Aca_city + "%";
		return academyRankInfoRepository.findAcademyInfoByAca_city(Aca_city);
	}
	
	@Transactional
	public List<AcademyRankInfo> findAcademyInfoByAca_citAndRank(String Aca_city,int startRanking, int endRanking){
		System.out.println("------------1-------------");
		Aca_city = "%" + Aca_city + "%";
		return academyRankInfoRepository.findAcademyInfoByAca_citAndRank(Aca_city,startRanking,endRanking);
	}
	
	@Transactional
	public List<AcademyRankInfo> findByAca_211(){
		return academyRankInfoRepository.findByAca_211();
	}
	
	@Transactional
	public List<AcademyRankInfo> findByAca_985AndAca_211(){
		return academyRankInfoRepository.findByAca_985AndAca_211();
	}
	
	@Transactional
	public List<AcademyRankInfo> findByAca_cityAndAca_211(String aca_city){
		aca_city = "%" + aca_city + "%";
		return academyRankInfoRepository.findByAca_cityAndAca_211(aca_city);
	}
	
	@Transactional
	public List<AcademyRankInfo> findByAca_cityAndAca_985AndAca_211(String aca_city){
		aca_city = "%" + aca_city + "%";
		return academyRankInfoRepository.findByAca_cityAndAca_985AndAca_211(aca_city);
	}
	
	
}
