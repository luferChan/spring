$(function(){
	$.getMenu();
	position.init();
});

var position = {
	
	init : function(){
		$('button.btn-newPosition').on('click',function(e){
			position.showAddBox();
		});
		
		$('button.btn-confirm-posi').on('click',function(){
			position.save();
		});
	},
	
	showAddBox : function(){
		position.getSelectDepartment();
		Dialog.showModal('#addPosiModal');
	},
	
	// 获得下拉菜单的部门数据列表
	getSelectDepartment : function(){
		$('input.add-posi-input,textarea.add-posi-text').val("");

		$.post('./mgr/0/position/getSelectDepartment',{ },
				function(data){
					if(!$.isSuccess(data)) return;
					$.echoSelect(data.body,'select.add-posi-select',-1);
				});
	},
	
	// 新增职位信息方法
	save : function(){
		$.verify = true;
		var department = $.verifySelect('select.add-posi-select',false);
		var name = $.verifyForm('input.add-posi-input',false);
		var description = $.verifyForm('textarea.add-posi-text',true);
			
		if($.verify == false){
			return ;
		}
		console.log(department);
		$.post('./mgr/0/position/addPosition',
				{
					departmentId : department,
					name : name,
					description : description
				},function(data){
					if(!$.isSuccess(data)) return;
					Dialog.success(data.body);
					Dialog.hideModal('#addPosiModal');
				});
	},
	
	// 职位信息数据列表的展示
};