package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the JOB_ORDER database table.
 * 
 */
@Entity
@Table(name="JOB_ORDER")
@NamedQuery(name="JobOrder.findAll", query="SELECT j FROM JobOrder j")
public class JobOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_order_in", nullable=false)
	private Date dateOrderIn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_order_out")
	private Date dateOrderOut;

	@Column(name="order_status", length=100)
	private String orderStatus;

	//bi-directional many-to-one association to Claim
	@ManyToOne
	@JoinColumn(name="claim_id")
	private Claim claim;

	//bi-directional many-to-one association to CashJob
	@ManyToOne
	@JoinColumn(name="cash_id")
	private CashJob cashJob;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public JobOrder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOrderIn() {
		return this.dateOrderIn;
	}

	public void setDateOrderIn(Date dateOrderIn) {
		this.dateOrderIn = dateOrderIn;
	}

	public Date getDateOrderOut() {
		return this.dateOrderOut;
	}

	public void setDateOrderOut(Date dateOrderOut) {
		this.dateOrderOut = dateOrderOut;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Claim getClaim() {
		return this.claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public CashJob getCashJob() {
		return this.cashJob;
	}

	public void setCashJob(CashJob cashJob) {
		this.cashJob = cashJob;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}