<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="header.jsp"%>
<div id="admindex">
<div id="admindex_main">
    <div id="tw">
        <div class="main_img"><a href="javascript:void(0)"><img src="admin/images/avatar.jpg" height="52" width="52" /></a></div>
        <div class="right">
        <div class="msg2"><a href="javascript:void(0)">admin</a></div>
        <div class="box_1"><textarea class="box2" name="t">功能开发中 ……</textarea></div>
        <div class="tbutton" style="display:none;"><input type="submit" value="发布" onclick="return checkt();"/> <a href="javascript:closet();">取消</a> <span>(你还可以输入140字)</span></div>
        </div>
		<div class="clear"></div>
    </div>
</div>
<div class="clear"></div>
<div id="admindex_servinfo">
<h3>站点信息</h3>
<ul>
	<li>有<b>0</b>篇日志，<b>0</b>条评论</li>
	<li>JDK版本：JDK <%=System.getProperty("java.version") %></li>
	<li>服务器环境：<%= application.getServerInfo() %></li>
	<li><a href="Javascript:void(0)">更多信息&raquo;</a></li>
</ul>
<p id="m"><a title="用手机访问你的站点">功能开发中...</a></p>
</div>
<div id="admindex_msg">
<h3>官方消息</h3>
<ul></ul>
</div>
<div class="clear"></div>
</div>
<script> 
$(document).ready(function(){
    $(".box2").focus(function(){
        $(this).val('').css('height','50px').unbind('focus');
        $(".tbutton").show();
    });
    $(".box2").keyup(function(){
       var t=$(this).val();
       var n = 140 - t.length;
       if (n>=0){
         $(".tbutton span").html("(你还可以输入"+n+"字)");
       }else {
         $(".tbutton span").html("<span style=\"color:#FF0000\">(已超出"+Math.abs(n)+"字)</span>");
       }
    });
});
function closet(){
    $(".tbutton").hide();
    $(".tbutton span").html("(你还可以输入140字)");
    $(".box2").val('为今天写点什么吧……').css('height','17px').bind('focus',function(){
        $(this).val('').css('height','50px').unbind('focus');
        $(".tbutton").show();});
}
function checkt(){
    var t=$(".box2").val();
    var n=140 - t.length;
    if (n<0){return false;}
}
</script>

<%@ include file="footer.jsp"%>