package com.jxufe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jxufe.entity.AcademyRankInfo;

public interface AcademyRankInfoRepository extends JpaRepository<AcademyRankInfo,Integer>{
	
	@Query("from ar academyRankInfo where ar.Aca_Ranking>=?1 and ar.Aca_Ranking<=?2 ORDER BY ar.Aca_Ranking desc")
	public List<AcademyRankInfo> findByAca_Ranking(int startRanking, int endRanking);
	
}
