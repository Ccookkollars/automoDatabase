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
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id"),
    @NamedQuery(name = "Vehicle.findByMake", query = "SELECT v FROM Vehicle v WHERE v.make = :make"),
    @NamedQuery(name = "Vehicle.findByModel", query = "SELECT v FROM Vehicle v WHERE v.model = :model"),
    @NamedQuery(name = "Vehicle.findByYearManufactured", query = "SELECT v FROM Vehicle v WHERE v.yearManufactured = :yearManufactured"),
    @NamedQuery(name = "Vehicle.findByColor", query = "SELECT v FROM Vehicle v WHERE v.color = :color"),
    @NamedQuery(name = "Vehicle.findByVin", query = "SELECT v FROM Vehicle v WHERE v.vin = :vin"),
    @NamedQuery(name = "Vehicle.findByPlate", query = "SELECT v FROM Vehicle v WHERE v.plate = :plate")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String make;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String model;
    @Basic(optional = false)
    @Column(name = "year_manufactured", nullable = false)
    private short yearManufactured;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String color;
    @Column(length = 100)
    private String vin;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String plate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<Claim> claimCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryVehicleId")
    private Collection<Customer> customerCollection;
    @JoinColumn(name = "primary_customer_id", referencedColumnName = "id")
    @ManyToOne
    private Customer primaryCustomerId;

    public Vehicle() {
    }

    public Vehicle(Integer id) {
        this.id = id;
    }

    public Vehicle(Integer id, String make, String model, short yearManufactured, String color, String plate) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearManufactured = yearManufactured;
        this.color = color;
        this.plate = plate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(short yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @XmlTransient
    public Collection<Claim> getClaimCollection() {
        return claimCollection;
    }

    public void setClaimCollection(Collection<Claim> claimCollection) {
        this.claimCollection = claimCollection;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public Customer getPrimaryCustomerId() {
        return primaryCustomerId;
    }

    public void setPrimaryCustomerId(Customer primaryCustomerId) {
        this.primaryCustomerId = primaryCustomerId;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.automo.entity.Vehicle[ id=" + id + " ]";
    }

}
