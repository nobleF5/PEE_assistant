<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书图片上传成功</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />   
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
	
	<style>
		#uploadFileForm{
			width:30%;
			margin:0 auto;
		}
	</style>
  </head>
  
  <body>
  	<div id="uploadDiv">
	  <form id="uploadFileForm" action="" method="post">
	  	<table>
	  		<tr>
	  			<td><img alt="图片加载失败" src="${pageContext.request.contextPath }/img/${requestScope.fileName}") width="100px" height="100px"></td>
	  		</tr>
	  		<tr>
	  			<td width=120px>图书名称:</td>
	  			<td>${bookname }</td>
	  		</tr>
	  		<tr>
		  		<td>图书照片:</td>
		  		<td>${fileName }</td>
		  	<tr/>
		  	<tr>
		  		<td><span>上传成功！</span><td>
		  	</tr>
	  	</table>
	   </form>
	 </div>
  </body>
</html>
