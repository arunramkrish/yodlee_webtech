package service;

import java.util.List;

import dao.DaoFactory;
import dao.IEmployeeDao;
import entity.Employee;

public class EmployeeService {
	private IEmployeeDao empDao;
	
	public void init() {
		empDao = new DaoFactory().getEmployeeDao("jdbc");
		empDao.init();
	}
	
	public List<Employee> getEmployees() {
		return empDao.get();
	}
	
	public void setEmployeeDao(IEmployeeDao dao) {
		this.empDao = dao;
	}
}
