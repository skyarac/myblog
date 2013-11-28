package com.wetuo.blog.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ActionInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;
	public void destroy(){	}
	public void init() {}
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		String name = invocation.getInvocationContext().getName();
	//	String method = invocation.getProxy().getMethod();
		ActionContext ac = invocation.getInvocationContext();
		Map<String, Object> session =(Map<String, Object>)ac.get(ServletActionContext.SESSION);
		if(name.equals("login")){
			return invocation.invoke();
		}else{
			if(session.get("loginUser")==null||session.get("loginUser")==""){
				System.out.println(session.get("loginUser"));
				return "nologin";
			}else{
				System.out.println("xxxx");
				return invocation.invoke();
			}
		}
	}
}
