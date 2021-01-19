/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
@Entity
@Table(name = "CLAIM_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaimLog.findAll", query = "SELECT c FROM ClaimLog c"),
    @NamedQuery(name = "ClaimLog.findById", query = "SELECT c FROM ClaimLog c WHERE c.id = :id"),
    @NamedQuery(name = "ClaimLog.findByTimestamp", query = "SELECT c FROM ClaimLog c WHERE c.timestamp = :timestamp"),
    @NamedQuery(name = "ClaimLog.findByNote", query = "SELECT c FROM ClaimLog c WHERE c.note = :note")})
public class ClaimLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "claim_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Claim claimId;

    public ClaimLog() {
    }

    public ClaimLog(Integer id) {
        this.id = id;
    }

    public ClaimLog(Integer id, Date timestamp, String note) {
        this.id = id;
        this.timestamp = timestamp;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        if (!(object instanceof ClaimLog)) {
            return false;
        }
        ClaimLog other = (ClaimLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.automo.entity.ClaimLog[ id=" + id + " ]";
    }

}
