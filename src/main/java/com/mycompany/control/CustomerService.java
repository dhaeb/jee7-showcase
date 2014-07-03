package com.mycompany.control;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mycompany.entity.Customer;
import com.mycompany.entity.QCustomer;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;

@Stateless
@Local
public class CustomerService {

	@PersistenceContext
	private EntityManager entityManager;

	public void saveCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	public List<Customer> findQCustomers(String searchString) {
		String[] searchTerms = splitSearchString(searchString);
		QCustomer qCustomer = QCustomer.customer;
		JPAQuery query = new JPAQuery(entityManager);
		BooleanBuilder builder = new BooleanBuilder();
	    for (String term : searchTerms){
	        builder.or(qCustomer.firstName.eq(term));
	        builder.or(qCustomer.lastName.eq(term));
	    }		
		return query.from(qCustomer).where(builder).list(qCustomer);
	}

	public List<Customer> findAllCustomers() {
		TypedQuery<Customer> query = entityManager.createQuery(
				"SELECT e FROM Customer e", Customer.class);
		return query.getResultList();
	}

	public List<Customer> findAllQCustomers() {
		QCustomer qCustomer = QCustomer.customer;
		JPAQuery query = new JPAQuery(entityManager);
		return query.from(qCustomer).list(qCustomer);
	}

	public List<Customer> findCustomers() {
		TypedQuery<Customer> query = entityManager.createQuery(
				"SELECT e FROM Customer e", Customer.class);
		return (List<Customer>) query.getResultList();
	}

	public Customer findCustomerById(Long id) {
		return entityManager.find(Customer.class, id);
	}

	public void updateCustomer(Customer customer) {
		entityManager.merge(customer);
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

	public List<Customer> findCustomers(String searchString) {

		String[] searchTerms = splitSearchString(searchString);
		String queryString = "SELECT e FROM Customer e where ";

		int counter = 0;
		for (String searchTerm : searchTerms) {
			if (counter++ != 0) {
				queryString += "or ";
			}
			queryString += "e.firstName LIKE '" + searchTerm
					+ "' OR e.lastName LIKE '" + searchTerm + "' ";
		}

		TypedQuery<Customer> query = entityManager.createQuery(queryString,
				Customer.class);

		return query.getResultList();
	}

	public void deleteCustomer(Long id) {
		Customer customer = findCustomerById(id);
		if (customer != null) {
			entityManager.remove(customer);
		}
	}

}
