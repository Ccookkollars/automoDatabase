/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.entity.Customer;
import com.google.common.eventbus.EventBus;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Getter;
import lombok.Setter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
@Getter
@Setter
public class ApplicationContext {

    private static final Logger LOG = LogManager.getLogger(ApplicationContext.class);
    private ApplicationSettings applicationSettings;
    private final EventBus eventBus = new EventBus("app");
    private boolean isSetup = false;

    private final EntityManagerFactory emf;
    private final EntityManager entityManager;

    private CustomerPickerFrame customerPicker = null;

    private ApplicationContext() {
        applicationSettings = new ApplicationSettings();
        emf = Persistence.createEntityManagerFactory("com.automo1");
        entityManager = emf.createEntityManager();
    }

    private void oneTimeSetup() {
        if (isSetup){
            return;
        }
        isSetup = true;
        customerPicker = new CustomerPickerFrame();
    }

    // Singleton
    private static ApplicationContext instance = new ApplicationContext();

    public static ApplicationContext getInstance() {
        instance.oneTimeSetup();
        return instance;
    }

}
