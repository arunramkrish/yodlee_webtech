package com.yodlee.training.ws.hello;

import java.io.StringWriter;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

@WebService(endpointInterface = "com.yodlee.training.ws.hello.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	@Override
	public String getMessage(String name) {
		return "Hello World JAX-WS " + name;
	}

	@Override
	public void createEmployee(Employee emp) {
		System.out.println("Employee obtained " + emp);
		
	}
	
	public static void main(String[] args) {
		Employee emp = new Employee(1,"a","e","d");
		try {
			JAXBContext context = JAXBContext.newInstance("com.yodlee.training.ws.hello");
			Marshaller marshaller = context.createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.marshal(new JAXBElement<Employee>(new QName("Emp"), Employee.class, emp), writer);
			
			System.out.println(writer.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}