package com.yodlee.maalee.dao.jdbc;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yodlee.maalee.entity.User;

public class UserDaoTest {
	private static UserDao userDao = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDao = new UserDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		User user = new User("arun@gmail", "564345", "pass", new Date(), "Arunkumar K");
		userDao.create(user);
	}

}
