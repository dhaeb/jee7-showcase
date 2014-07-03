package com.mycompany.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.mycompany.entity.Product;

public class ProductResource implements IProductResource{
	
	@Override
	public Response createProduct(UriInfo uriInfo, Product product) {
 
		// TODO: Save picture to the database 
		return Response.status(200)
		    .entity("Produkt wurde erfolgreich gespeichert.").build();
 
	}
}
