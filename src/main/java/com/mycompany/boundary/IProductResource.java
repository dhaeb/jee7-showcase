package com.mycompany.boundary;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.mycompany.entity.Product;

public interface IProductResource {
	
	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response createProduct(@Context UriInfo uriInfo,
			@MultipartForm Product product);

}
