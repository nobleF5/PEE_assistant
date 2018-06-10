package com.jxufe.util;

import java.security.MessageDigest;

public class MyMd5 {
	public static String MD5(String key) {
        char hexDigits[] = {
        		'Y','U','B','A','J','I','N','E','D','G','T','S','1','8','2','9','6','7'
        };
        try {
            byte[] btInput = key.getBytes();
            // ���MD5ժҪ�㷨�� MessageDigest ����
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // ʹ��ָ�����ֽڸ���ժҪ
            mdInst.update(btInput);
            // �������
            byte[] md = mdInst.digest();
            // ������ת����ʮ�����Ƶ��ַ�����ʽ
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
