package com.charspan.employee.action;

import java.util.List;

import com.charspan.employee.domain.Department;
import com.charspan.employee.domain.Employee;
import com.charspan.employee.domain.PageBean;
import com.charspan.employee.service.DepartmentService;
import com.charspan.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理的Action类
 */
public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2066014585421642703L;

	/**
	 * 模型驱动使用的对象
	 */
	private Employee employee = new Employee();

	@Override
	public Employee getModel() {
		return employee;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * 登录
	 */
	public String login() {
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			this.addActionError("username or password error!");
			return INPUT;
		} else {
			ActionContext.getContext().getSession()
					.put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// 将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	public String saveUI() {
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}

	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}

	public String edit() {
		employee=employeeService.findById(employee.getEid());
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}

	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}

	public String delete() {
		employee=employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}

}
