package com.yodlee.spring3tier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yodlee.spring3tier.entity.Employee;

public class EmployeeDao implements IEmployeeDao {
	private String driver = "";
	private String url = "";
	private String user = "";
	private String password = "";

	private Connection connection = null;

	public void init() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public void add(Employee emp) {
		// TODO Auto-generated method stub

	}
}
