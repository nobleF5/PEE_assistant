package com.jxufe.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.entityResult.AcademyAcceptStuResult;
import com.jxufe.service.DepartmentInfoService;

@Controller
@RequestMapping(value="/academyDetails")
public class AcademyDetailsHandler {
	
	@Autowired
	private DepartmentInfoService departmentInfoService;
	
	@ResponseBody
	@RequestMapping(value="/details")
	public List<AcademyAcceptStuResult> queryAcaDetails(@RequestParam(value="aca_id") int acaId){
		List<AcademyAcceptStuResult> academyAcceptStuResult = null;
		departmentInfoService.findByAcaId(acaId);
		return academyAcceptStuResult;
	}
}
