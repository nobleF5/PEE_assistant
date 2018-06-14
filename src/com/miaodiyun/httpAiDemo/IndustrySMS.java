package com.miaodiyun.httpAiDemo;

import com.miaodiyun.httpAiDemo.common.Config;
import com.miaodiyun.httpAiDemo.common.HttpUtil;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String to="15770700260";
	private static String identidyCode = "123456";
	
	public static void setTo(String mobile){
		IndustrySMS.to = mobile;
	}
	
	public static String getIdentidyCode() {
		return identidyCode;
	}

	public static void setIdentidyCode(String identidyCode) {
		IndustrySMS.identidyCode = identidyCode;
	}

	/**
	 * 验证码通知短信
	 */
	public static String execute()
	{
		String smsContent = "【巴金科技】验证码："+ identidyCode +"，打死都不要告诉别人哦！";

		System.out.println("要发送的手机为: " + to);
		System.out.println("你发的验证码位： " + identidyCode);
		
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		return result;
	}
}
