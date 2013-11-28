package com.wetuo.blog.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.wetuo.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.blog.model.Blog;
import com.wetuo.blog.model.Link;
import com.wetuo.blog.model.Record;
import com.wetuo.blog.model.Sort;
import com.wetuo.blog.model.Tag;
import com.wetuo.blog.model.User;
import com.wetuo.blog.service.BlogService;
import com.wetuo.blog.service.LinkService;
import com.wetuo.blog.service.SortService;
import com.wetuo.blog.service.TagService;
@Component("blogAction")
@Scope("prototype")
public class BlogAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -6284573737394643350L;
	private Map<String , Object> session;
	private Blog blog;
	private BlogService blogService;
	private PageBean<Blog> pageBlog;
	private String ids;
	private Long id;
	private String method;
	private String tagNames;
	private Blog nextBlog;
	private Blog prevBlog;
	private List<Sort> sortList;
	private SortService sortService;
	private List<Link> linkList;
	private LinkService linkService;
	private List<Tag> tagList;
	private TagService tagService;
	private List<Blog> newlogList;
	private List<Record> recordList;
	private String isTop;
	private String  commentStatus;
	
	/**
	 * 前台获取日志
	 * @return
	 */
	public String load(){
		this.blog = blogService.loadOneBlogForHome(id);
		this.prevBlog = blogService.prevBlog(this.blog.getPostDate());
		this.nextBlog = blogService.nextBlog(this.blog.getPostDate());
		
		this.sortList = sortService.getAll();//日志分类
		this.linkList = linkService.getByProperty();//友情链接
		this.tagList = tagService.getAll();//标签
		this.newlogList = blogService.getPage("from Blog as b where b.postStatus = 'Y' order by b.postDate desc", 0, 10);//最新日志
		this.recordList = blogService.record();//日志归档
		
		return "load";
	}
	/**
	 * 初始添加日志页面
	 */
	public String preAdd(){
		this.sortList = sortService.getAll();//日志分类
		this.tagList = tagService.getAll();
		return "preAdd";
	}
	/**
	 * 后台添加、更新日志
	 */
	public String addBlog(){
		if(this.isTop!=null&&this.isTop.equals("Y")){
			blog.setIsTop("0");
		}else{
			blog.setIsTop("1");
		}
		if(this.commentStatus!=null&&this.commentStatus.equals("Y")){
			blog.setCommentStatus("Y");
		}else{
			blog.setCommentStatus("N");
		}
		if(method!=null&&method.equals("edit")){
			blogService.updateBlog(blog, tagNames);
		}else{
			User u = (User) session.get("loginUser");
			blog.setUser(u);
			blog.setPostDate(new Date());
			blogService.addBlog(blog, tagNames);
		}
		return "addBlog";
	}
	/**
	 * 后台删除日志
	 */
	public String delete(){
		blogService.deleteByID(ids);
		return "delete";
	}
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public BlogService getBlogService() {
		return blogService;
	}
	@Resource(name="blogService")
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	public PageBean<Blog> getPageBlog() {
		return pageBlog;
	}
	public void setPageBlog(PageBean<Blog> pageBlog) {
		this.pageBlog = pageBlog;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getTagNames() {
		return tagNames;
	}
	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}
	public Blog getNextBlog() {
		return nextBlog;
	}
	public void setNextBlog(Blog nextBlog) {
		this.nextBlog = nextBlog;
	}
	public Blog getPrevBlog() {
		return prevBlog;
	}
	public void setPrevBlog(Blog prevBlog) {
		this.prevBlog = prevBlog;
	}
	public List<Sort> getSortList() {
		return sortList;
	}
	public void setSortList(List<Sort> sortList) {
		this.sortList = sortList;
	}
	public SortService getSortService() {
		return sortService;
	}
	@Resource(name="sortService")
	public void setSortService(SortService sortService) {
		this.sortService = sortService;
	}
	public List<Link> getLinkList() {
		return linkList;
	}
	public void setLinkList(List<Link> linkList) {
		this.linkList = linkList;
	}
	public LinkService getLinkService() {
		return linkService;
	}
	@Resource(name="linkService")
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public TagService getTagService() {
		return tagService;
	}
	@Resource(name="tagService")
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	public List<Blog> getNewlogList() {
		return newlogList;
	}
	public void setNewlogList(List<Blog> newlogList) {
		this.newlogList = newlogList;
	}
	public List<Record> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<Record> recordList) {
		this.recordList = recordList;
	}
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
