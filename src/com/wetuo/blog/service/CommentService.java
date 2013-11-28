package com.wetuo.blog.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wetuo.util.IpUtils;

import com.wetuo.blog.dao.BlogDAO;
import com.wetuo.blog.dao.CommentDAO;
import com.wetuo.blog.model.Blog;
import com.wetuo.blog.model.Comment;

@Component("commentService")
public class CommentService {
	private CommentDAO commentDAO;
	private BlogDAO blogDAO;
	public CommentDAO getCommentDAO() {
		return commentDAO;
	}
	@Resource(name="commentDAOImpl")
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	public BlogDAO getBlogDAO() {
		return blogDAO;
	}
	@Resource(name="blogDAOImpl")
	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
	
	@Transactional
	public void addComment(Comment comment){
		comment.setCommentDate(new Date());
		comment.setIp(IpUtils.getDefaultInstance().getRealIP());
		commentDAO.merge(comment);
		//增加评论次数
		Blog blog  = blogDAO.get(comment.getBlog().getBlogId());
		blog.setCommentCount(blog.getCommentCount()+1L);
		blogDAO.merge(blog);
	}
	@Transactional
	public void deleteByID(Long id){
		commentDAO.delete(id);
	}
	@Transactional
	public void deleteByIds(Long [] ids){
		commentDAO.bulkDelete(ids);
	}
}
