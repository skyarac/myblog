package com.wetuo.blog.dao.impl;

import org.springframework.stereotype.Component;

import com.wetuo.blog.dao.OptionsDAO;
import com.wetuo.blog.model.Options;
@Component("optionsDAOImpl")
public class OptionsDAOImpl extends BaseDAOSupport<Options> implements
		OptionsDAO {

}
