package com.mycompany.boundary;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.mycompany.control.CustomerService;
import com.mycompany.entity.Customer;

public class CustomerResource implements ICustomerResource {

	@EJB
	private CustomerService customerService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mycompany.boundary.ICustomerService#findCustomers(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Response findCustomers(String searchString) {
		List<Customer> customers;
		if (searchString != null) {
			customers = customerService.findCustomers(searchString);
		} else {
			customers = customerService.findAllCustomers();
		}
		return Response.ok(customers).build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mycompany.boundary.ICustomerService#saveCustomer(javax.ws.rs.core
	 * .UriInfo, com.mycompany.entity.Customer)
	 */
	@Override
	public Response saveCustomer(UriInfo uriInfo, Customer customer) throws URISyntaxException {
		customerService.saveCustomer(customer);
		return Response.created(
				new URI(uriInfo.getRequestUri() + "/" + customer.getId()))
				.build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mycompany.boundary.ICustomerService#findCustomerById(java.lang.String
	 * )
	 */
	@Override
	public Response findCustomerById(String customerId) {
		Customer customer = customerService.findCustomerById(Long
				.parseLong(customerId));

		if (customer != null) {
			return Response.ok().entity(customer).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mycompany.boundary.ICustomerService#updateCustomer(com.mycompany.
	 * entity.Customer)
	 */
	@Override
	public Response updateCustomer(Customer customer) {
		customerService.updateCustomer(customer);
		return Response.status(Status.ACCEPTED).build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mycompany.boundary.ICustomerService#deleteCustomer(java.lang.Long)
	 */
	@Override
	public Response deleteCustomer(Long customerId) {
		customerService.deleteCustomer(customerId);
		return Response.ok().build();
	}

}