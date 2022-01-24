package org.model;

import javax.persistence.Entity;

@Entity
public class Supplier extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Supplier() {
		super();
	}

	public Supplier(long id, String firstName, String middleName, String lastName) {
		super(id, firstName, middleName, lastName);
	}
	
}
