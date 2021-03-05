package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CAR database table.
 * 
 */
@Entity
@Table(name="CAR")
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=100)
	private String vin;

	@Column(nullable=false, length=100)
	private String color;

	@Column(nullable=false, length=100)
	private String make;

	@Column(nullable=false, length=100)
	private String model;

	@Column(nullable=false, length=100)
	private String plate;

	@Column(length=100)
	private String status;

	public Car() {
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
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

}