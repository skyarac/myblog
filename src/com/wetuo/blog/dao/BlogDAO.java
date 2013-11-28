package com.wetuo.blog.dao;

import java.util.Date;

import com.wetuo.blog.model.Blog;

public interface BlogDAO extends BaseDAO<Blog> {
	public abstract Blog nextBlog(Date date);
	public abstract Blog prevBlog(Date date);
	public abstract Blog loadOneBlogForHome(Long id);
	public abstract Long addBlog(Blog b);
}
