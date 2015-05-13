package com.yodlee.spring3tier.dao;

import java.util.ArrayList;
import java.util.List;

import com.yodlee.spring3tier.entity.Employee;

public class EmployeeInmemoryDao implements IEmployeeDao {
	private List<Employee> inmemoryCollection;

	@Override
	public void init() {
		inmemoryCollection = new ArrayList<Employee>();
	}
	
	public void add(Employee e) {
		inmemoryCollection.add(e);
	}
	
	@Override
	public List<Employee> get() {
		return inmemoryCollection;
	}

}
