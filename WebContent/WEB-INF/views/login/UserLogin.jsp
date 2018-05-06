<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>登录-图书管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8" />
	
	<!--
	<link type="text/css" href='<c:url value="/css/common.css"></c:url>' />
	<link type="text/css" href='<c:url value="/css/Login.css"></c:url>' />
	<link href='<c:url value="/css/bootstrap.min.css"></c:url>' />  
	<script src='<c:url value="/js/jquery.min.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	-->
	  
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Login.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">  
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	
	
	</head>
	<body background="${pageContext.request.contextPath}/img/bg3.jpg">
			<!--
            	作者：1803279085@qq.com
            	时间：2017-05-01
            	描述：用了Bootstrap
            -->
        <img src="${pageContext.request.contextPath }/img/bg3.jpg" style="display:none"/>
        <div id="content">
        	<div id="header">
        		<div id="header-left">
        			<span id="header-system">图书管理系统</span>
        		</div>
        		<div id="header-right">
	        		<span id="header-home"><a style="color: white;" href="#">首页</a> &nbsp;|&nbsp;</span>
	        		<span id="header-function"><a style="color: white;"  href="#">服务大厅</a>&nbsp;|&nbsp;</span>
	        		<span id="header-advice"><a style="color: white;"  href="#">提建议</a></span>
        		</div>
        	</div>
			<div id="loginFormWrap">
				<form action="/LMS/actions/submitLogin.action" id="loginForm" method="post">
					<div id="welcomewrap">
						<span id="welcome">欢迎你登录图书管理系统</span>
					</div>
					<div id="tipswrap">
						<span id="tips">该用户账号不存在或密码错误与账号不匹配，请确定后再重新输入账号密码</span>
					</div>
					
					<div class="input-group" id="accountWrap">
						<span class="input-group-addon" id="user">
							<span class="glyphicon glyphicon-user" id="userico"></span>
						</span>
						<input name="status" value="userlogin" style="display:none">
						<input type="text" class="form-control" name="username" placeholder="请输入账号" value="${username}">
					</div>
					
					<div class="input-group" id="passwordWrap">
						<span class="input-group-addon" id="lock">
							<span class="glyphicon glyphicon-lock" id="lockico" ></span>
						</span>
						<input type="password" class="form-control" name="passwd" placeholder="请输入密码" value="${passwd}">
					</div>
					<div id="a">
						<a href="#" style="color: white">忘记密码?</a>
					</div>
					<div id="submitdiv">
						<input type="submit" class="btn btn-success" value="登录" />
					</div>
					<div id="formfooder">
						<a href="${pageContext.request.contextPath }/AdminLogin.jsp" target="_blank"><span id="userlogin">管理员登录</span></a>
						<a href="${pageContext.request.contextPath }/Register.jsp" target="_blank"><span id="unpayregister">免费注册</span></a>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>

