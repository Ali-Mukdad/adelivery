package org.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	private Orders order;

	@PostConstruct
	public void init() {
		order = new Orders();
		orders = orderFacade.findAll();
		totalNbOfOrders = orders.size() > 0 ? orders.size() : 0;
		Date today = new Date();
		SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate = d1.format(today);
		orders.stream().forEach(order -> {
			totalPrices += order.getPrice();
			SimpleDateFormat d2 = new SimpleDateFormat("dd/MM/yyyy");
			String orderDate = d2.format(order.getDateFrom());
			if (orderDate.equals(stringDate)) {
				nbOfOrdersToday += 1;
			}

			if (order.isDelivered()) {
				nbOfOrdersDone += 1;
			}
		});
	}
	
	public boolean validateOrder(Orders order) {
		
		if(order.getOrderCode() == null || order.getOrderCode().isEmpty()) {
			return false;
		}else if(order.getDateFrom() == null || order.getDateFrom().toString().isEmpty()) {
			return false;
		}
		
		return true;
	}

	public void addOrder() {
		try {
			if(!validateOrder(order)) {
				return;
			}
			orderFacade.save(order);
			order = new Orders();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Added the order Succefully", "success"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error in adding order", "error"));
		}
	}

	public void updateOrder(Orders updatedOrder) {
		try {
			orderFacade.save(updatedOrder);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Updated order Succefully", "success"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteOrder() {
		try {
			Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = params.get("toDelete");
			orderFacade.remove(orderFacade.find(id));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deleting error", "error"));
		}
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

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

}
