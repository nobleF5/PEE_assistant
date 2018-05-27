package com.jxufe.test;

import java.util.List;

import com.jxufe.entity.AcademyInfo;
import com.jxufe.entity.EEDetails;
import com.jxufe.service.AcademyInfoService;
import com.jxufe.service.EEDetailsService;


public class Test {

	private static EEDetailsService eEDetailsService;
	private static AcademyInfoService academyInfoService;
	
	public static void main(String[] args) {
		List<AcademyInfo> academyInfos = academyInfoService.findByAca_985AndAca_211();
		System.out.println(academyInfos);
		
		List<EEDetails> eEDetails = eEDetailsService.findAll();
		System.out.println(eEDetails);
		
//		 String json = "[{'first': 'one','next': 'two'},{'second':'余拔�?','next': 'there'}]";
//		 JSONArray jsonArray = JSONArray.fromObject(json);
//		 
//		 for (int i = 0; i < jsonArray.size(); i++) {
//			JSONObject obj = jsonArray.getJSONObject(i);
//			
//			System.out.println("obj: " + obj.getString("next"));
//		}
		 
	}
	
//	 public static void example(String[] args) 
//	   {
//	      JSONObject obj = new JSONObject();
//
//	      obj.put("name", "foo");
//	      obj.put("num", new Integer(100));
//	      obj.put("balance", new Double(1000.21));
//	      obj.put("is_vip", new Boolean(true));
//
//	      System.out.print(obj);
//	   }
}
