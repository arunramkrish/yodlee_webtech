package com.yodlee.spring3tier.service;

import java.util.List;

import com.yodlee.spring3tier.entity.Employee;

public interface IEmployeeService {
	public List<Employee> getEmployees();

	public void addEmplyee(Employee emp);
}
