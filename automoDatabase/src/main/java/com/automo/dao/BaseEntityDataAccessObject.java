/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import com.automo.ApplicationContext;
import javax.persistence.EntityManager;

/**
 *
 */
public class BaseEntityDataAccessObject extends BasicDataAccessObject {
    
    EntityManager em;

    public BaseEntityDataAccessObject() {
        super();
        em = ApplicationContext.getInstance().getEntityManager();
    }

}
