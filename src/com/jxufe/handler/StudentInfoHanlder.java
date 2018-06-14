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
import com.miaodiyun.httpAiDemo.IndustrySMS;

import net.sf.json.JSONObject;

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
	@ResponseBody
	@RequestMapping("/getPersonalStudentInfo")
	public StudentInfo userOper(@RequestParam("studentInfo_id") int studentInfo_id){
		StudentInfo studentInfo = studentInfoService.getPersonnalCenter(studentInfo_id);
		System.out.println("用户名:" + studentInfo.getStu_name()+"进入个人中心了");
		return studentInfo;
	}
	
	//检查手机号
	@ResponseBody
	@RequestMapping("/checkMobile")
	public boolean checkMobile(@RequestParam("stu_mobile") String stu_mobile){
		boolean mobileExit = true;
		List<StudentInfo> findStuByMobile = studentInfoService.findStuByMobile(stu_mobile);
		if(findStuByMobile == null || findStuByMobile.size()<=0) {
			mobileExit = false;
		}
		return mobileExit;
	}
	
	//用户登录
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
					System.out.println("将学生stu_id设置到session中失败");
					e.printStackTrace();
				}
				return "redirect:/homePage.jsp";
			}else{
				loginStatus.setMessage(LoginStatus.ERROR_PASSWORD_MSG);
				return "redirect:/login.jsp";
			}
		}
	}
	
	//用户登出
	@RequestMapping(value="/loginOut",method=RequestMethod.GET)
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/homePage.jsp";
	}
	
	//用户注册
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
	
	//获得手机验证码
	@ResponseBody
	@RequestMapping(value = "/getMobileValidataCode", method = RequestMethod.POST)
	public String getMobileValidataCode(@RequestParam("tel") String tel,HttpSession session) {
		// 验证码通知短信接口
		int identifyCode = (int) ((Math.random() * 9 + 1) * 100000);
		String identifyCodeStr = identifyCode + "";
		IndustrySMS.setIdentidyCode(identifyCodeStr);
		IndustrySMS.setTo(tel);
		 String sendResponse = IndustrySMS.execute();
//		String sendResponse = "{\"respCode\":\"00000\",\"respDesc\":\"请求成功。\",\"failCount\":\"0\",\"failList\":[],\"smsId\":\"cb2057884e9d4acd8568f40b309edc9c\"}";

		JSONObject json = JSONObject.fromObject(sendResponse);

		String sendMessageResult = json.get("respCode").toString();

		session.setAttribute("mobileValidataCode", identifyCodeStr);
		
		System.out.println("手机为:+"+ tel +"验证码为:" + identifyCodeStr);
		System.out.println("请求结果:" + sendMessageResult);
		
		return sendMessageResult;
	}
	
		//验证用户输入的验证码
		@ResponseBody
		@RequestMapping(value = "/validataMobileValidataCode", method = RequestMethod.POST)
		public String validataMobileValidataCode(@RequestParam("identifyCode") String mobilecode,
												 HttpSession session) {
			
			String mobileValidataCode = session.getAttribute("mobileValidataCode").toString();
			System.out.println(" 手机验证码为:" + mobileValidataCode);
			if(mobileValidataCode.equals(mobilecode)){
	    		System.out.println("后台:用户输入手机验证码正正确");
	    		return "0";
	    	}else{
	    		System.out.println("后台：用户输入验证码不符合");
	    		return "-1";
	    	}
		}
}