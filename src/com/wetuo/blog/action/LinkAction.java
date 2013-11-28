package com.wetuo.blog.action;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.blog.model.Link;
import com.wetuo.blog.service.LinkService;
@Component("linkAction")
@Scope("prototype")
public class LinkAction extends ActionSupport {
	private static final long serialVersionUID = 7416382163731938681L;
	private String ids;
	private List<Link> linkList;
	private LinkService linkService;
	private Link link;
	private String msg;
	private String err;
	private String linkName;
	private String linkUrl;
	private String description;
	private Long lid;
	/**
	 * 后台添加友情链接
	 */
	public String add(){
		if(linkName==null || linkUrl==null || linkName.equals("")||linkUrl.equals("")){
			this.err = "站点名称和地址不能为空";
		}else{
			link = new Link();
			link.setLinkName(linkName);
			link.setLinkUrl(linkUrl);
			if(description != null && !description.equals("")){
				link.setDescription(description);
			}
			this.msg = "添加链接成功";
			link.setLinkStatus("Y");
			linkService.addLink(link);
		}
		return "add";
	}
	/**
	 * 后台删除友情链接 
	 */
	public String delete(){
		linkService.delete(lid);
		this.msg = "删除链接成功";
		return "delete";
	}
	
	/**
	 * 后台获取全部友情链接 
	 */
	public String loadAllForAdmin(){
		this.linkList = linkService.getAll();
		return "loadAllForAdmin";
	}
	/**
	 * 前台获取全部友情链接
	 */
	public String loadAllForHome(){
		this.linkList = linkService.getByProperty();
		return "loadAllForHome";
	}
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
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
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getLid() {
		return lid;
	}
	public void setLid(Long lid) {
		this.lid = lid;
	}

}
