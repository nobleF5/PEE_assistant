package com.jxufe.handler;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jxufe.entity.StudentInfo;
import com.jxufe.service.StudentInfoService;
import com.jxufe.util.ImageUtil;

@Controller
@RequestMapping(value="/studentInfoHanlder")
public class StudentInfoHanlder {
	
	@Autowired
	private StudentInfoService studentInfoService;
	
	//修改用户
	@RequestMapping(value="studentInfo/{id}", method=RequestMethod.PUT)
	public String updateUser(StudentInfo studentInfo){
		studentInfoService.save(studentInfo);
		return "redirect:/  ";
	}
	
	//删除用户 
	@RequestMapping(value="studentInfo/{id}",method=RequestMethod.DELETE)
	public String userDelete(@PathVariable("id") Integer id){
		
		studentInfoService.delete(id);
		return "redirect:/  ";
	}
	
	
	//获得用户
	@RequestMapping("/getStudentInfo")
	public String userOper(Map<String, Object> map){
		List<StudentInfo> studentInfo = studentInfoService.findAll();
		map.put("studentInfo", studentInfo);
		return "/foreui/  ";
	}
	
	//用户登录
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String adminLogin(HttpServletRequest request,
								@RequestParam("stu_mobile") String stu_mobile,
								@RequestParam("password") String password){

		System.out.println("stu_mobile: "+stu_mobile);
		System.out.println("password: "+password);
		
		boolean studentInfo = studentInfoService.isStudentInfo(stu_mobile, password);
		if(studentInfo){
			return "redirect:/homePage.jsp";
		}else{
			
			return "redirect:/login.jsp";
		}
	}
	
	//用户注册
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String save(StudentInfo studentInfo){
		studentInfoService.save(studentInfo);
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/valicode")
	public void valicode(HttpServletResponse response, HttpSession session){
		Object[] obj = ImageUtil.createImage();
		
		String code = (String) obj[0];
		BufferedImage image = (BufferedImage)obj[1];
		response.setContentType("image/png");
		try {
			ImageIO.write(image, "png", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
