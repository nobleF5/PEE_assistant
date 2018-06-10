<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
		<title>院校详情查询</title>
		<meta name="robots" content="all" />

		<link rel="stylesheet" href="https://t1.chei.com.cn/common/ch/iconfont.css">
		<link rel="stylesheet" href="https://t1.chei.com.cn/yz/assets/css/yz.min.css">
		<script src="https://t1.chei.com.cn/common/jquery/1.8.3/jquery.min.js"></script>

		<script src="https://t1.chei.com.cn/common/js/boomerang-min-20141211.js" type="text/javascript"></script>
		
		<script async src="https://www.googletagmanager.com/gtag/js?id=UA-100524-7"></script>
		<script>
			window.dataLayer = window.dataLayer || [];

			function gtag() {
				dataLayer.push(arguments);
			}
			gtag('js', new Date());
			gtag('config', 'UA-100524-7');
		</script>
	</head>

	<body class="ch-sticky">
		<div class="main-wrapper">

			<!-- 专业目录 共用header -->

			<div class="header-wrapper ch-simple">
				<div class="ch-header-second clearfix">
					<h1></h1>
					<div class="ch-sub-title"><span id="ch-sub-title-academyname"></span>招生详情</div>
					<div class="ch-search-box">

						<style>
							.ch-search-form span,
							.ch-search-form .ch-search-input {
								font-size: 14px;
								vertical-align: middle;
								font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Microsoft YaHei", "Hiragino Sans GB", "WenQuanYi Micro Hei", Arial, sans-serif;
							}
							
							.ch-search-form input[type="button"]::-moz-focus-inner {
								border: none;
								padding: 0;
							}
							
							.ch-search-input {
								float: left;
								width: 205px;
								height: 38px;
								line-height: 38px;
								border: 1px solid #d6d6d6;
								padding: 0 8px;
								outline: 0;
								box-sizing: content-box;
							}
							
							.ch-search-btn {
								float: left;
								width: 56px;
								height: 40px;
								border: none;
								background: #1787e0;
								cursor: pointer;
								vertical-align: middle
							}
							
							.ch-search-btn .iconfont {
								font-size: 18px;
								color: #fff
							}
						</style>
						<!-- 共用站内搜索代码 -->
						<form class="ch-search-form clearfix" method="get" action="" target="_blank" name="searchinfo" onsubmit="return searchSubmit()">
							<input class="ch-search-input" id="sbi" name="q" type="text" placeholder="站内搜索" maxlength="40">
							<button class="ch-search-btn" id="sbb" name="sa" type="submit"><i class="iconfont" title="站内搜索">&#xe6a9;</i></button>
							<input name="searchType" type="hidden" value="baidu">
							<input name="sitesearch" type="hidden" value="yz.chsi.com.cn">
						</form>
						<script>
							String.prototype.trim = function() {
								return this.replace(/(^\s*)|(\s*$)/g, "");
							}

							function searchSubmit() {
								var y = document.getElementById('sbi').value.trim();
								if(y == null || y == '' || y == '站内搜索') {
									alert('搜索关键字不能为空');
									return false;
								} else if(y.length < 2) {
									alert('请至少输入2个文字');
									return false
								} else if(y.length > 40) {
									alert('最多可输入40个文字');
									return false
								}
							}
						</script>
					</div>
				</div>
			</div>

			<!-- 专业目录主体- 详细 -->
			<div class="container clearfix">
				
				<style>
					.zsml-left{
						width:880px;
						float: none;
						margin: 0 auto;
					}
				</style>
				<div class="zsml-left">
					<div class="zsml-wrapper">
						<table class="zsml-condition" cellspacing="5" cellpadding="5">
							<colgroup>
								<col width="80">
								<col>
								<col width="130">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<td class="zsml-title">招生单位：</td>
									<td class="zsml-summary acaName" colspan="3"></td>
								</tr>
								<tr>
									<td class="zsml-title">院系所：</td>
									<td class="zsml-summary depName"></td>
									<td class="zsml-title">专业代码：</td>
									<td class="zsml-summary depSpecialty"></td>
								</tr>
								<tr>
									<td class="zsml-title">研究方向：</td>
									<td class="zsml-summary depDirection"></td>
									<td class="zsml-title">学习方式：</td>
									<td class="zsml-summary">全日制</td>

								</tr>
								<tr>
									<td class="zsml-title">拟招人数：</td>
									<td class="zsml-summary accStu" colspan="3">院系所：<span id="acce_stu_num"></span>,其中推免：<span id="acce_stu_recommend_nu"></span></td>
								</tr>

								<tr>
									<td class="zsml-title"><span class="zsml-bz">备注：</span></td>
									<td colspan="3">
										<span class="zsml-bz"></span>
									</td>
								</tr>

							</tbody>
						</table>
						<!-- 专业条件 end -->

						<div class="zsml-result">
							<h2>考试范围</h2>
							<table border="0" cellpadding="10" cellspacing="0" width="100%">
								<colgroup>
									<col width="25%">
									<col width="25%">
									<col width="25%">
									<col width="25%">
								</colgroup>
								<thead>
									<tr>
										<th>政治</th>
										<th>外语</th>
										<th>业务课一</th>
										<th>业务课二</th>
									</tr>
								</thead>

								<tbody class="zsml-res-items">
									<tr style="display:none">
										<td class="zsml-res-items-1"></td>
										<td  class="zsml-res-items-2"></td>
										<td class="zsml-res-items-3"></td>
										<td class="zsml-res-items-4"></td>
									</tr>
									<!-- 
									<tr>
										<td class="zsml-res-items-1">(101)思想政治理论</td>
										<td  class="zsml-res-items-2">(201)英语一</td>
										<td class="zsml-res-items-3">(701)数学（自命）</td>
										<td class="zsml-res-items-4">(801)植物生理学与生物化学（自命）</td>
									</tr>
									 -->
								</tbody>

								<tbody class="zsml-res-divider" style="display:none">
									<tr>
										<td colspan="4">
											<div>
												<span>或</span>
												<hr class="zsml-line">
											</div>
										</td>
									</tr>
								</tbody>

							</table>
						</div>
					</div>
					<!-- 考试范围 end -->
					<div class="zsml-page-tip">
						注：本系统数据从招生单位获取，如有疑问请咨询相关招生单位。
					</div>
				</div>
				<!-- 页面左侧 end -->

			</div>
		</div>
		
			<!-- 4: 底部区域 -->
		<style>
			/**
		     * description: footer 共用底部;
		     * author:myx;
		     * date:2017-07;
		     */
			
			.footer-wrapper {
				line-height: 30px;
				background: #282828;
				color: #ababab;
			}
			
			.footer-wrapper a {
				color: #ababab;
			}
			
			.footer-wrapper .footer {
				position: relative;
				width: 1180px;
				height: 160px;
				margin: 0 auto;
			}
			
			.footer-wrapper .footer-list {
				position: absolute;
				top: 32px;
				left: 0px;
			}
			
			.footer-wrapper .footer-list a {
				margin-right: 15px;
			}
			
			.footer-wrapper .footer-units {
				position: absolute;
				top: 75px;
				left: 0px;
			}
			
			.footer-wrapper .footer-media {
				position: absolute;
				top: 32px;
				left: 844px;
			}
			
			.footer-wrapper .footer-media a {
				display: inline-block;
				margin-right: 30px;
				vertical-align: top;
			}
			
			.footer-wrapper .footer-media a:hover {
				text-decoration: none;
			}
			
			.footer-wrapper .footer-media .iconfont {
				margin-right: 5px;
				font-size: 20px;
				vertical-align: middle;
			}
			
			.footer-wrapper .footer-msg {
				position: absolute;
				top: 75px;
				left: 844px;
			}
		</style>
		<div class="footer-wrapper">
			<div class="footer">
				<div class="footer-list">
					<a href="#">学信网</a>
					<a href="#">中心简介</a>
					<a href="#">关于我们</a>
					<a href="#">版权声明</a>
					<a href="#">帮助中心</a>
					<a href="#">网站地图</a>
					<a href="#">宣传代理</a>
				</div>
				<div class="footer-units">
					主管单位：
					<a href="http://www.moe.edu.cn/s78/A15/" target="_blank">教育部高校学生司</a>
					<br> 
					快速链接：
					<a href="http://yz.chsi.com.cn/" target="_blank">中国研究生招生信息网</a>
				</div>
				<div class="footer-media">
					<a href="/kyzx/kp/wbwx.shtml" target="_blank"><i class="iconfont" title="官方微信">&#xe694;</i>官方微信</a>
					<a href="/kyzx/kp/wbwx.shtml" target="_blank"><i class="iconfont" title="官方微博">&#xe693;</i>官方微博</a>
				</div>
				<div class="footer-msg">
					<a href="http://www.miibeian.gov.cn/" target="_blank">京ICP证030485号</a>
				</div>
			</div>
		</div>
		<!-- include_body 共用js -->
		
		<!-- body 底部共用js -->
		
		<script src="https://t1.chei.com.cn/common/plugins/layer/layer.js"></script>
		<script src="https://t1.chei.com.cn/common/plugins/placeholder-fix.js"></script>
		<script src="https://t1.chei.com.cn/common/ch/browser/least-ie8.min.js"></script>
		<link rel="stylesheet" href="https://t1.chei.com.cn/common/plugins/autocomplete/jquery.autocomplete.css">
		<script src="https://t1.chei.com.cn/common/plugins/autocomplete/jquery.autocomplete.js"></script>
		<style>
			/*修正：强制 layer中字符换行问题*/
			
			.layui-layer-content {
				word-wrap: break-word;
				word-break: break-all;
			}
		</style>
		
        
	</body>

	<script type="text/javascript">
		
		function showByAcaId(){
			var param = getUrlParam("acaId");
			getAcademyDetails(param);
		}
		showByAcaId();
		
		function getUrlParam(name) {  
		    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象  
		    var r = window.location.search.substr(1).match(reg);  // 匹配目标参数  
		    if (r != null) return unescape(r[2]); return null; // 返回参数值  
		} 
		
		function getAcademyDetails(aca_id){
			
			$.ajax({
				type:"GET",
				url:"${pageContext.request.contextPath }/academyDetails/detailsController",
				data:{
					"aca_id":aca_id
				},
				success:showAcademyDetails
			});
			
		}
		
		function showAcademyDetails(data){
			var acaNameTitle = $(".ch-header-second h1").text(data[0].aca_name);
			var ch_sub_title_academyname = $("#ch-sub-title-academyname").text(data[0].dep_name);
			
			var zsml_condition = $(".zsml-condition");
			var acaName = zsml_condition.find(".acaName").text(data[0].aca_name);
			var depName = zsml_condition.find(".depName").text(data[0].dep_name);
			var depSpecialty = zsml_condition.find(".depSpecialty").text(data[0].dep_specialty);
			var accStu = zsml_condition.find(".accStu").text();
			
			$("#acce_stu_num").text(data[0].acce_stu_num);
			$("#acce_stu_recommend_nu").text(data[0].acce_stu_recommend_nu);
			
			var zsml_result = $(".zsml-result");
			var resultTable = zsml_result.find("table")[0];
			
			var words = data[0].acce_stu_exam_scop.replace(";","").split(",");
			var politics = words[0];
			var foreignLanguage = words[1];
			var businessClass1 = words[2];
			var businessClass2 = words[3];
		
			var acaDetails = $($(".zsml-res-items").find("tr")[0]);
			var newacaDetails = acaDetails.clone(true);

			$($(newacaDetails).find(".zsml-res-items-1")[0]).text(politics);
			$($(newacaDetails).find(".zsml-res-items-2")[0]).text(foreignLanguage);
			$($(newacaDetails).find(".zsml-res-items-3")[0]).text(businessClass1);
			$($(newacaDetails).find(".zsml-res-items-4")[0]).text(businessClass2);
			
			newacaDetails.css("display","");
			
			$(".zsml-res-items").append($(newacaDetails).get(0));

			var depDirection = ""
			$(data).each(function(){
				depDirection += this.dep_direction + ",";
			});
			zsml_condition.find(".depDirection").text(depDirection);
			
		}
	</script>
</html>