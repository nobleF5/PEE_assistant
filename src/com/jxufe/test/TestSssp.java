//package com.jxufe.test;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.jxufe.entity.User;
//import com.jxufe.service.UserService;
//
//
//public class TestSssp {
//	private ApplicationContext ctx = null;
//	private UserService userService;
//	
//	{
//		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//	}
//	
//	@Test
//	public void testDataSource() throws SQLException {
//		DataSource dataSource = ctx.getBean(DataSource.class);
//		System.out.println(dataSource.getConnection());
//	}
//	
//	@Test
//	public void testFindUser() {
//		List<User> users = userService.findAll();
//		System.out.println(users);
//	}
//}
