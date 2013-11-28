package com.wetuo.blog.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.blog.model.Sort;
import com.wetuo.blog.service.SortService;

@Component("sortAction")
@Scope("prototype")
public class SortAction extends ActionSupport {
	private static final long serialVersionUID = -4386470630050459656L;
	private Sort sort;
	private List<Sort> sortList;
	private SortService sortService;
	private String ids;
	private String msg;
	private String name;
	private Long sid;
	private String err;
	/**
	 * 后台添加日志分类
	 */
	public String add(){
		if(name==null || name.equals("")){
			this.err = "分类名称不能为空";
		}else{
			sort = new Sort();
			sort.setBlogCount(0L);
			sort.setName(name);
			sortService.addSort(sort);
			this.msg = "添加分类成功";
		}
		return "add";
	}
	/**
	 * 后台更新日志分类
	 * @throws UnsupportedEncodingException 
	 */
	public String update() throws UnsupportedEncodingException{
		if(sortService.localUpdateOneField(sid, "name", java.net.URLDecoder.decode(name.trim().toString(), "UTF-8"))){
			this.msg = "更新分类成功";
		}else{
			this.err = "更新分类失败";
		}
		return "update";
	}
	
	/**
	 * 后台获取全部日志分类
	 */
	public String loadAll(){
		sortList = sortService.getAll();
		return "loadAll";
	}
	/**
	 * 后台删除日志分类
	 */
	public String delete(){
		sortService.delete(sid);
		this.msg = "删除分类成功";
		return "delete";
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	public SortService getSortService() {
		return sortService;
	}
	@Resource(name="sortService")
	public void setSortService(SortService sortService) {
		this.sortService = sortService;
	}
	public List<Sort> getSortList() {
		return sortList;
	}
	public void setSortList(List<Sort> sortList) {
		this.sortList = sortList;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public HttpServletRequest getRequest(){  
        return ServletActionContext.getRequest();  
    }  
      
    public HttpServletResponse getResponse(){  
        return ServletActionContext.getResponse();  
    }
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}  
}
