<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--顶部开始-->
<div id="header">
	<div class="mbox">
		<div id="tide">
			<h1><a href="">WeTuo</a><span>把活着的每一天看作生命的最后一天.</span></h1>
		</div>
		<div id="h_serch">
			<form name="keyform" method="get" id="searchform" class="search"
				action="home">
				<input type="text" name="keyword" class="keyword"
					onblur="if(this.value =='')this.value='Search...and Enter';"
					onfocus="this.value='';"
					onclick="if(this.value=='Search...and Enter')this.value=''"
					value="Search...and Enter" />
				<input type="submit" value="搜寻" class="submit" />
			</form>
		</div>
		<div id="navi">
			<ul>
				<li><a class="current" href="index.jsp">首页</a></li>
				<li class="common"><a href="">关于我</a></li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
</div>
<!--顶部结束-->
