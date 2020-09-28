/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import java.awt.GridBagConstraints;
import java.awt.TextField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public abstract class SingleEntityPanel<E> extends javax.swing.JPanel {

    private static final Logger LOG = LogManager.getLogger(SingleEntityPanel.class);
    private final String panelTitle = getPanelTitle();
    Class<E> typeToken = getTypeToken();
    E entity;

    List<InterestingField> interestingFields = new ArrayList<>();

    /**
     * Creates new form SingleClaimPanel
     */
    public SingleEntityPanel() {
        initInterestingFields(typeToken);
        initComponents();
        LOG.info("Initialized singleEntityPanel " + panelTitle);
    }

    abstract String getPanelTitle();

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
        java.awt.GridBagConstraints gridBagConstraints;

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(fieldGridPanel, gridBagConstraints);
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
            row++;
        }
    }

    private void initInterestingFields(Class clazz) {
        Set<String> set = new HashSet<>();
        while (clazz != null) {
            // Search fields for column annotations
            for (Field field : clazz.getDeclaredFields()) {
                if (!field.isAnnotationPresent(Column.class)) {
                    continue;
                }
                // Search methods for matching getter name
                Method getter = getGetter(field.getName(), clazz);
                Method setter = getSetter(field.getName(), clazz);
                if (getter != null && setter   != null) {
                    interestingFields.add(new InterestingField(field.getName(), getter, setter, new TextField()));
                }
                
            }
            clazz = clazz.getSuperclass();
        }
    }

    Method getGetter(String fieldName, Class clazz){
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getName().toLowerCase().contains("get")
                    && m.getName().toLowerCase().contains(fieldName.toLowerCase())) {
                return m;
            }
        }
        return null;
    }

    Method getSetter(String fieldName, Class clazz){
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getName().toLowerCase().contains("set")
                    && m.getName().toLowerCase().contains(fieldName.toLowerCase())) {
                return m;
            }
        }
        return null;
    }

    public void initEntityFields(E entity) {
        for (InterestingField i : interestingFields) {
            try {
                i.getTextField().setText(i.getGetter().invoke(entity).toString());
            } catch (Exception e) {
                LOG.warn("Issue setting field " + i.getDisplayName(), e);
            }
        }
    }

    @Data
    public static class InterestingField {
        private final String displayName;
        private final Method getter;
        private final Method setter;
        private final TextField textField;
    }

    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel fieldGridPanel;
}
