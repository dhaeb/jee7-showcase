package com.mycompany.entity;

import javax.persistence.Entity;

@Entity
public class BusinessCustomer extends Customer {
	
	/**
	 * Number between 0 and 1 in the database. Should be 1.x to multiply it with prices effeciently. 
	 */
	private float discount;

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		if(discount < 0 || discount > 1){
			throw new IllegalArgumentException("The given discount was not valid!");
		}
		this.discount = discount + 1f;
	}
	
}
