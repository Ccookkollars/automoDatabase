/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo;

import com.automo.entity.Customer;
import java.awt.GridBagConstraints;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
public class SingleCustomerPanel extends SingleEntityPanel<Customer> {

    SingleContactPanel contactPanel = new SingleContactPanel();

    public SingleCustomerPanel() {
        super();
        
        GridBagConstraints howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 4;
        add(contactPanel,  howToGridBro);
    }
    
    @Override
    String getPanelTitle() {
        return "Customer";
    }

    @Override
    void create(Customer e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update(Customer e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Class<Customer> getTypeToken() {
        return Customer.class;
    }

    @Override
    public void setEntity(Customer entity) {
        super.setEntity(entity);
        contactPanel.setEntity(entity.getContact());
    }
    
}
