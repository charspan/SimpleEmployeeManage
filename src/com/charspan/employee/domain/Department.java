package com.charspan.employee.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门的实体
 */
public class Department {
	/**
	 * 部门编号
	 */
	private Integer did;
	/**
	 * 部门名称
	 */
	private String dname;
	/**
	 * 部门描述
	 */
	private String ddesc;

	/**
	 * 部门的员工集合
	 */
	private Set<Employee> emplyoees = new HashSet<Employee>();

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdesc() {
		return ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

	public Set<Employee> getEmplyoees() {
		return emplyoees;
	}

	public void setEmplyoees(Set<Employee> emplyoees) {
		this.emplyoees = emplyoees;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", ddesc="
				+ ddesc + ", emplyoees=" + emplyoees + "]";
	}

}
