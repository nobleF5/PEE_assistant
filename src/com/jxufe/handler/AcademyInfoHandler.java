package com.jxufe.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.entity.AcademyInfo;
import com.jxufe.entity.AcademyRankInfo;
import com.jxufe.service.AcademyInfoService;
import com.jxufe.service.AcademyRankInfoService;

@Controller
@RequestMapping(value="/academyInfoHandler")
public class AcademyInfoHandler {
	
	@Autowired
	private AcademyInfoService academyInfoService;
	private AcademyRankInfoService academyRankInfoService;
	
	@ResponseBody
	@RequestMapping(value="queryAca_211")
	public List<AcademyInfo> queryAca_211(Map<String, Object> map) {
		List<AcademyInfo> academyInfo = academyInfoService.findByAca_211();
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return academyInfo;
	}
	
	@ResponseBody
	@RequestMapping(value="queryAca_985AndAca_211")
	public List<AcademyInfo> queryAca_985AndAca_211(Map<String, Object> map) {
		List<AcademyInfo> academyInfo = academyInfoService.findByAca_985AndAca_211();
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return academyInfo;
	}
	
	@ResponseBody
	@RequestMapping(value="queryByAca_city")
	public List<AcademyInfo> findByAca_city(Map<String, Object> map) {
		String aca_city = "±±¾©ÊÐ";
		List<AcademyInfo> academyInfo = academyInfoService.findByAca_city(aca_city);
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return academyInfo;
	}
	
	@ResponseBody
	@RequestMapping(value="queryByAca_Ranking")
	public List<AcademyRankInfo> findByAca_Ranking(Map<String, Object> map) {
		int startRanking = 0;
		int endRanking = 200;
		List<AcademyRankInfo> academyRankInfo = academyRankInfoService.findByAca_211(startRanking, endRanking);
		map.put("academyInfo", academyRankInfo);
		System.out.println(academyRankInfo);
		return academyRankInfo;
	}

}
