/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 */
public abstract class SingleEntityPanel<E> extends javax.swing.JPanel {

    private static final Logger LOG = Logger.getLogger(SingleEntityPanel.class.getName());
    private final String panelTitle = getPanelTitle();
    private E entity;

    Map<String, Label> labels = new HashMap<>();
    Map<String, TextField> textFields = new HashMap<>();
    /**
     * Creates new form SingleClaimPanel
     */
    public SingleEntityPanel() {
        initComponents();
        LOG.info("Initialized singleEntityPanel " + panelTitle);
    }

    abstract String getPanelTitle();
    abstract Set<String> getFieldNames();
    E getEntity() {
        return entity;
    }
    void setEntity(E entity) {
        this.entity = entity;
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        
        titleLabel = new javax.swing.JLabel();
        fieldGridPanel = new java.awt.Panel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.GridBagLayout());

        titleLabel.setText(panelTitle);
        add(titleLabel, new java.awt.GridBagConstraints());

        fieldGridPanel.setLayout(new java.awt.GridBagLayout());

        initFields(fieldGridPanel);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(fieldGridPanel, gridBagConstraints);
        
    }

    private void initFields(Panel panel) {
        int row = 0;
        for (String fieldName : getFieldNames()) {
            Label label = new Label();
            label.setText(fieldName);
            GridBagConstraints labelGridConstraints = new java.awt.GridBagConstraints();
            labelGridConstraints.gridx = 0;
            labelGridConstraints.gridy = row;
            panel.add(label, labelGridConstraints);
            labels.put(fieldName, label);
            
            TextField textField = new TextField();
            textField.setText(fieldName);
        
            GridBagConstraints textFieldGridConstraints = new java.awt.GridBagConstraints();
            textFieldGridConstraints.gridx = 1;
            textFieldGridConstraints.gridy = row;
            textFieldGridConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            panel.add(textField, textFieldGridConstraints);
            
            textField.addActionListener(actionEvent
                    -> LOG.info("Action performed on textField " + fieldName));
            textFields.put(fieldName, textField);

            row++;
        }
    }

    // Variables declaration - modify away!                     
    private javax.swing.JLabel titleLabel;
    private java.awt.Panel fieldGridPanel;
    // End of variables declaration                   
}
