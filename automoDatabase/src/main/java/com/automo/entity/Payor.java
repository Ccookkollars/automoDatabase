package com.automo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PAYOR database table.
 * 
 */
@Entity
@Table(name="PAYOR")
@NamedQuery(name="Payor.findAll", query="SELECT p FROM Payor p")
public class Payor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="company_name", nullable=false, length=100)
	private String companyName;

	@Column(name="federal_id", nullable=false)
	private int federalId;

	//bi-directional many-to-one association to Claim
	@OneToMany(mappedBy="payor")
	private List<Claim> claims;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contact_id", nullable=false)
	private Contact contact;

	public Payor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getFederalId() {
		return this.federalId;
	}

	public void setFederalId(int federalId) {
		this.federalId = federalId;
	}

	public List<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Claim addClaim(Claim claim) {
		getClaims().add(claim);
		claim.setPayor(this);

		return claim;
	}

	public Claim removeClaim(Claim claim) {
		getClaims().remove(claim);
		claim.setPayor(null);

		return claim;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}