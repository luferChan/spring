$(function(){
	$.getMenu();  //获取菜单 
	depm.init();  //初始化监听事件
	depm.initPagy();  // 初始化数据列表及分页事件	
});

var depm = {
	currentID : 0,	
	init : function(){
		$('button.btn-newDept').on('click',function(){
			depm.showAddBox();
		});
		// 新增部门信息
		$('button.btn-save').on('click',function(e){
			depm.save();
		});
		// 修改部门信息
		$('button.btn-modify').on('click',function(e){
			depm.modify();	
		});
		// 点击搜索监听事件
		$('button.btn-search').on('click',function(e){
			depm.initPagy();
		});
		$('input.text-search').on('keyup',function(event){ //实现回车键搜索
    		//回车键的keyCode为13
    		if(event.keyCode == 13){
    			depm.initPagy();
    		}
    	});
	},	
	
	initPagy : function(){
		depm.findDepartmentList(1);
		depm.findDepartmentPage(1);
	},
		
	showAddBox : function(){
		depm.cleanMsg();
		Dialog.showModal('#createDeptModal');
	},

	save : function(){
		$.verify = true;
		var depName = $.verifyForm('input.dep-name-input',false);
		var depDesc = $.verifyForm('textarea.dep-desc-text',true);
			
		if($.verify == false){
			return ;
		}
		
		$.post('./mgr/0/department/add',{ name : depName, description : depDesc },function(data){
			Dialog.hideModal('#createDeptModal');
			depm.initPagy();
			if(!$.isSuccess(data)) return;
			Dialog.success(data.body);
			
		});
	},
	
	modify : function(){
		$.verify = true;
		var modifyName = $.verifyForm('input.modify-name-input',false);
		var modifyDesc = $.verifyForm('textarea.modify-desc-text',true);
			
		var id = depm.currentID;
		if($.verify == false){
			return ;
		}
		
		$.post('./mgr/0/department/updateDepartment',
			{
				id : id,
				name : modifyName, 
				description : modifyDesc 
			},
			function(data){
				Dialog.hideModal('#modifyDeptModal');
				depm.initPagy();
				if(!$.isSuccess(data)) return;
				Dialog.success(data.body);
				
			});
	},
	
	cleanMsg : function(){
		$('input.dep-name-input,textarea.dep-desc-text').val("");
	},
	
	findDepartmentList : function(page){
		var search_name = $('input.text-search').val();
		var tbody = $('tbody.tbody-list').empty();
		$.post('./mgr/0/department/findDepartmentList',
				{
					search_name : search_name, 
					page : page
					
				},function(data){
					if(!$.isSuccess(data)) return;
					//console.log(data.body);
					$.each(data.body,function(index,value){
						$('<tr></tr>')
						.append($("<td></td>").append(value.id))
						.append($("<td></td>").append(value.name))
						.append($("<td></td>").append(value.creatTime))
						.append($("<td></td>").append(value.creator))
						.append($("<td></td>").append(value.description))
						.append($("<td></td>").append(depm.getBtns(index,value))).appendTo(tbody);
					});
			
				});
	},

	findDepartmentPage : function(page){
		var search_name = $('input.text-search').val();
		$("#pagination ul").empty();
		$.post('./mgr/0/department/findDepartmentPage',
				{
					search_name : search_name, 
					page : page
					
				},function(data){
					$.setPage(data.body,depm.findDepartmentList);
				});
	},
	
	deleteDepartment : function(id){
		if(!id) return;
		Dialog.confirm("请确认是否删除当前选中的部门", function(){
			$.post('./mgr/0/department/deleteDepartment',{id : id},function(data){
				if(!$.isSuccess) return;
				Dialog.success(data.body);
				depm.initPagy();
			});
		});
	},
	
	editDepartment : function(id,index){
		if(!id) return;		
		var tbodyArray =  $('tbody.tbody-list').find('tr').eq(index).find('td');		
		Dialog.showModal('#modifyDeptModal');
		$('input.modify-name-input').val(tbodyArray[1].textContent);
		$('textarea.modify-desc-text').val(tbodyArray[4].textContent);
		depm.currentID = id;
	},
	
	getBtns : function(index,value){
		var btns = "";
		btns += "<button type='button' class='btn btn-primary btn-xs' onclick=depm.editDepartment("+value.id+","+index+")><span class='glyphicon glyphicon-check' aria-hidden='true'></span>&nbsp;编辑</button>";
		btns += "<button type='button' class='btn btn-danger btn-xs' onclick=depm.deleteDepartment("+value.id+")><span class='glyphicon glyphicon-remove' aria-hidden='true'></span>&nbsp;删除</button>";
		return btns;
	},
};