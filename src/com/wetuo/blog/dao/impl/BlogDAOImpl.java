package com.wetuo.blog.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wetuo.blog.dao.BlogDAO;
import com.wetuo.blog.model.Blog;
@Component("blogDAOImpl")
public class BlogDAOImpl extends BaseDAOSupport<Blog> implements BlogDAO {
	@SuppressWarnings("unchecked")
	@Transactional
	public Blog nextBlog(Date date) {
		final String hql = "from Blog b where b.postDate < '" + date + "' and b.postStatus = 'Y' order by b.postDate desc";
		List<Blog> list = (List<Blog>)getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException,SQLException{
				List<Blog> result = (List<Blog>)session
									.createQuery(hql)
									.setFirstResult(0)
									.setMaxResults(1)
									.list();
				return result;
			}
		});
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Blog prevBlog(Date date) {
		final String hql = "from Blog b where b.postDate > '" + date + "' and b.postStatus = 'Y' order by b.postDate asc";
		List<Blog> list = (List<Blog>)getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException,SQLException{
				List<Blog> result = (List<Blog>)session
									.createQuery(hql)
									.setFirstResult(0)
									.setMaxResults(1)
									.list();
				return result;
			}
		});
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Blog loadOneBlogForHome(Long id){
		List<Blog> list = (List<Blog>)getHibernateTemplate().find("from Blog b where b.blogId = " + id + " and  b.postStatus = 'Y'");
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Transactional
	public Long addBlog(Blog b) {
		getHibernateTemplate().save(b);
		return b.getBlogId();
	}
}
