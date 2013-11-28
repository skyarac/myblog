<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="header.jsp"%>
<div class=containertitle><b>标签管理</b>
	<s:if test="%{msg.length()>0}">
	<span class="actived">${msg}</span>
	</s:if>
	<s:if test="%{err.length()>0}">
	<span class="error">${err}</span>
	</s:if>
</div>
<div class=line></div>
<div>
	<ul>
		<li id="tags">
		<s:iterator value="tagList" var="t">
		<input type="checkbox" name="tagId_<s:property value="#t.tagId"/>" value="<s:property value="#t.tagId"/>" >
		<a href="javascript:void(0)"><s:property value="#t.name"/></a> &nbsp;&nbsp;&nbsp;
		</s:iterator>
		</li>
		<li style="margin:20px 0px"><input type="button" value="删除所选标签" class="submit" onclick="delByIds('tags','tag')"/></li>
	</ul>
</div>
<script> 
setTimeout(hideActived,2600);
$("#menu_tag").addClass('sidebarsubmenu1');
</script>
<%@ include file="footer.jsp"%>