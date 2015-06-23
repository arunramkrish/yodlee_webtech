package com.yodlee.maalee.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yodlee.maalee.entity.User;

public class UserDao {
	public User create(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseUtil.getConnection();
			
			stmt = conn.prepareStatement("insert into users (email_id, password, name, phone_number, date_registered) "
					+ " values (?, ?, ?, ?, ?)");
			
			//set params
			stmt.setString(1, user.getEmailId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setDate(5, new java.sql.Date(user.getDateRegistered().getTime()));
			
			//execute
			stmt.executeUpdate();
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.releaseResources(conn, stmt, null);
		}
		return user;
	}
}
