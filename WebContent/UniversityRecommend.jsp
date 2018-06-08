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
				height: 800px;
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
				color: green;
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
				background: #FF6666;
				color: white;
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
			}
			
			.funcAssembly {
				float: left;
			}
			#aca_recommend{
				position: relative;
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
		
		<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
	</head>

	<body>
		
		<div id="funcOut">
			<div id="funcBox">
				<div id="cityChannel"><input id="cityValue" type="hidden" name="cityValue" value="" />
					<div id="cityList"><span id="cityFollow">省市频道：</span><span id="city_selected"></span>
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
						<option value="double_non">双非</option>
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
			</div>
	
				<div class="academy_card"  style="display: none;">
					<div class="pic-box" >
						<img class="aca-img" src="${pageContext.request.contextPath }/img/jxufe.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>江西财经大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>江西财经大学（Jiangxi University of Finance and Economics）坐落于英雄城南昌市，是一所财政部、教育部、江西省人民政府共建，以经济、管理类学科为主，法、工、文、理、农、教育、哲学、历史、艺术等学科协调发展的高等财经学府。2008年2月6日，时任国务院总理温家宝与学校师生共度除夕，并称赞说：“你们学校是所很好的学校”。江西省委书记鹿心社指出：“扎根红土地，培育栋梁材。江西财经大学为服务国家战略和地方经济社会发展做出了重大贡献”。</p>
						</div>
						<div class="row-3 aca-rank between-display" style="margin-top:0px">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
				
			<div id="aca_recommend">
				
			
			</div>
		</div>
		
		<script>
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
				$(data).each(function(){
					addAcademy_card(this.aca_name,this.aca_985,
							this.aca_211,this.aca_ranking);
				});
			}
			
			function clearAcademy_card(){
				var aca_recommend = document.getElementById("aca_recommend");
				aca_recommend.innerHTML = "";
			}
			
			function addAcademy_card(acaName,aca_985,aca_211,acaRank){
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
//				aca_summary.innerHTML = "<p>高校简介</p>";

				aca_recommend.appendChild(new_academy_card);
			}
		
			function setCityValue(cityElement) {
				var cityValue = document.getElementById("cityValue");
				var city = cityElement.getElementsByTagName("a")[0];
				var city_selected = document.getElementById("city_selected");
				cityValue.value = city.innerHTML;
				city_selected.innerHTML = cityValue.value;

			}

		</script>
	</body>

</html>