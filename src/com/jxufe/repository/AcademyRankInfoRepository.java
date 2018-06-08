package com.jxufe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jxufe.entity.AcademyInfo;
import com.jxufe.entity.AcademyRankInfo;

public interface AcademyRankInfoRepository extends JpaRepository<AcademyRankInfo,Integer>{
	
	List<AcademyRankInfo> findByAcademyInfo(AcademyInfo academyInfo);
	
	@Query(value = "select ari.* from academy_info ai , academy_rank_info ari where ai.aca_id = ari.aca_id and ai.aca_city like ?1",nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByAca_city(String Aca_city);
	
	
	@Query(value = "select ari.* from academy_rank_info ari, academy_info ai where ari.aca_id = ai.aca_id and ari.aca_ranking>=?1 and ari.aca_ranking<=?2",nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByRank(int startRanking, int endRanking);

	@Query(value = "select ari.* from academy_rank_info ari, academy_info ai where ari.aca_id = ai.aca_id and ai.aca_city like ?1 and ari.aca_ranking>=?2 and ari.aca_ranking<=?3",nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByAca_citAndRank(String Aca_city,int startRanking, int endRanking);


	@Query(value = "select ari.* from academy_rank_info ari, academy_info ai where ari.aca_id = ai.aca_id and ai.aca_211=1",nativeQuery = true)
	public List<AcademyRankInfo> findByAca_211();
	
	@Query(value = "select ari.* from academy_rank_info ari, academy_info ai where ari.aca_id = ai.aca_id and ai.aca_985=1 and ai.aca_211=1",nativeQuery = true)
	public List<AcademyRankInfo> findByAca_985AndAca_211();
	
	@Query(value = "select ari.* from academy_rank_info ari, academy_info ai where ari.aca_id = ai.aca_id and ai.aca_211=1 and ai.aca_city like ?1",nativeQuery = true)
	public List<AcademyRankInfo> findByAca_cityAndAca_211(String aca_city);
	
	@Query(value = "select ari.* from academy_rank_info ari, academy_info ai where ari.aca_id = ai.aca_id and ai.aca_211=1 and ai.aca_985=1 and ai.aca_city like ?1",nativeQuery = true)
	public List<AcademyRankInfo> findByAca_cityAndAca_985AndAca_211(String aca_city);
}
