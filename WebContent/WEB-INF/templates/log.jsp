<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="content" class="single">
	<div class="sitemap cbx">
		<a href="" title="返回主页">首页</a>&nbsp;&raquo;&nbsp;<s:property value="blog.postTitle"/></div>
	<div class="cbx post">
		<h2><s:property value="blog.postTitle"/></h2>
		<div class="postmeta">
			<ul>
				<li class="meta-date"><fmt:formatDate value="${blog.postDate}" pattern="yyyy-MM-dd HH:mm"/></li>
				<li class="meta-cat">分类：<a href="home?sid=<s:property value="blog.sort.sortId"/>"><s:property value="blog.sort.name"/></a></li>
				<li class="meta-views">围观  <s:property value="blog.viewConut"/>  次</li>
				<li class="meta-comments"><a href="javascript:void(0)" title="<s:property value="blog.postTitle"/>上的评论">拍砖   <s:property value="blog.commentCount"/>  次</a></li>
				<li class="meta-tags">
					标签:
					<s:iterator value="blog.tagRelationShipses" var = "trs">
						<a href="home?tid=<s:property value="#trs.tag.tagId"/>"><s:property value="#trs.tag.name"/></a>  
					</s:iterator>
				</li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="post-content">
			<div class="post-content-text">
				<s:property value="blog.postContent" escape="false"/>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div id="prext" class="cbx">
		<span class="prev">
		<s:if test="prevBlog!=null">
			<a href="log_<s:property value="prevBlog.blogId"/>.html"><s:property value="prevBlog.postTitle"/></a>
		</s:if>
		</span>
		<span class="next">
		<s:if test="nextBlog!=null">
			<a href="log_<s:property value="nextBlog.blogId"/>.html"><s:property value="nextBlog.postTitle"/></a>
		</s:if>
		</span>
	</div>
</div>