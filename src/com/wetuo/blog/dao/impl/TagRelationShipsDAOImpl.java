package com.wetuo.blog.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wetuo.blog.dao.TagRelationShipsDAO;
import com.wetuo.blog.model.TagRelationShips;
@Component("tagRelationShipsDAOImpl")
public class TagRelationShipsDAOImpl extends BaseDAOSupport<TagRelationShips>
		implements TagRelationShipsDAO {
	@Transactional
	public void delByBlogID(Long id) {
		final String queryString = "delete TagRelationShips as model where  model.id.blogId = " + id + " ";
		getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery(queryString);
                return query.executeUpdate();
            }
        });
	}
}
