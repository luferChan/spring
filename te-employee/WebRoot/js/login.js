/**
 * 	login登陆相关js
 * 
 * 
 * **/


	$(function(){ 		
    	$('#myModal').modal({
    		backdrop:false,
    		keyboard:false,
    		show:true	  				
    	});
    	//重置数据表单的事件监听
    	$('button.reset').on('click',login.reset);
    	//点击图形验证码刷新
    	$('img.login-verify-img').on('click',function(data){
    		login.resetVerifyCode();
    	});
    	//点击登录后 校验数据
    	$('button.login-confirm').on('click',login.login);
    });
	
	var login = {
			/**
			 *  登陆按钮事件
			 */
			'login' : function(){
				
				$.verify = true;
				var uname = $.verifyForm('input.username');
				var pword = $.verifyForm('input.password');
				var verify = $.verifyForm('input.verify');
				
				if($.verify == false){
					return ;
				}
				
				$.post('./mgr/0/login',{
					// 左边为后台所需要传入的参数名
					username : uname,
					password : pword,
					verify : verify
					
					
				},function(data){
					// if true 跳转， false这边无操作
					if($.isSuccess(data)){
						window.location.href = './index.html';
						return;
					}
					//刷新验证码
					login.resetVerifyCode();
				});
			},
			/** *	
			 *    重置按钮
			 */
			'reset' : function(){
				$('.username, .password, .verify').val('');
				login.resetVerifyCode();
			},
			/** *	
			 *    刷新验证码
			 */	
			'resetVerifyCode' : function(){
				$('img.login-verify-img').attr('src', './mgr/0/findVerifyCode?'+new Date().getTime());
			}
	};



	