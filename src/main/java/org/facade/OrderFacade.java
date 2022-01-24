package org.facade;

import java.io.Serializable;

import org.model.Order;

public class OrderFacade extends AbstractFacade<Order> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderFacade() {
		super(Order.class);
	}

}
