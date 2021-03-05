/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.dao.CustomerDao;
import com.automo.entity.Customer;
import com.google.common.base.MoreObjects;
import com.google.common.eventbus.Subscribe;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static DBConnector.CarSearchFrame.LOG;

/**
 * @author ylltrazoaar, the always and everywhere
 */
public class CustomerPickerFrame extends JFrame {

    private final CustomerDao customerDao = new CustomerDao();
    private final CustomerTableModel model = new CustomerTableModel();
    JLabel label;
    JTable table;
    JButton cancelButton;
    JButton selectButton;
    JPanel buttonPanel;

    public CustomerPickerFrame() {
        initComponents();
        ApplicationContext.getInstance().getEventBus().register(this);
    }

    private void initComponents() {
        java.awt.GridBagConstraints howToGridBro;

        label = new javax.swing.JLabel();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(1, 1, 1));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        label.setText("Customer Picker");
        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 0;
        getContentPane().add(label, howToGridBro);

        table.setModel(model);
//        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(250);

        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 2;
        getContentPane().add(table, howToGridBro);

        buttonPanel = new javax.swing.JPanel();
        selectButton = new JButton();
        selectButton.setText("Select");
        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 1;
        howToGridBro.gridy = 2;
        buttonPanel.add(selectButton, howToGridBro);

        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 2;
        buttonPanel.add(cancelButton, howToGridBro);

        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 3;
        getContentPane().add(buttonPanel, howToGridBro);

        addEntities();

        pack();
    }

    private void addEntities() {
        model.getItems().addAll(customerDao.findAll());
    }

    @Subscribe
    public void showFrameEvent(Event.ShowFrameEvent event) {
        if (event.getFrame().equals(this)) {
            setVisible(true);
            pack();
        }
    }

    private void tableMouseClicked(MouseEvent ev) {
        LOG.info(MoreObjects.toStringHelper(model.getItems().get(table.getSelectedRow())).toString());
    }


    static class CustomerTableModel extends AbstractTableModel {

        private final List<Customer> items = new ArrayList<>();
        private final List<Function<Customer, ?>> getters = new ArrayList<>();

        public CustomerTableModel() {
            addGetters();

        }

        private void addGetters() {
            getters.add(c -> c.getContact().getFirstName());
            getters.add(c -> c.getContact().getLastName());
            getters.add(c -> c.getContact().getPhoneNumber());
            getters.add(c -> c.getContact().getEmailAddress());
        }


        @Override
        public int getRowCount() {
            return items.size();
        }

        @Override
        public int getColumnCount() {
            return getters.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return getters.get(columnIndex).apply(items.get(rowIndex));
        }

        public List<Customer> getItems() {
            return items;
        }


    }

}
