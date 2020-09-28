/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.dao.ContactDao;
import com.automo.entity.Contact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class SingleContactPanel extends SingleEntityPanel<Contact> {

    private static final Logger LOG = LogManager.getLogger(SingleContactPanel.class);
    private final ContactDao contactDao = new ContactDao();
    
    @Override
    public String getPanelTitle() {
        return "Contact";
    }

    @Override
    Class<Contact> getTypeToken() {
        return Contact.class;
    }

    @Override
    void create(Contact e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update(Contact e) {
        contactDao.update(e);
    }
}
