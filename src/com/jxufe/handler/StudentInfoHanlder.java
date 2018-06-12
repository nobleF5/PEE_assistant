package com.jxufe.handler;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.entity.StudentInfo;
import com.jxufe.service.StudentInfoService;
import com.jxufe.status.LoginStatus;
import com.jxufe.util.ImageUtil;
import com.jxufe.util.MyMd5;

@Controller
@RequestMapping(value="/studentInfoHanlder")
public class StudentInfoHanlder {
	
	@Autowired
	private StudentInfoService studentInfoService;
	
	//�޸��û�
	@RequestMapping(value="studentInfo/{id}", method=RequestMethod.PUT)
	public String updateUser(StudentInfo studentInfo){
		studentInfoService.save(studentInfo);
		return "redirect:/  ";
	}
	
	//ɾ���û� 
	@RequestMapping(value="studentInfo/{id}",method=RequestMethod.DELETE)
	public String userDelete(@PathVariable("id") Integer id){
		
		studentInfoService.delete(id);
		return "redirect:/  ";
	}
	
	
	//����û�
	@ResponseBody
	@RequestMapping("/getPersonalStudentInfo")
	public StudentInfo userOper(@RequestParam("studentInfo_id") int studentInfo_id){
		StudentInfo studentInfo = studentInfoService.getPersonnalCenter(studentInfo_id);
		System.out.println("�û���:" + studentInfo.getStu_name()+"�������������");
		return studentInfo;
	}
	
	//�û���¼
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String adminLogin(HttpServletRequest request,
								@RequestParam("stu_mobile") String stu_mobile,
								@RequestParam("password") String password){
		System.out.println("raw password:" + password);
		String passMD5 = MyMd5.MD5(password);
		
		System.out.println("stu_mobile: "+stu_mobile);
		System.out.println("passMD5: "+passMD5);
		List<StudentInfo> studentInfos = studentInfoService.findStuByMobile(stu_mobile);

		LoginStatus loginStatus = new LoginStatus();
		System.out.println(studentInfos.size());
		System.out.println(studentInfos);
		if(studentInfos == null || studentInfos.size()<=0) {
			loginStatus.setMessage(LoginStatus.ERROR_ACCOUNT_MSG);
			return "redirect:/login.jsp";
		}else {
			StudentInfo studentInfo = studentInfos.get(0);
			boolean isStudent = studentInfoService.isStudentInfo(stu_mobile, passMD5);
			if(isStudent){
				try {
					request.getSession().setAttribute("stu_id", studentInfo.getStu_Id());
					request.getSession().setAttribute("stu_name", studentInfo.getStu_name());
				}catch(Exception e) {
					System.out.println("��ѧ��stu_id���õ�session��ʧ��");
					e.printStackTrace();
				}
				return "redirect:/homePage.jsp";
			}else{
				loginStatus.setMessage(LoginStatus.ERROR_PASSWORD_MSG);
				return "redirect:/login.jsp";
			}
		}
	}
	
	//�û��ǳ�
	@RequestMapping(value="/loginOut",method=RequestMethod.GET)
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/homePage.jsp";
	}
	
	//�û�ע��
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String save(StudentInfo studentInfo){
		String stu_password = studentInfo.getStu_password();
		String passMD5 = MyMd5.MD5(stu_password);
		studentInfo.setStu_password(passMD5);
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
