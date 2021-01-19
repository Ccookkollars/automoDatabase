/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.dao.VehicleDao;
import com.automo.entity.Vehicle;
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
public class VehiclePickerFrame extends JFrame {

    private final VehicleDao VehicleDao = new VehicleDao();
    private final VehicleTableModel model = new VehicleTableModel();
    JLabel label;
    JTable table;
    JButton cancelButton;
    JButton selectButton;
    JPanel buttonPanel;

    public VehiclePickerFrame() {
        initComponents();
        ApplicationContext.getInstance().getEventBus().register(this);
    }

    private void initComponents() {
        java.awt.GridBagConstraints howToGridBro;

        label = new JLabel();
        table = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(1, 1, 1));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        label.setText("Vehicle Picker");
        howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 0;
        getContentPane().add(label, howToGridBro);

        table.setModel(model);
//        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
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

        buttonPanel = new JPanel();
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
        model.getItems().addAll(VehicleDao.findAll());
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


    static class VehicleTableModel extends AbstractTableModel {

        private final List<Vehicle> items = new ArrayList<>();
        private final List<Function<Vehicle, ?>> getters = new ArrayList<>();

        public VehicleTableModel() {
            addGetters();

        }

        private void addGetters() {
            getters.add(Vehicle::getYearManufactured);
            getters.add(Vehicle::getMake);
            getters.add(Vehicle::getModel);
            getters.add(Vehicle::getColor);
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

        public List<Vehicle> getItems() {
            return items;
        }
    }

}
