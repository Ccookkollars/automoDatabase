/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payor.findAll", query = "SELECT p FROM Payor p"),
    @NamedQuery(name = "Payor.findById", query = "SELECT p FROM Payor p WHERE p.id = :id"),
    @NamedQuery(name = "Payor.findByCompanyName", query = "SELECT p FROM Payor p WHERE p.companyName = :companyName"),
    @NamedQuery(name = "Payor.findByFederalId", query = "SELECT p FROM Payor p WHERE p.federalId = :federalId")})
public class Payor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;
    @Basic(optional = false)
    @Column(name = "federal_id", nullable = false)
    private int federalId;
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Contact contactId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payorId")
    private Collection<Claim> claimCollection;

    public Payor() {
    }

    public Payor(Integer id) {
        this.id = id;
    }

    public Payor(Integer id, String companyName, int federalId) {
        this.id = id;
        this.companyName = companyName;
        this.federalId = federalId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getFederalId() {
        return federalId;
    }

    public void setFederalId(int federalId) {
        this.federalId = federalId;
    }

    public Contact getContactId() {
        return contactId;
    }

    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }

    @XmlTransient
    public Collection<Claim> getClaimCollection() {
        return claimCollection;
    }

    public void setClaimCollection(Collection<Claim> claimCollection) {
        this.claimCollection = claimCollection;
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
        if (!(object instanceof Payor)) {
            return false;
        }
        Payor other = (Payor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.automo.entity.Payor[ id=" + id + " ]";
    }

}
