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
		$('button.btn-search-posi').on('click',function(){
			position.getPositionList();
		});
		
		position.getSearchSelectDepm();
		position.getPositionList();
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
	// 获得查询下拉菜单的部门数据列表
	getSearchSelectDepm : function(){
		$('input.add-posi-input,textarea.add-posi-text').val("");

		$.post('./mgr/0/position/getSelectDepartment',{ },
				function(data){
					if(!$.isSuccess(data)) return;
					$.echoSelect(data.body,'select.select-depm',-1);
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
	getPositionList : function(){
		var search_name = $('input.posi-search').val();
		var tbody = $('tbody.posi-tbody-list').empty();
		$.post('./mgr/0/position/getPositionList',
				{
					search_name : search_name,
					page : 1,
					
				},function(data){
					if(!$.isSuccess(data)) return;
					$.each(data.body,function(index,value){
						$('<tr></tr>')
						.append($('<td></td>').append(value.id))
						.append($('<td></td>').append(value.name))
						.append($('<td></td>').append(value.createTime))
						.append($('<td></td>').append(value.creator))
						.append($('<td></td>').append(value.department))
						.append($('<td></td>').append(value.description))
						.append($('<td></td>').append("")).appendTo(tbody);
					});
					
				});
	},
};