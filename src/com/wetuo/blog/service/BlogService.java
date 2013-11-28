package com.wetuo.blog.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wetuo.util.PageBean;

import com.wetuo.blog.dao.BlogDAO;
import com.wetuo.blog.dao.SortDAO;
import com.wetuo.blog.dao.TagDAO;
import com.wetuo.blog.dao.TagRelationShipsDAO;
import com.wetuo.blog.model.Blog;
import com.wetuo.blog.model.Record;
import com.wetuo.blog.model.Sort;
import com.wetuo.blog.model.Tag;
import com.wetuo.blog.model.TagRelationShips;
import com.wetuo.blog.model.TagRelationShipsId;

@Component("blogService")
public class BlogService {
	private BlogDAO blogDAO;
	private SortDAO sortDAO;
	private TagDAO tagDAO;
	private TagRelationShipsDAO tagRelationShipsDAO;
	public BlogDAO getBlogDAO() {
		return blogDAO;
	}
	@Resource(name="blogDAOImpl")
	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
	public SortDAO getSortDAO() {
		return sortDAO;
	}
	@Resource(name="sortDAOImpl")
	public void setSortDAO(SortDAO sortDAO) {
		this.sortDAO = sortDAO;
	}
	
	public TagDAO getTagDAO() {
		return tagDAO;
	}
	@Resource(name="tagDAOImpl")
	public void setTagDAO(TagDAO tagDAO) {
		this.tagDAO = tagDAO;
	}
	
	public TagRelationShipsDAO getTagRelationShipsDAO() {
		return tagRelationShipsDAO;
	}
	@Resource(name="tagRelationShipsDAOImpl")
	public void setTagRelationShipsDAO(TagRelationShipsDAO tagRelationShipsDAO) {
		this.tagRelationShipsDAO = tagRelationShipsDAO;
	}
	/**
	 * 日志归档 
	 */
	@Transactional
	public List<Record> record(){
		List<Blog> logList = blogDAO.getByProperty("postStatus", "Y", "postDate", false);
		SimpleDateFormat  sf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat  sf1 = new SimpleDateFormat("yyyy年MM月");
		List<Record> recordList = new ArrayList<Record>();
		for (Blog blog : logList) {
			boolean boo = true;
			for(int i =0;i<recordList.size();i++){
				if(recordList.get(i).getDate().equals(sf.format(blog.getPostDate()))){
					Record r = recordList.get(i);
					r.setConut(r.getConut()+1);
					recordList.set(i, r);
					boo = false;
					break;
				}
			}
			if(boo){
				Record  record = new Record();
				record.setDate(sf.format(blog.getPostDate()));
				record.setFormatDate(sf1.format(blog.getPostDate()));
				record.setConut(1);
				recordList.add(record);
			}
		}
		return recordList;
	}
	/**
	 * 前台获取日志
	 * @param id
	 * @return
	 */
	@Transactional
	public Blog loadOneBlogForHome(Long id){
		Blog b = blogDAO.loadOneBlogForHome(id);
		//增加阅读次数
		if(b!=null){
			b.setViewConut(b.getViewConut()+1L);
			blogDAO.merge(b);
		}
		return b; 
	}
	/**
	 * 前台获取下一篇日志
	 * @param date
	 * @return
	 */
	@Transactional
	public Blog nextBlog(Date date){
		return blogDAO.nextBlog(date);
	}
	/**
	 * 前台获取上一篇日志
	 * @param date
	 * @return
	 */
	@Transactional
	public Blog prevBlog(Date date){
		return blogDAO.prevBlog(date);
	}
	/**
	 * 后台获取日志
	 * @param id
	 * @return
	 */
	@Transactional
	public Blog loadOneBlogForAdmin(Long id){
		return blogDAO.get(id);
	}
	/**
	 * 后台发表日志
	 * @param blog
	 * @param tagNames
	 */
	@Transactional
	public void addBlog(Blog blog,String tagNames){
		Long bid  = blogDAO.addBlog(blog);
		//增加文章数量
		Sort sort = sortDAO.get(blog.getSort().getSortId());
		sort.setBlogCount(sort.getBlogCount()+1L);
		sortDAO.merge(sort);
		//增加日志标签
		if(tagNames.length()>0){
			tagNames = tagNames.replaceAll(" ", "");//去除空格
			tagNames = tagNames.replaceAll("，", ",");//全角逗号转半角逗号
			String[] ary = tagNames.split("[,]");//按逗号分割字符串
			for(String str: ary){
				if(str.length()>0){
					Long id = tagDAO.existsByName(str);
					Tag tag  = new Tag();
					TagRelationShips tagRelationShips = new TagRelationShips();
					TagRelationShipsId trsid = new TagRelationShipsId();
					trsid.setBlogId(bid);
					if(id==null){
						tag.setName(str);
						Long tid = tagDAO.addTag(tag);
						trsid.setTagId(tid);
					}else{
						trsid.setTagId(id);
					}
					tagRelationShips.setId(trsid);
					tagRelationShipsDAO.merge(tagRelationShips);
				}
			}
		}
	}
	/**
	 * 后台更新日志
	 * @param blog
	 * @param tagNames
	 */
	@Transactional
	public void updateBlog(Blog blog , String tagNames){
		blogDAO.merge(blog);
		if(tagNames.length()>0){
			tagNames = tagNames.replaceAll(" ", "");//去除空格
			tagNames = tagNames.replaceAll("，", ",");//全角逗号转半角逗号
			String[] ary = tagNames.split("[,]");//按逗号分割字符串
			tagRelationShipsDAO.delByBlogID(blog.getBlogId());
			for(String str: ary){
				if(str.length()>0){
					Long id = tagDAO.existsByName(str);
					Tag tag  = new Tag();
					TagRelationShips tagRelationShips = new TagRelationShips();
					TagRelationShipsId trsid = new TagRelationShipsId();
					trsid.setBlogId(blog.getBlogId());
					if(id==null){
						tag.setName(str);
						tag = tagDAO.add(tag);
						trsid.setTagId(tag.getTagId());
					}else{
						trsid.setTagId(id);
					}
					tagRelationShips.setId(trsid);
					tagRelationShipsDAO.merge(tagRelationShips);
				}
			}
		}
	}
	/**
	 * 后台删除日志
	 * @param id
	 */
	@Transactional
	public void deleteByID(String ids){
		Object [] o = ids.split(",");
		blogDAO.bulkDelete(o);
	}
	/**
	 * 更新日志状态
	 * @param blogId
	 * @param srotId
	 * @param postStatus N--草稿，Y--发布
	 */
	@Transactional
	public void hideSwitch(Long blogId ,Long srotId, String postStatus){
		blogDAO.localUpdateOneField(blogId, "postStatus", postStatus);
		if(postStatus.equals("N")){
			Sort sort = sortDAO.get(srotId);
			sort.setBlogCount(sort.getBlogCount()-1L);
			sortDAO.merge(sort);
		}else{
			Sort sort = sortDAO.get(srotId);
			sort.setBlogCount(sort.getBlogCount()+1L);
			sortDAO.merge(sort);
		}
	}
	@Transactional
	public PageBean<Blog> loadPage(String hql, int pageSize, int page){
		return blogDAO.pageQuery(hql, pageSize, page);
	}
	@Transactional
	public List<Blog> getPage( String hql,  int offset,  int length) {
		return blogDAO.getPage(hql, offset, length);
	}
}
