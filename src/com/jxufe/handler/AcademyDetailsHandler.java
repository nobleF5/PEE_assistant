package com.jxufe.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/detailsPage")
	public String queryAcaDetailsPage(){
		return "/foreui/academyDetails";
	}
	
	@ResponseBody
	@RequestMapping(value="/detailsController")
	public List<AcademyAcceptStuResult> queryAcaDetailsController(@RequestParam("aca_id") int aca_id){
		List<AcademyAcceptStuResult> academyAcceptStuResult = null;
		academyAcceptStuResult = departmentInfoService.findByAcaId(aca_id);
		System.out.println("/academyDetails/detailsController");
		return academyAcceptStuResult;
	}
}
