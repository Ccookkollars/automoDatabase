/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Claim.findAll", query = "SELECT c FROM Claim c"),
    @NamedQuery(name = "Claim.findById", query = "SELECT c FROM Claim c WHERE c.id = :id"),
    @NamedQuery(name = "Claim.findByClaimNumber", query = "SELECT c FROM Claim c WHERE c.claimNumber = :claimNumber"),
    @NamedQuery(name = "Claim.findByClaimStatus", query = "SELECT c FROM Claim c WHERE c.claimStatus = :claimStatus"),
    @NamedQuery(name = "Claim.findByDateClaimIn", query = "SELECT c FROM Claim c WHERE c.dateClaimIn = :dateClaimIn"),
    @NamedQuery(name = "Claim.findByDateClaimOut", query = "SELECT c FROM Claim c WHERE c.dateClaimOut = :dateClaimOut"),
    @NamedQuery(name = "Claim.findByDateRentalCarStart", query = "SELECT c FROM Claim c WHERE c.dateRentalCarStart = :dateRentalCarStart"),
    @NamedQuery(name = "Claim.findByDateRentalCarEnd", query = "SELECT c FROM Claim c WHERE c.dateRentalCarEnd = :dateRentalCarEnd")})
public class Claim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "claim_number", nullable = false, length = 100)
    private String claimNumber;
    @Basic(optional = false)
    @Column(name = "claim_status", nullable = false, length = 100)
    private String claimStatus;
    @Basic(optional = false)
    @Column(name = "date_claim_in", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateClaimIn;
    @Basic(optional = false)
    @Column(name = "date_claim_out", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateClaimOut;
    @Column(name = "date_rental_car_start")
    @Temporal(TemporalType.DATE)
    private Date dateRentalCarStart;
    @Column(name = "date_rental_car_end")
    @Temporal(TemporalType.DATE)
    private Date dateRentalCarEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claimId")
    private Collection<Payment> paymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claimId")
    private Collection<ClaimLog> claimLogCollection;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Vehicle vehicleId;
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "payor_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Payor payorId;
    @JoinColumn(name = "insurance_contact_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Contact insuranceContactId;
    @JoinColumn(name = "appraiser_contact_id", referencedColumnName = "id")
    @ManyToOne
    private Contact appraiserContactId;

    public Claim() {
    }

    public Claim(Integer id) {
        this.id = id;
    }

    public Claim(Integer id, String claimNumber, String claimStatus, Date dateClaimIn, Date dateClaimOut) {
        this.id = id;
        this.claimNumber = claimNumber;
        this.claimStatus = claimStatus;
        this.dateClaimIn = dateClaimIn;
        this.dateClaimOut = dateClaimOut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Date getDateClaimIn() {
        return dateClaimIn;
    }

    public void setDateClaimIn(Date dateClaimIn) {
        this.dateClaimIn = dateClaimIn;
    }

    public Date getDateClaimOut() {
        return dateClaimOut;
    }

    public void setDateClaimOut(Date dateClaimOut) {
        this.dateClaimOut = dateClaimOut;
    }

    public Date getDateRentalCarStart() {
        return dateRentalCarStart;
    }

    public void setDateRentalCarStart(Date dateRentalCarStart) {
        this.dateRentalCarStart = dateRentalCarStart;
    }

    public Date getDateRentalCarEnd() {
        return dateRentalCarEnd;
    }

    public void setDateRentalCarEnd(Date dateRentalCarEnd) {
        this.dateRentalCarEnd = dateRentalCarEnd;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @XmlTransient
    public Collection<ClaimLog> getClaimLogCollection() {
        return claimLogCollection;
    }

    public void setClaimLogCollection(Collection<ClaimLog> claimLogCollection) {
        this.claimLogCollection = claimLogCollection;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Payor getPayorId() {
        return payorId;
    }

    public void setPayorId(Payor payorId) {
        this.payorId = payorId;
    }

    public Contact getInsuranceContactId() {
        return insuranceContactId;
    }

    public void setInsuranceContactId(Contact insuranceContactId) {
        this.insuranceContactId = insuranceContactId;
    }

    public Contact getAppraiserContactId() {
        return appraiserContactId;
    }

    public void setAppraiserContactId(Contact appraiserContactId) {
        this.appraiserContactId = appraiserContactId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Claim)) {
            return false;
        }
        Claim other = (Claim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.automo.entity.Claim[ id=" + id + " ]";
    }

}
