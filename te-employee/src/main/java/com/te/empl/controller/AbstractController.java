package com.te.empl.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;



import com.te.empl.constant.SessionKey;
import com.te.empl.model.TeAccount;

public class AbstractController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8578132448569992361L;
	
	//返回当前登录信息的用户名
	public String acctName(HttpServletRequest request){
		try {
			TeAccount account = (TeAccount) request.getSession().getAttribute(SessionKey.LOGIN_USER_INFO);
			return account == null ? "" : account.getUsername();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return "";
	}
	
}
