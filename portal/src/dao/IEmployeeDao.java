package dao;

import java.util.List;

import entity.Employee;

public interface IEmployeeDao {
	void init();

	List<Employee> get();
}
