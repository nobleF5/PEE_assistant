package com.jxufe.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jxufe.entity.AcademyRankInfo;
import com.jxufe.service.AcademyRankInfoService;

@Controller
@RequestMapping(value="/academyRecommend")
public class AcademyRecommend {
	
	@Autowired
	private AcademyRankInfoService academyRankInfoService;
	
	@RequestMapping(value="/queryAca")
	public String queryAca(
			@RequestParam(value="aca_city") String aca_city,
			@RequestParam(value="startRanking") int startRanking,
			@RequestParam(value="endRanking") int endRanking,
			@RequestParam(value="aca_985") boolean aca_985,
			@RequestParam(value="aca_211") boolean aca_211,
			Map<String, Object> map){
		List<AcademyRankInfo> academyInfo = null;
		if(aca_city != null || !"".equals(aca_city)) {
			
		}
		map.put("academyInfo", academyInfo);
		System.out.println(academyInfo);
		return "foreui/UniversityRecommend";
		
	}
	
	public List<AcademyRankInfo> queryAca_211() {
		List<AcademyRankInfo> academyInfo = academyRankInfoService.findByAca_211();
		return academyInfo;
	}
	
	public List<AcademyRankInfo> queryAca_985AndAca_211() {
		List<AcademyRankInfo> academyInfo = academyRankInfoService.findByAca_985AndAca_211();
		return academyInfo;
	}
	
	public List<AcademyRankInfo> findByAca_city(String aca_city) {
		List<AcademyRankInfo> academyInfo = academyRankInfoService.findAcademyInfoByAca_city(aca_city);
		return academyInfo;
	}
	
	public List<AcademyRankInfo> findByAca_cityAndAca_211(String aca_city) {
		List<AcademyRankInfo> academyInfo = academyRankInfoService.findByAca_cityAndAca_211(aca_city);
		return academyInfo;
	}
	
	public List<AcademyRankInfo> findByAca_cityAndAca_985AndAca_211( String aca_city) {
		List<AcademyRankInfo> academyInfo = academyRankInfoService.findByAca_cityAndAca_985AndAca_211(aca_city);
		return academyInfo;
	}
	
	public List<AcademyRankInfo> findByAca_Ranking(int startRanking,int endRanking) {
		List<AcademyRankInfo> academyRankInfo = academyRankInfoService.findAcademyInfoByRank(startRanking, endRanking);
		return academyRankInfo;
	}
	
	public List<AcademyRankInfo> findAcademyInfoByAca_city(String Aca_city) {
		List<AcademyRankInfo> academyRankInfo = academyRankInfoService.findAcademyInfoByAca_city(Aca_city);
		return academyRankInfo;
	}
	
	public List<AcademyRankInfo> findAcademyInfoByAca_citAndRank(String Aca_city,int startRanking,int endRanking) {
		List<AcademyRankInfo> academyRankInfo = academyRankInfoService.findAcademyInfoByAca_citAndRank(Aca_city,startRanking,endRanking);
		return academyRankInfo;
	}
	

}
