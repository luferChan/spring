

/** 
 * 		监听按钮的点击事件
 * 
 * 
 */

$(function(){
	$.getMenu();
	$('.btn-newInfo').on('click',function(e){
		window.location.href = './employee_info.html';
	});
});

