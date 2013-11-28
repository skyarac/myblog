package org.wetuo.util;

import java.security.MessageDigest;

/**
 * 
 * <p>MD5加密辅助类</p>
 * @author LH
 * 
 */
public class MD5 {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	private static MD5 md5;
	/**
	 * 
	 * 私有构造函数  ，类不能用new关键字实例
	 *
	 */
	private MD5(){};
	/**
	 * 
	 * 获得一个单一实例
	 * @return MD5   
	 */
	public synchronized static MD5 getDefaultInstance(){
		if(md5==null){
			md5 = new MD5();
		}
		return md5;
	}
	/**
	 * 转换字节数组为16进制字串
	 * @param b 字节数组
	 * @return 16进制字串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	/**
	 * 
	 * MD5加密
	 * @param  plainText 需要加密字符串
	 * @return String  MD5加密后字符串
	 */
	public  String MD5Encode(String plainText) {
		String resultString = null;
		try {
			resultString = new String(plainText);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
	
		}
		return resultString;
	}
}
