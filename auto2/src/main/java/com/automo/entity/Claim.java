/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class Claim implements Serializable{
    private Integer id;
    private String claimStatus;
    private Integer vehicleId;
    private Integer customerId;
    private Integer payorId;
    private Integer insuranceContactId;
    private Integer appraiserContactId;
    private LocalDate dateClaimIn;
    private LocalDate dateClaimOut;
    private LocalDate dateRentalCarStart;
    private LocalDate dateRentalCarEnd;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getPayorId() {
        return payorId;
    }

    public void setPayorId(Integer payorId) {
        this.payorId = payorId;
    }

    public Integer getInsuranceContactId() {
        return insuranceContactId;
    }

    public void setInsuranceContactId(Integer insuranceContactId) {
        this.insuranceContactId = insuranceContactId;
    }

    public Integer getAppraiserContactId() {
        return appraiserContactId;
    }

    public void setAppraiserContactId(Integer appraiserContactId) {
        this.appraiserContactId = appraiserContactId;
    }

    public LocalDate getDateClaimIn() {
        return dateClaimIn;
    }

    public void setDateClaimIn(LocalDate dateClaimIn) {
        this.dateClaimIn = dateClaimIn;
    }

    public LocalDate getDateClaimOut() {
        return dateClaimOut;
    }

    public void setDateClaimOut(LocalDate dateClaimOut) {
        this.dateClaimOut = dateClaimOut;
    }

    public LocalDate getDateRentalCarStart() {
        return dateRentalCarStart;
    }

    public void setDateRentalCarStart(LocalDate dateRentalCarStart) {
        this.dateRentalCarStart = dateRentalCarStart;
    }

    public LocalDate getDateRentalCarEnd() {
        return dateRentalCarEnd;
    }

    public void setDateRentalCarEnd(LocalDate dateRentalCarEnd) {
        this.dateRentalCarEnd = dateRentalCarEnd;
    }

}
