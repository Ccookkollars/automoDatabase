/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

import com.automo.dao.ClaimDao;
import com.automo.entity.Contact;
import com.automo.entity.Vehicle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 */
public class MasterFrame extends javax.swing.JFrame {

    private static final MasterFrame instance = new MasterFrame();
    ClaimDao claimDao;
    public static MasterFrame getInstance() {
        return instance;
    }
    /**
     * Creates new form MasterFrame
     */
    private MasterFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MasterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        claimDao = new ClaimDao();
        claimFrame = new ClaimFrame();
        setTitle("MasterFrame");
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        claimFrameButton = new java.awt.Button();
        customerNameBox = new javax.swing.JTextField();
        vehicleYearBox = new javax.swing.JTextField();
        vehicleMakeBox = new javax.swing.JTextField();
        vehicleModelBox = new javax.swing.JTextField();
        button2 = new java.awt.Button();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Vehicle Make");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Customer Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Vehicle Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Vehicle Model");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel3.add(jLabel4, gridBagConstraints);

        claimFrameButton.setLabel("Find Claim");
        claimFrameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claimFrameButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel3.add(claimFrameButton, gridBagConstraints);

        customerNameBox.setText("Lizeth");
        customerNameBox.setPreferredSize(new java.awt.Dimension(65, 27));
        customerNameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel3.add(customerNameBox, gridBagConstraints);

        vehicleYearBox.setText("2011");
        vehicleYearBox.setMinimumSize(new java.awt.Dimension(1100, 27));
        vehicleYearBox.setPreferredSize(new java.awt.Dimension(65, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        jPanel3.add(vehicleYearBox, gridBagConstraints);

        vehicleMakeBox.setText("honda");
        vehicleMakeBox.setPreferredSize(new java.awt.Dimension(65, 27));
        vehicleMakeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleMakeBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel3.add(vehicleMakeBox, gridBagConstraints);

        vehicleModelBox.setText("accord");
        vehicleModelBox.setPreferredSize(new java.awt.Dimension(65, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel3.add(vehicleModelBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jPanel3, gridBagConstraints);

        button2.setLabel("Show Vehicles");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new java.awt.GridBagConstraints());

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void claimFrameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claimFrameButtonActionPerformed
        try{
            Object[] result = claimDao.findClaim(customerNameBox.getText(), vehicleYearBox.getText(), vehicleMakeBox.getText(), vehicleModelBox.getText());
            claimFrame.setContact((Contact) result[3]);
            claimFrame.setVehicle((Vehicle) result[1]);
            claimFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MasterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_claimFrameButtonActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

        CarSearchFrame vehicles = new CarSearchFrame();
        vehicles.setTitle("Getting There");
        vehicles.setVisible(true);    }//GEN-LAST:event_button2ActionPerformed

    private void customerNameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameBoxActionPerformed

    private void vehicleMakeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleMakeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleMakeBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MasterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterFrame().setVisible(true);
            }
        });
    }

    private final ClaimFrame claimFrame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button2;
    private java.awt.Button claimFrameButton;
    private javax.swing.JTextField customerNameBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField vehicleMakeBox;
    private javax.swing.JTextField vehicleModelBox;
    private javax.swing.JTextField vehicleYearBox;
    // End of variables declaration//GEN-END:variables
}
