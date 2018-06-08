package com.jxufe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jxufe.entity.AcademyInfo;
import com.jxufe.entity.AcademyRankInfo;

public interface AcademyRankInfoRepository extends JpaRepository<AcademyRankInfo,Integer>{
	
//	@Query(value = "select new com.jxufe.entityResult.AcademyResult("
//			+ "ai.Aca_city,ai.academyRankInfo.Aca_Ranking,"
//			+ "ai.Aca_985,ai.Aca_211) "
//			+ "from AcademyInfo ai")
//	List<AcademyResult> myFindAll();
	
	List<AcademyRankInfo> findByAcademyInfo(AcademyInfo academyInfo);
	
	@Query(value = "select ari.* "
			+ "from academy_info ai , academy_rank_info ari "
			+ "where ai.aca_id = ari.aca_id and ai.aca_city like ?1",
			nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByAca_city(String Aca_city);
	
	
	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ari.aca_ranking>=?1 and ari.aca_ranking<=?2",
			nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByRank(int startRanking, int endRanking);

	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_985=1 "
			+ "and ari.aca_ranking>=?1 and ari.aca_ranking<=?2",
			nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByAca_985AndRank(int startRanking, int endRanking);
	
	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_211=1"
			+ "and ari.aca_ranking>=?1 and ari.aca_ranking<=?2",
			nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByAca_211AndRank(int startRanking, int endRanking);
	
	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_city like ?1 "
			+ "and ari.aca_ranking>=?2 and ari.aca_ranking<=?3",
			nativeQuery = true)
	List<AcademyRankInfo> findAcademyInfoByAca_citAndRank(String Aca_city,
			int startRanking, int endRanking);


	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_211=1",
			nativeQuery = true)
	public List<AcademyRankInfo> findByAca_211();
	
	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_985=1 and ai.aca_211=1",
			nativeQuery = true)
	public List<AcademyRankInfo> findByAca_985AndAca_211();
	
	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_211=1 "
			+ "and ai.aca_city like ?1",
			nativeQuery = true)
	public List<AcademyRankInfo> findByAca_cityAndAca_211(String aca_city);
	
	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_211=1 and ai.aca_985=1 and ai.aca_city like ?1",
			nativeQuery = true)
	public List<AcademyRankInfo> findByAca_cityAndAca_985AndAca_211(String aca_city);
	
	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_city like ?1 and ai.aca_985=1 "
			+ "and ari.aca_ranking>=?2 and ari.aca_ranking<=?3",
			nativeQuery = true)
	public List<AcademyRankInfo> findAcademyInfoByAca_citAndAca_985AndRank(String Aca_city,
			int startRanking, int endRanking);
	
	@Query(value = "select ari.* "
			+ "from academy_rank_info ari, academy_info ai "
			+ "where ari.aca_id = ai.aca_id and ai.aca_city like ?1 and ai.aca_211=1 "
			+ "and ari.aca_ranking>=?2 and ari.aca_ranking<=?3",
			nativeQuery = true)
	public List<AcademyRankInfo> findAcademyInfoByAca_citAndAca_211AndRank(String Aca_city,
			int startRanking, int endRanking);
}
