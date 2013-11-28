package com.wetuo.blog.dao.impl;

import org.springframework.stereotype.Component;

import com.wetuo.blog.dao.CommentDAO;
import com.wetuo.blog.model.Comment;
@Component("commentDAOImpl")
public class CommentDAOImpl extends BaseDAOSupport<Comment> implements
		CommentDAO {

}
