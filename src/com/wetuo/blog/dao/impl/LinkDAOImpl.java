package com.wetuo.blog.dao.impl;

import org.springframework.stereotype.Component;

import com.wetuo.blog.dao.LinkDAO;
import com.wetuo.blog.model.Link;
@Component("linkDAOImpl")
public class LinkDAOImpl extends BaseDAOSupport<Link> implements LinkDAO {

}
