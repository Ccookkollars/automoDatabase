package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="CUSTOMER")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="primary_vehicle_id", nullable=false)
	private Vehicle vehicle;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contact_id", nullable=false)
	private Contact contact;

	//bi-directional many-to-one association to JobOrder
	@OneToMany(mappedBy="customer")
	private List<JobOrder> jobOrders;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="customer")
	private List<Vehicle> vehicles;

	public Customer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<JobOrder> getJobOrders() {
		return this.jobOrders;
	}

	public void setJobOrders(List<JobOrder> jobOrders) {
		this.jobOrders = jobOrders;
	}

	public JobOrder addJobOrder(JobOrder jobOrder) {
		getJobOrders().add(jobOrder);
		jobOrder.setCustomer(this);

		return jobOrder;
	}

	public JobOrder removeJobOrder(JobOrder jobOrder) {
		getJobOrders().remove(jobOrder);
		jobOrder.setCustomer(null);

		return jobOrder;
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setCustomer(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setCustomer(null);

		return vehicle;
	}

}