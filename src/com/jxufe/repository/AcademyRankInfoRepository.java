package com.jxufe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jxufe.entity.AcademyInfo;
import com.jxufe.entity.AcademyRankInfo;

public interface AcademyRankInfoRepository extends JpaRepository<AcademyRankInfo,Integer>{
	
//	@Query("from academyRankInfo ar where ar.Aca_Ranking>=?1 and ar.Aca_Ranking<=?2 ORDER BY ar.Aca_Ranking desc")
//	public List<AcademyRankInfo> findByAca_Ranking(int startRanking, int endRanking);
	
	List<AcademyRankInfo> findByAcademyInfo(AcademyInfo academyInfo);
	
	@Query(value = "select ari.* from academy_info ai , academy_rank_info ari where ai.aca_id = ari.aca_id and ai.aca_city like ?1",nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByAca_city(String Aca_city);
	
	
//	@Query(value = "select ai.* from academy_rank_info ari, academy_info ai where ari.aca_id = ar.aca_id and ari.aca_ranking>=?1 and ari.aca_ranking<=?2",nativeQuery = true)
//	List<AcademyRankInfo> findAcademyInfoByRank(int startRanking, int endRanking);
	@Query("select n from AcademyRankInfo n where n.Rank_ID = n.academyInfo.Aca_ID and n.Aca_Ranking >= :startRanking and n.Aca_Ranking <= :endRanking")
	List<AcademyRankInfo> findAcademyInfoByRank(@Param("startRanking")int startRanking, @Param("endRanking")int endRanking);
}
