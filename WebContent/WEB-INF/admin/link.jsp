<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="header.jsp"%>
<% int num = 1; %>
<div class=containertitle><b>链接管理</b>
	<s:if test="%{msg.length()>0}">
	<span class="actived">${msg}</span>
	</s:if>
	<s:if test="%{err.length()>0}">
	<span class="error">${err}</span>
	</s:if>
</div>
<div class=line></div>
  <table width="100%" id="adm_link_list" class="item_list">
    <thead>
      <tr>
	  	<th width="50"><b>序号</b></th>
        <th width="230"><b>链接</b></th>
		<th width="30" class="tdcenter"><b>查看</b></th>
		<th width="550"><b>描述</b></th>
        <th width="100"></th>
      </tr>
    </thead>
    <tbody>
	  <s:iterator value="linkList" var = "link">
      <tr>
		<td><%=num %></td>
		<td><a href="javascript:void(0)" title="修改链接"><s:property value="#link.linkName"/></a></td>
		<td class="tdcenter">
	  	<a href="<s:property value="#link.linkUrl"/>" target="_blank" title="查看链接">
	  	<img src="admin/images/vlog.gif" align="absbottom" border="0" /></a>
	  	</td>
        <td><s:property value="#link.description"/></td>
        <td><a href="javascript: del(<s:property value="#link.linkId"/>, 'link');">删除</a></td>
      </tr>
      <% num++; %>
	  </s:iterator>
	    </tbody>
  </table>

<form action="admin/link!add" method="post"  id="link">
<div style="margin:30px 0px 10px 0px;"><a href="javascript:displayToggle('link_new');">添加链接+</a></div>
<div id="link_new" style="display: none;">
<ul>
	<li>名称</li>
	<li><input maxlength="200" style="width:228px;" name="linkName" /></li>
	<li>地址</li>
	<li><input maxlength="200" style="width:228px;" name="linkUrl" /></li>
	<li>描述</li>
	<li><textarea name="description" type="text" style="width:230px;height:60px;overflow:auto;"></textarea></li>
	<li><input type="submit" name="" value="添加链接"  /></li>
</ul>
</div>
</form>
<script> 
$(document).ready(function(){
	$("#adm_link_list tbody tr:odd").addClass("tralt_b");
	$("#adm_link_list tbody tr")
		.mouseover(function(){$(this).addClass("trover")})
		.mouseout(function(){$(this).removeClass("trover")})
});
setTimeout(hideActived,2600);
$("#menu_link").addClass('sidebarsubmenu1');
</script>

<%@ include file="footer.jsp"%>