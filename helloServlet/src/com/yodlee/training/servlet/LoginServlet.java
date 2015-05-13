package com.yodlee.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if ((password != null) && (!"".equals(password))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userName);
			request.getRequestDispatcher("WEB-INF/views/mypage.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Invalid credentials");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
