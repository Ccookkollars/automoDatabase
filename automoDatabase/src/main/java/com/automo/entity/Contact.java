package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CONTACT database table.
 * 
 */
@Entity
@Table(name="CONTACT")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="email_address", length=100)
	private String emailAddress;

	@Column(name="first_name", nullable=false, length=100)
	private String firstName;

	@Column(name="last_name", nullable=false, length=100)
	private String lastName;

	@Column(name="phone_number", nullable=false, length=100)
	private String phoneNumber;

	@Column(name="street_address", length=100)
	private String streetAddress;

	//bi-directional many-to-one association to Claim
	@OneToMany(mappedBy="contact1")
	private List<Claim> claims1;

	//bi-directional many-to-one association to Claim
	@OneToMany(mappedBy="contact2")
	private List<Claim> claims2;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="contact")
	private List<Customer> customers;

	//bi-directional many-to-one association to Payor
	@OneToMany(mappedBy="contact")
	private List<Payor> payors;

	public Contact() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public List<Claim> getClaims1() {
		return this.claims1;
	}

	public void setClaims1(List<Claim> claims1) {
		this.claims1 = claims1;
	}

	public Claim addClaims1(Claim claims1) {
		getClaims1().add(claims1);
		claims1.setContact1(this);

		return claims1;
	}

	public Claim removeClaims1(Claim claims1) {
		getClaims1().remove(claims1);
		claims1.setContact1(null);

		return claims1;
	}

	public List<Claim> getClaims2() {
		return this.claims2;
	}

	public void setClaims2(List<Claim> claims2) {
		this.claims2 = claims2;
	}

	public Claim addClaims2(Claim claims2) {
		getClaims2().add(claims2);
		claims2.setContact2(this);

		return claims2;
	}

	public Claim removeClaims2(Claim claims2) {
		getClaims2().remove(claims2);
		claims2.setContact2(null);

		return claims2;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setContact(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setContact(null);

		return customer;
	}

	public List<Payor> getPayors() {
		return this.payors;
	}

	public void setPayors(List<Payor> payors) {
		this.payors = payors;
	}

	public Payor addPayor(Payor payor) {
		getPayors().add(payor);
		payor.setContact(this);

		return payor;
	}

	public Payor removePayor(Payor payor) {
		getPayors().remove(payor);
		payor.setContact(null);

		return payor;
	}

}