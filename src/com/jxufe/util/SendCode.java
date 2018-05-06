package com.jxufe.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 发送验证码
 * @author Administrator
 *
 */
public class SendCode {
    private final String
            SERVER_URL="https://api.netease.im/sms/sendcode.action";
    private final String 
            APP_KEY="8c8e21d81a37b0ceb17efca8aa1877ea";
    private final String APP_SECRET="a9a523bf8b18";
    //随机数
    private String NONCE="654321";
    //短信模板ID
    private final String TEMPLATEID="3064710";
    //手机号
    private String MOBILE="15770700260";
    //验证码长度，范围4～10，默认为4
    private final String CODELEN="6";
    
    public SendCode(){
    	int random = (int)((Math.random()*9+1)*100000);
    	NONCE = random+"";
    	System.out.println("NONCE:"+NONCE);
    }

    public String getIdentifyCode(String mobile) {

		String SMI = ""; 
		
        @SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(SERVER_URL);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        /*
         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
         */
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

        MOBILE=mobile;
        
        // 设置请求的header
        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的的参数，requestBody参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        /*
         * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
         * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
         * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
         */
        nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
        nvps.add(new BasicNameValuePair("mobile", MOBILE));
        nvps.add(new BasicNameValuePair("codeLen", CODELEN));

        try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // 执行请求
        HttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /*
         * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
         * 2.具体的code有问题的可以参考官网的Code状态表
         */
        try {
			Object object="";
			//{"code":200,"msg":"202","obj":"362362"}
			String code = EntityUtils.toString(response.getEntity(), "utf-8");
			String jsonCode = "["+code+"]";
			
			JSONArray jsonArray = JSONArray.fromObject(jsonCode);
			
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				object = jsonObject.get("obj");
			}
			
			SMI=object.toString();
			
//			System.out.println("SMI:"+SMI);
//	        System.out.println("code:"+code);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return SMI;
    }
    
//    public static void main(String[] args){
//    	SendCode sendCode = new SendCode();
//    	System.out.println("您的验证码位:"+sendCode.getIdentifyCode("15770700260"));
//    }
    
}