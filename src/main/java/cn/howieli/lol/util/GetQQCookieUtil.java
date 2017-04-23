package cn.howieli.lol.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.howieli.lol.controller.msg.Message;

public class GetQQCookieUtil {
	
	public static String getQQCookie() throws JsonParseException, JsonMappingException, IOException {
		String url = "http://www.51carry.com/api/getCookies";
		String json = sendPost(url);
		ObjectMapper mapper = new ObjectMapper();
		Message msg = mapper.readValue(json, Message.class);
		return msg.getObject().toString();
	}
	
	public static String sendPost(String url) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
