<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--日志分类开始-->
<div class="cbx">
	<h3><span>分类</span></h3>
	<div class="ctx">
		<ul id="blogsort">
			<s:iterator value="sortList" var="s">
			<li>
				<a href="home?sid=<s:property value="#s.sortId"/>" title="<s:property value="#s.name"/>">
					<s:property value="#s.name"/>(<s:property value="#s.blogCount"/>)</a>
			</li>
			</s:iterator>
		</ul>
	</div>
</div>
<!--日志分类结束-->