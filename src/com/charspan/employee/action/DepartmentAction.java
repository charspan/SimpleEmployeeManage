package com.charspan.employee.action;

import com.charspan.employee.domain.Department;
import com.charspan.employee.domain.PageBean;
import com.charspan.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 部门管理Action的类
 * 
 * @author charspanWork
 * 
 */
public class DepartmentAction extends ActionSupport implements
		ModelDriven<Department> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2634261413607984456L;
	/**
	 * 模型驱动使用的对象
	 */
	private Department department = new Department();

	@Override
	public Department getModel() {
		return department;
	}

	// 注入部门管理service
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 提供一个查询方法
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		// 将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	// 跳转到添加部门的页面
	public String saveUI() {
		return "saveUI";
	}

	// 添加部门
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}

	// 编辑部门
	public String edit() {
		// 模型驱动默认在值栈中
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}

	// 修改部门
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}

	// 删除部门
	public String delete() {
		// // 方法一 无法级联删除
		// departmentService.delete(department.getDid());
		// 方法二 先查询后删除
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}

}
