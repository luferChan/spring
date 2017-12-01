package com.te.empl.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.te.empl.support.JSONReturn;

@ControllerAdvice
public class TeException implements Serializable{

	/**
	 *   全局异常捕获
	 */
	private static final long serialVersionUID = 3778556703129692205L;
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	public JSONReturn exception(Exception ex){
		ex.printStackTrace();
		return JSONReturn.buildFailure("服务器异常！");
	}
}
