package com.jxufe.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;


public class NetUtils {
	
	private Map<String, String> cookies;
	
	private Connection getConnection(String url) {
		Connection con = Jsoup.connect(url);
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
		con.headers(headers);
		return con;
	}
	
	
	/**
	 * 第一次连接的时获取cookies
	 * @param url
	 */
	public Response getCookie(String url) {
		Connection con = getConnection(url);
		Response response = null;
		try {
			response = con.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cookies = response.cookies();
		System.out.println("cookies:\n"+this.cookies.toString());
		return response;
	}
	
	public Response doMyGetRequest(String url) {
		Connection con = getConnection(url);
		Response response = null;
		try {
			//如果请求的数据是json数据,则要设置为ignoreContentType为true
			response = con.ignoreContentType(true).method(Method.GET).cookies(cookies).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public Response doMyPostRequest(String url,Map<String,String> datas) {
		Connection con = getConnection(url);
		Response response = null;
		try {
			//如果请求的数据是json数据,则要设置为ignoreContentType为true
			response = con.ignoreContentType(true).method(Method.POST).cookies(cookies).data(datas).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public static void main(String[] args) {
		NetUtils utils = new NetUtils();
		String url = "http://yz.chsi.com.cn/zsml/pages/getSs.jsp";
		utils.getCookie(url);
		Response doMyGetRequest = utils.doMyGetRequest(url);
		String body = doMyGetRequest.body();
		
		JSONArray jsonArray = JSONArray.fromObject(body);
		System.out.println("jsonStr:" + body);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject JSONObj = (JSONObject) jsonArray.get(i);
			try {
				String distribute = (String) JSONObj.get("mc");
				System.out.println("distribute:" + distribute);
			} catch (JSONException e) {
				System.out.println("json数据解析错误!");
				e.printStackTrace();
			}
		}
		
	}
}