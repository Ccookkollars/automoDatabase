/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import DBConnector.ApplicationSettings;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ApplicationContext {

    private static final Logger LOG = LogManager.getLogger(ApplicationContext.class);
    private ApplicationSettings applicationSettings;
    private ApplicationContext applicationContext;
    private EntityManagerFactory emf;
    private EntityManager em;

    private ApplicationContext() {
        applicationSettings = new ApplicationSettings();
        emf = Persistence.createEntityManagerFactory("com.automo1");
        em = emf.createEntityManager();
    }

    // Singleton
    public static ApplicationContext instance = new ApplicationContext();
    public static ApplicationContext getInstance() {
        return instance;
    }

    public ApplicationSettings getApplicationSettings() {
        return applicationSettings;
    }
    public void setApplicationSettings(ApplicationSettings applicationSettings) {
        this.applicationSettings = applicationSettings;
    }
    public EntityManager getEntityManager() {
        return em;
    }
}
