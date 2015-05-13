package dao;

public class DaoFactory {
	public IEmployeeDao getEmployeeDao(String type) {
		if ("jdbc".equals(type)) {
			return new EmployeeDao();
		} else {
			return new EmployeeInmemoryDao();
		}
	}
}
