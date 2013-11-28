package org.wetuo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 
 * <p>常用字符串操作辅助类</p>
 * @author LH
 * 
 */
public class StringUtils {
	private static StringUtils stringUtils;
	/**
	 * 
	 * 私有构造函数  ，类不能用new关键字实例
	 *
	 */
	private StringUtils(){}
	/**
	 * 
	 * 获得一个单一实例
	 * @return StringUtils   
	 */
	public synchronized static StringUtils getDefaultInstance(){
		if(stringUtils==null){
			stringUtils = new StringUtils();
		}
		return stringUtils;
	}
	
	/**
	 * 邮箱验证
	 * @param email 需要验证的字符串
	 * @return boolean
	 */
	public static boolean isVaildEmail(String email){
		String emailPattern="[a-zA-Z0-9][a-zA-Z0-9._-]{2,16}[a-zA-Z0-9]@[a-zA-Z0-9]+.[a-zA-Z0-9]+";
		boolean result=Pattern.matches(emailPattern, email);
		return result;
	}
	/**
	 * 判断一个字符串在另一个字符串数字中是否存在
	 * @param str
	 * @param strs
	 * @return
	 */
	public boolean stringExists(String str , String [] strs){
		for(int i=0;i<strs.length;i++){
			if(strs[i].equals(str)){
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断文件后缀名是否合法
	 * @param upfilename 文件名
	 * @param upExt 允许上传文件类型
	 * @return 
	 */
	public boolean checkUpExtName(String upFileName ,String upExt){
		if(upFileName.indexOf(String.valueOf('.')) == -1){
			return false;
		}else{
			String[] as = upExt.toLowerCase().split(",");
			boolean boo = false;
			label:
				for (int i = 0; i < as.length; i++) {
					if(as[i].equals(upFileName.substring(upFileName.lastIndexOf(".")+1).toLowerCase())){
						boo = true;
						break label;
					}
				}
			return boo;
		}
	}
	/**
	 * String数组转Long数组
	 */
	public Long[] castLong(String [] strs){
		Long[] nums = new Long[strs.length];
        for (int idx = 0; idx < strs.length; idx++) {
            nums[idx] = Long.parseLong(strs[idx]);
        }
        return nums;

	}
	/**
	 * 生成新的文件名
	 * 规则：当期年月日时分秒+4位随机数
	 * @return 新文件名
	 */
	public String getNewFileName(String upFileName){
		return new SimpleDateFormat ("yyyyMMddHHmmss").format(new Date())
				+ String.valueOf((int)(Math.random()*8999+1000)) 
				+ upFileName.substring(upFileName.lastIndexOf(".")).toLowerCase(); 
	}
}
