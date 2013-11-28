package org.wetuo.util;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class WebUtils {
	private static WebUtils webUtils;
	private WebUtils(){};
	public synchronized static WebUtils getDefaultInstance(){
		if(webUtils==null){
			webUtils = new WebUtils();
		}
		return webUtils;
	}
	
	/**
	 * 获取当前项目真实路径
	 * @return
	 */
	public String getRealPath(){
		ActionContext ac = ActionContext.getContext();
		ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		return sc.getRealPath("/");
	}
	/**
	 * 获取当前项目HTTP路径
	 * @return
	 */
	public String getBasePath(){
		return ServletActionContext.getRequest().getScheme() 
				+ "://"+ServletActionContext.getRequest().getServerName() 
				+ ":"+ServletActionContext.getRequest().getServerPort()
				+ ServletActionContext.getServletContext().getContextPath()+"/";
	}
}
