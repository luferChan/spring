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
		if(typeof data != 'object'){
			data = $.parseJSON(data);
		}
		if(data.head){
			return data.head;
		}
		if('UNLOGIN' == data.body){
			window.location.href = './login.html';
			return false;
		}
		// if false 弹窗提示 刷新验证码 返回false
		Dialog.msg(data.body);
		
		return data.head;
	};
	
	$.getMenu = function(){
		var ul = $('ul.nav-list').empty();
		$.post('./mgr/0/getMenu',function(data){
			if(!$.isSuccess(data)){
				return;
			}
			$.each(data.body, function(index,value){
				
				if(value.level != 0){
					return;
				} 
				$("<li class='dropdown'></li>").append($("<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'></a>")
						.append(value.name).append("<span class='caret'></span>"))
						.append($.subMenu(data.body, value.code)).appendTo(ul);
				
			});
		});
	};
	
	$.subMenu = function(data,code){
		
		var ul = $("<ul class='dropdown-menu'></ul>");
		if(!data || !code){
			return;
		}
		
		$.each(data, function(i,v){
			if(v.level != 1 || v.superCode != code) return;
			$("<li></li>").append($("<a href='"+v.page+"''></a>").append(v.name)).appendTo(ul);
		});
		return ul;
	};
	
	
	$.verify = true;
	
	// 获取并验证input表单中的数据，最后将数据返回。
	$.verifyForm = function(classname,isNull){
		$(classname).removeClass('border-red');
		var val =  $(classname).val();
		if(val == null || val == "" || val.length<=0){
			$.verify = false;
			$(classname).addClass('border-red');
		}
		return val;
	};
})(jQuery);


function InitWdatePicker(){
	WdatePicker();
}




