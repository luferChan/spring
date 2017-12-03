$(function(){
	$.getMenu();  //获取菜单 
	depm.init();  //初始化监听事件
	depm.initPagy();  // 初始化数据列表及分页事件	
});

var depm = {
		
	init : function(){
		$('button.btn-newDept').on('click',function(){
			depm.showAddBox();
		});
		$('button.btn-save').on('click',function(e){
			depm.save();
			depm.initPagy();
		});
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
	
	findDepartmentList : function(page){
		var search_name = $('input.text-search').val();
		var tbody = $('tbody.tbody-list').empty();
		$.post('./mgr/0/department/findDepartmentList',
				{
					search_name : search_name, 
					page : page
					
				},function(data){
					if(!$.isSuccess(data)) return;
					console.log(data.body);
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
	
	getBtns : function(index,value){
		var btns = "";
		btns += "<button type='button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-check' aria-hidden='true'></span>&nbsp;编辑</button>";
		btns += "<button type='button' class='btn btn-danger btn-xs' onclick=depm.deleteDepartment("+value.id+")><span class='glyphicon glyphicon-remove' aria-hidden='true'></span>&nbsp;删除</button>";
		return btns;
	},
};