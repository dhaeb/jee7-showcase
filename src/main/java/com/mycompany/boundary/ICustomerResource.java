package com.mycompany.boundary;

import java.net.URISyntaxException;

import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.mycompany.entity.Customer;

@Path("/customer")
@Stateless
public interface ICustomerResource {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public abstract Response sayHello();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public abstract Response findCustomers(
			@QueryParam("searchString") String searchString,
			@QueryParam("name") String name);

	@POST
	public abstract Response saveCustomer(@Context UriInfo uriInfo,
			Customer customer) throws URISyntaxException;

	@GET
	@Path("/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public abstract Response findCustomerById(
			@PathParam(value = "customerId") String customerId);

	@PUT
	@Path("/{customerId}")
	public abstract Response updateCustomer(Customer customer);

	@DELETE
	@Path("/{customerId}")
	public abstract Response deleteCustomer(
			@PathParam("customerId") Long customerId);

}