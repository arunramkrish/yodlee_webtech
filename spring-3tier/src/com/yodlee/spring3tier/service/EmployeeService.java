package com.yodlee.spring3tier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yodlee.spring3tier.dao.IEmployeeDao;
import com.yodlee.spring3tier.entity.Employee;

@Component
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeDao empDao;

	public List<Employee> getEmployees() {
		return empDao.get();
	}

	public void addEmplyee(Employee emp) {
		empDao.add(emp);
	}

	public void setEmployeeDao(IEmployeeDao dao) {
		this.empDao = dao;
	}
}
