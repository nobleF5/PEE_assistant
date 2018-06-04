<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="dns-prefetch" href="//axvert.chsi.com.cn">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script src="js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/countTime.js"></script>
		<title>PEE</title>
</head>
<body>
			<!--
      		  标题
        -->
		<header class="header">
			<!--
        	作者：offline
        	时间：2018-05-16
        	描述：导航栏
        -->
			<div class="container-inner">
				<div class="row ">
					<div class="col-lg-4">
					</div>
					<div class="col-lg-4 inner-flex">
						<div class="headTipe">
							<a href="/">
								<span class=vintage2 style="font-size: 25px;">考研！！！           我们帮你</span>
							</a>
						</div>
					</div>
					<div class="col-lg-4">
					</div>
				</div>
			</div>
			</div>

		</header>
		<div class="navbar navbar-inverse ">
			<div class="container-fluid">
				<div class="navbar-header">
					<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
	           		<span class="icon-bar"></span>
	            	<span class="icon-bar"></span>
	            	<span class="icon-bar"></span>
	          		</button>
					<a class="navbar-brand hidden-sm" href="#">首页</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li>
							<a href="#">院校推荐</a>
						</li>
						<li>
							<a href="#">学习平台</a>
						</li>
						<li>
							<a href="#">有偿辅导平台</a>
						</li>
						<li>
							<a href="#">考研交流平台</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--
	作者：offline
	时间：2018-05-16
	描述：中部
-->
		<div class="middle">
			<div class="middle-inner">
				<div class="container">
					<div class="row middle--inner-header">
						<div class="col-xs-10 middle--inner-header-first">
							<div>
								<img src="img/edb102881950f3319d14653eb1b0cd38.jpg" />
							</div>
							<div>
								<span style="font-family: '楷体'; font-size: 23px;color: #666666;">希望本网站能有助于各位学子考研，祝大家考研成功.....</span>
							</div>

						</div>
						<div class="col-xs-2 middle--inner-header-second">

							<div>
								<img src="img/98b9d160847286efb8544c581bbb4599.jpg" />
							</div>
							<div>
								<a href="#">
									<span style="font-family: '楷体'; font-size: 23px;color: #666666;">登录</span>
								</a>
							</div>
							<div>
								<img src="img/98b9d160847286efb8544c581bbb4599.jpg" />
							</div>
							<div>
								<a href="#">
									<span style="font-family: '楷体'; font-size: 23px;color: #666666;">注册</span>
								</a>
							</div>
						</div>
					</div>

					<div class="row middle-inner-last">
						<div class="container-middle">

							<!--
		               	 轮播图
		                	-->

							<div class="col-xs-8 middle-inner-last-first">
								<div id="play" class="carousel slide" data-interval="3000" data-ride="carousel">
									<ol class="carousel-indicators">
										<li class="active"></li>
										<li></li>
										<li></li>
										<li></li>
									</ol>

									<div class="carousel-inner">
										<div class="item active">
											<img src="img/8fc5c0b3a237993bfa81060656098e.jpg" />
										</div>

										<div class="item">
											<img src="img/2eac03333b0b303458fc01875e1a424.jpg" />
										</div>
										<div class="item">
											<img src="img/86283374755b47d29fa9f424ba8a34.jpg" />
										</div>
										<div class="item">
											<img src="img/8a7ac4eea29ba123406321b1dc0392.jpg" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-4 middle-inner-last-second">
								<div class="container-middle">
									<div class="row">
										<div class="col-xs-12 middle-inner-right-top-buttom">
											<div>
												<input class="middle-inner-right-top-input" name="sersch" />
												<input type="button" class="middle-inner-right-top-button" />
											</div>
										</div>
										<div class="col-xs-12 middle-inner-right-middle">
											<div class="middle-inner-right-middle-tipe">
												<div>
													<h2 class="threed">考研倒计时</h2>
												</div>

											</div>
											<div class="middle-inner-right-middle-countDown">
												<div class="middle-inner-right-middle-countDown-number">
													<span id="countDownNumber" class="countDownNumberType"></span>
												</div>
											</div>
											<div style="height: 30px;">
											</div>

										</div>
									</div>
								</div>

							</div>

						</div>

					</div>
					<div style="height:20px; position: relative;">
					</div>
					<hr />
					<footer class="footer ">
						<div class="container">
							<div class="row footer-top">
								<div class="col-md-4">
									<h4>
            <img src="img/111122.jpg">
          </h4>
								</div>
								<div class="col-md-8">
									<div class="row about">
										<div class="col-sm-4">
											<h4>关于</h4>
											<ul class="list-unstyled">
												<li>
													<a href="/about/">关于我们</a>
												</li>
												<li>
													<a href="/ad/">广告合作</a>
												</li>
												<li>
													<a href="/links/">友情链接</a>
												</li>
												<li>
													<a href="/hr/">招聘</a>
												</li>
											</ul>
										</div>
										<div class="col-sm-4">
											<h4>联系方式</h4>
											<ul class="list-unstyled">
												<li>
													<a href="http://weibo.com/bootcss" title="Bootstrap中文网官方微博" target="_blank">新浪微博</a>
												</li>
												<li>
													<a href="mailto:admin@bootcss.com">电子邮件</a>
												</li>
											</ul>
										</div>
										<div class="col-sm-4">
											<h4>赞助商</h4>
											<ul class="list-unstyled">
												<li>
													<a href="https://www.upyun.com" target="_blank">又拍云</a>
												</li>
											</ul>
										</div>
									</div>

								</div>
							</div>
							<div class="row footer-bottom">
								<ul class="list-inline text-center">
									<li>
										<a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008151号</a>
									</li>
									<li>京公网安备11010802014853</li>
								</ul>
							</div>
						</div>
					</footer>

				</div>
			</div>

		</div>
		</div>
		</div>
		</div>
	</body>
</html>