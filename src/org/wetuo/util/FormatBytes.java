package org.wetuo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * <p>格式化文件大小辅助类<p>
 * @author LH
 * 
 */
public class FormatBytes {
	private static FormatBytes  formatBytes = null;
	/**
	 * 
	 * 私有构造方法.   
	 *
	 */
	private FormatBytes(){}
	/**
	 * 获得一个单一实例
	 * @return SendMail   
	 */
	public synchronized static FormatBytes getDefaultInstance(){
		if(formatBytes==null){
			formatBytes = new FormatBytes();
		}
		return formatBytes;
	}
	/**
	 * 格式化文件大小
	 * @param bytes 文件字节数
	 * @return 格式化后文文件大小
	 */
	public String Format(long bytes){
		String temp = "";
		if(bytes >= 1073741824) {
			temp = ((bytes / 1073741824 * 100) / 100) + ".GB";
		} else if(bytes >= 1048576) {
			temp = ((bytes / 1048576 * 100) / 100) + ".MB";
		} else if(bytes >= 1024) {
			temp = ((bytes / 1024 * 100) / 100) + ".KB";
		} else {
			temp = bytes + ".Bytes";
		}
		return temp;
	}
	public String Format(File file){
		String temp="";
		long bytes = getFileSize(file);
		if(bytes >= 1073741824) {
			temp = ((bytes / 1073741824 * 100) / 100) + ".GB";
		} else if(bytes >= 1048576) {
			temp = ((bytes / 1048576 * 100) / 100) + ".MB";
		} else if(bytes >= 1024) {
			temp = ((bytes / 1024 * 100) / 100) + ".KB";
		} else {
			temp = bytes + ".Bytes";
		}
		return temp;
	}
	/**
	 * 获取文件字节数(Bytes)
	 * @param file 文件
	 * @return 文件字节数
	 */
	public long getFileSize(File file){
		try {
			FileInputStream ins = new FileInputStream(file);
			return ins.available();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
//	public static void main(String[] args) {
//		FormatBytes f = new FormatBytes();
//		File file = new File("F:\\bmc.sql");
//		System.out.println(f.Format(f.getFileSize(file)));
//	}
}
