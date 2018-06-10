package com.jxufe.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jxufe.entity.CollectAcademyInfo;
import com.jxufe.entityResult.AcademyResult;

public interface CollectAcademyInfoRepository extends JpaRepository<CollectAcademyInfo, Integer>{
	
	@Query("select new com.jxufe.entityResult.AcademyResult("
			+ "academyInfo.Aca_ID,academyInfo.Aca_Name,academyInfo.Aca_985,academyInfo.Aca_211)"
			+ "from CollectAcademyInfo cai where studentInfo.stuId = ?1")
	List<AcademyResult> findByStudentInfoStuId(int stuId);
}
