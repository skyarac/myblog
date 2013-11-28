<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--友情链接开始-->
<div class="cbx">
	<h3><span>链接</span></h3>
	<div class="ctx">
		<ul id="link">
			<s:iterator value="linkList" var="link">
			<li>
				<a href="<s:property value="#link.linkUrl"/>" title="<s:property value="#link.description"/>" target="_blank">
					<s:property value="#link.linkName"/></a>
			</li>
			</s:iterator>
		</ul>
	</div>
</div>
<!--友情链接开始-->