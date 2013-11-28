package org.wetuo.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * <p>获取用户IP辅助类<p>
 * @author LH
 * 
 */
public class IpUtils {
	private static IpUtils ipUtils;
	private IpUtils(){};
	/**
	 * 获得一个单一实例
	 */
	public synchronized static IpUtils getDefaultInstance(){
		if(ipUtils==null){
			ipUtils = new IpUtils();
		}
		return ipUtils;
	}
	public  String getRealIP(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String realIP = request.getHeader("x-forwarded-for");
	  	if(realIP != null && realIP.length() != 0 ){
			while((realIP!=null)&&(realIP.equalsIgnoreCase("unknown"))){
	    		realIP = request.getHeader("x-forwarded-for");
	   		}
	  	}
	  	if(realIP == null || realIP.length() == 0 ){
	   		realIP = request.getHeader("Proxy-Client-IP");
	  	}
	  	if(realIP == null || realIP.length() == 0 ){
	   		realIP = request.getHeader("WL-Proxy-Client-IP");
	  	}
	  	if(realIP == null || realIP.length() == 0 ){
	   		realIP=request.getRemoteAddr();
	  	} 
	  	
	  	return realIP;
	}
}
