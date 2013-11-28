package com.wetuo.blog.dao.impl;

import org.springframework.stereotype.Component;

import com.wetuo.blog.dao.UserDAO;
import com.wetuo.blog.model.User;
@Component("userDAOImpl")
public class UserDAOImpl extends BaseDAOSupport<User> implements UserDAO {

}
