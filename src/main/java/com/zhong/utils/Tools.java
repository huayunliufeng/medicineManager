package com.zhong.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author 华韵流风
 */
public class Tools
{
	public static String md5(String str){
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		sun.misc.BASE64Encoder encoder =  new sun.misc.BASE64Encoder();
		assert md5 != null;
		return encoder.encode(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
    }
}
