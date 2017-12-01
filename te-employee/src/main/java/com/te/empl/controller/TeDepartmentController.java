package com.te.empl.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.te.empl.service.TeDepartmentService;
import com.te.empl.support.JSONReturn;

@Controller
@RequestMapping(value = "/0/department")
public class TeDepartmentController extends AbstractController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6411112693589098016L;
	
	@Autowired
	private TeDepartmentService teDepartmentService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public JSONReturn addDepartment(String name,String description,HttpServletRequest request){
		return teDepartmentService.addDepartment(name,description,acctName(request));
	}
	
}
