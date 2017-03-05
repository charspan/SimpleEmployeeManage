package com.charspan.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.charspan.employee.dao.DepartmentDao;
import com.charspan.employee.domain.Department;

/**
 * 部门管理的DAO层的实现类
 */
@Transactional
public class DepartmentDaoImpl extends HibernateDaoSupport implements
		DepartmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(
				criteria, begin, pageSize);
		return list;
	}

	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	// 根据部门编号查询部门信息
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}

}
