/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class ClaimDao extends BasicDataAccessObject {

    public int[] findClaim(String firstName, String vehicleYear, String vehicleMake, String vehicleModel) throws SQLException {
        String queryString = "select\n"
                + "	cl.id as claim_id, ve.id as vehicle_id, cu.id as customer_id\n"
                + "from\n"
                + "	customer cu\n"
                + "inner join contact cu_contact on\n"
                + "	cu.contact_id = cu_contact.id\n"
                + "inner join claim cl on\n"
                + "	cl.customer_id = cu.id\n"
                + "inner join vehicle ve on\n"
                + "	cl.vehicle_id = ve.id\n"
                + "where\n"
                + "	cu_contact.first_name like '%" + firstName + "%'\n"
                + "	and ve.make = '" + vehicleMake + "'\n"
                + "	and ve.model = '" + vehicleModel + "'\n"
                + "	and ve.year_manufactured = " + vehicleYear + ";";
        
        Statement stmt = connection.getConnection().createStatement();

        ResultSet rs;
        rs = stmt.executeQuery(queryString);
        int[] result = null;
        if (rs.next()){
            result = new int[]{rs.getInt("claim_id"), rs.getInt("vehicle_id"), rs.getInt("customer_id")};
        }
        return result;
    }

}
