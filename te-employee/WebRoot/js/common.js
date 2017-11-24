var Dialog = {
	msg : function(text){
		new BootstrapDialog({
			title : "警告框",
			message : text,
			type : BootstrapDialog.TYPE_WARNING
		}).open();
	},
	
	confirm : function(text,callback){
		new BootstrapDialog({
			title : "确认框",
			message : text,
			type : BootstrapDialog.TYPE_SUCCESS,
		
		buttons :[
			{
				label : '取消',
				action : function(dialog){
					dialog.close();
				}
			},
			
			{
				label : '确定',
				action : function(dialog){
					callback();
					dialog.close();
				}
			},
		]
		}).open();
	},
	
	showModal : function(id){
		$(id).modal({
			backdrop : 'static',
			keyboard : false
		}).modal('show');
	},
	hideModal : function(id){
		$(id).modal('hide');
	},
};

$(function(){
	$('a.Logout').on('click',function(e){
		Dialog.confirm("确定要注销当前用户吗？", function(){
			Dialog.msg("注销成功！");
			window.location = './login.html';
		});
	});
	
	$('.modify_password').on('click',function(){
		BootstrapDialog.show({
            message: $('<div></div>').load('modify_password.html'),
            cssClass : 'modify_password_dialog'    
        });
	});
	
	$('input.datePicker').on('click, focus',function(e){
		InitWdatePicker();
	});
	
	$('input.datePicker-before').on('click, focus',function(e){
		WdatePicker({maxDate : '%y-%M-%d'});
	});
});

(function($){
	// 检测后台返回的数据是否成功
	$.isSuccess = function(data){
		if(data.head){
			return data.head;
		}
		// if false 弹窗提示 刷新验证码 返回false
		Dialog.msg(data.body);
		
		return data.head;
	};
})(jQuery);


function InitWdatePicker(){
	WdatePicker();
}




