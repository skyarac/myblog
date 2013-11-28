<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="header.jsp"%>
<% int num = 1; %>
<script>setTimeout(hideActived,2600);</script>
<div class=containertitle>
	<b>分类管理</b>
	<s:if test="%{msg.length()>0}">
	<span class="actived">${msg}</span>
	</s:if>
	<s:if test="%{err.length()>0}">
	<span class="error">${err}</span>
	</s:if>
</div>
<div class=line></div>
  <table width="100%" id="adm_sort_list" class="item_list">
    <thead>
      <tr>
        <th width="55"><b>序号</b></th>
        <th width="300"><b>名称</b></th>
        <th width="50" class="tdcenter"><b>日志</b></th>
        <th width="100"></th>
      </tr>
    </thead>
    <tbody>
    <s:iterator value="sortList" var = "s">
      <tr>
        <td><input type="hidden" value="<s:property value="#s.sortId"/>" class="sort_id" /><%=num %></td>
		<td class="sortname"><s:property value="#s.name"/></td>
		<td class="tdcenter"><a href="javascript:void(0)"><s:property value="#s.blogCount"/></a></td>
        <td><a href="javascript: del(<s:property value="#s.sortId"/>, 'sort');">删除</a></td>
      </tr>
      <% num++; %>
     </s:iterator>
     <s:if test="%{!sortList.size>0}">
     	<tr><td class="tdcenter" colspan="4">还没有添加分类</td></tr>
     </s:if>
</tbody>
</table>

<form action="admin/sort!add" method="post">
<div style="margin:30px 0px 10px 0px;"><a href="javascript:displayToggle('sort_new');">添加新分类+</a></div>
<div id="sort_new" style="display: none;">
	<ul>
		<li><input maxlength="200" style="width:200px;" name="name" id="sortname" /> 名称</li>
		<li><input type="submit" id="addsort" value="添加新分类" class="submit"/><span id="alias_msg_hook"></span></li>
	</ul>
</div>
</form>
<script>
$(document).ready(function(){
	$("#menu_sort").addClass('sidebarsubmenu1');
	$("#adm_sort_list tbody tr:odd").addClass("tralt_b");
	$("#adm_sort_list tbody tr")
		.mouseover(function(){$(this).addClass("trover")})
		.mouseout(function(){$(this).removeClass("trover")});
	$(".sortname").click(function a(){
		if($(this).find(".sort_input").attr("type") == "text"){return false;}
		var name = $.trim($(this).html());
		var m = $.trim($(this).text());
		$(this).html("<input type=text  maxlength=200 value=\""+name+"\" class=sort_input>");
		$(this).find(".sort_input").focus();
		$(this).find(".sort_input").bind("blur", function(){
			var n = $.trim($(this).val());
			if(n != m && n != ""){
				window.location = "admin/sort!update?sid="+$(this).parent().parent().find(".sort_id").val()+"&name="+encodeURI(encodeURI(n));
			}else{
				$(this).parent().html(name);
			}
		});
	});
});
</script>
<%@ include file="footer.jsp"%>