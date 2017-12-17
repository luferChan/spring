$(function(){
	$.getMenu();
	position.init();
	position.initPagy();
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
			position.initPagy();
		});
		$('button.btn-confirm-edit').on('click',function(){
			position.modify();
		});
		position.getSearchSelectDepm();
		
		
	},
	
	initPagy : function(){
		position.getPositionList(1);
		position.getPagy(1);
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
	// 获得编辑下拉菜单的部门数据列表
	getEditSelectDepm : function(){
		$('input.edit-posi-input,textarea.edit-posi-text').val("");

		$.post('./mgr/0/position/getSelectDepartment',{ },
				function(data){
					if(!$.isSuccess(data)) return;
					$.echoSelect(data.body,'select.edit-posi-select',-1);
					
				});
	},
	
	
	getPagy : function(page){
		$("#pagination ul").empty(); //每次调用时清空分页组件
		
		var dpmId = $('select.select-depm').val();
		var search_name = $('input.posi-search').val();
		
		$.post('./mgr/0/position/getPositionPage',
				{
					departmentId : dpmId,
					search_name : search_name,
					page : page,
					
				},function(data){
					$.setPage(data.body,position.getPositionList);
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
					position.initPagy();
					Dialog.hideModal('#addPosiModal');
					
				});
	},
	
	//当前职位ID
	currentId : null,
	//修改操作
	modify : function(){
		$.verify = true;
		var dpmId = $.verifySelect('select.edit-posi-select',false);
		var dpmName = $.verifyForm('input.edit-posi-input',false);
		var dpmDescription = $.verifyForm('textarea.edit-posi-text',true);
			
		if($.verify == false){
			return ;
		}
		
		var positionId = position.currentId;

		$.post('./mgr/0/position/editPosition',
				{ 
					positionId : positionId, 
					departmentId : dpmId,
					name : dpmName,
					description : dpmDescription
					
				},function(data){
					if(!$.isSuccess) return;
					Dialog.success(data.body);
					position.initPagy();
					Dialog.hideModal('#editPosiModal');
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
	
	//编辑职位信息
	editPosition : function(index){
		if(position.dataList == null || position.dataList.length <= 0){
			return ;
		}
		position.currentId = position.dataList[index].id;
		
		position.getEditSelectDepm();
		Dialog.showModal('#editPosiModal');
		$('input.edit-posi-input').val(position.dataList[index].name);
		$('textarea.edit-posi-text').val(position.dataList[index].description);
	},
	
	
	deletePosition : function(index){
		if(position.dataList == null || position.dataList.length <= 0){
			return ;
		}
		
		var id = position.dataList[index].id;
		Dialog.confirm("请确认是否删除选中的职位", function(){
			$.post('./mgr/0/position/deletePosition',{id : id},function(data){
				if(!$.isSuccess) return;
				Dialog.success(data.body);
				position.initPagy();
			});
		});
	},
};