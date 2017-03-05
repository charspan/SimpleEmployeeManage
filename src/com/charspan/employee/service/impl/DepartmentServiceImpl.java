package com.charspan.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.charspan.employee.dao.DepartmentDao;
import com.charspan.employee.domain.Department;
import com.charspan.employee.domain.PageBean;
import com.charspan.employee.service.DepartmentService;

/**
 * 部门管理的业务层接口实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	// 注入部门管理的DAO
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	// 分页查询部门
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		// 设置当前页数
		pageBean.setCurrPage(currPage);
		// 设置每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		// 设置总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 设置每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	// 保存部门
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	// 根据部门编号查询部门信息
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}

	@Override
	// 修改部门
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	// 查询所有部门
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

}
