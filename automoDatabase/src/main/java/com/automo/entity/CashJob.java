package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CASH_JOB database table.
 * 
 */
@Entity
@Table(name="CASH_JOB")
@NamedQuery(name="CashJob.findAll", query="SELECT c FROM CashJob c")
public class CashJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String description;

	//bi-directional many-to-one association to JobOrder
	@OneToMany(mappedBy="cashJob")
	private List<JobOrder> jobOrders;

	public CashJob() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<JobOrder> getJobOrders() {
		return this.jobOrders;
	}

	public void setJobOrders(List<JobOrder> jobOrders) {
		this.jobOrders = jobOrders;
	}

	public JobOrder addJobOrder(JobOrder jobOrder) {
		getJobOrders().add(jobOrder);
		jobOrder.setCashJob(this);

		return jobOrder;
	}

	public JobOrder removeJobOrder(JobOrder jobOrder) {
		getJobOrders().remove(jobOrder);
		jobOrder.setCashJob(null);

		return jobOrder;
	}

}