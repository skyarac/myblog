<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="header.jsp"%>
<script type="text/javascript" src="xheditor-1.1.13/xheditor-1.1.13-zh-cn.min.js"></script>
<script type="text/javascript" src="xheditor-1.1.13/config.js"></script>
<style type="text/css">  
.btnCode {background:transparent url(syntaxhighlighter/styles/code.gif) no-repeat;}
</style>
<script type="text/javascript"> 
$(pageInit);
</script>
<div class=containertitle><b>写日志</b><span id="msg_2"></span></div>
<div id="msg"></div>
  <form action="admin/blog!addBlog?method=add" method="post" id="addlog" name="addlog">
    <table cellspacing="1" cellpadding="4" width="720" border="0">
      <tbody>
        <tr nowrap="nowrap">
          <td>
          <label for="title" id="title_label">输入日志标题</label>
          <input type="text" maxlength="200" style="width:710px;" name="blog.postTitle" id="title"/>
          </td>
        </tr>
        <tr>
          <td>
		  <textarea id="content" name="blog.postContent" cols="100" rows="8" style="width:719px; height:460px;"></textarea>
          </td>
        </tr>
        <tr nowrap="nowrap">
          <td>
		  <div style="margin:10px 0px 5px 0px;">
		  <label for="tag" id="tag_label">日志标签，逗号或空格分隔</label>
          <input name="tagNames" id="tag" maxlength="200" style="width:432px;" />
		  <s:select list="sortList" headerKey="" headerValue="选择分类..." listKey="sortId" listValue="name" 
		  	id="sort" cssStyle="width:130px;" name="blog.sort.sortId" theme="simple"></s:select>
		  </div>
		  <s:if test="%{tagList.size>0}">
		  <div style="color:#2A9DDB;cursor:pointer;"><a href="javascript:displayToggle('tagbox');">选择已有标签+</a></div>
		  </s:if>
          <div id="tagbox" style="width:688px;margin:0px 0px 0px 30px;display:none;">
          	<s:iterator value="tagList" var="t">
          		 <a href="javascript: insertTag('<s:property value="#t.name"/>','tag');"><s:property value="#t.name"/></a> 
          	</s:iterator>
          </div>
          </td>
        </tr>
	</tbody>
	</table>
	<table cellspacing="1" cellpadding="4" width="720" border="0" id="advset">
        <tr>
          <td>
          <span id="post_options">
          <input type="checkbox" value="Y" name="isTop" id="top" />
          <label for="top">日志置顶</label>
          <input type="checkbox" value="Y" name="commentStatus" id="allow_remark" checked="checked" />
          <label for="allow_remark">允许评论</label>
          </span>
          <input type="hidden" name="blog.commentCount" value="0"/>
          <input type="hidden" name="blog.viewConut" value="0"/>
          <input type="hidden" name="blog.postStatus" value="Y" />
		  </td>
        </tr>
	</table>
	<table cellspacing="1" cellpadding="4" width="720" border="0">
		<tr>
          <td align="center">
          <input type="submit" value="发布日志" onclick="return checkform();" class="button" />
          <input type="button" id="savedf" value="保存草稿" onclick="autosave(2);" class="button" />
		  </td>
        </tr>
    </table>
  </form>
<div class=line></div>
<script>
$("#menu_wt").addClass('sidebarsubmenu1');
$("#title").focus(function(){$("#title_label").hide();});
$("#title").blur(function(){if($("#title").val() == '') {$("#title_label").show();}});
$("#tag").focus(function(){$("#tag_label").hide();});
$("#tag").blur(function(){if($("#tag").val() == '') {$("#tag_label").show();}});
</script>

<%@ include file="footer.jsp"%>