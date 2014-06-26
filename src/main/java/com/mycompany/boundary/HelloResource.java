package com.mycompany.boundary;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
@Stateless
public class HelloResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello(){
		return "hello world!";
	}
}
