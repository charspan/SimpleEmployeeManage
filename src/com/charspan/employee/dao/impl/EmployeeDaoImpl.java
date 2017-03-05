package com.charspan.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.charspan.employee.dao.EmployeeDao;
import com.charspan.employee.domain.Employee;

/**
 * 员工管理的DAO层接口实现类
 */
@Transactional
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		System.out.println(employee.getUsername() + "  "
				+ employee.getPassword());
		// 数据库 表名就是类名 很重要！
		String hql = "from Employee where username = ? and password = ?";
		@SuppressWarnings("unchecked")
		List<Employee> list = this.getHibernateTemplate().find(hql,
				employee.getUsername(), employee.getPassword());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(
				criteria, begin, pageSize);
		return list;
	}

	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}
	
}
