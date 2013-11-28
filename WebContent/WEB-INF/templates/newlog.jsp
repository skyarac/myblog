<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--最新日志开始-->
<div class="cbx">
	<h3><span>最新日志</span></h3>
	<div class="ctx">
		<ul id="newlog">
			<s:iterator value="newlogList" var="log">
			<li>
				<a href="log_<s:property value="#log.blogId"/>.html" title="<s:property value="#log.postTitle"/>">
					<s:property value="#log.postTitle"/></a>
			</li>
			</s:iterator>
		</ul>
	</div>
</div>
<!--最新日志结束-->