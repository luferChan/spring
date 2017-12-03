package com.te.empl.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public JSONReturn addDepartment(@RequestParam String name,@RequestParam String description,HttpServletRequest request){
		return teDepartmentService.addDepartment(name,description,acctName(request));
	}
	/**
	 *  获得部门数据列表
	 * @param search_name  搜索关键字
	 * @param page
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findDepartmentList")
	public JSONReturn findDepartmentList(@RequestParam String search_name, @RequestParam int page,HttpServletRequest request){
		return teDepartmentService.findDepartmentList(search_name,page,acctName(request));
	}
	/**
	 *  获取部门数据分页
	 * @param search_name   搜索关键字
	 * @param page  当前页码
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findDepartmentPage")
	public JSONReturn findDepartmentPage(@RequestParam String search_name, @RequestParam int page,HttpServletRequest request){
		return teDepartmentService.findDepartmentPage(search_name,page,acctName(request));
	}
	/**
	 * 删除部门
	 * @param id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteDepartment")
	public JSONReturn deleteDepartment(@RequestParam Long id, HttpServletRequest request){
		return teDepartmentService.deleteDepartment(id,acctName(request));
	}
	/**
	 *  修改部门信息
	 * @param id
	 * @param name  部门名称 
	 * @param description  部门描述
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateDepartment")
	public JSONReturn updateDepartment(@RequestParam Long id,@RequestParam String name,@RequestParam String description, HttpServletRequest request){
		return teDepartmentService.updateDepartment(id,name,description, acctName(request));
	}
}
