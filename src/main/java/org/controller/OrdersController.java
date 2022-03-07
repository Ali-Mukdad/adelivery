package org.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.facade.OrderFacade;
import org.model.Orders;
import org.omnifaces.cdi.ViewScoped;

@Named
@ViewScoped
public class OrdersController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private OrderFacade orderFacade;

	private List<Orders> orders = new ArrayList<>();
	private double totalPrices = 0;
	private int totalNbOfOrders = 0;
	private int nbOfOrdersToday = 0;
	private int nbOfOrdersDone = 0;

	@PostConstruct
	public void init() {
		orders = orderFacade.findAll();
		totalNbOfOrders = orders.size() > 0 ? orders.size() : 0;
		orders.stream().forEach(order -> totalPrices += order.getPrice());
	}

	public OrderFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public double getTotalPrices() {
		return totalPrices;
	}

	public void setTotalPrices(double totalPrices) {
		this.totalPrices = totalPrices;
	}

	public int getTotalNbOfOrders() {
		return totalNbOfOrders;
	}

	public void setTotalNbOfOrders(int totalNbOfOrders) {
		this.totalNbOfOrders = totalNbOfOrders;
	}

	public int getNbOfOrdersToday() {
		return nbOfOrdersToday;
	}

	public void setNbOfOrdersToday(int nbOfOrdersToday) {
		this.nbOfOrdersToday = nbOfOrdersToday;
	}

	public int getNbOfOrdersDone() {
		return nbOfOrdersDone;
	}

	public void setNbOfOrdersDone(int nbOfOrdersDone) {
		this.nbOfOrdersDone = nbOfOrdersDone;
	}

}
