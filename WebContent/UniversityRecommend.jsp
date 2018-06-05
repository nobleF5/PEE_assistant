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
				<div class="pop_box">
					<div class="popbox_video">
						<video class="video" loop="loop" autoplay="autoplay" muted="muted" src="video/加勒比海盗5.mp4" type="audio/mp4"></video>
					</div>
					<div class="popbox_details">
						<div class="popbox_details_titleandscore flexlayout">
							<div class="interval">加勒比海盗5</div>
							<div class="interval"><span class="orange">9.0</span></div>
						</div>
						<div class="popbox_details_lableandduration flexlayout smallfont">
							<div class="interval">标签:美国 动作 奇幻</div>
							<div class="interval">124分钟</div>
						</div>
						<div class="smallfont">
							<div class="interval">主演:约翰尼·德普，哈维尔·巴登，杰弗里·拉什，导演：故事发生在《加勒比海盗3：世界的尽头》沉船湾之战20年后。 男孩亨利随英...</div>
						</div>
						<div class="scoreandcollection"><img style="text-align: center;" src="img/scoreimg.png" /></div>
					</div>
					<div class="popbox_interactive">
						<div class="likeordislike"><img style="margin-top: -5px;" src="img/like.png" /></div>
					</div>
				</div>
				
				
			</div>
			
		</div>
	</body>

</html>