/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import DBConnector.Vehicle;
import com.google.common.collect.Sets;
import java.util.Set;

/**
 *
 * @author caleb
 */
public class SingleVehiclePanel extends SingleEntityPanel<Vehicle>{

    @Override
    String getPanelTitle() {
        return "Vehicle";
    }

    @Override
    Set<String> getFieldNames() {
        return Sets.newHashSet("vin", "make", "model", "ABZZZC", "color");
    }
    
}
