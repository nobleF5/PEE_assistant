package com.jxufe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.entity.AcademyRankInfo;
import com.jxufe.entityResult.AcademyResult;
import com.jxufe.repository.AcademyRankInfoRepository;

@Service
public class AcademyRankInfoService {

	@Autowired
	private AcademyRankInfoRepository academyRankInfoRepository;
	
	@Transactional
	public List<AcademyResult> findAll(){
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository.findAll();
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
												 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	

	
	@Transactional
	public List<AcademyResult> findAcademyInfoByAca_Name(String acaName){
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
				.findAcademyInfoByAca_Name(acaName);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	
	@Transactional
	public List<AcademyResult> findAcademyInfoByRank(int startRanking, int endRanking){
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
				.findAcademyInfoByRank(startRanking, endRanking);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	@Transactional
	public List<AcademyResult> findAcademyInfoByAca_985AndRank(int startRanking, int endRanking){
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
				.findAcademyInfoByAca_985AndRank(startRanking, endRanking);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	@Transactional
	public List<AcademyResult> findAcademyInfoByAca_211AndRank(int startRanking, int endRanking){
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
				.findAcademyInfoByAca_211AndRank(startRanking, endRanking);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	@Transactional
	public List<AcademyResult> findAcademyInfoByAca_city(String Aca_city){
		Aca_city = "%" + Aca_city + "%";
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
				.findAcademyInfoByAca_city(Aca_city);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	@Transactional
	public List<AcademyResult> findAcademyInfoByAca_citAndRank(String Aca_city,int startRanking, int endRanking){
		Aca_city = "%" + Aca_city + "%";
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
				.findAcademyInfoByAca_citAndRank(Aca_city,startRanking,endRanking);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	@Transactional
	public List<AcademyRankInfo> findByAca_211(){
		return academyRankInfoRepository.findByAca_211();
	}
	
	@Transactional
	public List<AcademyRankInfo> findByAca_985AndAca_211(){
		return academyRankInfoRepository.findByAca_985AndAca_211();
	}
	
	@Transactional
	public List<AcademyResult> findByAca_cityAndAca_211(String aca_city){
		aca_city = "%" + aca_city + "%";
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
				.findByAca_cityAndAca_211(aca_city);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	@Transactional
	public List<AcademyResult> findByAca_cityAndAca_985AndAca_211(String aca_city){
		aca_city = "%" + aca_city + "%";
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
				.findByAca_cityAndAca_985AndAca_211(aca_city);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}

	@Transactional
	public List<AcademyResult> findAcademyInfoByAca_citAndAca_985AndRank(String aca_city,
			int startRanking, int endRanking){
		aca_city = "%" + aca_city + "%";
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
											.findAcademyInfoByAca_citAndAca_985AndRank(aca_city,startRanking, endRanking);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	@Transactional
	public List<AcademyResult> findAcademyInfoByAca_citAndAca_211AndRank(String aca_city,
			int startRanking, int endRanking){
		aca_city = "%" + aca_city + "%";
		List<AcademyResult> academyInfoList = new ArrayList<>();
		List<AcademyRankInfo> academyInfo = academyRankInfoRepository
											.findAcademyInfoByAca_citAndAca_211AndRank(aca_city,startRanking, endRanking);
		for(AcademyRankInfo info : academyInfo) {
			AcademyResult vo = new AcademyResult(info.getAcademyInfo().getAca_ID(),
					 							 info.getAcademyInfo().getAca_Name(),
												 info.getAca_Ranking(),
												 info.getAcademyInfo().isAca_985(),
												 info.getAcademyInfo().isAca_211());
			academyInfoList.add(vo);
		}
		return academyInfoList;
	}
	
	
}
