package com.te.empl.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.te.empl.constant.LoginState;
import com.te.empl.constant.SessionKey;
import com.te.empl.support.JSONReturn;

public class TeIntercept extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//拦截访问路径中包含'/mgr/0'的所有请求，如果true,则放行。
		if(request.getRequestURI().contains("/mgr/0/")){
			return true;
		}
		// 判断当前用户是否登录
		Object obj = request.getSession().getAttribute(SessionKey.LOGIN_USER_INFO);
		if(obj == null){
			response.getOutputStream().print(JSONObject.fromObject(JSONReturn.buildFailure(LoginState.UNLOGIN)).toString());
			return false;
		}
		return false;
	}
}
