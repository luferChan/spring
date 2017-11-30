

/** 
 * 		监听按钮的点击事件
 * 
 * 
 */

$(function(){
	$.getMenu();
});

	$(function(){
		$('.search_dropdown li').on('click',function(e){	
			$('.search_name').empty().append(e.target.text).append("&nbsp;<span class='caret'></span>");
		});
		$('.btn-newInfo').on('click',function(e){
			window.location.href = './employee_info.html';
		});
	});