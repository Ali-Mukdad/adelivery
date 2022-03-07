package org.facade;

import java.io.Serializable;

import org.model.Orders;

public class OrderFacade extends AbstractFacade<Orders> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderFacade() {
		super(Orders.class);
	}

}
