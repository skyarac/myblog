package com.wetuo.blog.dao;


import com.wetuo.blog.model.Tag;

public interface TagDAO extends BaseDAO<Tag> {
	public abstract Long existsByName(String name);
	public abstract Long addTag(Tag t);
}
