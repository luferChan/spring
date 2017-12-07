$(function(){
	$.getMenu();
	position.init();
	
});

var position = {
	
	init : function(){
		$('button.btn-newPosition').on('click',function(e){
			position.showAddBox();
		});
	},
	
	showAddBox : function(){
		position.getSelectDepartment();
		Dialog.showModal('#addPosiModal');
	},
	
	getSelectDepartment : function(){
		var select = $('select.add-posi-select').empty().append($('<option value="0"></option>').append("请选择部门..."));
		$.post('./mgr/0/position/getSelectDepartment',
				{
				
				},function(data){
					if(!$.isSuccess(data)) return;
					//console.log(data.body);
					$.each(data.body,function(index,value){
						$("<option value="+value.id+"></option>").append(value.name).appendTo(select);
					});
			
				});
	},
};