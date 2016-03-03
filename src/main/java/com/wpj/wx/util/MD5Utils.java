/*
 * Copyright (c) 2016 - 3 - 3  4 : 20 :10
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
/**
 * 可以把一段文字转换为MD
 * Can convert a file to MD5
 * @param text
 * @return md5
 */
public static String encode(String text){
	try {
	MessageDigest digest = MessageDigest.getInstance("md5");
	byte[] buffer = digest.digest(text.getBytes());
	// byte -128 ---- 127
	StringBuffer sb = new StringBuffer();
	for (byte b : buffer) {
		int a = b & 0xff;
		// Log.d(TAG, "" + a);
		String hex = Integer.toHexString(a);

		if (hex.length() == 1) {
			hex = 0 + hex;
		}
		sb.append(hex);
	}
	return sb.toString();
} catch (NoSuchAlgorithmException e) {
	e.printStackTrace();
}
return null;
}

/***
 * 任意文件转换成Md5
 * Can convert a text to MD5
 * @param inputStream
 * @return md5
 */

public static String encode(InputStream inputStream) {
	try {
		MessageDigest digester = MessageDigest.getInstance("MD5");
		byte[] bytes = new byte[8192];
		int byteCount;
		while ((byteCount = inputStream.read(bytes)) > 0) {
			digester.update(bytes, 0, byteCount);
		}
		byte[] digest = digester.digest();

		// byte -128 ---- 127
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			int a = b & 0xff;
			// Log.d(TAG, "" + a);

			String hex = Integer.toHexString(a);

			if (hex.length() == 1) {
				hex = 0 + hex;
			}

			sb.append(hex);
		}

		return sb.toString();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			inputStream = null;
		}
	}
	return null;
}



}