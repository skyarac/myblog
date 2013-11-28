package com.wetuo.blog.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wetuo.blog.dao.TagDAO;
import com.wetuo.blog.model.Tag;
@Component("tagDAOImpl")
public class TagDAOImpl extends BaseDAOSupport<Tag> implements TagDAO {
	@SuppressWarnings("unchecked")
	@Transactional
	public Long existsByName(String name) {
		List<Tag> list  = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Tag.class).add(Restrictions.eq("name", name)));
		if(list.size()>0){
			return list.get(0).getTagId();
		}else{
			return null;
		}
	}
	@Transactional
	public Long addTag(Tag t) {
		getHibernateTemplate().save(t);
		return t.getTagId();
	}

}
