<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>adminHomePafe_top</title>
    
	<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />   
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		*{
			margin:0;
			padding:0;
		}
		body{
			background: #DCDCDC;
		}
		#page_header{
			background: grey;
			height: 50px;
			clear: both;
		}
		
		#page_header_title{
			float:left;
			padding:8px 15px;
			font-size:28px;
			font-family: "宋体";
			color:white;
		}
		
		#page_header_righttips{
			float:right;
			padding-right:20px;
			padding-top:24px;
			color:white;
			font-family: "宋体";
		}
		a{
			text-decoration:none;
			color:white;
		}
		
	</style>
  </head>
  <body>
  	<div id="page_header">
  		<span id="page_header_title">图书管理系统</span>
  		<span id="page_header_righttips">欢迎管理员admin的登录  &nbsp;&nbsp;<a href="/LibraryManagerSystem/servlet/AdminSaveExit">安全退出</a></span>
  	</div>
  </body>
</html>
