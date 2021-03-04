package com.twkf.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}

	private static final String salt = "1a2b3c4d";

	/**
	 * 第一次salt
	 *
	 * @param inputPass
	 * @return
	 */
	public static String inputPassToFormPass(String inputPass) {
		String str = salt.charAt(0) + salt.charAt(2) + inputPass
				+ salt.charAt(5) + salt.charAt(4);
		return md5(str);
	}

	/**
	 * 第二次salt
	 *
	 * @param formPass
	 * @return
	 */
	public static String formPassToDBPass(String formPass, String salt) {
		String str = salt.charAt(0) + salt.charAt(2) + formPass
				+ salt.charAt(5) + salt.charAt(4);
		return md5(str);
	}

	public static String inputPassToDbPass(String inputPass, String saltDB) {
		String formPass = inputPassToFormPass(inputPass);
		String dbPass = formPassToDBPass(formPass, saltDB);
		return dbPass;
	}

//	public static void main(String[] args) {
//		System.out.println(inputPassToFormPass("taxi_test"));//d3b1294a61a07da9b49b6e22b2cbd7f9
//		System.out.println(formPassToDBPass(inputPassToFormPass("taxi_test"), "1a2b3c4d"));
//		System.out.println(inputPassToDbPass("taxi_test", "1a2b3c4d"));//b7797cce01b4b131b433b6acf4add449
//	}
}
