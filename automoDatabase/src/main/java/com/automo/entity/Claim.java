package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CLAIM database table.
 * 
 */
@Entity
@Table(name="CLAIM")
@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_claim_in", nullable=false)
	private Date dateClaimIn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_claim_out", nullable=false)
	private Date dateClaimOut;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_rental_car_end")
	private Date dateRentalCarEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_rental_car_start")
	private Date dateRentalCarStart;

	//bi-directional many-to-one association to Payor
	@ManyToOne
	@JoinColumn(name="payor_id", nullable=false)
	private Payor payor;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="insurance_contact_id", nullable=false)
	private Contact contact1;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="appraiser_contact_id")
	private Contact contact2;

	//bi-directional many-to-one association to ClaimLog
	@OneToMany(mappedBy="claim")
	private List<ClaimLog> claimLogs;

	//bi-directional many-to-one association to JobOrder
	@OneToMany(mappedBy="claim")
	private List<JobOrder> jobOrders;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="claim")
	private List<Payment> payments;

	public Claim() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateClaimIn() {
		return this.dateClaimIn;
	}

	public void setDateClaimIn(Date dateClaimIn) {
		this.dateClaimIn = dateClaimIn;
	}

	public Date getDateClaimOut() {
		return this.dateClaimOut;
	}

	public void setDateClaimOut(Date dateClaimOut) {
		this.dateClaimOut = dateClaimOut;
	}

	public Date getDateRentalCarEnd() {
		return this.dateRentalCarEnd;
	}

	public void setDateRentalCarEnd(Date dateRentalCarEnd) {
		this.dateRentalCarEnd = dateRentalCarEnd;
	}

	public Date getDateRentalCarStart() {
		return this.dateRentalCarStart;
	}

	public void setDateRentalCarStart(Date dateRentalCarStart) {
		this.dateRentalCarStart = dateRentalCarStart;
	}

	public Payor getPayor() {
		return this.payor;
	}

	public void setPayor(Payor payor) {
		this.payor = payor;
	}

	public Contact getContact1() {
		return this.contact1;
	}

	public void setContact1(Contact contact1) {
		this.contact1 = contact1;
	}

	public Contact getContact2() {
		return this.contact2;
	}

	public void setContact2(Contact contact2) {
		this.contact2 = contact2;
	}

	public List<ClaimLog> getClaimLogs() {
		return this.claimLogs;
	}

	public void setClaimLogs(List<ClaimLog> claimLogs) {
		this.claimLogs = claimLogs;
	}

	public ClaimLog addClaimLog(ClaimLog claimLog) {
		getClaimLogs().add(claimLog);
		claimLog.setClaim(this);

		return claimLog;
	}

	public ClaimLog removeClaimLog(ClaimLog claimLog) {
		getClaimLogs().remove(claimLog);
		claimLog.setClaim(null);

		return claimLog;
	}

	public List<JobOrder> getJobOrders() {
		return this.jobOrders;
	}

	public void setJobOrders(List<JobOrder> jobOrders) {
		this.jobOrders = jobOrders;
	}

	public JobOrder addJobOrder(JobOrder jobOrder) {
		getJobOrders().add(jobOrder);
		jobOrder.setClaim(this);

		return jobOrder;
	}

	public JobOrder removeJobOrder(JobOrder jobOrder) {
		getJobOrders().remove(jobOrder);
		jobOrder.setClaim(null);

		return jobOrder;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setClaim(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setClaim(null);

		return payment;
	}

}