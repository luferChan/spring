

/** 
 * 		监听按钮的点击事件
 * 
 * 
 */

	$(function(){
		$('.search_dropdown li').on('click',function(e){	
			$('.search_name').empty().append(e.target.text).append("&nbsp;<span class='caret'></span>");
		});
	});