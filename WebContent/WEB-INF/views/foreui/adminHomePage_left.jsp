<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>adminHomePage_left.jsp</title>
    
	<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />   
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body{
			background: #DCDCDC;
		}
		a{
			display:block;
			width:180px;
			text-decoration:none;
			background:#4CAE4C;
			color:white;
			font-family:"宋体";
			font-size:24px;
			padding:10px 14px;
			margin:10px 8px;
			text-align:center;
			border-radius:4px;
		}
		div{
			width:220px;
		}
	</style>

  </head>
  
  <body>
    <div>
    	<a href="${pageContext.request.contextPath }/userOper" target="right">用户管理</a>
    	</div>
    <div>
		<a href="${pageContext.request.contextPath }/menu"  target="right">查看图书</a>    
    </div>
    <div>
    	<a href="${pageContext.request.contextPath }/addBookHome"  target="right">添加图书</a>
    </div>
    <div>
    	<a href="#"  target="right">删除图书</a>
    </div>
    <div>
    	<a href="#"  target="right">更改图书</a>
    </div>
	
  </body>
</html>
