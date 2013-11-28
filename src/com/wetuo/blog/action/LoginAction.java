package com.wetuo.blog.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.wetuo.util.IpUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.blog.model.User;
import com.wetuo.blog.service.UserService;
@Component("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 2492339009782610856L;
	private Map<String, Object> session;
	private User user;
	private String username;
	private String password;
	private UserService userService;
	private String msg;
	private String yzm;
	public String home(){
		return "home";
	}
	/**
	 * 用户退出 
	 */
	public String logout(){
		session.remove("loginUser");
		session.clear();
		return "logout";
	}
	public String login(){
		if(session.get("loginUser")==null||session.get("loginUser")==""){
			if(!this.yzm.toUpperCase().equals(session.get("validationCode").toString().toUpperCase())){
				this.msg = "验证码错误!";
				return "loginFail";
			}
			if(username!=null&&username!=""&&password!=null&&password!=""){
				user = userService.checkLogin(username, password);
				if(user!=null){
					String [] propertyNames = {"loginTime","loginIp"};
					Object [] values = {new Date(),IpUtils.getDefaultInstance().getRealIP()};
					userService.localUpdateOneFields(user.getUserId(), propertyNames, values);
					session.put("loginUser", user);
					return "loginSuccess";
				}else{
					this.msg="登录失败！";
					return "loginFail";
				}
			}else{
				this.msg="登录失败！";
				return "loginFail";
			}
		}else{
			return "loginSuccess";
		}
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	
}
