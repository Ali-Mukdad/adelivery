package org.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "orderid")
	private String orderId;

	@Column(name = "ordercode")
	private String orderCode;

	@Column(name = "destinationfrom")
	private String destinationFrom;

	@Column(name = "destinationto")
	private String destinationTo;

	@Column(name = "price")
	private double price;

	@Column(name = "delivered")
	private boolean delivered;

	@Column(name = "drivername")
	private String driverName;

	@Column(name = "suppliername")
	private String supplierName;

	public Orders() {
		super();
	}

	public Orders(long id, String orderId, String orderCode, String destinationFrom, String destinationTo, double price,
			boolean delivered, String driverName, String supplierName) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.orderCode = orderCode;
		this.destinationFrom = destinationFrom;
		this.destinationTo = destinationTo;
		this.price = price;
		this.delivered = delivered;
		this.driverName = driverName;
		this.supplierName = supplierName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getDestinationFrom() {
		return destinationFrom;
	}

	public void setDestinationFrom(String destinationFrom) {
		this.destinationFrom = destinationFrom;
	}

	public String getDestinationTo() {
		return destinationTo;
	}

	public void setDestinationTo(String destinationTo) {
		this.destinationTo = destinationTo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
}
