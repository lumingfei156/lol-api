package cn.howieli.lol.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetNetDataUtil {

	public static String GetNetData(String requestUrl, String param, boolean isCookie) {
		StringBuilder json = new StringBuilder();
		URL url = null;
		URLConnection urlConnection = null;
		BufferedReader in = null;
		try {
			if (param != null) {
				url = new URL(requestUrl + "?" + param);
			} else {
				url = new URL(requestUrl);
			}
			
			urlConnection = url.openConnection();
			
			if (isCookie) {
				String cookie = GetQQCookieUtil.getQQCookie();
				urlConnection.setRequestProperty("Cookie", cookie);
			}
			urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
			urlConnection.connect();
			in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json.toString();
	}
}
