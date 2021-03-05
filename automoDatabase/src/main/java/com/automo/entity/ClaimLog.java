package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CLAIM_LOG database table.
 * 
 */
@Entity
@Table(name="CLAIM_LOG")
@NamedQuery(name="ClaimLog.findAll", query="SELECT c FROM ClaimLog c")
public class ClaimLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String note;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date timestamp;

	//bi-directional many-to-one association to Claim
	@ManyToOne
	@JoinColumn(name="claim_id", nullable=false)
	private Claim claim;

	public ClaimLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Claim getClaim() {
		return this.claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

}