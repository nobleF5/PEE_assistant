<%@page import="net.sf.json.JSON"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>注册</title>

<meta http-equiv="pragma" content="no-cache" charset="utf-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon" />

<style>
body {
	background: gainsboro;
}

h1 {
	font-family: italic;
	color: #333333;
}

input[type="text"] {
	height: 30px;
	width: 100%;
	border-color: white;
}

#userNameI {placeholder ="用户名";
	
}

input[type="text"]:focus {
	outline: none;
	border-color: lightskyblue;
}

input[type="password"] {
	height: 30px;
	width: 100%;
	border-color: white;
}

input[type="password"]:focus {
	outline: none;
	border-color: lightskyblue;
}

input[type="submit"] {
	display: inline-block;
	width: 100%;
	height: 35px;
	font-size: 14px;
	font-family: "新宋体";
	font-weight: bold;
}

.RegisterBT {
	background-color: #FF6666;
	color: white;
	font-weight: bold;
	border-radius: 8px;
	-moz-border-radius: 8px;
}

.bnt {
	display: inline-block;
	float: right;
	height: 35px;
	font-size: 14px;
	font-family: "新宋体";
	font-weight: bold;
}

.lefttips {
	font-weight: bold;
	color: gray;
	visibility: hidden;
}

span#reader {
	text-decoration: none;
	font-size: 12px;
	visibility: visible;
}

div {
	margin: 2px 4px;
	padding: 8px 4px;
	text-align: center;
	font-size: 12px;
	font-weight: bold;
	color: gray;
	background-color: #E6E6E6;
	visibility: hidden;
}

li {
	list-style: none;
}
</style>

	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
	<script src="${pageContext.request.contextPath }/js/VerifiCutDown.js"></script>

