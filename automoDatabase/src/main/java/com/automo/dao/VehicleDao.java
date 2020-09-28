/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import com.automo.entity.Vehicle;

/**
 *
 * @author in communist project no authors
 */
public class VehicleDao extends BaseEntityDataAccessObject {

    public Vehicle getByVin(String vin) {
        return em.createNamedQuery("Vehicle.findByVin", Vehicle.class).getSingleResult();
    }

    @Override
    Class getTypeToken() {
        return Vehicle.class;
    }
    
}
