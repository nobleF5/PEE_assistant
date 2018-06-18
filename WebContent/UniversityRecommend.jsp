<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title>UnibrsityRecommend</title>
		<style>
			* {
				margin: 0;
				padding: 0;
			}
			
			body {
				background: white;
			}
			
			#funcOut {
				margin: 0 auto;
				width: 1100px;
				height: 600px;
			}
			
			#cityChannel {
				width: 100%;
				height: 110px;
			}
			
			ul {
				/*width: 100%;
				height: 85px;
				background: yellow;
				float: left;*/
			}
			#cityFollow , #city_selected{
				width: 80px;
				height: 20px;
				margin: 5px 0px;
				padding: 5px 0px;
				list-style: none;
				text-align: center;
				color: gray;
			}
			
			#city_selected{
				font-weight: bold;
			}
			#cityChannel ul li,
			#cityMore,
			#recommend {
				width: 80px;
				height: 20px;
				margin: 5px 10px;
				padding: 5px 15px;
				list-style: none;
				float: left;
				text-align: center;
				color: gray;
				cursor: pointer;
			}
			#aca_property,
			#pro_property {
				width: 85px;
				height: 30px;
				margin: 5px 10px;
				padding: 2px 2px;
				text-align: center;
				font-size: 14px;
			}
			
			#aca_property option,
			#pro_property option {
				font-size: 14px;
				margin: 5px 10px;
				padding: 2px 2px;
			}
			
			#cityChannel ul li:hover {
				background: gray;
				color: white;
			}
			
			#cityMore:hover {
				background: gray;
				color: white;
			}
			
			#recommend {
				background:gray;
				color: white;
			}
			
			#recommend:hover{
				background: #FF6666;
			}
			
			/*#aca_property option:hover{
				background: gray;
				color: white;
			}*/
			
			#cityMore,
			#recommend {
				text-decoration: none;
			}
			
			.rank_input {
				width: 85px;
				height: 26px;
				font-size: 14px;
				margin: 5px 10px;
				padding: 2px 2px;
			}
			
			.funcAssembly {
				float: left;
			}
			#aca_recommend{
				position: absolute;
				margin-top:25px;
			}
			#funcOut .pop_box{
				background: white;
				display: none;
				position: absolute;
				left: 0px;
				top: 0px;
				width: 250px;
				height: 360px;
				overflow: hidden;
				/*opacity: 0.4;*/
				z-index: 1;
			}
			.popbox_video{
				width: 100%;
				height: 40%;
			}
			.popbox_details{
				width: 100%;
				height: 48%;
				margin-top: 5px;
			}
			.popbox_interactive{
				width: 100%;
				height: 12%;
				text-align: center;
			}
			.popbox_details_titleandscore{
				font-size: 24px;
				font-family:"楷体";
				color: black;
			}
			.flexlayout{
				display: flex;
				justify-content: space-between;
			}
			.smallfont{
				font-size: 12px;
				font-family:"宋体";
				color: gray;
			}
			.orange{
				color: orange;
			}
			.interval{
				padding: 5px 5px;
			}
			.video{
				width: 100%;
				height: 100%;
			}
			.academy_card{
				background: white;
				border: 1px solid gainsboro;
				width: 240px;
				height: 320px;
				margin-right: 20px;
				margin-top: 22px;
				float: left;
			}
			.academy_card .pic-box{
				width: 240px;
				height: 50%;
			}
			.ctx-box{
				width: 240px;
				height: 50%;
			}
			.academy_card .pic-box img{
				width: 100%;
				height: 100%;
			}
			.between-display{
				display: flex;
				justify-content: space-between;
				align-items: center;
				margin-top: 10px;
				padding: 0 10px;
			}
			.academy-name{
				font-size: 18px;
				color: green;
			}
			.aca-summary{
				font-size: 14px;
				max-height: 60%;
				min-height: 60%;
				display: -webkit-box;
				-webkit-box-orient: vertical;
				-webkit-line-clamp: 4;
				overflow: hidden;
			}
			@font-face {
				font-family:myfont;
				src: url('${pageContext.request.contextPath }/fonts/长城中楷体繁.TTF');
			}
			p {
				position: relative;
				line-height: 20px;
				max-height: 80px;
				font-family: myfont;
				overflow: hidden;
			}
			
			p::after {
				content: "...";
				font-family: myfont;
				position: absolute;
				bottom: 0;
				right: 0;
				padding-left: 40px;
				background: -webkit-linear-gradient(left, transparent, white 55%);
				background: -o-linear-gradient(right, transparent, white 55%);
				background: -moz-linear-gradient(right, transparent, white 55%);
				background: linear-gradient(to right, transparent, white 55%);
			}
			.ranking{
				font-family: myfont;
				font-size: 14px;
				color: #888;
			}
			.stress-rank{
				font-family: myfont;
				font-size: 24px;
				color: #F40;
			}
			.aca-star{
				width: 28px;
				height: 28px;
				color: gold;
			}
		</style>
		
		<link href="css/font-awesome.css" />
	    <link rel="stylesheet" href="css/ai-usercss-overall.css">
		<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
	</head>

	<body>
		
	<div class="ai-register-box" data-heigth="0">
        <div class="ai-register-lizi" data-height="0"></div>
        
        <div class="ai-register-card-login" style="">
            <div id="funcOut">
				<div id="funcBox">
					<div id="cityChannel"><input id="cityValue" type="hidden" name="cityValue" value="" />
						<div id="cityList"><span id="cityFollow">省市频道：</span><div style="display:inline" onclick="clearCityValue()"><span id="city_selected"></span></div>
							<div style="float:right">
								<a href="/PEE_assistant" style="margin-right:10px; color:gray;cursor:pointer;text-decoration:none">返回首页</a>
							</div>
							<ul>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >北京</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >上海</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >广东</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >湖南</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >江西</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >河南</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >河北</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >湖北</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >陕西</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >山西</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >云南</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >安徽</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >山东</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >福建</a>
									</div>
								</li>
								<li>
									<div  onclick="setCityValue(this)">
										<a class="city" >天津</a>
									</div>
								</li>
							</ul>
						</div>
						<a id="cityMore" href="#" target="_blank" rel="nofollow">更多><b class="arrowD"></b></a>
					</div>
				</div>
				<div id="funcSearch">
					<div class="funcAssembly">
						<select id="aca_property">
							<option value="default" selected="">院校性质</option>
							<option value="_985">985</option>
							<option value="_211">211</option>
							<option value="double_non">所有</option>
						</select>
					</div>
					<div class="funcAssembly">院校排名： <input class="rank_input acaRankStart" type="text" name="aca_startRanking" value="1" />- <input class="rank_input acaRankEnd" type="text" name="aca_endRanking" value="100" /></div>
					<div class="funcAssembly">专业排名： <input class="rank_input proRankStart" type="text" name="startRanking" value="1" />- <input class="rank_input proRankEnd" type="text" name="endRanking" value="100" /></div>
					<div class="funcAssembly">
						<select id="pro_property">
							<option value="pro_master">专硕</option>
							<option value="aca_master">学硕</option>
						</select>
					</div>
					<div id="recommend_div" onclick="recommendFun()">
						<a id="recommend" href="#">一键推荐</a>
					</div>
					<div id="searchDiv">
						<input type="search" id="smallSearch" class="rank_input" placeholder="搜索院校"/>
						
					</div>
				</div>
		
		
		
				<style>
					#content{
						margin:12px auto;
						width:100%;
						padding-left: 10px;
					}
					#search{
						/*width:450px;*/
						width:80%;
						height:45px;
						font-size:24px;
					}
					#popDiv{
						position:absolute;
					}
					#content_table{
						font-size:21px;
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
				<div id="page1" style="display: none;">
					<div id="content">
						<input type="search" id="search" name="keyword" size="50" />
						<input type="submit" id="submit" value="搜索" width="50px" onclick = "acaSubmitClick()" />
						<div id="popDiv">
							<table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
								<tbody id="content_table_body">
								</tbody>
							</table>
						</div>
					</div>
				</div>
				
		
					<div class="academy_card" style="display: none;" >
						<div class="pic-box" >
							<img class="aca-img" src="${pageContext.request.contextPath }/img/jxufe.jpg" />
						</div>
						<div class="ctx-box">
							<div class="row-1 aca-title between-display">
								<span class="academy-name"><strong>江西财经大学</strong></span>
								<span>985/211</span>
							</div>
							<div class="row-2 aca-summary">
								<p>是中华人民共和国教育部直属、中央直管副部级建制的综合性研究型全国重点大学，是国家“七五”、“八五”首批重点建设高校之一，“211工程”首批重点建设的七所大学之一，“985工程”首批重点建设的九所高校之一，世界一流大学建设高校。是中国九校联盟（C9）、中国大学校长联谊会、“111计划”成员，“珠峰计划”首批11所名校之一，教育部首批“卓越工程师教育培养计划”高校，</p>
							</div>
							<div class="row-3 aca-rank between-display" style="margin-top:0px">
								<span class="ranking">排名:<span class="stress-rank">23</span></span>
								<div id="collectAca">
									<a id="star_link">
										<img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/>
									</a>
								</div>
							</div>
						</div>
					</div>
					
				<div id="aca_recommend">
					
				
				</div>
			</div>
            
        </div>
    </div>
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            // 導航
            $('.ai-logonavi-logo').on("mouseenter", function () {
                $('.ai-logonavi-list').show();
            }).on("mouseleave",function () {
                $('.ai-logonavi-list').hide();
            });
            $('.ai-logonavi-list').on("mouseenter", function () {
                $('.ai-logonavi-list').show();
            }).on("mouseleave",function () {
                $('.ai-logonavi-list').hide();
            });
        })
    </script>

    <script src="js/particleground.all.js"></script>
    <script src="js/particle.js"></script>
    <script>
        $(function () {
            $('.ai-register-lizi').css({"height":window.innerHeight});
            new Particleground.particle('.ai-register-lizi');
        });
    </script>
		
		
		<style>
			.message{
				font-size:20px;
				text-align:center;
			}
		</style>
		<script>
		
		//搜索功能js////////////////////////////////////////////////////////////////////////////////////////////////
			var searchDiv = $("#searchDiv");
			searchDiv[0].addEventListener("click",function(){
				searchDiv.css("display","none");
				var page1 = $("#page1");
				page1.css("display","block");
			})
			
			$("#search").keyup(function(){
				getMoreContents();	
				clearAcademy_card();
			});
			
			$("#search").focus(function(){	getMoreContents();	});
			
			//$("#search").blur(function(){	clearContent();	});
			 
			function getMoreContents(){
				
				var content = $("#search").val();
				content = $.trim(content);
				$("search").val(content);
				console.log("content: "+content);
				
				if(content == ""){
					clearContent();
					return;
				}
				$.ajax({
					        url:"${pageContext.request.contextPath}/academyRecommend/queryAcaLike",
					        data:{"acaName":content},
					        type:"post",
					        dataType:"json",
					        success:function(data)
					        {
					        	setContent((data));
					        },
					        error:function(data){
								console.log(data);}
					    });
				
			}
			
			//设置关联数据的展示,参数代表的是服务器传递过来的关联数据
			function setContent (contents) {
				clearContent();
				setLocation();
				var size = contents.length;
				for(var i=0;i<size;i++){	
					
					//
					//	contents是json对象，不是json数组，仍可用访问对象的属性来显示 
					//
					var nextNode = contents[i].aca_Name;//代表的是格式数据的第i个元素
					var content=document.getElementById("search");
					var width = content.offsetWidth;//输入框高度
					var height = content.offsetHeight;
					var tr = document.createElement("tr");
					
					var td = document.createElement("td");
					td.setAttribute("border","0");
					td.setAttribute("bgcolor","#FFFAFA");
					td.setAttribute("width",width);
					td.setAttribute("height",height);
					td.setAttribute("nodeText",nextNode);
					td.onmouseover=function(){
					//鼠标停留时的样式
						this.className='mouseOver';//this.className表示样式
					};
					td.onmouseout=function(){
					//鼠标离开时的样式
						this.className='mouseOut';
					};
					td.onclick = function(){
						$("#search").val(this.getAttribute("nodeText"));
						clearContent();
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
			
			//////////////////////////////////////////////////////////////////////////////////////////////////搜索功能js//
			
			
			function acaSubmitClick(){
				var acaContent = $("#search").val()
				$.ajax({
			        url:"${pageContext.request.contextPath}/academyRecommend/queryAcaName",
			        data:{"acaName":acaContent},
			        type:"post",
			        dataType:"json",
			        success:showAcademyCard,
			        error:function(data){
						console.log(data);}
			    });
			}
	
			
			//addAcademy_card(473,"西安交通大学",true,true,34);
		
			function clearCityValue(){
				var city_selected = $("#city_selected");
				city_selected.text("");
			}
			
			function recommendFun(){
				var city_selected = $("#city_selected");
				var city = city_selected.text();
				var aca_property = $("#aca_property option:selected").text();
				var aca_985 = aca_property.indexOf("985")==-1?false:true;
				var aca_211 = aca_property.indexOf("211")==-1?false:true;
				
				var acaRankStart = $(".acaRankStart").val();
				var acaRankEnd = $(".acaRankEnd").val();
				var proRankStart = $(".proRankStart").val();
				var proRankEnd = $(".proRankEnd").val();
				
				$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath }/academyRecommend/queryAca",
					contentType : "application/x-www-form-urlencoded",
					data:{
						"aca_city":city,
						"startRanking":acaRankStart,
						"endRanking":acaRankEnd,
						"aca_985":aca_985,//
						"aca_211":aca_211
					},
					success:showAcademyCard
				});
			}
			
			function showAcademyCard(data){
				clearAcademy_card();
				if(data.length == 0){
					console.log("length:",data.length);
					var aca_recommend = document.getElementById("aca_recommend");
					var newDiv = document.createElement("div");
					var newText = document.createTextNode("暂无数据");
					newDiv.appendChild(newText);
					newDiv.className = "message";
					aca_recommend.appendChild(newDiv);
				}
				$(data).each(function(){
					addAcademy_card(this.aca_id,this.aca_name,this.aca_985,
							this.aca_211,this.aca_ranking);
				});
			}
			
			function clearAcademy_card(){
				var aca_recommend = document.getElementById("aca_recommend");
				aca_recommend.innerHTML = "";
			}
			
			function addAcademy_card(aca_id,acaName,aca_985,aca_211,acaRank){
				var academy_card = document.getElementsByClassName("academy_card")[0];
				var aca_recommend = document.getElementById("aca_recommend");
				var new_academy_card= academy_card.cloneNode(true);
				new_academy_card.setAttribute("isNew","yes");
				
				new_academy_card.style.display = "block";
				new_academy_card.getElementsByClassName("academy-name")[0].innerHTML = "<strong>" + acaName +"</strong>";
				new_academy_card.getElementsByClassName("stress-rank")[0].innerHTML = acaRank;
				
				var aca_title = new_academy_card.getElementsByClassName("aca-title")[0];
				var acaProperty = aca_title.getElementsByTagName("span")[1];
				if(aca_211==true){
					acaProperty.innerHTML = "<strong style='color: purple;'>211</strong>";
					if(aca_985==true){
						acaProperty.innerHTML = "<strong style='color: red;'>985,211</strong>";
					}
				}else{
					acaProperty.innerHTML = "双非";
				}
				
				var aca_img = new_academy_card.getElementsByClassName("aca-img")[0];
				aca_img.src = "${pageContext.request.contextPath }/schoolImg/" + acaName + ".jpg";
				aca_img.alt = "抱歉，没有该高校的图片";

//				var aca_summary = new_academy_card.getElementsByClassName("aca-summary")[0];
//				aca_summary.innerHTML = "<p>高校简介高校简介高校简介高校简介高校简介高校简介高校简介高校简介高校简介高校简介高校简介高校简介高校简介</p>";
				
				var new_academy_card_a = document.createElement('a');
				
				var href = document.createAttribute("href");
				href.value = "${pageContext.request.contextPath }/academyDetails.jsp?acaId=" + aca_id;
				new_academy_card_a.setAttributeNode(href);
				var aid = document.createAttribute("aid");
				aid.value = "a" + aca_id;
				new_academy_card_a.setAttributeNode(aid);
				new_academy_card.appendChild(new_academy_card_a);
				new_academy_card.setAttribute("aca_id",aca_id);
				aca_recommend.appendChild(new_academy_card);
				new_academy_card.addEventListener("click",function(){
					jump(aca_id);
				});
				
				var star = new_academy_card.getElementsByClassName("aca-star")[0];
				star.addEventListener("click",function(e){
					 // 如果提供了事件对象，则这是一个非IE浏览器
				    if ( e && e.stopPropagation ) {
				        // 因此它支持W3C的stopPropagation()方法 
				        e.stopPropagation();
				    } else {
				        // 否则，我们需要使用IE的方式来取消事件冒泡
				        window.event.cancelBubble = true;
				    }
				    var stu_id = null;
					 <%if(request.getSession().getAttribute("stu_id")!= null){%>
				      		stu_id = <%= request.getSession().getAttribute("stu_id") %>
					 <%}else{%>
							alert("请登录!");
					 		return;
					 <%} %>
					
					$.ajax({
						type:"POST",
						url:"${pageContext.request.contextPath }/CollectAcademyInfoHandler/collectAcademy",
						contentType : "application/x-www-form-urlencoded",
						data:{
							"stu_id":stu_id,
							"aca_id":aca_id
						},
						success:function(data){alert(data.message)},
						error:function(data){alert(data.message)}
					});
				})
				 
			}
		
			function setCityValue(cityElement) {
				var cityValue = document.getElementById("cityValue");
				var city = cityElement.getElementsByTagName("a")[0];
				var city_selected = document.getElementById("city_selected");
				cityValue.value = city.innerHTML;
				city_selected.innerHTML = cityValue.value;

			}

			function jump(aca_id){
				var academy_card = $("div[aca_id='"+ aca_id +"']");
				var aid = "a" + aca_id;
				var academy_card_a = $("a[aid='"+ aid +"']");
				href = academy_card_a.attr("href");

				window.location.href=href;
			}
		</script>
	</body>

</html>