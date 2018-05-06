//package com.jxufe.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.jxufe.entity.Admin;
//import com.jxufe.repository.AdminRepository;
//
//@Service
//public class AdminService {
//	
//	@Autowired
//	private AdminRepository adminRepository;
//	
//	@Transactional
//	public Admin getByAdminnameAndPassword(String adminname, String password){
//		return adminRepository.getByAdminnameAndPassword(adminname, password);
//	}
//
//}
