package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Employee;

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
