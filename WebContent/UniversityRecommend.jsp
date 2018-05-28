<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>UniversityRecommend</title>

	<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<div id="cityChannel" style="float:left; margin-left:20px">
      <select name="cityChannel">
		  <option value="" style="display:none">城市频道</option>
		  <option value="beijin">北京</option>
		  <option value="shanghai">上海</option>
		  <option value="guangzhou">广州</option>
	  </select>
    </div>
    
    <div id="academyProperty" style="float:left; margin-left:20px">
      <select name="academyProperty">
		  <option value="" style="display:none">院校性质</option>
		  <option value="beijin">北京</option>
		  <option value="shanghai">上海</option>
		  <option value="guangzhou">广州</option>
	  </select>
    </div>
    
    <div id="academyRank" style="float:left; margin-left:20px">
      <select name="academyRank">
		  <option value="" style="display:none">院校排名</option>
		  <option value="oneToFifty">1-50</option>
		  <option value="fiftyToHundred">50-100</option>
		  <option value="HundredToHundredFifty">100-150</option>
	  </select>
    </div>
    
    <div id="departmentRank" style="float:left; margin-left:20px">
      <select name="departmentRank">
		  <option value="" style="display:none">专业排名</option>
		  <option value="oneToFifty">1-50</option>
		  <option value="fiftyToHundred">50-100</option>
		  <option value="HundredToHundredFifty">100-150</option>
	  </select>
    </div>
    
    <div id="degreeCategory" style="float:left; margin-left:20px">
      <select name="degreeCategory">
		  <option value="" style="display:none">学位类别</option>
		  <option value="academicMaster">学硕</option>
		  <option value="professionalMaster">专硕</option>
	  </select>
    </div>
    
    <br/><br/>
    
    <a href="#">院校推荐</a>
    
    <script type="text/javascript">
    	function recommend(){
    		var cityChannel = $("select[name=cityChannel]")
    		var academyProperty = $("select[name=academyProperty]")
    		var academyRank = $("select[name=academyRank]")
    		var departmentRank = $("select[name=departmentRank]")
    		var degreeCategory = $("select[name=degreeCategory]")
    		
    		cityChannelValue = cityChannel.attr("selected");
    		academyPropertyValue = academyProperty.attr("selected");
    		academyRankValue = academyRank.attr("selected");
    		departmentRankValue = departmentRank.attr("selected");
    		degreeCategoryValue = degreeCategory.attr("selected");
    		
    		$.ajax({
					type : "GET",
					url : "${pageContext.request.contextPath }/academyRecommend?"
							+ "city=&&academyProperty=&&academyRank=&&departmentRank=&&degreeCategory=",
					success : function(){}
    		});
    	}
    </script>
	
</body>
</html>