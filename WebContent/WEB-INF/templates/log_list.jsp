<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="content">
	<s:iterator value="pageBlog.list" var="b">
	<div class="cbx post">
		<h2><a href="log_<s:property value="#b.blogId"/>.html" rel="bookmark"><s:property value="#b.postTitle"/></a></h2>
		<a href="log_<s:property value="#b.blogId"/>.html" class="readmore readmorea">Continue	Read.. </a>
		<div class="postmeta">
			<ul>
				<li class="meta-date"><fmt:formatDate value="${b.postDate}" pattern="yyyy-MM-dd HH:mm"/></li>
				<li class="meta-cat">分类：<a href="home?sid=<s:property value="#b.sort.sortId"/>"><s:property value="#b.sort.name"/></a></li>
				<li class="meta-views">围观    <s:property value="#b.viewConut"/> 次</li>
				<li class="meta-comments">
					<a href="log_<s:property value="#b.blogId"/>.html" title="<s:property value="#b.postTitle"/> 上的评论">拍砖  <s:property value="#b.commentCount"/> 次</a>
				</li>
				<li class="meta-tags">
					标签:
					<s:iterator value="#b.tagRelationShipses" var = "trs">
						<a href="home?tid=<s:property value="#trs.tag.tagId"/>"><s:property value="#trs.tag.name"/></a>  
					</s:iterator>
				</li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="post-content">
			<s:property value="getSubContent(350)" escape="false"/>
		</div>
	</div>
	</s:iterator>
	<!--分页-->
	<div class="pagenavi pnb">
		<s:property value="pageUrl" escape="false"/>
	</div>
</div>