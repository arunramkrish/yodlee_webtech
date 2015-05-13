package com.yodlee.training.ws.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface HelloWorld {
	@WebMethod
	String getMessage(String name);
	
	@WebMethod
	void createEmployee(Employee emp);
}
