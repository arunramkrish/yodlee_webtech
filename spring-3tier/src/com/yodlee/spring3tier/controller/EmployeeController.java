package com.yodlee.spring3tier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yodlee.spring3tier.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "addEmployee")
	public String showEmployeeForm() {
		return "employeeForm";
	}

	@RequestMapping(method = RequestMethod.GET, value = "employees")
	public String getEmployeesList() {
		System.out.println(employeeService.getEmployees());
		return "listEmployees";
	}

}
