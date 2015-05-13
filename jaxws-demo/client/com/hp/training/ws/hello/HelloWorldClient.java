package com.hp.training.ws.hello;

import com.yodlee.training.ws.hello.Employee;


public class HelloWorldClient {
	public static void main(String[] args) {
		HelloWorldImplService helloWorld = new HelloWorldImplService();
		System.out.println(helloWorld.getHelloWorldImplPort().getMessage("Arun"));
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Client");
		helloWorld.getHelloWorldImplPort().createEmployee(emp);
	}
}
