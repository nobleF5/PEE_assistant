<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		#page{
			width:60%;
			height:80%;
			margin:0 auto;
			text-align:center;
		}
		h1{
			padding-top:150px;
		}
		a{
			text-decoration:none;
			color:#4CAE4C;
		}
		span{
			color:red;
		}
	</style>

  </head>
  
  <body onload="refresh()">
  	<div id="page">
	  	<h1>注册成功，<span id="second">5</span>秒后跳转</h1>
	  	<a href="/PEE_assistant/login.jsp">点击进入登录界面</a>
  	</div>
  	<script type="text/javascript">
  		var initSecond = 5;
  		function openNewPage(){
  			location.href="/PEE_assistant/login.jsp";
  		}
  		function refresh(){
			document.getElementById("second").innerHTML=initSecond;
			initSecond--;
			if(initSecond!=0)
  				setTimeout("refresh()",1000);
  		}
  		setTimeout("openNewPage()", 5000);
  	</script>
  </body>
</html>
