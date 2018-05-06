<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书图片上传</title>
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
	  <form id="uploadFileForm" action="${pageContext.request.contextPath }/springUpload" method="post" enctype="multipart/form-data">
	  	<table>
	  		<tr>
	  			<td><img alt="图片上传" src="" width="100px" height="100px"></td>
	  		</tr>
	  		<tr>
	  			<td width=120px>图书名称:</td>
	  			<td><input type="text" name="bookname"  required="required"/></td>
	  		</tr>
	  		<tr>
		  		<td>图书照片:</td>
		  		<td><input type="file" id="myfile" name="file" required="required" ></td>
		  	<tr/>
		  	<tr>
		  		<td><input type="submit" value="上传"></td>
		  	</tr>
	  	</table>
	   </form>
	 </div>
  </body>
</html>
