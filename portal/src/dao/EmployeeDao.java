package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class EmployeeDao implements IEmployeeDao {
	static {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private Connection connection = null;

	public void init() {
		try {
//			connection = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/yodlee", "root", "");
			connection = DriverManager.getConnection(
					"jdbc:hsqldb:file:E:/Training/yodlee/yodleedb", "SA", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> get() {
		List<Employee> empList = new ArrayList<Employee>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
			while (rs.next()) {
				empList.add(getEmployee(rs));
			}
			return empList;
		} catch (SQLException e) {
			e.printStackTrace();
			return empList;
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		Employee emp = new Employee(rs.getInt("ID"), rs.getString("NAME"),
				rs.getInt("SALARY"));
		return emp;
	}
}
