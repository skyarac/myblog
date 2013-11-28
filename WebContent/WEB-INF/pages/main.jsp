<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath ;
String serverName=request.getServerName();
if(request.getServerPort()==80){
	basePath = request.getScheme()+"://"+serverName+path+"/";
	if(!(serverName.substring(0,3).equals("www")||serverName.equals("localhost"))){
		String addres="http://www."+serverName+path+"/";
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);   
		response.setHeader("Location",addres);
	}
}else{
	basePath = request.getScheme()+"://"+serverName+":"+request.getServerPort()+path+"/";
	if(!(serverName.substring(0,3).equals("www")||serverName.equals("localhost"))){
		String addres="http://www."+serverName+":"+ request.getServerPort()+path+"/";
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);   
		response.setHeader("Location",addres);
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="baidu-site-verification" content="uNIJcfTQxxYruqRe" />
<meta name="author" content="304113037@qq.com,ICUIT" />
<meta name="keywords" content="ICUIT,Java,Blog,Solr,Lucene,ExtJS,jquery,Linux,PostgreSQL,MySQL,WEBGIS,MapInfo，ArcGis" />
<meta name="description" content="ICUIT的个人博客 - Java技术|WEBGIS|数据库|搜索引擎|网站应用" />
<meta http-equiv="imagetoolbar" content="no"/>
<title>WeTuo的个人博客 - Java技术|WEBGIS|数据库|搜索引擎|网站应用</title>
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
	<%@ include file="../templates/log_list.jsp"%>
	<!-- 日志列表内容结束 -->
	
	<!-- 侧边栏开始 -->
	<%@ include file="../templates/side.jsp"%>
	<!-- 侧边栏结束 -->
	<div class="clear"></div>
</div>
<!--container 结束-->
<div style="clear:both;"></div>

<%@ include file="../templates/footer.jsp"%>
</body>
</html>
