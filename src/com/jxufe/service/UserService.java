//package com.jxufe.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.jxufe.entity.User;
//import com.jxufe.repository.UserRepository;
//
//@Service
//public class UserService {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Transactional
//	public void save(User user){
//		userRepository.saveAndFlush(user);
//	}
//
//	@Transactional
//	public List<User> findAll(){
//		return userRepository.findAll();
//	}
//	
//	@Transactional
//	public void delete(Integer id){
//		userRepository.delete(id);
//	}
//	
//	public User findOne(Integer id){
//		return userRepository.findOne(id);
//	}
//}
