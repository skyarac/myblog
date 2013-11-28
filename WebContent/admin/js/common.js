function displayToggle(id){
	if($("#"+id).is(":hidden")){
		$("#"+id).show();
	}else{
		$("#"+id).hide();
	}
}
function checkform(){
	var t = $.trim($("#title").val());
	var c = $.trim($("#content").val());
	var s = $.trim($("#sort").val());
	if (t==""){
		alert("标题不能为空");
		$("#title").focus();
		return false;
	}else if(c==""){
		alert("内容不能为空");
		$("#content").focus();
		return false;
	}else if(s==""){
		alert("分类不能为空");
		$("#sort").focus();
		return false;
	}else{
		return true;
	}
		
}
function hideActived(){
	$(".actived").hide();
	$(".error").hide();
}
function del(id, property) {
	switch (property){
		case 'sort':
			var urlreturn="admn/sort!delete?sid="+id;
			var msg = "你确定要删除该分类吗？";break;
		case 'link':
			var urlreturn="admn/link!delete?lid="+id;
			var msg = "你确定要删除该链接吗？";break;
	}
	if(confirm(msg)){window.location = urlreturn;}else {return;}
}
function delByIds(id,property){
	var ids = "";
	$("#"+id+" input[type='checkbox']:checked").each(function() {
  		ids+=$(this).val()+",";
	});
	switch (property){
		case 'tag':
			var urlreturn="admn/tag!delTags?ids="+ids;
			var msg = "你确定要删除该标签吗？";break;
	}
	if(confirm(msg)){window.location = urlreturn;}else {return;}
}
function insertTag (tag, boxId){
	var targetinput = $("#"+boxId).val();
	if(targetinput == ''){
		targetinput += tag;
	}else{
		var n = ',' + tag;
		targetinput += n;
	}
	$("#"+boxId).val(targetinput);
	if (boxId == "tag")
		$("#tag_label").hide();
}
function autosave(act){
	alert("功能开发中....");
}