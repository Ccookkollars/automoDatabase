/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import com.automo.entity.Claim;
import java.sql.SQLException;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ClaimDao extends BaseEntityDataAccessObject {

    private static final Logger LOG = LogManager.getLogger(ClaimDao.class);
    public Object[] findClaim(String firstName, String vehicleYear, String vehicleMake, String vehicleModel) throws SQLException {
        
        TypedQuery<Object[]> query = em.createQuery(
            "SELECT cl, ve, cu, ct FROM Claim cl "
                    + "JOIN cl.customerId cu\n"
                    + "JOIN cu.contactId ct\n"
                    + "JOIN cl.vehicleId ve\n"
                    + "WHERE ct.firstName like :firstName\n"
                    + "AND ve.make = :vehicleMake\n"
                    + "AND ve.model = :vehicleModel\n"
                    + "AND ve.yearManufactured = :vehicleYear", Object[].class);

        query.setParameter("firstName", "%"+firstName+"%");
        query.setParameter("vehicleMake", vehicleMake);
        query.setParameter("vehicleModel", vehicleModel);
        query.setParameter("vehicleYear", Integer.parseInt(vehicleYear));
        LOG.info("JPQL query:" + query.toString());
        return query.getSingleResult();
    }
    
    public Claim findById(int id) {
        return em.find(Claim.class, id);
    }

    @Override
    Class<Claim> getTypeToken() {
        return Claim.class;
    }
}
