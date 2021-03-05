package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VEHICLE database table.
 * 
 */
@Entity
@Table(name="VEHICLE")
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String color;

	@Column(nullable=false, length=100)
	private String make;

	@Column(nullable=false, length=100)
	private String model;

	@Column(nullable=false, length=100)
	private String plate;

	@Column(nullable=false, length=100)
	private String status;

	@Column(length=100)
	private String vin;

	@Column(name="year_manufactured", nullable=false)
	private int yearManufactured;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="vehicle")
	private List<Customer> customers;

	//bi-directional many-to-one association to JobOrder
	@OneToMany(mappedBy="vehicle")
	private List<JobOrder> jobOrders;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="primary_customer_id")
	private Customer customer;

	public Vehicle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return this.plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getYearManufactured() {
		return this.yearManufactured;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setVehicle(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setVehicle(null);

		return customer;
	}

	public List<JobOrder> getJobOrders() {
		return this.jobOrders;
	}

	public void setJobOrders(List<JobOrder> jobOrders) {
		this.jobOrders = jobOrders;
	}

	public JobOrder addJobOrder(JobOrder jobOrder) {
		getJobOrders().add(jobOrder);
		jobOrder.setVehicle(this);

		return jobOrder;
	}

	public JobOrder removeJobOrder(JobOrder jobOrder) {
		getJobOrders().remove(jobOrder);
		jobOrder.setVehicle(null);

		return jobOrder;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}