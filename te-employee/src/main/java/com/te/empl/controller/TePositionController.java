package com.te.empl.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.te.empl.service.TeDepartmentService;
import com.te.empl.service.TePositionService;
import com.te.empl.support.JSONReturn;

@Controller
@RequestMapping(value = "/0/position")
public class TePositionController extends AbstractController implements Serializable{

	private static final long serialVersionUID = 3171739692776643217L;
	
	@Autowired
	private TePositionService tePositionService;
	@Autowired
	private TeDepartmentService teDepartmentService;
	
	/**
	 * 
	 * @param departmentId  选择的部门ID
	 * @param name 职位名称
	 * @param description 职位描述
	 * @param request
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value="/addPosition")
	public JSONReturn addPosition(@RequestParam Long departmentId, @RequestParam String name,@RequestParam String description,HttpServletRequest request){
		return tePositionService.addPosition(departmentId,name,description,acctName(request));
	}
	
	/**
	 * 编辑职位信息
	 * @param positionId
	 * @param departmentId
	 * @param name
	 * @param description
	 * @param request
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value="/editPosition")
	public JSONReturn editPosition(@RequestParam Long positionId,@RequestParam Long departmentId, @RequestParam String name,@RequestParam String description,HttpServletRequest request){
		return tePositionService.editPosition(positionId,departmentId,name,description,acctName(request));
	}
	
	/**
	 * 删除职位
	 * @param id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deletePosition")
	public JSONReturn deletePosition(@RequestParam Long id,HttpServletRequest request){
		return tePositionService.deletePosition(id,acctName(request));
	}
	
	
	/**
	 *  获取下拉菜单的部门列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getSelectDepartment")
	public JSONReturn getSelectDepartment(){
		return teDepartmentService.getSelectDepartment();
	}
	
	/**
	 * 获取职位数据列表
	 * @param departmentId
	 * @param search_name
	 * @param page
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getPositionList")
	public JSONReturn getPositionList(@RequestParam Long departmentId,@RequestParam String search_name, @RequestParam int page,
			HttpServletRequest request){
		return tePositionService.getPositionList(departmentId,search_name,page,acctName(request));
	}
	/**
	 * 获取分页信息
	 * @param departmentId
	 * @param search_name
	 * @param page
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getPositionPage")
	public JSONReturn getPositionPage(@RequestParam Long departmentId,@RequestParam String search_name, @RequestParam int page,
			HttpServletRequest request){
		return tePositionService.getPositionPage(departmentId,search_name,page,acctName(request));
	}
}
