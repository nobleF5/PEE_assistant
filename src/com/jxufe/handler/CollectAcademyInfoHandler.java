package com.jxufe.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.entity.AcademyInfo;
import com.jxufe.entity.CollectAcademyInfo;
import com.jxufe.entity.StudentInfo;
import com.jxufe.entityResult.AcademyResult;
import com.jxufe.service.CollectAcademyService;
import com.jxufe.status.CollectStatus;

@Controller
@RequestMapping("/CollectAcademyInfoHandler")
public class CollectAcademyInfoHandler {
	
	@Autowired
	private CollectAcademyService collectAcademyService;
	
	//查看收藏
	@ResponseBody
	@RequestMapping("/fromCollectAcademyGetAcademyResult")
	public List<AcademyResult> getCollectAcademy(@RequestParam("studentInfo_id") int studentInfo_id) {
		List<AcademyResult> byStudentInfoStuId = collectAcademyService.getByStudentInfoStuId(studentInfo_id);
		return byStudentInfoStuId;
	}
	
	@ResponseBody
	@RequestMapping("/getCollectAcademyAll")
	public List<CollectAcademyInfo> getCollectAcademyAll() {
		List<CollectAcademyInfo> findAll = collectAcademyService.findAll();
		return findAll;
	}
	
	//用户收藏
	@ResponseBody
	@RequestMapping("/collectAcademy")
	public CollectStatus collectAcademy(@RequestParam("stu_id") int stu_id,@RequestParam("aca_id") int aca_id) {
		
		CollectAcademyInfo collectAcademyInfo = new CollectAcademyInfo();
		collectAcademyInfo.setAcademyInfo(new AcademyInfo(aca_id));
		collectAcademyInfo.setStudentInfo(new StudentInfo(stu_id));
		
		CollectStatus collectAcademy = new CollectStatus();
		try {
			collectAcademyService.collectAcademy(collectAcademyInfo);
			collectAcademy.setMessage(CollectStatus.SUCCESS_COLLECT_MSG);
			collectAcademy.setCode(CollectStatus.SUCCESS);
		} catch (Exception e) {
			collectAcademy.setMessage(CollectStatus.SUCCESS_COLLECT_MSG);
			collectAcademy.setCode(CollectStatus.FAILED);
		}
		return collectAcademy;
	}
	
	//取消收藏
	@ResponseBody
	@RequestMapping("/cancelCollect")
	public CollectStatus cancleCollect(@RequestParam("stu_id") int stu_id,@RequestParam("aca_id") int aca_id) {
		CollectStatus collectStatus = new CollectStatus();
		try {
			collectAcademyService.cancleColect(stu_id,aca_id);
			collectStatus.setCode(CollectStatus.SUCCESS);
			collectStatus.setMessage(CollectStatus.SUCCESS_CANCLECOLLECT_MSG);
		} catch (Exception e) {
			collectStatus.setCode(CollectStatus.FAILED);
			collectStatus.setMessage(CollectStatus.FAILURE_CANCLECOLLECT_MSG);
			e.printStackTrace();
		}
		
		return collectStatus;
	}
	
}