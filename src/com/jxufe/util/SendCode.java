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
 * ������֤��
 * @author Administrator
 *
 */
public class SendCode {
    private final String
            SERVER_URL="https://api.netease.im/sms/sendcode.action";
    private final String 
            APP_KEY="8c8e21d81a37b0ceb17efca8aa1877ea";
    private final String APP_SECRET="a9a523bf8b18";
    //�����
    private String NONCE="654321";
    //����ģ��ID
    private final String TEMPLATEID="3064710";
    //�ֻ���
    private String MOBILE="15770700260";
    //��֤�볤�ȣ���Χ4��10��Ĭ��Ϊ4
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
         * �ο�����CheckSum��java���룬�������ĵ��Ĳ����б��У���CheckSum�ļ����ĵ�ʾ��
         */
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

        MOBILE=mobile;
        
        // ���������header
        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // ��������ĵĲ�����requestBody����
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        /*
         * 1.�����ģ����ţ���ע�����mobile����s�ģ���ϸ����������ο�������ģ������ĵ���
         * 2.������ʽ��jsonArray�ĸ�ʽ������ "['13888888888','13666666666']"
         * 3.params�Ǹ�����ģ�������м���������������Ĳ���Ҳ��jsonArray��ʽ
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

        // ִ������
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
         * 1.��ӡִ�н������ӡ���һ���200��315��403��404��413��414��500
         * 2.�����code������Ŀ��Բο�������Code״̬��
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
//    	System.out.println("������֤��λ:"+sendCode.getIdentifyCode("15770700260"));
//    }
    
}