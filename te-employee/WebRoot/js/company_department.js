$(function(){
	$.getMenu();
	$('button.btn-newDept').on('click',function(){
		depm.showAddBox();
	});
	$('button.btn-save').on('click',function(e){
		depm.save();
	});
	$('button.btn-search').on('click',function(e){
		depm.findDepartmentList(1);
	});
	depm.findDepartmentList(1);
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
	
	findDepartmentList : function(page){
		var search_name = $('input.text-search').val();
		var tbody = $('tbody.tbody-list').empty();
		$.post('./mgr/0/department/findDepartmentList',
				{
					search_name : search_name, 
					page : page
					
				},function(data){
					if(!$.isSuccess(data)) return;
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
	
	getBtns : function(index,value){
		var btns = "";
		btns += "<button type='button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-check' aria-hidden='true'></span>&nbsp;编辑</button>";
		btns += "<button type='button' class='btn btn-danger btn-xs'><span class='glyphicon glyphicon-remove' aria-hidden='true'></span>&nbsp;删除</button>";
		return btns;
	},
};