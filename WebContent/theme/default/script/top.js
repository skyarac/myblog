$(function(){
	$('.post').hover(function() {
		$(this).find('.readmorea').fadeIn('fast')
	}, function() {
		$(this).find('.readmorea').fadeOut('fast')
	});
	// 回到顶部
	var btn = $('.scroll-to-top');
	function check() {
		var topConfig = 768,
			top = btn.offset().top;
		
		if (top > topConfig) {
			btn.fadeIn('fast');
		} else {
			btn.fadeOut('fast');
		}
	}
	$(window).scroll(function(){
		check();
	});
	$(btn).click(function(){
		window.scrollTo(0, 0);
	});
});

// 修复图片尺寸
function fixImgSize(img){
    var MAXWIDTH = '500';

    if(img.width > MAXWIDTH){
        img.width = MAXWIDTH;
        img.removeAttribute('height');
    }
}
