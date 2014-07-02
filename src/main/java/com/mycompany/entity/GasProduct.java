package com.mycompany.entity;

import javax.persistence.Entity;

@Entity
public class GasProduct extends Product {

	private double volumne; 
	
	public GasProduct() {}

	public double getVolumne() {
		return volumne;
	}

	public void setVolumne(double volumne) {
		this.volumne = volumne;
	}
	
}
