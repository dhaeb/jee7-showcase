package com.mycompany.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.mycompany.entity.Product;

public class ProductResource implements IProductResource{
	
	@Override
	public Response saveProduct(UriInfo uriInfo, Product product) {
 
		// TODO: Save picture to the database 
		return Response.status(200)
		    .entity("Produkt wurde erfolgreich gespeichert.").build();
 
	}

	@Override
	public Response findProductById(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response findProducts(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
