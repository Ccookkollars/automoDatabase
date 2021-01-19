/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import com.automo.ApplicationContext;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public abstract class BaseEntityDataAccessObject<E> extends BasicDataAccessObject {

    private static final Logger LOG = LogManager.getLogger(BaseEntityDataAccessObject.class);
    EntityManager em;
    Class<E> typeToken;

    public BaseEntityDataAccessObject() {
        super();
        try {
            em = ApplicationContext.getInstance().getEntityManager();
        } catch (NoClassDefFoundError e) {
            LOG.error(e);
        }
        typeToken = getTypeToken();
    }

    abstract Class<E> getTypeToken();

    public void create(E e) {
        throw new UnsupportedOperationException("Was lazy. Please implement in the corresponding Data Access Object for " + typeToken.getSimpleName());
    }

    public E read(int id) {
        throw new UnsupportedOperationException("Was lazy. Please implement in the corresponding Data Access Object for " + typeToken.getSimpleName());
    }

    public void update(E e) {
        throw new UnsupportedOperationException("Was lazy. Please implement in the corresponding Data Access Object for " + typeToken.getSimpleName());
    }

    public void delete(E e) {
        throw new UnsupportedOperationException("Was lazy. Please implement in the corresponding Data Access Object for " + typeToken.getSimpleName());
    }

    public List<E> findAll() {
        return em.createNamedQuery(typeToken.getSimpleName() + ".findAll", typeToken).getResultList();
    }
}
