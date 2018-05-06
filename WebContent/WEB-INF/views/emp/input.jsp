<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
		$(function(){
			$("#lastName").change(function(){
				var val = $(this).val();
				val = $.trim(val);
				$(this).val(val);
					
				//若修改的lastName和之前的lastName一致，则不发送AJAX请求 
				var _oldLastName = $("#_oldLastName").val();
				alert(_oldLastName);
				_oldLastName = $.trim(_oldLastName);
				if (_oldLastName != null && _oldLastName != "" && _oldLastName == val) {
					alert("lastName为旧值，可用 ");
					return;
				}
				
				var url = "${pageContext.request.contextPath}/ajaxValidateLastName";
				var args =  {"lastName":val, "date":new Date()};
				
				$.post(url, args, function name(data) {
					if(data == "0"){
						alert("lastName可用 ");
					}else if(data == "1"){
						alert("lastName不可用 ");
					}else{
						alert("网络或程序出错 ");
					}
				});
			})
		})
</script>
</head>
<body>

	<c:set value="${pageContext.request.contextPath }/emp" var="url"></c:set>	
	<c:if test="${employee.id != null }"> 
		<c:set value="${pageContext.request.contextPath }/emp/${employee.id }" var="url"></c:set>	
	</c:if>

	<form:form action="${url }" method="POST" modelAttribute="employee">
		
		<c:if test="${employee.id != null }"> <!-- 说明处于Employee修改状态,从list到input的过程中，list带了一个参数id用于修改 -->
			<input type="hidden" id="_oldLastName" value="${employee.lastName }"/><!-- 保存旧的lastName用于判断是否和旧lastName一致 -->
			
			<!-- 要修改时，传入要修改记录的id和method -->
			<form:hidden path="id"/>		<!-- 与modelAttribute相关就用form:hidden写隐藏域 -->
			<input type="hidden" name="_method" value="PUT"/>
			
		</c:if>
		
		LastName: <form:input path="lastName" id="lastName"/><br>
		
		Email: <form:input path="email"/><br>
		
		Birth: <form:input path="birth"/><br>
		
		Department: <form:select path="department.id" items="${departments }"
						itemLabel="departmentName" itemValue="id">
					</form:select><br>
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>