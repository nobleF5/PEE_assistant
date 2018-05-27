package com.jxufe.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.entity.AcademyRankInfo;
import com.jxufe.repository.AcademyRankInfoRepository;

@Service
public class AcademyRankInfoService {

	private AcademyRankInfoRepository academyRankInfoRepository;
	
	@Transactional
	public List<AcademyRankInfo> findByAca_211(int startRanking, int endRanking){
		
		return academyRankInfoRepository.findByAca_Ranking(startRanking, endRanking);
	}
}
