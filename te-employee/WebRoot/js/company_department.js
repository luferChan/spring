$(function(){
	$.getMenu();
	$('button.btn-newDept').on('click',function(){
		depm.showAddBox();
	});
	$('button.btn-save').on('click',function(e){
		depm.save();
	});
});

var depm = {
	showAddBox : function(){
		depm.cleanMsg();
		Dialog.showModal('#createDeptModal');
	},

	save : function(){
		$.verify = true;
		var depName = $.verifyForm('input.dep-name-input');
		var depDesc = $('textarea.dep-desc-text').val();
		if($.verify == false){
			return ;
		}
		
		$.post('./mgr/0/department/add',{name : depName, description : depDesc },function(data){
			Dialog.hideModal('#createDeptModal');
			if(!$.isSuccess(data)) return;
			Dialog.success(data.body);
		});
	},
	
	cleanMsg : function(){
		$('input.dep-name-input,textarea.dep-desc-text').val("");
	},
};