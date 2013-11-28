package com.wetuo.blog.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.wetuo.util.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.blog.model.Tag;
import com.wetuo.blog.service.TagService;
@Component("tagAction")
@Scope("prototype")
public class TagAction extends ActionSupport {
	private static final long serialVersionUID = 5997471052087803586L;
	private List<Tag> tagList;
	private String ids;
	private TagService tagService;
	private String msg;
	private String err;
	/**
	 * 后台获取全部标签
	 */
	public String loadAll(){
		this.tagList = tagService.getAll();
		return "loadAll";
	}
	/**
	 * 后台删除标签 
	 */
	public String delTags(){
		if(ids==null||ids.equals("")){
			this.err = "请选择要删除的标签";
		}else{
			tagService.deleteByIds(StringUtils.getDefaultInstance().castLong(ids.split(",")));
			this.msg = "删除标签成功";
		}
		return "delTags";
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public TagService getTagService() {
		return tagService;
	}
	@Resource(name="tagService")
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
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
}
