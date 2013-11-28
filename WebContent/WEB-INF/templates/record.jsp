<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--日志存档开始-->
<div class="cbx">
	<h3><span>存档</span></h3>
	<div class="ctx ">
		<ul id="record">
			<s:iterator value="recordList" var="re">
			<li><a href="home?rid=<s:property value="#re.date"/>"><s:property value="#re.formatDate"/>(<s:property value="#re.conut"/>)</a></li>
			</s:iterator>
		</ul>
	</div>
</div>
<!--日志存档结束-->