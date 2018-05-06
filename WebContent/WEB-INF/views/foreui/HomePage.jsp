<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
response.setContentType("text/html;chartset=UTF-8");
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>主页-图书管理系统</title>
    
	<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />   
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	</head>
	<style>
		*{
			margin: 0;
		}
		body{
			background: #DCDCDC;
		}
		#header{
			background: grey;
			height: 32px;
			clear: both;
		}
		#header-left{
			float: left;
			padding: 4px 10px;
			margin-top: 4px;
			font-size: 14px;
			color: white;
			font-family: "宋体";
		}
		#header-right{
			float: right;
			padding: 4px 5px;
			margin-top: 4px;
			font-size: 12px;
			color: white;
			font-family: "宋体";
		}
		#header-right a{
			text-decoration: none;
			color: white;
		}
		#page_footer{
			background: gray;
			width:100%;
			height:80px;
			text-align:center;
		}
		#jxufe,#address{
			diplay:block;
			padding:4px 6px;
			margin:2px auto;
			font-family:"宋体 ";
			font-size:17px;
		}
		#content{
			margin:12px auto;
			width:560px;
		}
		#search{
			width:450px;
			height:45px;
			font-size:24px;
		}
		#popDiv{
			position:absolute;
		}
		#content_table{
			font-size:21px;
		}
		#bookinfowrap{
			margin: 0 auto;
			padding-left:40px;
			overflow: auto;
			zoom: 1;
		}
		#bookinfo{
			float: left;
			margin: 12px 16px;
			border: solid #4CAE4C;
			width: 200px;
			height: 320px;
			padding: 3px 5px;
		}
		
		#bookinfo-header{	
			height: 60%;
			width: 200px;
		}
		
		#bookimg{
			width: 100%;
			height: 100%;
		}
		
		#libraryCanBorrow,#libraryCollection{
			font-family: "宋体";
			font-size: 12px;
			color: black;
			float: left;
		}
		
		#libraryCanBorrowstro,#readedNumbersstro{
			color: #4CAE4C;
			font-size: 18px;
		}
		
		#readedNumbers,#author{
			font-family: "宋体";
			font-size: 12px;
			color: black;
			float: right;
		}
		
		#summary{
			clear: both;
			width: 100%;
		}
		
		#summary a{
			padding-top: 10px;
			font-family: "宋体";
			font-size: 13px;
			display: block;
			width: 200px;
			height: 60px;
			color: black;
			text-decoration: none;
			overflow: hidden;	/*内容超出后隐藏*/	
			text-overflow: ellipsis;	/*超出内容为省略号*/
			white-space: normal;
		}
		#libraryCollection,#author{
			color: grey;
		}
		
		#bookinfo-footer3{
			margin-top: 12px;
		}
		#submit{
			margin-top:0px;
			width:80px;
			height:45px;
			font-size:17px;
		}
		.mouseOver{
			background:#708090;
			color:#FFFAFA;
		}
		
		.mouseOut{
			background:#FFFAFA;
			color:#000000;
		}
	</style>
	
	
	<body>
	<div id="page">
	
	<!--  
		<div id="header">
			<div id="header-left">
				<span>图书管理系统</span>
			</div>
			<div id="header-right">
				<span>你好，欢迎<span id="username">&nbsp;<a href="#">用户</a>&nbsp;</span>的登录</span>
				<span><a href="">安全退出</a></span>
				<span>&nbsp;&nbsp;<a href="#">我要留言 </a> | <a href="#">新手上路</a> | <a href="#">帮助中心</a>  | <a href="#">建议反馈</a></span>
			</div>
		</div>
		-->
		
		<div id="page1">
			<div id="content">
				<input type="search" id="search" name="keyword" size="50" />
				<input type="submit" id="submit" value="搜索" width="50px" />
				<div id="popDiv">
					<table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
						<tbody id="content_table_body">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	
		
		<div id="bookinfowrap" >
			<c:forEach items="${page.content }" var="books">
			 	<div id="bookinfo">
					<div id="bookinfo-header">
						<img id="bookimg" src="${pageContext.request.contextPath }/<c:out value='${books.bookimg}'></c:out>" alt="图片加载失败"/>
					</div>
					<div id="bookinfo-footer">
						<div id="bookinfo-footer1">
							<span id="libraryCanBorrow"><span id="libraryCanBorrowstro"><c:out value="${books.librarycanborrow }"></c:out></span>本可借</span>
							<span id="readedNumbers"><span id="readedNumbersstro"><c:out value="${books.readednumbers }"></c:out></span>人已阅读</span>
						</div>
						<div id="summary">
							<span id="summaryinfo"><a href="#"><c:out value="${books.summary }"></c:out></a></span>
						</div>
						<div id="bookinfo-footer3">
							<span id="libraryCollection">馆藏量<span id="libraryCollectionstro"><c:out value="${books.librarycollection }"></c:out></span>本</span>
							<span id="author">作者:<span id="authorstro"><c:out value="${books.author }"></c:out></span></span>
						</div>
					</div>
				</div>
			 </c:forEach>
			
		</div>
		 
		<br><br>
		<center>
			 <table>
			 
				<tr>
					<td colspan="8">
						共 ${page.totalElements } 条记录
						共 ${page.totalPages } 页
						当前 ${page.number + 1 } 页
						<a href="?pageNo=${page.number + 1 - 1 }">上一页</a>
						<a href="?pageNo=${page.number + 1 + 1 }">下一页</a>
					</td>
				</tr>
			 </table>
		</center>
		
		
		<!--  
		<div id="page_footer">
    		<div id="jxufe">Copyright(c) 2011 All Rights Reserved 版权所有：江西财经大学软件与通信工程学院</div>
    		<div id="address">地址：江西省南昌市昌北国家经济技术开发区双港东大街169号 邮编：330000</div>
   	 	</div>
   	 	-->
   	 	
	</div>
	
	<script type="text/javascript">
		$(function(){
			
			$("#search").keyup(function(){	getMoreContents();	});
			
			$("#search").blur(function(){	clearContent();	});
			
			$("#search").focus(function(){	getMoreContents();	});

			 
			function getMoreContents(){
				
				var content = $("#search").val();
				content = $.trim(content);
				$("search").val(content);
				console.log("content: "+content);
				
				if(content == ""){
					clearContent();
					return;
				}
				//var url="${pageContext.request.contextPath}/searchAjax";
				//var args = {"content":content};
				
				//$.post(url, args, function sendContentAndGetJson(data){
				//	console.log("data: "+data);
				//	alert("data: "+eval(data));
				//});
				
				$.ajax({
					        url:"${pageContext.request.contextPath}/searchAjax",
					        data:{"content":content},
					        type:"post",
					        dataType:"json",
					        success:function(data)
					        {
					        	$(data).each(function() {
									console.log(data.bookname);
								});
					        	setContent((data));
					        },
					        error:function(data){
								alert(data);}
					    });
				
			}
			
			//设置关联数据的展示,参数代表的是服务器传递过来的关联数据
			function setContent (contents) {
				clearContent();
				setLocation();
				var size = contents.length;
				//console.log("size:"+size);
				for(var i=0;i<size;i++){
					
					//
					//	contents是json对象，不是json数组，仍可用访问对象的属性来显示 
					//
					var nextNode = contents[i].bookname;//代表的是格式数据的第i个元素
					var content=document.getElementById("search");
					var width = content.offsetWidth;//输入框高度
					var height = content.offsetHeight;
					var tr = document.createElement("tr");
					var td = document.createElement("td");
					td.setAttribute("border","0");
					td.setAttribute("bgcolor","#FFFAFA");
					td.setAttribute("width",width);
					td.setAttribute("height",height);	
					td.onmouseover=function(){
					//鼠标停留时的样式
						this.className='mouseOver';//this.className表示样式
					};
					td.onmouseout=function(){
					//鼠标离开时的样式
						this.className='mouseOut';
					};
					td.onclick=function(){
						//当选择关键数据时，鼠标点击一个关键数据，关键数据自动设置为输入框的数据
						
					}
					var text = document.createTextNode(nextNode);
					console.log("nextNode:"+nextNode);
					td.appendChild(text);
					tr.appendChild(td);
					document.getElementById("content_table_body").appendChild(tr);
				}
			}
			
			function clearContent(){
				var contentTableBody = document.getElementById("content_table_body");
				var size = contentTableBody.childNodes.length;
				for(var i=size-1;i>=0;i--){
					contentTableBody.removeChild(contentTableBody.childNodes[i]);
				}
				document.getElementById("popDiv").style.border="none";
			}
			
			//设置显示关联信息位置
			function setLocation(){
			//关联信息的显示位置要和输入框一致
				var content=document.getElementById("search");
				var width = content.offsetWidth;//输入框高度
				console.log("width:"+width);
				var left = content["offsetLeft"];//到左边的距离
				var top = content["offsetTop"]+content.offsetHeight;//到顶部的距离
			//显示数据的div
				var popDiv = document.getElementById("popDiv");
				popDiv.style.border="black 1px solid";
				popDiv.style.left=left+"px";
				popDiv.style.top=top+"px";
				popDiv.style.width=width+"px";
				
			}
			
		});
	</script>
	</body>
</html>

