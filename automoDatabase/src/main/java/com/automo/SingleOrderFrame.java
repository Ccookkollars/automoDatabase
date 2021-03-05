/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.entity.JobOrder;
import com.google.common.eventbus.Subscribe;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
public class SingleOrderFrame extends JFrame {

    SingleOrderPanel singleOrderPanel = new SingleOrderPanel();

    public SingleOrderFrame() {
        super();
        ApplicationContext.getInstance().getEventBus().register(this);

        GridBagConstraints howToGridBro = new java.awt.GridBagConstraints();
        howToGridBro.gridx = 0;
        howToGridBro.gridy = 4;
        getContentPane().setLayout(new GridBagLayout());
        getContentPane().add(singleOrderPanel, howToGridBro);
        pack();
    }

    @Subscribe
    public void showFrameEvent(Event.ShowFrameEvent event) {
        if (event.getFrame().equals(this)) {
            setVisible(true);
            pack();
        }
    }

    class SingleOrderPanel extends SingleEntityPanel<JobOrder> {

        @Override
        String getPanelTitle() {
            return "Order";
        }

        @Override
        void create(JobOrder e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        void update(JobOrder e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        Class<JobOrder> getTypeToken() {
            return JobOrder.class;
        }

    }
}
