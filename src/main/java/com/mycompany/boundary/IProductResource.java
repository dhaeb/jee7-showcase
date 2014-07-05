package com.mycompany.boundary;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.mycompany.entity.Product;
@Path("/product")
@Stateless
public interface IProductResource {
	
	@POST
	@Path("/save")
	@Consumes("multipart/form-data")
	public Response saveProduct(@Context UriInfo uriInfo,
			@MultipartForm Product product);
	
	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	Response findProductById(@PathParam(value = "productId") String productId);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	Response findProducts(@QueryParam("searchString") String searchString);
	
	@DELETE
	@Path("/{productId}")
	Response deleteProduct(@PathParam("productId") Long productId);
	

}
