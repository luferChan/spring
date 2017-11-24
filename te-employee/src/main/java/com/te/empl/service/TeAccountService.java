package com.te.empl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.te.empl.model.TeAccount;
import com.te.empl.support.JSONReturn;

public abstract interface TeAccountService {

		public JSONReturn login(String username, String password,
				HttpServletRequest request);
	
}
