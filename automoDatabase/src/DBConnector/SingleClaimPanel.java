/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

/**
 *
 * @author caleb
 */
public class SingleClaimPanel extends javax.swing.JPanel {

    /**
     * Creates new form SingleClaimPanel
     */
    public SingleClaimPanel() {
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        label3 = new java.awt.Label();
        textField3 = new java.awt.TextField();
        label4 = new java.awt.Label();
        textField4 = new java.awt.TextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("jLabel1");
        add(jLabel1, new java.awt.GridBagConstraints());

        panel2.setLayout(new java.awt.GridBagLayout());

        label3.setText("label1");
        panel2.add(label3, new java.awt.GridBagConstraints());

        textField3.setMinimumSize(new java.awt.Dimension(40, 20));
        textField3.setPreferredSize(new java.awt.Dimension(40, 20));
        textField3.setText("text1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel2.add(textField3, gridBagConstraints);

        label4.setText("labelname1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel2.add(label4, gridBagConstraints);

        textField4.setText("textField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panel2.add(textField4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(panel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Panel panel2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    // End of variables declaration//GEN-END:variables
}
