package com.wetuo.blog.dao;


import com.wetuo.blog.model.TagRelationShips;


public interface TagRelationShipsDAO extends BaseDAO<TagRelationShips> {
	public abstract void delByBlogID(Long id);
}
