/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import com.automo.entity.Claim;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ClaimDao extends BaseEntityDataAccessObject {

    private static final Logger LOG = LogManager.getLogger(ClaimDao.class);
    public int[] findClaim(String firstName, String vehicleYear, String vehicleMake, String vehicleModel) throws SQLException {
        Integer.parseInt(vehicleYear);
        String queryString = "select\n"
                + "	cl.id as claim_id, ve.id as vehicle_id, cu.id as customer_id\n"
                + "from\n"
                + "	CUSTOMER cu\n"
                + "inner join CONTACT cu_contact on\n"
                + "	cu.contact_id = cu_contact.id\n"
                + "inner join CLAIM cl on\n"
                + "	cl.customer_id = cu.id\n"
                + "inner join VEHICLE ve on\n"
                + "	cl.vehicle_id = ve.id\n"
                + "where\n"
                + "	cu_contact.first_name like '%" + firstName + "%'\n"
                + "	and ve.make = '" + vehicleMake + "'\n"
                + "	and ve.model = '" + vehicleModel + "'\n"
                + "	and ve.year_manufactured = " + vehicleYear + ";";
        
        Statement stmt = connection.getConnection().createStatement();

        LOG.info("running query:" + queryString);
        ResultSet rs;
        rs = stmt.executeQuery(queryString);
        int[] result = null;
        if (rs.next()){
            result = new int[]{rs.getInt("claim_id"), rs.getInt("vehicle_id"), rs.getInt("customer_id")};
        }
        return result;
    }
    
    public List<Claim> findAllClaims() {
        TypedQuery<Claim> query = em.createNamedQuery("Claim.findAll", Claim.class);
        return query.getResultList();
    }
    public List<Claim> findAll() {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Claim> cq = cb.createQuery(Claim.class);
        Root<Claim> rootEntry = cq.from(Claim.class);
        CriteriaQuery<Claim> all = cq.select(rootEntry);
        TypedQuery<Claim> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public Claim findById(int id) {
        return em.find(Claim.class, id);
    }
}
