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
