var editor;
function pageInit(){
	var plugins={
		Code:{c:'btnCode',t:'插入代码',h:1,e:function(){
			var _this=this;
			var htmlCode='<div><select id="xheCodeType"><option value="html">HTML</option><option value="java">Java</option><option value="xml">XML</option><option value="sql">SQL</option><option value="js">Javascript</option><option value="css">CSS</option></select></div><div><textarea id="xheCodeValue" wrap="soft" spellcheck="false" style="width:300px;height:100px;" /></div><div style="text-align:right;"><input type="button" id="xheSave" value="确定" /></div>';
			var jCode=$(htmlCode),jType=$('#xheCodeType',jCode),jValue=$('#xheCodeValue',jCode),jSave=$('#xheSave',jCode);
			jSave.click(function(){
				_this.loadBookmark();
				_this.pasteHTML('<pre title="'+jType.val()+ ' 代码" class="brush:'+jType.val()+'">'+_this.domEncode(jValue.val())+'</pre>');
				_this.hidePanel();
				return false;	
			});
			_this.saveBookmark();
			_this.showDialog(jCode);
		}}
	};
	editor=$('#content').xheditor({
		skin:'nostyle',
		html5Upload:false,
		upBtnText:'上传',
		upImgUrl:'editor/upload?immediate=1',
		upImgExt:'jpg,jpeg,gif,png',
		upLinkUrl:'editor/upload?immediate=2',
		upLinkExt:'txt,rar,zip,jpg,jpeg,gif,png,doc,pdf',
		defLinkText:'点击下载',
		plugins:plugins,
		tools:'Cut,Copy,Paste,Pastetext,Blocktag,Fontface,FontSize,Bold,Italic,Underline,Strikethrough,FontColor,BackColor,SelectAll,Removeformat,Align,List,Outdent,Indent,Link,Unlink,Anchor,Img,Hr,Emot,Table,Code,Source,Preview,Fullscreen',
		emots:{
			msn:{name:'MSN',count:40,width:22,height:22,line:8},
			pidgin:{name:'Pidgin',width:22,height:25,line:8,list:{smile:'微笑',cute:'可爱',wink:'眨眼',laugh:'大笑',victory:'胜利',sad:'伤心',cry:'哭泣',angry:'生气',shout:'大骂',curse:'诅咒',devil:'魔鬼',blush:'害羞',tongue:'吐舌头',envy:'羡慕',cool:'耍酷',kiss:'吻',shocked:'惊讶',sweat:'汗',sick:'生病',bye:'再见',tired:'累',sleepy:'睡了',question:'疑问',rose:'玫瑰',gift:'礼物',coffee:'咖啡',music:'音乐',soccer:'足球',good:'赞同',bad:'反对',love:'心',brokenheart:'伤心'}},
			ipb:{name:'IPB',width:20,height:25,line:8,list:{smile:'微笑',joyful:'开心',laugh:'笑',biglaugh:'大笑',w00t:'欢呼',wub:'欢喜',depres:'沮丧',sad:'悲伤',cry:'哭泣',angry:'生气',devil:'魔鬼',blush:'脸红',kiss:'吻',surprised:'惊讶',wondering:'疑惑',unsure:'不确定',tongue:'吐舌头',cool:'耍酷',blink:'眨眼',whistling:'吹口哨',glare:'轻视',pinch:'捏',sideways:'侧身',sleep:'睡了',sick:'生病',ninja:'忍者',bandit:'强盗',police:'警察',angel:'天使',magician:'魔法师',alien:'外星人',heart:'心动'}}
		},
		loadCSS:'<style>pre{margin-left:2em;border-left:3px solid #CCC;padding:0 1em;}</style>',
		//shortcuts:{'ctrl+enter':submitForm} //快捷键提交
	});
}
///function submitForm(){$('#editorForm').submit();}