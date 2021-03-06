<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>考研软件专业信息查询</title>
	<style type="text/css">
		*{
			margin:0px;
			padding:0px;
		}
		body{
			background: gainsboro;
		}
		#userOperTable{
			width:500px;
			margin:10px auto;
			border-collapse:collapse;
			border: solid thin gray;
		}
		
		th{
			background:gray;
			color:white;
		}
		tr{
			background:white;
		}
		th,td{
			padding:2px 18px;
			text-align:left;
			
		}
		a{
			display:inline-block;
			text-decoration:none;
			background:#4CAE4C;
			color:white;
			font-family:"宋体";
			font-size:16px;
			padding:6px 8px;
			margin:1px 2px;
			text-align:center;
			border-radius:4px;
		}
	</style>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(function(){
			$(".delete").click(function(){
				var label = $("#label").val();
				var flag = confirm("确定要删除 " + label + "的信息? ");
				if(flag){
					var url = $(this).attr("href");
					
					$("#_form").attr("action", url);
					$("#_method").val("DELETE");
					$("#_form").submit();
				}
				return false;
			});
			
			$("a").click(function(){
				$.ajax({
					type: "get",
					dataType: "html",
					url: '/queryeedetails',
					data: dataurl,
					success: function (data) {
						if (data != "") {
							console.log(data)
							}
						}
					});
			})
			
		})   
	
	</script>
</head>
<body>
	<!--  <a href="/PEE_assistant/queryeedetails">获取用户信息</a> -->
	<a>获取用户信息</a>
	<form action="" method="POST" id="_form">
  		<input type="hidden" id="_method" name="_method" value="DELETE">
  	</form>
  
    <table id="userOperTable" onmousemove="fmove()" onmouseout="fout()">
    	<tr>
    		<th>姓名</th>  
            <th>密码</th>   
            <th>操作</th>
    	</tr>
    	<c:forEach items="${users }" var="user">
    	<tr>
		    <td>${user.username }</td>
		    <td>${user.password }</td>
		    <td>
		    	<a href="#" class="delete">删除</a>
		    	<a href="#">修改</a>
		    	<input type="hidden" id="label" value="${user.username }"/> 
		    </td>
		</tr>
    	</c:forEach>	
    </table>
   
    <script type="text/javascript">
    	var table = document.getElementById("userOperTable");
    	var trs = document.getElementsByTagName("tr");
    	var start=1;
    	for(var i=start;i<trs.length;i++){
    		if(i%2==0){
    			trs[i].style.background="white";
    		}
    		else
    			trs[i].style.background="gainsboro";
    	}
    	
    	function fmove(){
    		var e = event.srcElement;
    		if(e.tagName=="TD"){
    			e.parentNode.style.background="#BDB76B";
    		}
    		if(e.tagName=="A"){
    			e.parentNode.parentNode.style.background="#BDB76B";
    		}
    	}
    	
    	function fout(){
    		var trs = document.getElementsByTagName("tr");
    		var start=1;
    		for(var i=start;i<trs.length;i++){
	    		if(i%2==0){
	    			trs[i].style.background="white";
	    		}
	    		else
	    			trs[i].style.background="gainsboro";
	    	}
    	}
    </script>
</body>
</html>