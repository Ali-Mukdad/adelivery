package org.model;

import javax.persistence.Entity;

@Entity
public class Driver extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Driver() {
		super();
	}

	public Driver(long id, String firstName, String middleName, String lastName) {
		super(id, firstName, middleName, lastName);
	}
	
	

}
