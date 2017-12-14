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
			position.getPositionList(1);
		});
		
		position.getSearchSelectDepm();
		position.getPositionList(1);
	},
	
	showAddBox : function(){
		position.getSelectDepartment();
		Dialog.showModal('#addPosiModal');
	},
	
	dataList : null,
	
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
					position.getPositionList(1);
				});
	},
	
	// 职位信息数据列表的展示
	getPositionList : function(page){
		var dpmId = $('select.select-depm').val();
		var search_name = $('input.posi-search').val();
		var tbody = $('tbody.posi-tbody-list').empty();
		$.post('./mgr/0/position/getPositionList',
				{
					departmentId : dpmId,
					search_name : search_name,
					page : page,
					
				},function(data){
					if(!$.isSuccess(data)) return;
					position.dataList = data.body;
					
					$.each(data.body,function(index,value){
						$('<tr></tr>')
						.append($('<td></td>').append(value.id))
						.append($('<td></td>').append(value.name))
						.append($('<td></td>').append(value.createTime))
						.append($('<td></td>').append(value.creator))
						.append($('<td></td>').append(value.department))
						.append($('<td></td>').append(value.description))
						.append($('<td></td>').append(position.getBtns(index))).appendTo(tbody);
					});
					
				});
	},
	//定义编辑与删除按钮
	getBtns : function(index){
		var btns = "";
		btns += "<button type='button' class='btn btn-primary btn-xs' onclick=position.editPosition("+index+")><span class='glyphicon glyphicon-check' aria-hidden='true'></span>&nbsp;编辑</button>";
		btns += "<button type='button' class='btn btn-danger btn-xs' onclick=position.deletePosition("+index+")><span class='glyphicon glyphicon-remove' aria-hidden='true'></span>&nbsp;删除</button>";
		return btns;
	},
	
	deletePosition : function(index){
		if(position.dataList == null || position.dataList.length <= 0){
			return ;
		}
		console.log(position.dataList[index].id);
		var id = position.dataList[index].id;
		Dialog.confirm("请确认是否删除选中的职位", function(){
			$.post('./mgr/0/position/deletePosition',{id : id},function(data){
				if(!$.isSuccess) return;
				Dialog.success(data.body);
				position.init();
			});
		});
	},
};