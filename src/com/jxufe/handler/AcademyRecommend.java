package com.jxufe.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jxufe.service.AcademyInfoService;

@Controller
@RequestMapping(value="/academyRecommend")
public class AcademyRecommend {
	
	private AcademyInfoService academyInfoService;
	

}
