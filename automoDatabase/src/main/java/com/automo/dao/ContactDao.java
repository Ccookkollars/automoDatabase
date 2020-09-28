/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo.dao;

import com.automo.entity.Contact;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
public class ContactDao extends BaseEntityDataAccessObject{

    @Override
    Class getTypeToken() {
        return Contact.class;
    }

    @Override
    public void update(Object e) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(e);
        et.commit();
    }
    
}
