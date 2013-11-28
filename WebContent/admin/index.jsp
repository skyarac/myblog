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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<title>登录</title>
<script type="text/javascript" src="admin/js/jquery-1.4.4.min.js"></script>
<style type="text/css">
*{margin-left:auto; margin-right:auto; font-size: 12px;}
</style>
<script type="text/javascript">
$(function() {
	$("#yzm").bind("click", function() {
		var timenow = new Date().getTime();
		$("#yzm").attr("src","code/ValidateImage?d=" + timenow);
	});
	$("#ayzm").bind("click", function() {
		var timenow = new Date().getTime();
		$("#yzm").attr("src","code/ValidateImage?d=" + timenow);
	});
	$(':input:visible:enabled:first').focus();
});
</script>
</head>
<body>
<form action="admin/home.html" method="post">
<table>
	<tr>
		<td align="right">用户名/邮箱:</td>
		<td align="left"><input type="text" name="username"/><span style="color: red;">${msg}</span></td>
	</tr>
	<tr>
		<td align="right">密码:</td>
		<td align="left"><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td align="right">验证码：</td>
		<td align="left"><input type="text" style="width:90px;" name="yzm"/><img id="yzm" src="code/ValidateImage"  style="vertical-align:middle; cursor: pointer;"   title="看不清?换一张" alt="看不清?，换一张"/><a href="javascript:void(0);" id="ayzm" title="看不清?换一张">看不清?换一张</a></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="登录" /></td>
	</tr>
</table>
		
	</form>
</body>
</html>
