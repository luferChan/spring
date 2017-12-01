$(function(){
	$.getMenu();
	$('button.btn-newDept').on('click',function(){
		Dialog.showModal('#creatDeptModal');
	});
});