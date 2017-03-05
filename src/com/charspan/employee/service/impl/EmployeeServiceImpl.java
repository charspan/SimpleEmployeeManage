package com.charspan.employee.service.impl;

import java.util.List;

import com.charspan.employee.dao.EmployeeDao;
import com.charspan.employee.domain.Employee;
import com.charspan.employee.domain.PageBean;
import com.charspan.employee.service.EmployeeService;

/**
 * 员工管理的业务层接口实现类
 */
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		Employee existEmplyoee = employeeDao
				.findByUsernameAndPassword(employee);
		return existEmplyoee;
	}

	@Override
	// 分页查询员工
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		// 设置当前页数
		pageBean.setCurrPage(currPage);
		// 设置每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		// 设置总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 设置每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

}
