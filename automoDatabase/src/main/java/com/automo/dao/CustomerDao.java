/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo.dao;

import com.automo.entity.Customer;
import java.sql.SQLException;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
public class CustomerDao extends BaseEntityDataAccessObject {

    private static final Logger LOG = LogManager.getLogger(CustomerDao.class);
    @Override
    Class getTypeToken() {
        return Customer.class;
    }

    public Object[] findByName(String name) throws SQLException{
              TypedQuery<Object[]> query = em.createQuery(
            "SELECT cu, ct FROM Customer cu "
                    + "JOIN cu.contactId ct\n"
                    + "WHERE ct.firstName like :name\n",
                      Object[].class);

        query.setParameter("name", "%"+name+"%");
        LOG.info("JPQL query:" + query.toString());
        return query.getSingleResult();
    }
}
