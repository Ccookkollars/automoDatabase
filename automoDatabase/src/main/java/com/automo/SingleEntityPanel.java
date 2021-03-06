/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.PersistenceException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdatepicker.JDateComponent;
import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.JDatePicker;

/**
 *
 */
public abstract class SingleEntityPanel<E> extends javax.swing.JPanel {

    private static final Logger LOG = LogManager.getLogger(SingleEntityPanel.class);
    private final String panelTitle = getPanelTitle();
    Class<E> typeToken = getTypeToken();
    E entity = null;

    List<InterestingField> interestingFields = new ArrayList<>();

    /**
     * Creates new form SingleClaimPanel
     */
    public SingleEntityPanel() {
        try{
            interestingFields = ApplicationContext.getInstance().getApplicationSettings().getInterestingFieldsFor(typeToken);
        } catch (NoClassDefFoundError | PersistenceException e) {
            interestingFields = new ArrayList<>();
            LOG.error(e);
        }
        initComponents();
    }

    abstract String getPanelTitle();

    abstract void create(E e);
    abstract void update(E e);
    abstract Class<E> getTypeToken();

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
        initEntityFields(entity);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints howToGridBro;

        titleLabel = new javax.swing.JLabel();
        fieldGridPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.GridBagLayout());

        titleLabel.setText(panelTitle);
        add(titleLabel, new java.awt.GridBagConstraints());

        fieldGridPanel.setLayout(new java.awt.GridBagLayout());
        fieldGridPanel.setBackground(new java.awt.Color(1, 1, 1));
        fieldGridPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        initFieldComponents(fieldGridPanel);

        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 2;
        add(fieldGridPanel, howToGridBro);
        
        buttonPanel = new javax.swing.JPanel();
        reloadButton = new JButton();
        reloadButton.setText("Reload");
        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 2;
        howToGridBro.gridy = 2;
        buttonPanel.add(reloadButton, howToGridBro);

        deleteButton = new JButton();
        deleteButton.setText("Delete entry");
        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 1;
        howToGridBro.gridy = 2;
        buttonPanel.add(deleteButton, howToGridBro);

        saveButton = new JButton();
        saveButton.setText("Save");
        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 2;
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSave();
            }
        });
        buttonPanel.add(saveButton, howToGridBro);
        
        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 3;
        add(buttonPanel, howToGridBro);
    }

    private void initFieldComponents(JPanel panel) {
        int row = 0;
        for (InterestingField i : interestingFields) {
            String fieldName = i.getDisplayName();
            JLabel label = new JLabel();
            label.setText(fieldName);
            label.setOpaque(true);
            GridBagConstraints labelGridConstraints = new java.awt.GridBagConstraints();
            labelGridConstraints.gridx = 0;
            labelGridConstraints.gridy = row;
            labelGridConstraints.fill = java.awt.GridBagConstraints.BOTH;

            labelGridConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
            panel.add(label, labelGridConstraints);
            
            
            if (i.getTypeToken() == String.class || i.getTypeToken() == int.class){
                
                TextField textField = i.getTextField();
                textField.setText(fieldName);

                GridBagConstraints textFieldGridConstraints = new java.awt.GridBagConstraints();
                textFieldGridConstraints.gridx = 1;
                textFieldGridConstraints.gridy = row;
                textFieldGridConstraints.fill = java.awt.GridBagConstraints.BOTH;
                textFieldGridConstraints.insets = new java.awt.Insets(1, 1, 1, 1);

                panel.add(textField, textFieldGridConstraints);

                textField.addActionListener(actionEvent
                        -> LOG.info("Action performed on textField " + fieldName));

            }else if(i.getTypeToken() == Date.class){
                
                JDateComponentFactory fact = new JDateComponentFactory();
                JDatePicker picker = fact.createJDatePicker();
                Date today = new Date();
//                picker.getModel().setDate(today.getDay(), today.getMonth(), today.getYear());

                GridBagConstraints textFieldGridConstraints = new java.awt.GridBagConstraints();
                textFieldGridConstraints.gridx = 1;
                textFieldGridConstraints.gridy = row;
                textFieldGridConstraints.fill = java.awt.GridBagConstraints.BOTH;
                textFieldGridConstraints.insets = new java.awt.Insets(1, 1, 1, 1);

                panel.add((Component)picker, textFieldGridConstraints);

                picker.addActionListener(actionEvent
                        -> LOG.info("Action performed on textField " + fieldName));

            }else{
                throw new IllegalArgumentException("Unhandled type " + i.getTypeToken().getSimpleName());
            }
            
            row++;
        }
    }

    void onSave() {

        LOG.info("ONSAVE");
        boolean anythingChanged = false;
        boolean isNew = false;
        if (entity == null) {
            try {
                entity = typeToken.getConstructor().newInstance();
                anythingChanged = true;
                isNew = true;
            } catch (Exception e){
                LOG.error("Could not initialize entity for new item", e);
                throw new RuntimeException(e);
            }
        }
        for (InterestingField i : interestingFields) {
            try{
                if (!i.getTextField().getText().equals(Objects.toString(i.getGetter().apply(entity)))){
                    LOG.info("Detected changed value for field " + i.getDisplayName());
                    anythingChanged = true;
                    i.getSetter().accept(entity, i.getTextField().getText());
                }
            } catch (Exception e) {
                LOG.error("Could not save value " + i.getTextField() +" for " + typeToken.getSimpleName());
                throw new RuntimeException(e);
            }
        }
        if (anythingChanged) {
            if (isNew){
                create(entity);
            } else {
                update(entity);
            }
        }
    }

    public void initEntityFields(E entity) {
        for (InterestingField i : interestingFields) {
            try {
                i.getTextField().setText(Objects.toString(i.getGetter().apply(entity)));
            } catch (Exception e) {
                LOG.warn("Issue setting field " + i.getDisplayName(), e);
            }
        }
    }


    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel fieldGridPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel buttonPanel;
}
