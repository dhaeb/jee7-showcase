package com.mycompany.entity;

import javax.persistence.Entity;

@Entity
public class PrivateCustomer extends Customer {

	private boolean hasBonusCard;

	public boolean isHasBonusCard() {
		return hasBonusCard;
	}

	public void setHasBonusCard(boolean hasBonusCard) {
		this.hasBonusCard = hasBonusCard;
	}
	
}
