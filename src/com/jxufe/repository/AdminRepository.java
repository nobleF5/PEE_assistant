//package com.jxufe.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.jxufe.entity.Admin;
//
//public interface AdminRepository extends JpaRepository<Admin, Integer>{
//
//	/*
//	@Query("from table t where t.propertyOne in :param1 and (t.propertyTwo like :param2 or t.propertyThree like :param3 or t.propertyFour like :param4)")
//	List<Table> findByParams(@Param("param1") List<String> param1, @Param("param2") String param2, @Param("param3") String param3, @Param("param4") String param4);
//	*/
//	
//	public Admin getByAdminnameAndPassword(String adminname, String password);
//}
