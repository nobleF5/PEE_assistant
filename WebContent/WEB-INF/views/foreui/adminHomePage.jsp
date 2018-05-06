<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
response.setContentType("text/html;chartset=UTF-8");
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员主页</title>
    
	<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />   
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	</style>
	</head>
	<frameset rows="48,*" >
		<frame src="${pageContext.request.contextPath }/adminHomePage_top"  scrolling="no" noresize="noresize"/>
		<frameset cols="240,*">
			<frame src="${pageContext.request.contextPath }/adminHomePage_left"  scrolling="no" noresize="noresize"/>
			<frame src="${pageContext.request.contextPath }/menu"  name="right" noresize="noresize"/>
		</frameset>
	</frameset>
