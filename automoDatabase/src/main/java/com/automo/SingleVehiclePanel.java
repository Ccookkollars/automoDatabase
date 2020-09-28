/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.dao.VehicleDao;
import com.automo.entity.Vehicle;

/**
 *
 */
public class SingleVehiclePanel extends SingleEntityPanel<Vehicle>{

    VehicleDao vehicleDao = new VehicleDao();
   
    @Override
    String getPanelTitle() {
        return "Vehicle";
    }

    @Override
    Class<Vehicle> getTypeToken() {
        return Vehicle.class;
    }

    @Override
    void create(Vehicle e) {
        vehicleDao.create(e);
    }

    @Override
    void update(Vehicle e) {
        vehicleDao.update(e);
    }

  
}
