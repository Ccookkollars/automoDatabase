/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findById", query = "SELECT p FROM Payment p WHERE p.id = :id"),
    @NamedQuery(name = "Payment.findByPaymentStatus", query = "SELECT p FROM Payment p WHERE p.paymentStatus = :paymentStatus"),
    @NamedQuery(name = "Payment.findByPaymentType", query = "SELECT p FROM Payment p WHERE p.paymentType = :paymentType"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM Payment p WHERE p.amount = :amount"),
    @NamedQuery(name = "Payment.findByDateQuoted", query = "SELECT p FROM Payment p WHERE p.dateQuoted = :dateQuoted"),
    @NamedQuery(name = "Payment.findByDatePayed", query = "SELECT p FROM Payment p WHERE p.datePayed = :datePayed"),
    @NamedQuery(name = "Payment.findByDateCashed", query = "SELECT p FROM Payment p WHERE p.dateCashed = :dateCashed")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "payment_status", nullable = false, length = 100)
    private String paymentStatus;
    @Basic(optional = false)
    @Column(name = "payment_type", nullable = false, length = 100)
    private String paymentType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 13, scale = 4)
    private BigDecimal amount;
    @Basic(optional = false)
    @Column(name = "date_quoted", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateQuoted;
    @Basic(optional = false)
    @Column(name = "date_payed", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePayed;
    @Basic(optional = false)
    @Column(name = "date_cashed", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCashed;
    @JoinColumn(name = "claim_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Claim claimId;

    public Payment() {
    }

    public Payment(Integer id) {
        this.id = id;
    }

    public Payment(Integer id, String paymentStatus, String paymentType, BigDecimal amount, Date dateQuoted, Date datePayed, Date dateCashed) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.paymentType = paymentType;
        this.amount = amount;
        this.dateQuoted = dateQuoted;
        this.datePayed = datePayed;
        this.dateCashed = dateCashed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDateQuoted() {
        return dateQuoted;
    }

    public void setDateQuoted(Date dateQuoted) {
        this.dateQuoted = dateQuoted;
    }

    public Date getDatePayed() {
        return datePayed;
    }

    public void setDatePayed(Date datePayed) {
        this.datePayed = datePayed;
    }

    public Date getDateCashed() {
        return dateCashed;
    }

    public void setDateCashed(Date dateCashed) {
        this.dateCashed = dateCashed;
    }

    public Claim getClaimId() {
        return claimId;
    }

    public void setClaimId(Claim claimId) {
        this.claimId = claimId;
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
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.automo.entity.Payment[ id=" + id + " ]";
    }

}
