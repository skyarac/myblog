package org.wetuo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>字符串截取辅助类<p>
 * @author LH
 * 
 */
public class CutHtml{
	private static String htmlMatch = "";
	private static CutHtml cutHtml;
	private CutHtml(){}
	/**
	 * 
	 * 获得一个单一实例
	 * @return MD5   
	 */
	public synchronized static CutHtml getDefaultInstance(){
		if(cutHtml==null){
			cutHtml = new CutHtml();
		}
		return cutHtml;
	}
	public static String removeMatchHtmlTag(){
		Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>");
		Matcher m = p.matcher(htmlMatch);
		if (m.find()){
			htmlMatch = htmlMatch.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2");
			removeMatchHtmlTag();
		}
		return htmlMatch;
	}
	/**
	 * 
	 * @Title: subStringHTML
	 * @Description: TODO(带HTML元素字符串截取,补全HTML元素)
	 * @param param 需要截取的字符串
	 * @param length 需要截取长度
	 * @param endStr 截取字符串后添加类容，如...
	 * @return String  截取后字符串
	 */
	public static String subStringHTML(String param, int length, String endStr){
		if (length < 1){
			System.out.println("length must >0");
			return null;
		}
		if (param.length() < length)
			return param;
		StringBuffer result = new StringBuffer();
		StringBuffer str = new StringBuffer();
		int n = 0;
		boolean isCode = false;
		boolean isHTML = false;
		for (int i = 0; i < param.length(); i++){
			char temp = param.charAt(i);
			if (temp == '<')
				isCode = true;
			else
			if (temp == '&')
				isHTML = true;
			else
			if (temp == '>' && isCode){
				n--;
				isCode = false;
			} else
			if (temp == ';' && isHTML)
				isHTML = false;
			if (!isCode && !isHTML){
				n++;
				if ((new StringBuilder(String.valueOf(temp))).toString().getBytes().length > 1)
					n++;
				str.append(temp);
			}
			result.append(temp);
			if (n >= length)
				break;
		}
		result.append(endStr);
		String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)", "$1$2");
		temp_result = temp_result.replaceAll("<(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/>", "");
		htmlMatch = temp_result;
		temp_result = removeMatchHtmlTag();
		Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
		Matcher m = p.matcher(temp_result);
		List<String> endHTML = new ArrayList<String>();
		for (; m.find(); endHTML.add(m.group(1)));
		for (int i = endHTML.size() - 1; i >= 0; i--){
			result.append("</");
			result.append(endHTML.get(i));
			result.append(">");
		}
		return result.toString();
	}
	/**
	 * 
	 * @Title: splitAndFilterString
	 * @Description: TODO(带HTML元素字符串截取，并去掉所有HTML元素)
	 * @param param 需要截取的字符串
	 * @param length 需要截取长度
	 * @param endStr 截取字符串后添加类容，如...
	 * @return String  截取后字符串
	 */
	public static String splitAndFilterString(String param, int length , String endStr) {
		if (param == null || param.trim().equals("")) {
			return "";
		}
		String str = param.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
				"<[^>]*>", "");
		str = str.replaceAll("[(/>)<]", "");
		int len = str.length();
		if (len <= length) {
			return str;
		} else {
			str = str.substring(0, length);
			str += endStr;
		}
		return str;
	}
	/**
	 * 
	 * @Title: splitString
	 * @Description: TODO(普通字符串截取)
	 * @param @param input 需要截取的字符串
	 * @param @param length 需要截取长度
	 * @return String  返回截取后的字符串
	 */
	public static String splitString (String input ,int length){
		if (input == null || input.trim().equals("")) {
			return "";
		}
		if(input.length()>length){
			input = input.substring(0,length);
		}
		return input;
	}
}
