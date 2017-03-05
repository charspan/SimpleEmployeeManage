package com.charspan.employee.dao;

import java.util.List;

import com.charspan.employee.domain.Employee;

/**
 * 员工管理的DAO层接口
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
