package com.wetuo.blog.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.wetuo.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.blog.model.Blog;
import com.wetuo.blog.model.Link;
import com.wetuo.blog.model.Options;
import com.wetuo.blog.model.Record;
import com.wetuo.blog.model.Sort;
import com.wetuo.blog.model.Tag;
import com.wetuo.blog.service.BlogService;
import com.wetuo.blog.service.LinkService;
import com.wetuo.blog.service.OptionsService;
import com.wetuo.blog.service.SortService;
import com.wetuo.blog.service.TagService;
@Component("homeAction")
@Scope("prototype")
public class HomeAction extends ActionSupport {
	private static final long serialVersionUID = -2863166307366471918L;
	private List<Sort> sortList;
	private SortService sortService;
	private PageBean<Blog> pageBlog;
	private BlogService blogService;
	private List<Link> linkList;
	private LinkService linkService;
	private List<Tag> tagList;
	private TagService tagService;
	private List<Blog> newlogList;
	private List<Blog> randlogList;
	private List<Record> recordList;
	private Options options;
	private List<Options> optionsList;
	private OptionsService optionsService;
	private int page;
	private String pageUrl;
	
	private String rid;//按归档查询
	private String keyword;//按关键字查询
	private String sid;//按日志分类查询
	private Long tid;
	
	public String serch(){
		//this.options = optionsService.getUniqueByProperty("optionName", "widgets");//配置信息
		this.sortList = sortService.getAll();//日志分类
		this.linkList = linkService.getByProperty();//友情链接
		this.tagList = tagService.getAll();//标签
		this.newlogList = blogService.getPage("from Blog as b where b.postStatus = 'Y' order by b.postDate desc", 0, 10);//最新日志
		this.recordList = blogService.record();//日志归档
		this.pageUrl = loadLogPage();//日志查询
		return SUCCESS;
	}
	
	private String loadLogPage(){
		String parameter  = "";
		if(rid != null && rid != ""){
			this.pageBlog = blogService.loadPage("from Blog as b where b.postStatus = 'Y' and to_char(b.postDate,'yyyyMM') = '"+ this.rid +"' order by b.isTop ,b.postDate desc", 10, page);
			parameter = "&rid=" + rid;
		}else if(keyword !=null && keyword != ""){
			String word = "";
			try {
				word = URLEncoder.encode(this.keyword,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				return ERROR;
			}
			this.pageBlog = blogService.loadPage("from Blog as b where b.postStatus = 'Y' and (b.postTitle like '%"+ this.keyword +"%' or " +
					"b.postContent like '%"+ this.keyword +"%') order by b.isTop ,b.postDate desc", 10, page);
			parameter = "&keyword=" + word ;
		}else if(sid != null && sid != ""){
			this.pageBlog = blogService.loadPage("from Blog as b where b.postStatus = 'Y' and b.sort.sortId = " + Long.parseLong(sid) + " order by b.isTop ,b.postDate desc", 10, page);
			parameter = "&sid=" +sid;
		}else if(tid != null){
			this.pageBlog = blogService.loadPage("from Blog as b where b.postStatus = 'Y' and b.blogId in (select t.id.blogId from TagRelationShips as t where t.id.tagId = "+ tid +" ) order by b.isTop ,b.postDate desc", 10, page);
			parameter = "&tid=" +tid;
		}else{
			this.pageBlog = blogService.loadPage("from Blog as b where b.postStatus = 'Y' order by b.isTop ,b.postDate desc", 10, page);
		}
		
		//组装分页代码
		StringBuffer tempPageUrl = new StringBuffer();
		if(pageBlog.getTotalPage() > 10){
			if(pageBlog.getCurrentPage() > 6){
				tempPageUrl.append("<a href=\"home?page=1" + parameter + "\" title=\"首页\">&laquo;</a><em>...</em>");
				if((pageBlog.getCurrentPage()+5)< pageBlog.getTotalPage()){
					for(int i = (pageBlog.getCurrentPage()-5); i <= (pageBlog.getCurrentPage()+5) ; i++){
						if(pageBlog.getCurrentPage()==i){
							tempPageUrl.append("<span>"+ i +"</span>  ");
						}else{
							tempPageUrl.append("<a href=\"home?page=" + i + parameter + "\">"+ i +"</a>  ");
						}
					}
					tempPageUrl.append("<em>...</em><a href=home\"?page=" + pageBlog.getTotalPage()+ parameter + "\" title=\"尾页\">&raquo;</a>");
				}else{
					for(int i = (pageBlog.getCurrentPage()-5); i <= pageBlog.getTotalPage() ; i++){
						if(pageBlog.getCurrentPage()==i){
							tempPageUrl.append("<span>"+ i +"</span>  ");
						}else{
							tempPageUrl.append("<a href=\"home?page="+ i + parameter + "\">"+ i +"</a>  ");
						}
					}
				}
			}else{
				for(int i = 1;i <= 11; i++){
					if(pageBlog.getCurrentPage()==i){
						tempPageUrl.append("<span>"+ i +"</span>  ");
					}else{
						tempPageUrl.append("<a href=\"home?page="+ i + parameter +"\">"+ i +"</a>  ");
					}
					
				}
				tempPageUrl.append("<em>...</em><a href=\"home?page="+pageBlog.getTotalPage()+ parameter +"\" title=\"尾页\">&raquo;</a>");
			}
			
		}else if(pageBlog.getTotalPage()>1&&pageBlog.getTotalPage()<=10){
			for(int i=1;i<=pageBlog.getTotalPage();i++){
				if(pageBlog.getCurrentPage()==i){
					tempPageUrl.append("<span>"+ i +"</span>  ");
				}else{
					tempPageUrl.append("<a href=\"home?page="+ i + parameter +"\">"+ i +"</a>  ");
				}
				
			}
		}
		return tempPageUrl.toString();
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
	public PageBean<Blog> getPageBlog() {
		return pageBlog;
	}
	public void setPageBlog(PageBean<Blog> pageBlog) {
		this.pageBlog = pageBlog;
	}
	public BlogService getBlogService() {
		return blogService;
	}
	@Resource(name="blogService")
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
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
	public List<Blog> getRandlogList() {
		return randlogList;
	}
	public void setRandlogList(List<Blog> randlogList) {
		this.randlogList = randlogList;
	}
	public List<Record> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<Record> recordList) {
		this.recordList = recordList;
	}
	public List<Options> getOptionsList() {
		return optionsList;
	}
	public void setOptionsList(List<Options> optionsList) {
		this.optionsList = optionsList;
	}
	public OptionsService getOptionsService() {
		return optionsService;
	}
	@Resource(name="optionsService")
	public void setOptionsService(OptionsService optionsService) {
		this.optionsService = optionsService;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}
}
