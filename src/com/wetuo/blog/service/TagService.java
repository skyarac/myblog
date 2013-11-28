package com.wetuo.blog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wetuo.blog.dao.TagDAO;
import com.wetuo.blog.model.Tag;

@Component("tagService")
public class TagService {
	private TagDAO tagDAO;
	public TagDAO getTagDAO() {
		return tagDAO;
	}
	@Resource(name="tagDAOImpl")
	public void setTagDAO(TagDAO tagDAO) {
		this.tagDAO = tagDAO;
	}
	@Transactional
	public void deleteByIds(Long[] ids){
		tagDAO.bulkDelete(ids);
	}
	@Transactional
	public List<Tag> getAll(){
		return tagDAO.getAll("tagId", true);
	}
}
