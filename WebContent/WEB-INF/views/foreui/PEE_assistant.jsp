<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>院校展示</title>
    
	<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />   
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
	
	<style type="text/css">
		*{
			margin:0px;
			padding:0px;
		}
		body{
			background: gainsboro;
		}
		#userOperTable{
			width:900px;
			margin:10px auto;
			border-collapse:collapse;
			border: solid thin gray;
		}
		
		th{
			background:gray;
			color:white;
			min-width:40px;
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
			
			var td = $("td .collegue_grass");
			var value = td.text();
		})   
	
	</script>
	
  </head>
  <body>
  	<form action="" method="POST" id="_form">
  		<input type="hidden" id="_method" name="_method" value="DELETE">
  	</form>
  
    <table id="userOperTable" onmousemove="fmove()" onmouseout="fout()">
    	<tr>
    		<th>学校</th>  
            <th>985</th>
            <th>211</th>
            <th>院系</th>   
            <th>专业</th>
            <th>招生人数</th>
            <th>推免人数</th>
    	</tr>
    	<c:forEach items="${eEDetails }" var="eEDetails">
    	<tr>
		    <td>${eEDetails.school }</td>
		    <td class="collegue_grass">${eEDetails._985}</td>
		    <td class="collegue_grass">${eEDetails._211}</td>
		    <td>${eEDetails.department }</td>
		    <td>${eEDetails.major }</td>
		    <td>${eEDetails.zhaosheng_number}</td>
		    <td>${eEDetails.tuimian_number}</td>
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
