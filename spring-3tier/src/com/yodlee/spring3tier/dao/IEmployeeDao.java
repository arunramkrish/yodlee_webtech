package com.yodlee.spring3tier.dao;

import java.util.List;

import com.yodlee.spring3tier.entity.Employee;

public interface IEmployeeDao {
	void init();

	List<Employee> get();
	
	void add(Employee emp);
}
