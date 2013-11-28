<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--标签开始-->
<div class="cbx">
	<h3><span>标签</span></h3>
	<div class="ctx">
		<div id="blogtags">
			<s:iterator value="tagList" var="t">
			<a href="home?tid=<s:property value="#t.tagId"/>" title="<s:property value="#t.tagRelationShipses.size"/> 篇日志"><s:property value="#t.name"/></a>
			</s:iterator>
		</div>
	</div>
</div>
<!--标签结束-->
<script>
$(document).ready(function(){
        var tags     = $('#blogtags a');
        var tagsLen  = tags.size();
        var fontSize = new Array('11px','12px','14px','16px');
        var getRandomColor = function(){ 
		   return '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6); 
		} 
        function RtEle(array){
            var arraysize = array.length;
            var eleArray = Math.floor(Math.random()*(arraysize));
            return array[eleArray];
        }
        for(var i=0 ;i<tagsLen;i++){
            var tagtxt = tags.eq(i).css({'font-size':RtEle(fontSize),'color':getRandomColor()});
        }
})
</script>

