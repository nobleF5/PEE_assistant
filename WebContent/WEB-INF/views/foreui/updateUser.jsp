<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>updateUser.jsp</title>
	<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
	<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />   
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
	
	<style>
		#Table{
			margin:0 auto;
			width:400px;
			border-collapse:collapse;
			border:solid thin gray;
		}
		th{
			background:gray;
			color:white;
			text-align:center;
		}
		tr,td{
			width:240px;
			margin:3px 2px;
		}
		#input{
			size:24px;
		}
		#submit{
			display:inline-block;
			width:60px;
			text-decoration:none;
			background:#4CAE4C;
			color:white;
			font-family:"宋体";
			font-size:16px;
			padding:6px 8px;
			border-radius:4px;
		}
	</style>
	
  </head>

  <body>
  	<form:form action="${pageContext.request.contextPath }/user/${user.id }" method="PUT" modelAttribute="user">
  	<!--  
  		<input type="hidden" name="_method" value="PUT">
  		<form:hidden path="id"/>
  	-->
  	
	  	<table id="Table">
	    	<tr>
	    		<th>用户名</th>
	    		<th>密码</th>
	    	</tr>
	    	<tr>
	    		<td>
	    			<form:input class="input" path="username"/>
	    		</td>
				<td>
		    		<form:input class="input" path="password"/>
		    	</td>
	    	</tr>
	    	<tr>
		    	<td>
		    		<input id="submit" type="submit" value="提交">
		    	</td>
		    	<td></td>
	    	</tr>
	    </table>
  	</form:form>
   
  </body>
</html>
