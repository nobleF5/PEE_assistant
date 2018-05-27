package com.jxufe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jxufe.entity.AcademyInfo;

public interface AcademyInfoRepository extends JpaRepository<AcademyInfo,Integer>{
	
	@Query("from AcademyInfo academyInfo where Aca_city=?1")
	public List<AcademyInfo> findByAca_city(String aca_city);
	
	@Query("from AcademyInfo academyInfo where Aca_211=1")
	public List<AcademyInfo> findByAca_211();
	
	@Query("from AcademyInfo academyInfo where Aca_985=1 and academyInfo.Aca_211=1")
	public List<AcademyInfo> findByAca_985AndAca_211();
}
