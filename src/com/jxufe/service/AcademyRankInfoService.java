//package com.jxufe.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.jxufe.entity.AcademyRankInfo;
//import com.jxufe.repository.AcademyRankInfoRepository;
//
//@Service
//public class AcademyRankInfoService {
//
//	@Autowired
//	private AcademyRankInfoRepository academyRankInfoRepository;
//	
//	@Transactional
//	public List<AcademyRankInfo> findByAca_Ranking(int startRanking, int endRanking){
//		
//		return academyRankInfoRepository.findByAca_Ranking(startRanking, endRanking);
//	}
//}