</head>
<body>
    
	<h1 align="center">用户注册</h1>
	<hr />
	<form action="" method="post" id="_form" name="_form">
		<input type="hidden" id="_method" name="_method" value="POST" />
		<table align="center" height="300px" width="600px">
			<tr>
				<td width="24%"><span id="userNameO" class="lefttips">用户名*</span></td>
				<td width="52%"><input type="text" name="stu_name"
					required="required" id="userNameI" placeholder="用户名"
					onfocus="checkUsername()" onChange="checkUsername()" /></td>
				<td><div id="div1">用户名不能为空</div></td>
			</tr>

			<tr>
				<td><span id="passwordtip" class="lefttips">密码*</span></td>
				<td><input type="password" name="stu_password" id="password0"
					placeholder="密码" required="required" onfocus="checkPasswords()"
					onChange="checkPasswords()" /></td>
				<td><div id="div2">密码不能为空</div></td>
			</tr>
			<tr>
				<td><span id="password1tip" class="lefttips">确定密码*</span></td>
				<td><input name="passwordconfirm" type="password"
					id="password1" required="required" placeholder="确定密码"
					onfocus="confirmPasswords()" onChange="confirmPasswords()" /></td>
				<td><div id="div3">请确定密码一致性</div></td>
			</tr>

			<tr style="height: 12px"></tr>
			<tr>
				<td></td>
				<td>性别:<label><input type="radio" checked="checked"
						name="stu_sex" value="男" />男</label> <label><input type="radio"
						name="stu_sex" value="女" />女</label></td>
				<td></td>
			</tr>

			<tr style="height: 12px"></tr>

			<tr>
				<td><span id="acatip" class="lefttips">意愿院校*</span></td>
				<td><input type="text" name="stu_academy" id="aca"
					placeholder="意愿院校" onfocus="checkAcedemy()"
					onChange="checkAcedemy()"></td>
				<td><div id="div45">输入意愿院校</div></td>
			</tr>

			<tr>
				<td><span id="telNumtip" class="lefttips">手机号码*</span></td>
				<td><input type="text" name="stu_mobile" id="telNum"
					placeholder="手机号码" required="required"
					onfocus="checkTel()" onChange="checkTel()"></td>
				<td><div id="div5">输入11位的数字</div></td>
			</tr>

			<tr>
				<td><span id="identifyCodetip" class="lefttips">手机验证码*</span></td>
				<td><input type="text" name="identifyCode" id="identifyCode"
					disabled="disabled" style="width: 26%;" placeholder="手机验证码"
					onfocus="checkMobileCode()" onChange="checkMobileCode()" /> <input
					type="button" name="identifyCodeButton" disabled="disabled"
					id="identifyCodebt" class="bnt" value="获取验证码" /></td>
				<td><div id="div6">输入6位的验证码</div></td>
			</tr>

			<tr>
				<td></td>
				<td><label style="width: 24%">验证码</label> <input
					style="width: 45%" type="text" name="codeImage" id="codeImg"
					onfocus="checkImgCode()" onChange="checkImgCode()" /> <img
					style="width: 25%; position: relative; top: 10px" type="image"
					id="codeId" onclick="javascript:changeCode();"
					src="${pageContext.request.contextPath }/studentInfoHanlder/valicode" />
				</td>
				<td><div id="div7">输入6位的验证码</div></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="checkbox" checked="true" /><span id="reader">我已认真阅读并同意<a
						href="http://www.ciac.sh.cn/newsdata/news10981.htm"
						target="_blank"> &lt;&lt;用户注册协议&gt;&gt; </a></span></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" id="Register" disabled="disabled"
					value="同意协议并提交" onclick="finalValidate()" /></td>
				<td></td>
			</tr>
		</table>
	</form>
	<script>
			
	
			function Check(checkUsername,checkPasswords,confirmPasswords,checkAcedemy,
				checkTel,checkMobileCode,checkImgCode,mobileCodeValidata,imgCodeValidata){
				var o = {};
				o.checkUsername = checkUsername;
				o.checkPasswords = checkPasswords;
				o.confirmPasswords = confirmPasswords;
				o.checkAcedemy = checkAcedemy;
				o.checkTel = checkTel;
				
				o.checkMobileCode = checkMobileCode;
				o.checkImgCode = checkImgCode;
				
				o.mobileCodeValidata = mobileCodeValidata;
				o.imgCodeValidata = imgCodeValidata;
				
				return o;
				
			}
			
			var o = Check(false,false,false,false,false,false,false,false,false);

			
			
			function submitState(){

				var pass = o.checkUsername&o.checkPasswords&o.confirmPasswords&o.checkAcedemy&o.checkTel
						   &o.checkMobileCode&o.checkImgCode&o.mobileCodeValidata;//&o.imgCodeValidata
				console.log(o.checkUsername,o.checkPasswords,o.confirmPasswords,o.checkAcedemy,o.checkTel,
						o.checkMobileCode,o.checkImgCode,o.mobileCodeValidata,"pass:",pass);

				

				var Register = $("#Register");
				var RegisterDom = Register[0];
				if(pass){
					RegisterDom.className = "RegisterBT";
					Register.removeAttr("disabled");
				}
				else{
					RegisterDom.className = "";
					Register.attr("disabled","disabled");
				}
			}
			
			function finalValidate(){
				var url = "${pageContext.request.contextPath }/studentInfoHanlder/add"
				$("#_form").attr("action",url);
				$("#_method").val("POST");
				$("#_form").submit();
			}	

			function checkUsername(){
				var username = $("#userNameI");
				usernameValNum = username.val().length;
				if(usernameValNum <= 0){
	           		$("#div1").text("账号不能为空! "); 
	           		username.css("border","1px solid #a03e3e");
	           		$("#div1").css("visibility","visible");
	           		o.checkUsername = false;
	           		username[0].focus();
	        	}else{
	           		$("#div1").css("visibility","hidden");
	           		username.css("border","");
	           		o.checkUsername = true;
	        	}
				console.log(o.checkUsername);
				submitState();
				return o.checkUsername;
			}
			
			function checkPasswords(){
				var pass1 = $("#password0");
				pass1ValNum = pass1.val().length;
				if(pass1ValNum <= 0){
	           		$("#div2").text("密码不能为空!"); 
	           		pass1.css("border","1px solid #a03e3e");
	           		$("#div2").css("visibility","visible");
	           		pass1[0].focus();
	        	}else if(pass1ValNum <8){
	           		$("#div2").text("密码不能小于8位 !"); 
	           		pass1.css("border","1px solid #a03e3e");
	           		$("#div2").css("visibility","visible");
	           		o.checkPasswords = false;
	        	}else{
	           		$("#div2").css("visibility","hidden");
	           		pass1.css("border","");
	           		o.checkPasswords = true;
	        	}
				console.log(o.checkPasswords);
				submitState();
				return o.checkPasswords;
			}
			
			function confirmPasswords(){
				var pass1 = $("#password0");
				var pass2 = $("#password1");
				if(pass1.val()==pass2.val()&&pass2.val()!=""){
					$("#div3").css("visibility","hidden");
	           		pass2.css("border","");
	           		o.confirmPasswords = true;
				}else{
					$("#div3").text("两次输入密码不一致 !"); 
	           		pass2.css("border","1px solid #a03e3e");
	           		$("#div3").css("visibility","visible");
	           		o.confirmPasswords = false;
				}
				console.log(o.confirmPasswords);
				submitState();
				return o.confirmPasswords;
			}

			function checkAcedemy(){
				var stu_academy = $("#aca");
				stu_academyValNum = stu_academy.val().length;
				if(stu_academyValNum <= 0){
	           		$("#div45").text("意愿院校不能为空!"); 
	           		stu_academy.css("border","1px solid #a03e3e");
	           		$("#div45").css("visibility","visible");
	           		o.checkAcedemy = false;
	           		stu_academy[0].focus();
	        	}else{
	           		$("#div45").css("visibility","hidden");
	           		stu_academy.css("border","");
	           		o.checkAcedemy = true;
	        	}
				console.log(o.checkAcedemy);
				submitState();
				return o.checkAcedemy;
			}
			
			
			function checkTel(){
				var tel = $("#telNum");
				var telValNum = tel.val().length;
				if(telValNum <= 0){
					$("#div5").text("手机信息不能为空!");  
					tel.css("border","1px solid #a03e3e");
	           		$("#div5").css("visibility","visible");
	           		$("#identifyCodebt").attr("disabled","disabled");
	           		$("#identifyCode").attr("disabled","disabled");
	           		o.checkTel = false;
	        	}else if(!((/^1[3-9]\d{9}$/).test(tel.val()))){
	        		$("#div5").text("手机格式不对!");  
					tel.css("border","1px solid #a03e3e");
	           		$("#div5").css("visibility","visible");
	           		$("#identifyCodebt").attr("disabled","disabled");
	           		$("#identifyCode").attr("disabled","disabled");
	           		o.checkTel = false;
	        	}else{
	        		tel.css("border","");
	           		$("#div5").css("visibility","hidden");
	           		$("#identifyCodebt").removeAttr("disabled");
	           		$("#identifyCode").removeAttr("disabled");
	           		o.checkTel = true;
	        	}
				console.log(o.checkTel);
				submitState();
				return o.checkTel;
			}
			
			function checkMobileCode(){
				var MobileCode = $("#identifyCode");
				var MobileCodeValNum = MobileCode.val().length;
				if(MobileCodeValNum <= 0){
					$("#div6").text("手机验证码不能为空!");  
					MobileCode.css("border","1px solid #a03e3e");
	           		$("#div6").css("visibility","visible");
	           		o.checkMobileCode = false;
	        	}else{
	        		MobileCode.css("border","");
	           		$("#div6").css("visibility","hidden");
	           		o.checkMobileCode = true;
	        	}
				console.log(o.checkMobileCode);
				submitState();
			}
			
			function checkImgCode(){
				var codeImg = $("#codeImg");
				var codeImgValNum = codeImg.val().length;
				if(codeImgValNum <= 0){
					$("#div7").text("图形验证码不能为空!");  
					codeImg.css("border","1px solid #a03e3e");
	           		$("#div7").css("visibility","visible");
	           		o.checkImgCode = false;
	        	}else{
	        		codeImg.css("border","");
	           		$("#div7").css("visibility","hidden");
	           		o.checkImgCode = true;
	        	}
				console.log(o.checkImgCode);
				submitState();
				return o.checkImgCode;
			}
			
			
			function changeCode(){
				var codeImage = document.getElementById("codeId");
				//用参数去改变路径，路径不对后重新执行正确路径
				var foreCodeImageSrc = codeImage.src;
				codeImage.src = foreCodeImageSrc+"?"+Math.random();
			}
			

			console.log("telNum val",$("#telNum").val());
			$("#identifyCodebt").click(function(){
				var telNum = $("#telNum").val();
				telNum = $.trim(telNum);
				console.log("前台输入手机号码 : "+telNum);
				
				$.ajax({
					url:"/PEE_assistant/studentInfoHanlder/getMobileValidataCode",
					data:{"tel":telNum},
					type:"post",
					dataType:"json",
					success:function(data){
						if(data == "00000"){
							console.log("手机验证码已经发送, data:" + data);
						}else{
							console.log("手机验证码发送失败 ,data: " + data);
						}
					}
				});
				
				$("#identifyCode").change(function(){
					var identifyCode = $("#identifyCode").val();
					identifyCode = $.trim(identifyCode);
					console.log("前台输入验证码 : "+identifyCode);
					
					$.ajax({
						url:"/PEE_assistant/studentInfoHanlder/validataMobileValidataCode",
						data:{"identifyCode":identifyCode},
						type:"post",
						dataType:"json",
						success:function(data){
							var mobileCode = $("#identifyCode");
							if(data == 0){
								alert("验证码输入正确 ");
				           		$("#div6").css("visibility","hidden");
				           		mobileCode.css("border","");
								o.mobileCodeValidata = true;
								console.log("data: " + data);
							}else{
								alert("验证码输入错误 ");
								$("#div6").text("手机验证码错误 "); 
								mobileCode.css("border","1px solid #a03e3e");
				           		$("#div6").css("visibility","visible");
								o.mobileCodeValidata = false;
								console.log("data: " + data);
							}
							submitState();
						}
					});
				})
			})
			
		</script>
</body>
</html>