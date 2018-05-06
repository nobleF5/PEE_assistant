//package com.jxufe.handler;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//import com.jxufe.entity.Admin;
//import com.jxufe.entity.User;
//import com.jxufe.service.AdminService;
//import com.jxufe.service.UserService;
//import com.jxufe.util.ImageUtil;
//
//@SessionAttributes("filename")
//@Controller
//public class UserHandler {
//	
//	@Autowired
//	private UserService userservice;
//	@Autowired
//	private AdminService adminService;
//
//	@RequestMapping("valicode")
//	public void valicode(HttpServletResponse response, HttpSession session){
//		Object[] obj = ImageUtil.createImage();
//		
//		String code = (String) obj[0];
//		BufferedImage image = (BufferedImage)obj[1];
//		response.setContentType("image/png");
//		try {
//			ImageIO.write(image, "png", response.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	//修改用户
//	@RequestMapping(value="user/{id}", method=RequestMethod.PUT)
//	public String updateUser(User user){
//		userservice.save(user);
//		return "redirect:/userOper";
//	}
//	
//	//绑定实体�? 初始�?,实现修改图书界面默认值为原来�?
//	@ModelAttribute
//	public void getUser(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map){
//		if(id != null){
//			User user = userservice.findOne(id);
//			map.put("user", user);
//		}
//	}
//	
//	//删除用户 
//	@RequestMapping(value="userOper/{id}",method=RequestMethod.DELETE)
//	public String userDelete(@PathVariable("id") Integer id){
//		
//		userservice.delete(id);
//		return "redirect:/userOper";
//	}
//	
//	
//	//获得�?有用�?
//	@RequestMapping("/userOper")
//	public String userOper(Map<String, Object> map){
//		List<User> users = userservice.findAll();
//		map.put("users", users);
//		return "/foreui/userOper";
//	}
//	
//	//管理员登�?
//	@RequestMapping(value="/adminLogin", method=RequestMethod.POST)
//	public String adminLogin(HttpServletRequest request,
//								@RequestParam("adminname") String adminname,
//								@RequestParam("password") String password){
//
//		System.out.println("adminname: "+adminname);
//		System.out.println("password: "+password);
//		
//		Admin admin = adminService.getByAdminnameAndPassword(adminname, password);
//		if(admin != null && (!"".equals(admin))){
////			return "redirect:/menu";
//			return "foreui/adminHomePage";
//		}else{
//			
//			return "redirect:AdminLogin.jsp";
//		}
//	}
//	
//	//注册
//	@RequestMapping(value="/add",method=RequestMethod.POST)
//	public String save(User user){
//		userservice.save(user);
//		return "redirect:UserLogin.jsp";
//	}
//	
//	//只进行页面转发，不进行业务处�?
//	@RequestMapping(value="adminHomePage_left")
//	public String adminHomePage_left(){
//		
//		return "foreui/adminHomePage_left";
//	}
//	
//	@RequestMapping(value="adminHomePage_top")
//	public String adminHomePage_top(){
//		
//		return "foreui/adminHomePage_top";
//	}
//
//	@RequestMapping(value="addBookInfo")
//	public String addBookInfo(){
//		return "/foreui/addBookInfo";
//	}
//	
//	@RequestMapping(value="uploadFile")
//	public String uploadFile(){
//		return "/foreui/uploadFile";
//	}
//	
//	@RequestMapping(value="addBookHome")
//	public String addBookHome(){
//		return "foreui/addBookHome";
//	}
//	
//	/*
//     *采用spring提供的上传文件的方法
//     */
//    @RequestMapping("/springUpload")
//    public String  springUpload(@RequestParam("bookname") String bookname,
//    			HttpServletRequest request, HttpSession session, Map<String, Object> map) 
//    		throws Exception{
////    	long  startTime=System.currentTimeMillis();
//        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
//       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
//               request.getSession().getServletContext());
//       //�?查form中是否有enctype="multipart/form-data"
//       if(multipartResolver.isMultipart(request))
//       {
//           //将request变成多部分request
//           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
//          //获取multiRequest 中所有的文件�?
//           Iterator iter=multiRequest.getFileNames();  
//           String absolutePath = request.getSession().getServletContext().getRealPath("/WEB-INF/img")+"/";
//            
//           while(iter.hasNext())
//           {
//        	 //�?次遍历所有文�?
//               MultipartFile file=multiRequest.getFile(iter.next().toString());
//               if(file!=null)
//               {
//                   String path= absolutePath + file.getOriginalFilename();
//                   map.put("fileName", file.getOriginalFilename());
//                   map.put("bookname", bookname);
//                   
//                   System.out.println("path: " + path);
//                   //上传
//                   file.transferTo(new File(path));	
//               }
//           }
//       }
////       long  endTime=System.currentTimeMillis();
////       System.out.println("方法三的运行时间�?"+String.valueOf(endTime-startTime)+"ms");
//         
//        return "/foreui/uploadSuccess"; 
//    }
// 
//  //验证用户输入的验证码
//    @ResponseBody
//    @RequestMapping(value="/identifyCode", method=RequestMethod.POST)
//    public String validataCode(@RequestParam("identifyCode") String identifyCode,
//    		HttpSession session){
//    	System.out.println("用户输入验证码位:" + identifyCode);
//    	
//    	Object codeobj = session.getAttribute("code");
//    	String code = codeobj.toString();
//    	System.out.println("系统产生的验证码:" + code);
//    	
//    	if(identifyCode.equals(code)){
//    		System.out.println("后台:用户输入验证码正�?");
//    		return "1";
//    	}else{
//    		System.out.println("后台：用户输入验证码不符�?");
//    		return "0";
//    	}
//    	
//    }
//}