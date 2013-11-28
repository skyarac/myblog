package org.wetuo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static DateUtils dateUtils;
	private DateUtils(){};
	public synchronized static DateUtils getDefaultInstance(){
		if(dateUtils==null){
			dateUtils = new DateUtils();
		}
		return dateUtils;
	}
	
	public String formatYear(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy");
		return sf.format(new Date());
	}
	public String formatMonth(){
		SimpleDateFormat sf = new SimpleDateFormat("MM");
		return sf.format(new Date());
	}
	public String formatDate(String pattern){
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.format(new Date());
	}
}
