package com.mycompany.control;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.entity.GasProduct;
import com.mycompany.entity.Product;
import com.mycompany.entity.QGasProduct;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;

@Stateless
@Local
public class GasProductService {

	@PersistenceContext
	private EntityManager entityManager;

	public void saveCustomer(Product product) {
		entityManager.persist(product);
	}

	public List<GasProduct> findGasProducts() {
		QGasProduct qProduct = QGasProduct.gasProduct;
		JPAQuery query = new JPAQuery(entityManager);
		return query.from(qProduct).list(qProduct);
	}

	public GasProduct findGasProductById(Long id) {
		return entityManager.find(GasProduct.class, id);
	}

	public void updateGasProduct(GasProduct gasProduct) {
		entityManager.merge(gasProduct);
	}
	
	public List<GasProduct> findGasProduct(String searchString) {
		String[] searchTerms = splitSearchString(searchString);
		QGasProduct qProduct = QGasProduct.gasProduct;
		JPAQuery query = new JPAQuery(entityManager);
		BooleanBuilder builder = new BooleanBuilder();
	    for (String term : searchTerms){
	        builder.or(qProduct.name.eq(term));
	    }		
		return query.from(qProduct).where(builder).list(qProduct);
	}

	private String[] splitSearchString(String searchString) {
		String[] searchTerms = new String[] { searchString };
		if (searchString.contains(", ")) {
			searchTerms = searchString.split(", ");
		} else if (searchString.contains("; ")) {
			searchTerms = searchString.split("; ");
		} else if (searchString.contains(",")) {
			searchTerms = searchString.split(",");
		} else if (searchString.contains(";")) {
			searchTerms = searchString.split(";");
		} else if (searchString.contains(" ")) {
			searchTerms = searchString.split(" ");
		}
		return searchTerms;
	}

	public void deleteGasProduct(Long id) {
		GasProduct gasProduct = findGasProductById(id);
		if (gasProduct != null) {
			entityManager.remove(gasProduct);
		}
	}

}
