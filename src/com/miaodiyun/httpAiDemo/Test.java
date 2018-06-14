package com.miaodiyun.httpAiDemo;

import net.sf.json.JSONObject;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// 获取开发者账号信息
//		 AccountInfo.execute();

		 //设置手机号和验证码
		 
		// 验证码通知短信接口
		int random = (int)((Math.random()*9+1)*100000);
		 IndustrySMS.setIdentidyCode(random+"");
		 IndustrySMS.setTo("15770700260");
//		 String execute = IndustrySMS.execute();
		 String execute = "{\"respCode\":\"00000\",\"respDesc\":\"请求成功。\",\"failCount\":\"0\",\"failList\":[],\"smsId\":\"cb2057884e9d4acd8568f40b309edc9c\"}";
		 
		 JSONObject json = JSONObject.fromObject(execute);

		 String sendMessageResult = json.get("respCode").toString();
		 System.out.println(sendMessageResult);
		 System.out.println(IndustrySMS.getIdentidyCode());
		 
		// 会员营销短信接口
		// AffMarkSMS.execute();

		// 短信邮验证码通知短信接口
		// IndustryEmailSMS.execute();

		// 短信邮验证码通知短信接口
		// AffMarkEmailSMS.execute();

		// 语音验证码
		// VoiceCode.execute();

	}
}
