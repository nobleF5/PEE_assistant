package com.jxufe.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.entityResult.AcademyResult;
import com.jxufe.service.CollectAcademyService;

@Controller
@RequestMapping("/CollectAcademyInfoHandler")
public class CollectAcademyInfoHandler {
	
	@Autowired
	private CollectAcademyService collectAcademyService;
	
	@ResponseBody
	@RequestMapping("/getCollectAcademy")
	public List<AcademyResult> getCollectAcademy(@RequestParam("studentInfo_id") int studentInfo_id) {
		
		List<AcademyResult> byStudentInfoStuId = collectAcademyService.getByStudentInfoStuId(studentInfo_id);
		return byStudentInfoStuId;
	}
	
}
