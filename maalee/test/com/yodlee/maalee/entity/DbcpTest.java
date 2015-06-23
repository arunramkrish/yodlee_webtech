package com.yodlee.maalee.entity;

import java.sql.Connection;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

public class DbcpTest {
	private static String connectURI = "jdbc:mysql://localhost/maalee";
	private static Connection conn;
	private static ConnectionFactory connectionFactory;
	private static ObjectPool connectionPool;
	private static PoolingDataSource dataSource;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionFactory = new DriverManagerConnectionFactory(connectURI,
					"root", "");
			connectionPool = new GenericObjectPool();
			new PoolableConnectionFactory(connectionFactory, connectionPool,
					null, null, false, true);
			dataSource = new PoolingDataSource(connectionPool);
			
			new DbcpTest().getConnection();

		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println(conn);
	}
	public void shutdownDatasource(DataSource ds) {
		try {
			BasicDataSource bds = (BasicDataSource) ds;
			bds.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public Connection getConnection() {
		try {
			conn = dataSource.getConnection();
			if (conn != null) {
				return conn;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}