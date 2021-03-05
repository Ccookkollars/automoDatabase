package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PAYMENT database table.
 * 
 */
@Entity
@Table(name="PAYMENT")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, precision=10, scale=4)
	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name="date_cashed", nullable=false)
	private Date dateCashed;

	@Temporal(TemporalType.DATE)
	@Column(name="date_payed", nullable=false)
	private Date datePayed;

	@Temporal(TemporalType.DATE)
	@Column(name="date_quoted", nullable=false)
	private Date dateQuoted;

	@Column(name="payment_status", nullable=false, length=100)
	private String paymentStatus;

	@Column(name="payment_type", nullable=false, length=100)
	private String paymentType;

	//bi-directional many-to-one association to Claim
	@ManyToOne
	@JoinColumn(name="claim_id", nullable=false)
	private Claim claim;

	public Payment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDateCashed() {
		return this.dateCashed;
	}

	public void setDateCashed(Date dateCashed) {
		this.dateCashed = dateCashed;
	}

	public Date getDatePayed() {
		return this.datePayed;
	}

	public void setDatePayed(Date datePayed) {
		this.datePayed = datePayed;
	}

	public Date getDateQuoted() {
		return this.dateQuoted;
	}

	public void setDateQuoted(Date dateQuoted) {
		this.dateQuoted = dateQuoted;
	}

	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Claim getClaim() {
		return this.claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

}