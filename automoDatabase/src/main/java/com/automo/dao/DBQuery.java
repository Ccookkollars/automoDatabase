package com.automo.dao;

import com.automo.entity.Vehicle;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBQuery extends BasicDataAccessObject {

    private static final Logger LOG = Logger.getLogger("DBQuery");

    public String[] makeModelVinStatus() {

        List<String> resultsList = new ArrayList<>();
        try {

            Statement stmt = connection.getConnection().createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM VEHICLE");

            while (rs.next()) {
                resultsList.add(rs.getString("make"));
                resultsList.add(rs.getString("model"));
                resultsList.add(rs.getString("vin"));
                resultsList.add(rs.getString("status"));
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e, () -> "WHYYYY");
            System.out.println(e);
        }

        String[] list = new String[resultsList.size()];
        list = resultsList.toArray(list);

        return list;
    }

    public Vehicle getVehicleByVin(String vin) {

        List<String> resultsList = new ArrayList<>();
        try {

            Statement stmt = connection.getConnection().createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM CAR WHERE vin = '" + vin + "'");

            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(rs.getString("vin"));
                vehicle.setMake(rs.getString("make"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setPlate(rs.getString("plate"));
                vehicle.setColor(rs.getString("color"));
                return vehicle;
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e, () -> "WHYYYY");
            System.out.println(e);
        }
        return null;
    }

}
