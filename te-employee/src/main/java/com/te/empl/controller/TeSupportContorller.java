package com.te.empl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.te.empl.constant.SessionKey;
import com.te.empl.service.TeAccountService;
import com.te.empl.support.JSONReturn;
import com.te.empl.support.RandomValidateCode;


@Controller
public class TeSupportContorller {
	
	@Autowired
	private TeAccountService teAccountService;
	
	
	@RequestMapping(value="/0/findVerifyCode")
	public void findVerifyCode(HttpServletRequest request,HttpServletResponse response){
		//生成图形验证码并将图片返回给前台
		RandomValidateCode.getRandcode(request, response);
	}
	
	@ResponseBody
	@RequestMapping(value = "/0/login")
	public JSONReturn login(@RequestParam String username,@RequestParam String password,@RequestParam String verify, HttpServletRequest request,HttpServletResponse response){
		// 处理图形验证码的检测
		//判空
		if(StringUtils.isEmpty(verify)){
			return JSONReturn.buildFailure("验证码为空...");
		}
		Object verifyCode =  request.getSession().getAttribute(SessionKey.VALIDATE_CODE);
		if(!verify.equalsIgnoreCase(String.valueOf(verifyCode))){
			return JSONReturn.buildFailure("验证码输入错误！");
		}
		return teAccountService.login(username,password,request);
	}
	
}

