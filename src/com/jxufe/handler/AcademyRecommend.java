package com.jxufe.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.entityResult.AcademyResult;
import com.jxufe.service.AcademyRankInfoService;

@Controller
@RequestMapping(value="/academyRecommend")
public class AcademyRecommend {
	
	@Autowired
	private AcademyRankInfoService academyRankInfoService;
	
	@ResponseBody
	@RequestMapping(value="/queryAca", method = RequestMethod.POST)
	public List<AcademyResult> queryAca(
			@RequestParam(value="aca_city") String aca_city,
			@RequestParam(value="startRanking") int startRanking,
			@RequestParam(value="endRanking") int endRanking,
			@RequestParam(value="aca_985") boolean aca_985,
			@RequestParam(value="aca_211") boolean aca_211){

		List<AcademyResult> academyInfoList = null;

		if(aca_985==true&!"".equals(aca_city)&!"".equals(startRanking)&!"".equals(endRanking)) {
			academyInfoList = academyRankInfoService.findAcademyInfoByAca_citAndAca_985AndRank(aca_city, startRanking, endRanking);
		}
		if(aca_211==true&!"".equals(aca_city)&!"".equals(startRanking)&!"".equals(endRanking)) {
			academyInfoList = academyRankInfoService.findAcademyInfoByAca_citAndAca_211AndRank(aca_city, startRanking, endRanking);
		}
		if(aca_211==true&!"".equals(aca_city)&"".equals(startRanking)&"".equals(endRanking)) {
			academyInfoList = academyRankInfoService.findByAca_cityAndAca_211(aca_city);
		}
		if(aca_985==true&!"".equals(aca_city)&"".equals(startRanking)&"".equals(endRanking)) {
			academyInfoList = academyRankInfoService.findByAca_cityAndAca_985AndAca_211(aca_city);
		}
		if(aca_985==false&aca_211==false&!"".equals(aca_city)&!"".equals(startRanking)&!"".equals(endRanking)) {
			academyInfoList = academyRankInfoService.findAcademyInfoByAca_citAndRank(aca_city, startRanking, endRanking);
		}
		if(aca_985==true&"".equals(aca_city)&!"".equals(startRanking)&!"".equals(endRanking)) {
			academyInfoList = academyRankInfoService.findAcademyInfoByAca_211AndRank(startRanking, endRanking);
		}
		return academyInfoList;
	}
	
	
}
