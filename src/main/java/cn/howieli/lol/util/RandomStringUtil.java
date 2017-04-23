package cn.howieli.lol.util;

import java.util.Random;

public class RandomStringUtil {
	private static String base = "abcdefghigklmnopqrstuvwxyz" + "ABCDEFGHIGKLMNOPQRSTUVWXYZ" + "0123456789";
	private static Random random = new Random();
	private static StringBuffer sb = new StringBuffer();

	/**
	 * length=10,生成随机salt
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		sb.setLength(0);
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
