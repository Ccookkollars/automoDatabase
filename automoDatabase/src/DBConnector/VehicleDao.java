/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

import com.automo.entity.Vehicle;

/**
 *
 * @author in communist project no authors
 */
public class VehicleDao {

    DBQuery dbq = new DBQuery();
    public void createVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Didn't do");
    }
    public Vehicle getVehicle(String vin) {
        return dbq.getVehicleByVin(vin);
    }
    public void updateVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Didn't do");
    }
    public void deleteVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Didn't do");
    }
}

