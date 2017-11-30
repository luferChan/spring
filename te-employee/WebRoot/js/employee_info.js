$(function(){
	$('button.btn-addJob').on('click',function(){	
		$('tbody.tbody-jobList').append($('tbody.tbody-jobList tr:last').prop('outerHTML'));
		//$('tbody.tbody-jobList').append($('<tr></tr>').append($('tbody.tbody-jobList tr:last').html()));
	});
	
	$('button.btn-saveORmodify').on('click',function(){
		var data = getEmployeeInfo(); //获取并验证表单中的所有数据
	});
	//获取顶级导航菜单
	$.getMenu();
});

//验证页面中的所有表单，并将最终的数据封装为一个JSON对象返回
function getEmployeeInfo(){
	$('.color-red').removeClass('color-red');
	var empl = {};
	empl.fullname = $.input('.fullname',false); //姓名
	empl.sex = $.radio('.optionsRadiosSex',false);//性别
	empl.position = $.select('.position',false); //职位
	empl.department = $.select('.department',false);//部门 
	empl.culture = $.radio('.optionsRadiosCulture',false); //文化程度
	empl.marriage = $.radio('.optionsRadiosMarriage',false);//婚姻状况 
	empl.optionsRadiosNation = $.radio('.optionsRadiosNation',false); //民族
	empl.optionsRadiosStatus = $.radio('.optionsRadiosStatus',false);//政治面貌 
	empl.idNumber = $.input('.id-number',false);//身份证号
	empl.birthday = $.input('.birthday',false);//出生年月
	empl.cardNumber = $.input('.cardNumber',true);//社保卡号
	empl.dutyDate = $.input('.dutyDate',false);//上岗日期   
	
	console.log(empl);
	return empl;
}

(function($){
	//如果isSubmit为true，则所有表单验证通过。
	$.isSubmit = true;
	
	// 获取并验证input表单中的数据，最后将数据返回。
	$.input = function(className,isNull){
		//1. 获取指定元素中的值
		var val = $(className).val(); 	
		//2. 验证值是否合法
		if(isNull) return val;
		if(val!=null && val!='') return val; //验证通过，返回数据
		$(className + '-Label').addClass('color-red'); 
		$.isSubmit = false;
		//3. 将值返回
		return ''; //验证不通过，返回空串。
	};
	
	// 获取并验证select表单中的数据，最后将数据返回。
	$.select = function(className,isNull){
		//1. 获取指定元素中的值
		var val = $(className).val(); 	
		//2. 验证值是否合法
		if(isNull) return val;
		if(val!=null && val!=-1) return val; //验证通过，返回数据
		$(className + '-Label').addClass('color-red'); 		
		$.isSubmit = false;
		//3. 将值返回
		return ''; //验证不通过，返回空串。
	};
	
	// 获取并验证radio表单中的数据，最后将数据返回。
	$.radio = function(className,isNull){
		//1. 获取指定元素中的被选择的对象
		var obj =  $(className+':checked');
		//2. 判断是否允许为空，且单选框是否被选择。
		if(isNull && obj.length <=0){
				return "";
			}
			else if (isNull){
				return obj.val();
			}
		if(obj.length <= 0){
			$(className + '-Label').addClass('color-red');
			$.isSubmit = false;
			return '';
		}		
		
		return obj.val();
			
		
	};
})(jQuery);



function removeCurrent(_this){
	if($('tr.tr-job').length <=1 ){
		return;
	}
	$(_this).parent().parent().remove();
};



KindEditor.ready(function(K){
	var editor = K.editor({});
	
	K('img.emp-photoImg').click(function(){
		editor.loadPlugin('image',function(){
			editor.plugin.imageDialog({
				showRemote : false
			});
		});
	});
});
