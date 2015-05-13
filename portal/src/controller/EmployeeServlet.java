package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeService empService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		empService = new EmployeeService();
		empService.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// HttpSession session = request.getSession(false);
		// if (session == null) {
		// request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(
		// request, response);
		// } else {
		String requestUri = request.getRequestURI();
		if (requestUri.endsWith("employees")) {
			getEmployees(request, response);
		}
		// }
	}

	private void getEmployees(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Employee> employees = empService.getEmployees();
		if (request.getHeader("Accept").equals("application/json")) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				response.getOutputStream().println(mapper.writeValueAsString(employees));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			request.setAttribute("employees", employees);

			request.getRequestDispatcher("WEB-INF/views/listEmployees.jsp")
					.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
