/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.entity.Vehicle;

/**
 *
 */
public class SingleVehiclePanel extends SingleEntityPanel<Vehicle>{

    @Override
    String getPanelTitle() {
        return "Vehicle";
    }

    @Override
    Class<Vehicle> getTypeToken() {
        return Vehicle.class;
    }

  
}
