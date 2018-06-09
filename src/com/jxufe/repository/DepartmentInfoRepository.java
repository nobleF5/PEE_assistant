package com.jxufe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jxufe.entity.DepartmentInfo;

public interface DepartmentInfoRepository extends JpaRepository<DepartmentInfo, Integer>{

//	@Query(value = "select di.*"
//			+ "from academy_info ai, department_info di, accept_student_info asi"
//			+ "where di.aca_id =?1 and di.dep_id = asi.dep_id and  ai.aca_id = di.aca_id",
//			nativeQuery = true)
	
//	@Query(value = "from DepartmentInfo di innner join fetch di.academyInfo left join di.acceptStuInfo"
//			+ "where di.id = ?1")
	@Query(value = "from DepartmentInfo di where academyInfo.Aca_ID = ?1")
	List<DepartmentInfo> findByAcaId(int acaId);
}
