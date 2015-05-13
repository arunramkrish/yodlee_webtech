package com.yodlee.training.web.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/hi")
public class HelloJax {
	@GET
	public Response getMessage(@QueryParam("name") String name) {
		Employee e = new Employee();
		e.setName(name);
		return Response.status(200).entity(e).build();
	}
}
