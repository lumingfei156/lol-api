package cn.howieli.lol.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLCodeUtil {
	public static String getUTF8(String str) {
		try {
			str = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String getChinese(String str) {
		try {
			str = URLDecoder.decode(str.replaceAll("%", "%25"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
}
