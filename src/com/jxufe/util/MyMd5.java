package com.jxufe.util;

import java.security.MessageDigest;

public class MyMd5 {
	public static String MD5(String key) {
        char hexDigits[] = {
        		'Y','U','B','A','J','I','N','E','D','G','T','S','1','8','2','9','6','7'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
        
    }
	
	public static void main(String[] args) {
		String pwd = MyMd5.MD5("12345");
		System.out.println(pwd);
		String pwd1 = MyMd5.MD5("12345");
		System.out.println(pwd1);
		String pwd2 = MyMd5.MD5("123456");
		System.out.println(pwd2);
	}
}
