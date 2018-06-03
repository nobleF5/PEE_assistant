package com.jxufe.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jxufe.entity.AcademyInfo;
import com.jxufe.entity.AcademyRankInfo;
import com.jxufe.service.AcademyInfoService;
import com.jxufe.service.AcademyRankInfoService;

@Controller
@RequestMapping(value="/academyInfoHandler")
public class AcademyInfoHandler {
	
	@Autowired
	private AcademyInfoService academyInfoService;
	@Autowired
	private AcademyRankInfoService academyRankInfoService;
	
	@RequestMapping(value="queryAca_211")
	public List<AcademyInfo> queryAca_211(Map<String, Object> map) {
		List<AcademyInfo> academyInfo = academyInfoService.findByAca_211();
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return academyInfo;
	}
	
	@RequestMapping(value="queryAca_985AndAca_211")
	public List<AcademyInfo> queryAca_985AndAca_211(Map<String, Object> map) {
		List<AcademyInfo> academyInfo = academyInfoService.findByAca_985AndAca_211();
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return academyInfo;
	}
	
	@RequestMapping(value="queryByAca_city")
	public String findByAca_city(
			@RequestParam(value="aca_city") String aca_city,
			Map<String, Object> map) {
		List<AcademyInfo> academyInfo = academyInfoService.findByAca_city(aca_city);
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return "foreui/temp2";
	}
	
	@RequestMapping(value="queryByAca_211AndAca_city")
	public String findByAca_cityAndAca_211(
			@RequestParam(value="aca_city") String aca_city,
			Map<String, Object> map) {
		List<AcademyInfo> academyInfo = academyInfoService.findByAca_cityAndAca_211(aca_city);
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return "foreui/temp2";
	}
	
	@RequestMapping(value="queryByAca_cityAndAca_985AndAca_211")
	public String findByAca_cityAndAca_985AndAca_211(
			@RequestParam(value="aca_city") String aca_city,
			Map<String, Object> map) {
		List<AcademyInfo> academyInfo = academyInfoService.findByAca_cityAndAca_985AndAca_211(aca_city);
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return "foreui/temp2";
	}
	
	@RequestMapping(value="queryByAca_Ranking")
	public String findByAca_Ranking(
			@RequestParam(value="startRanking") int startRanking,
			@RequestParam(value="endRanking") int endRanking,
			Map<String, Object> map) {
		List<AcademyRankInfo> academyRankInfo = academyRankInfoService.findAcademyInfoByRank(startRanking, endRanking);
		map.put("academyInfo", academyRankInfo);
		System.out.println(academyRankInfo);
		return "foreui/temp";
	}
	
	@RequestMapping(value="queryAcademyInfoByAca_city")
	public String findAcademyInfoByAca_city(
			@RequestParam(value="aca_city") String Aca_city,
			Map<String, Object> map) {
		List<AcademyRankInfo> academyRankInfo = academyRankInfoService.findAcademyInfoByAca_city(Aca_city);
		map.put("academyInfo", academyRankInfo);
		System.out.println(academyRankInfo);
		return "foreui/temp";
	}
	
	@RequestMapping(value="queryAcademyInfoByAca_cityAndRank")
	public String findAcademyInfoByAca_citAndRank(
			@RequestParam(value="aca_city") String Aca_city,
			@RequestParam(value="startRanking") int startRanking,
			@RequestParam(value="endRanking") int endRanking,
			Map<String, Object> map) {
		List<AcademyRankInfo> academyRankInfo = academyRankInfoService.findAcademyInfoByAca_citAndRank(Aca_city,startRanking,endRanking);
		map.put("academyInfo", academyRankInfo);
		System.out.println(academyRankInfo);
		return "foreui/temp";
	}

}
