package org.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "ordercode")
	private String orderCode;

	@Column(name = "destinationfrom")
	private String destinationFrom;

	@Column(name = "destinationto")
	private String destinationTo;

	@Column(name = "datefrom")
	@Temporal(TemporalType.DATE)
	private Date dateFrom;

	@Column(name = "dateto")
	@Temporal(TemporalType.DATE)
	private Date dateTo;

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

	public Orders(long id, String orderCode, String destinationFrom, String destinationTo, Date dateFrom, Date dateTo,
			double price, boolean delivered, String driverName, String supplierName) {
		super();
		this.id = id;
		this.orderCode = orderCode;
		this.destinationFrom = destinationFrom;
		this.destinationTo = destinationTo;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
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

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

}
