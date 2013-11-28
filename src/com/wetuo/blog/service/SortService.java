package com.wetuo.blog.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wetuo.blog.dao.SortDAO;
import com.wetuo.blog.model.Sort;

@Component("sortService")
public class SortService {
	private SortDAO sortDAO;

	public SortDAO getSortDAO() {
		return sortDAO;
	}
	@Resource(name="sortDAOImpl")
	public void setSortDAO(SortDAO sortDAO) {
		this.sortDAO = sortDAO;
	}
	@Transactional
	public void addSort(Sort sort){
		sortDAO.merge(sort);
	}
	@Transactional
	public List<Sort> getAll(){
		return sortDAO.getAll("sortId", true);
	}
	@Transactional
	public void deleteByIds(Object[] ids){
		sortDAO.bulkDelete(ids);
	}
	@Transactional
	public boolean localUpdateOneField(Serializable entityid,  String propertyName,
			 Object value){
		return sortDAO.localUpdateOneField(entityid, propertyName, value);
	}
	@Transactional
	public void delete(Serializable id){
		sortDAO.delete(id);
	}
}
