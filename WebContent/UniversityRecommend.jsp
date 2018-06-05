<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
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
			
			#cityFollow {
				width: 80px;
				height: 20px;
				margin: 5px 0px;
				padding: 5px 0px;
				list-style: none;
				text-align: center;
				color: gray;
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
				display: -webkit-box;
				-webkit-box-orient: vertical;
				-webkit-line-clamp: 4;
				overflow: hidden;
			}
			@font-face {
				font-family:myfont;
				src: url('fonts/长城中楷体繁.TTF');
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
	</head>

	<body>
		<div id="funcOut">
			<div id="funcBox">
				<div id="cityChannel"><input id="cityValue" type="hidden" name="cityValue" value="" />
					<div id="cityList"><span id="cityFollow">省市频道：</span>
						<ul>
							<li>
								<a class="hl">北京</a>
							</li>
							<li>
								<a>上海</a>
							</li>
							<li>
								<a>广东</a>
							</li>
							<li>
								<a>湖南</a>
							</li>
							<li>
								<a>江西</a>
							</li>
							<li>
								<a>河南</a>
							</li>
							<li>
								<a>河北</a>
							</li>
							<li>
								<a>湖北</a>
							</li>
							<li>
								<a>陕西</a>
							</li>
							<li>
								<a>山西</a>
							</li>
							<li>
								<a>云南</a>
							</li>
							<li>
								<a>安徽</a>
							</li>
							<li>
								<a>山东</a>
							</li>
							<li>
								<a>福建</a>
							</li>
							<li>
								<a>天津</a>
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
				<div class="funcAssembly">
					<select id="aca_property">
						<option value="default" selected="">院校性质</option>
						<option value="_985">985</option>
						<option value="_211">211</option>
						<option value="double_non">双非</option>
					</select>
				</div>
				<div class="funcAssembly">院校排名： <input class="rank_input" type="text" name="aca_startRanking" value="1" />- <input class="rank_input" type="text" name="aca_endRanking" value="100" /></div>
				<div class="funcAssembly">专业排名： <input class="rank_input" type="text" name="startRanking" value="1" />- <input class="rank_input" type="text" name="endRanking" value="100" /></div>
				<div class="funcAssembly">
					<select id="pro_property">
						<option value="pro_master">专硕</option>
						<option value="aca_master">学硕</option>
					</select>
				</div>
				<a id="recommend" href="#">一键推荐</a>
			</div>
			<div id="aca_recommend">
				<div class="academy_card">
					<div class="pic-box">
						<img src="${pageContext.request.contextPath }/img/jxufe.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>江西财经大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>江西财经大学（Jiangxi University of Finance and Economics）坐落于英雄城南昌市，是一所财政部、教育部、江西省人民政府共建，以经济、管理类学科为主，法、工、文、理、农、教育、哲学、历史、艺术等学科协调发展的高等财经学府。2008年2月6日，时任国务院总理温家宝与学校师生共度除夕，并称赞说：“你们学校是所很好的学校”。江西省委书记鹿心社指出：“扎根红土地，培育栋梁材。江西财经大学为服务国家战略和地方经济社会发展做出了重大贡献”。</p>
						</div>
						<div class="row-3 aca-rank between-display">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
				
				<div class="academy_card">
					<div class="pic-box">
						<img src="${pageContext.request.contextPath }/img/Qinghua.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>清华大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>清华大学（Tsinghua University），简称“清华”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”、“世界一流大学和一流学科”，入选“基础学科拔尖学生培养试验计划”、“高等学校创新能力提升计划”、“高等学校学科创新引智计划”，为九校联盟、中国大学校长联谊会、东亚研究型大学协会、亚洲大学联盟、环太平洋大学联盟、清华—剑桥—MIT低碳大学联盟成员，被誉为“红色工程师的摇篮”。</p>
						</div>
						<div class="row-3 aca-rank between-display">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a href="#"><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
				
				<div class="academy_card">
					<div class="pic-box">
						<img src="${pageContext.request.contextPath }/img/jxufe.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>江西财经大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>江西财经大学（Jiangxi University of Finance and Economics）坐落于英雄城南昌市，是一所财政部、教育部、江西省人民政府共建，以经济、管理类学科为主，法、工、文、理、农、教育、哲学、历史、艺术等学科协调发展的高等财经学府。2008年2月6日，时任国务院总理温家宝与学校师生共度除夕，并称赞说：“你们学校是所很好的学校”。江西省委书记鹿心社指出：“扎根红土地，培育栋梁材。江西财经大学为服务国家战略和地方经济社会发展做出了重大贡献”。</p>
						</div>
						<div class="row-3 aca-rank between-display">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
				
				<div class="academy_card">
					<div class="pic-box">
						<img src="${pageContext.request.contextPath }/img/Qinghua.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>清华大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>清华大学（Tsinghua University），简称“清华”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”、“世界一流大学和一流学科”，入选“基础学科拔尖学生培养试验计划”、“高等学校创新能力提升计划”、“高等学校学科创新引智计划”，为九校联盟、中国大学校长联谊会、东亚研究型大学协会、亚洲大学联盟、环太平洋大学联盟、清华—剑桥—MIT低碳大学联盟成员，被誉为“红色工程师的摇篮”。</p>
						</div>
						<div class="row-3 aca-rank between-display">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a href="#"><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
			
				<div class="academy_card">
					<div class="pic-box">
						<img src="${pageContext.request.contextPath }/img/jxufe.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>江西财经大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>江西财经大学（Jiangxi University of Finance and Economics）坐落于英雄城南昌市，是一所财政部、教育部、江西省人民政府共建，以经济、管理类学科为主，法、工、文、理、农、教育、哲学、历史、艺术等学科协调发展的高等财经学府。2008年2月6日，时任国务院总理温家宝与学校师生共度除夕，并称赞说：“你们学校是所很好的学校”。江西省委书记鹿心社指出：“扎根红土地，培育栋梁材。江西财经大学为服务国家战略和地方经济社会发展做出了重大贡献”。</p>
						</div>
						<div class="row-3 aca-rank between-display">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
				
				<div class="academy_card">
					<div class="pic-box">
						<img src="${pageContext.request.contextPath }/img/Qinghua.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>清华大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>清华大学（Tsinghua University），简称“清华”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”、“世界一流大学和一流学科”，入选“基础学科拔尖学生培养试验计划”、“高等学校创新能力提升计划”、“高等学校学科创新引智计划”，为九校联盟、中国大学校长联谊会、东亚研究型大学协会、亚洲大学联盟、环太平洋大学联盟、清华—剑桥—MIT低碳大学联盟成员，被誉为“红色工程师的摇篮”。</p>
						</div>
						<div class="row-3 aca-rank between-display">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a href="#"><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
			
				<div class="academy_card">
					<div class="pic-box">
						<img src="${pageContext.request.contextPath }/img/jxufe.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>江西财经大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>江西财经大学（Jiangxi University of Finance and Economics）坐落于英雄城南昌市，是一所财政部、教育部、江西省人民政府共建，以经济、管理类学科为主，法、工、文、理、农、教育、哲学、历史、艺术等学科协调发展的高等财经学府。2008年2月6日，时任国务院总理温家宝与学校师生共度除夕，并称赞说：“你们学校是所很好的学校”。江西省委书记鹿心社指出：“扎根红土地，培育栋梁材。江西财经大学为服务国家战略和地方经济社会发展做出了重大贡献”。</p>
						</div>
						<div class="row-3 aca-rank between-display">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
				
				<div class="academy_card">
					<div class="pic-box">
						<img src="${pageContext.request.contextPath }/img/Qinghua.jpg" />
					</div>
					<div class="ctx-box">
						<div class="row-1 aca-title between-display">
							<span class="academy-name"><strong>清华大学</strong></span>
							<span>985/211</span>
						</div>
						<div class="row-2 aca-summary">
							<p>清华大学（Tsinghua University），简称“清华”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”、“世界一流大学和一流学科”，入选“基础学科拔尖学生培养试验计划”、“高等学校创新能力提升计划”、“高等学校学科创新引智计划”，为九校联盟、中国大学校长联谊会、东亚研究型大学协会、亚洲大学联盟、环太平洋大学联盟、清华—剑桥—MIT低碳大学联盟成员，被誉为“红色工程师的摇篮”。</p>
						</div>
						<div class="row-3 aca-rank between-display">
							<span class="ranking">排名:<span class="stress-rank">23</span></span>
							<a href="#"><img class="aca-star" src="${pageContext.request.contextPath }/img/star.ico"/></a>
						</div>
					</div>
				</div>
			
			</div>
		</div>
	</body>

</html>