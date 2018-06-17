package com.jxufe.test;

public class Test {

//	private static EEDetailsService eEDetailsService;
//	private static AcademyInfoService academyInfoService;
	
	public static void main(String[] args) {
		
		String str = "7A3D9C7F1E8E07AA9101D4C346C569D6";
		int a = Math.abs(str.hashCode());
		System.out.println(str.hashCode());
		System.out.println(a);
		
		String str1 = "7A3D9C7F1E8E07AA9101D4C346C569Df";
		int a1 = Math.abs((str1.hashCode()));
		System.out.println(str1.hashCode());
		System.out.println(a1);
//		List<AcademyInfo> academyInfos = academyInfoService.findByAca_985AndAca_211();
//		System.out.println(academyInfos);
//		
//		List<EEDetails> eEDetails = eEDetailsService.findAll();
//		System.out.println(eEDetails);
		
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
