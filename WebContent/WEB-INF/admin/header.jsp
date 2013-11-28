<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath ;
if(request.getServerPort()==80){
	basePath = request.getScheme()+"://"+request.getServerName()+path+"/";
}else{
	basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<base href="<%=basePath%>">
<link href="admin/style/default/style.css" type="text/css" rel="stylesheet">
<link href="admin/css/css-main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="admin/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="admin/js/common.js"></script>
<title>wetuo - 管理中心</title>
</head>
<body>
<div class="center">
<table id="header" cellspacing="0" cellpadding="0" width="988" border="0">
  <tbody>
  <tr>
    <td width="9" id="headerleft"></td>
    <td width="125"  class="logo" align="left"><a href="admin/home.html" title="返回管理首页">wetuo</a></td>
    <td class="vesion" width="20">1.2.1</td>
    <td  class="home" align="left"><a href="<%=basePath%>" target="_blank" title="在新窗口浏站点">边走边乔的个人博客</a></td>
    <td align="right" nowrap class="headtext">
		你好，<a href="javascript:void(0)">${session.loginUser.username} <img src="admin/images/avatar.jpg" align="top" height="20" width="20" style="border:1px #FFFFFF solid;" /></a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="logout.html">退出</a>
	</td>
    <td width="9" id="headerright" ></td>
	</tbody>
</table>
<table cellspacing=0 cellpadding=0 width="100%" border=0>
<tbody >
  <tr>
    <td valign=top align=left width="114">
		<div id=sidebartop></div>
		<table cellspacing=0 cellpadding=0 width="100%" border=0>
			<tbody>
			<tr>
			  <td valign=top align=left width="114">
				<div id=sidebar>
					<div class="sidebarmenu" onclick="displayToggle('log_mg');">日志管理</div>
					<div id="log_mg">
						<div class="sidebarsubmenu" id="menu_wt"><a href="admin/add_log.html">写日志</a></div>
						<div class="sidebarsubmenu" id="menu_draft"><a href="javascript:void(0)">草稿<span id="dfnum">(0)</span></a></div>
						<div class="sidebarsubmenu" id="menu_log"><a href="javascript:void(0)">日志</a></div>
						<div class="sidebarsubmenu" id="menu_tag"><a href="admin/tag!loadAll">标签</a></div>
						<div class="sidebarsubmenu" id="menu_sort"><a href="admin/sort!loadAll">分类</a></div>
						<div class="sidebarsubmenu" id="menu_cm"><a href="javascript:void(0)">评论</a> </div>
						<div class="coment_number"><a href="javascript:void(0)" title="1条待审">1</a></div>
					</div>
				</div>
			  </td>
			</tr>
			</tbody>
		</table>
		<table cellspacing=0 cellpadding=0 width="100%" border=0 >
			<tbody>
			<tr>
			  <td valign=top align=left width=114>
				<div id=sidebar>
					<div class="sidebarmenu" onclick="displayToggle('blog_mg');">站点管理</div>
					<div id="blog_mg">
						<div class="sidebarsubmenu" id="menu_widget"><a href="javascript:void(0)" >Widgets</a></div>
						<div class="sidebarsubmenu" id="menu_page"><a href="javascript:void(0)" >页面</a></div>
						<div class="sidebarsubmenu" id="menu_link"><a href="admin/link!loadAllForAdmin">链接</a></div>
					</div>
				</div>
			  </td>
			</tr>
			</tbody>
		</table>
		<table cellspacing=0 cellpadding=0 width="100%" border=0>
		  <tbody>
			<tr>
			  <td valign=top align=left width=114>
				<div id=sidebar>
					<div class="sidebarmenu" onclick="displayToggle('extend_mg');">功能扩展</div>
					<div id="extend_mg">
						<div class="sidebarsubmenu" id="menu_plug"><a href="javascript:void(0)"><img src="admin/images/plugin.gif" align="absbottom" border="0"> 插件</a></div>
					</div>
				</div>
			  </td>
			 </tr>
		  </tbody>
		</table>
		<div id="sidebarBottom"></div>
	</td>
	<td id=container valign=top align=left>