<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath ;
if(request.getServerPort()==80){
	basePath = request.getScheme()+"://"+request.getServerName()+path+"/";
}else{
	basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="author" content="304113037@qq.com,ICUIT" />
<meta name="keywords" content="ICUIT,Java,Blog,Solr,Lucene,ExtJS,jquery,Linux,PostgreSQL,MySQL,WEBGIS,MapInfo，ArcGis" />
<meta name="description" content="ICUIT的个人博客 - Java技术|WEBGIS|数据库|搜索引擎|网站应用" />
<meta http-equiv="imagetoolbar" content="no"/>
<title><s:property value="blog.postTitle"/> - WeTo的个人博客 </title>
<link href="theme/default/css/main.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="syntaxhighlighter/styles/shCoreDefault.css"/>
<link type="text/css" rel="stylesheet" href="syntaxhighlighter/styles/shThemeDefault.css"/>
<script src="theme/default/script/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="theme/default/script/top.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="../templates/header.jsp"%>
<!--container 开始-->
<div id="container">
	<%@ include file="../templates/t.jsp"%>
	<!--日志列表内容开始-->
	<%@ include file="../templates/log.jsp"%>
	<!-- 日志列表内容结束 -->
	
	<!-- 侧边栏开始 -->
	<div id="sidebar">
	<%@ include file="../templates/side.jsp"%>
	</div>
	<!-- 侧边栏结束 -->
	<div class="clear"></div>
</div>
<!--container 结束-->
<div style="clear:both;"></div>

<%@ include file="../templates/footer.jsp"%>

</body>
</html>
