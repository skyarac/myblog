package com.wetuo.blog.service;

import java.io.Serializable;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wetuo.util.MD5;
import org.wetuo.util.StringUtils;

import com.wetuo.blog.dao.UserDAO;
import com.wetuo.blog.model.User;

@Component("userService")
public class UserService {
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="userDAOImpl")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	/**
	 * 登录验证
	 */
	@Transactional
	public User checkLogin(String username , String password){
		if(StringUtils.isVaildEmail(username)){
			String[] propertyNames = {"email","password"};
		//	String[] values = {username,MD5.getDefaultInstance().MD5Encode(password)};
			String[] values = {username,password};
			return userDAO.getUniqueByPropertys(propertyNames, values);
		}else{
			String[] propertyNames = {"username","password"};
		//	String[] values = {username,MD5.getDefaultInstance().MD5Encode(password)};
			String[] values = {username,password};
			return userDAO.getUniqueByPropertys(propertyNames, values);
		}
	}
	@Transactional
	public boolean localUpdateOneFields(Serializable entityid,
			String[] propertyNames, Object[] values) {
		return userDAO.localUpdateOneFields(entityid, propertyNames, values);
	}
	
}
