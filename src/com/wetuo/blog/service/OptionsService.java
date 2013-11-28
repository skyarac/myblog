package com.wetuo.blog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wetuo.blog.dao.OptionsDAO;
import com.wetuo.blog.model.Options;

@Component("optionsService")
public class OptionsService {
	private OptionsDAO optionsDAO;

	public OptionsDAO getOptionsDAO() {
		return optionsDAO;
	}
	@Resource(name="optionsDAOImpl")
	public void setOptionsDAO(OptionsDAO optionsDAO) {
		this.optionsDAO = optionsDAO;
	}
	@Transactional
	public List<Options> getAll(){
		return optionsDAO.getAll();
	}
	@Transactional
	public void updateOptions(String name ,String value){
		Options  o = optionsDAO.getUniqueByProperty("optionName", name);
		o.setOptionValue(value);
		optionsDAO.merge(o);
	}
	
	@Transactional
	public Options getUniqueByProperty(String propertyName ,Object value){
		return optionsDAO.getUniqueByProperty(propertyName, value);
	}
}
