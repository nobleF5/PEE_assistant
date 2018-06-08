package com.jxufe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.entity.DepartmentInfo;
import com.jxufe.entityResult.AcademyAcceptStuResult;
import com.jxufe.repository.DepartmentInfoRepository;

@Service
public class DepartmentInfoService {
	
	@Autowired
	private DepartmentInfoRepository departmentInfoRepository;
	
	@Transactional
	public List<AcademyAcceptStuResult> findByAcaId(int acaId){
		
		ArrayList<AcademyAcceptStuResult> departmentInfoList = new ArrayList<>();
		List<DepartmentInfo> departmentInfos = departmentInfoRepository.findByAcaId(acaId);
		for(DepartmentInfo info: departmentInfos) {
			AcademyAcceptStuResult vo = new AcademyAcceptStuResult(info.getId(),
																   info.getAcademyInfo().getAca_Name(),
																   info.getDep_Name(),
																   info.getDep_Specialty(),
																   info.getDep_Direction(),
																   info.getAcceptStuInfo().getAcceStu_Num(),
																   info.getAcceptStuInfo().getAcceStu_RecommendNu(),
																   info.getAcceptStuInfo().getAcceStu_ExamScop());
			departmentInfoList.add(vo);
		}
		return departmentInfoList;
	}
}
