/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.entity.Contact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class SingleContactPanel extends SingleEntityPanel<Contact> {

    private static final Logger LOG = LogManager.getLogger(SingleContactPanel.class);

    @Override
    public String getPanelTitle() {
        return "Contact";
    }

    @Override
    Class<Contact> getTypeToken() {
        return Contact.class;
    }

}
