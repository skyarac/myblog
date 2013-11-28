package com.wetuo.blog.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wetuo.blog.dao.LinkDAO;
import com.wetuo.blog.model.Link;

@Component("linkService")
public class LinkService {
	private LinkDAO linkDAO;

	public LinkDAO getLinkDAO() {
		return linkDAO;
	}
	@Resource(name="linkDAOImpl")
	public void setLinkDAO(LinkDAO linkDAO) {
		this.linkDAO = linkDAO;
	}
	
	@Transactional
	public void addLink(Link link){
		linkDAO.merge(link);
	}
	@Transactional
	public List<Link> getAll(){
		return linkDAO.getAll("linkStatus", true);
	}
	//查询所有通过审核友情链接
	@Transactional
	public List<Link> getByProperty(){
		return linkDAO.getByProperty("linkStatus", "Y");
	}
	@Transactional
	public void deleteByIds(Object[] ids){
		linkDAO.bulkDelete(ids);
	}
	@Transactional
	public void delete(Serializable id){
		linkDAO.delete(id);
	}
}
