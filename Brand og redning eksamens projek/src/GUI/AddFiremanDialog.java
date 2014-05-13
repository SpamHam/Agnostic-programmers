/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEFireman;

/**
 *
 * @author Claus
 */
public class AddFiremanDialog extends javax.swing.JDialog {

    private BEFireman fireman = null;

    /**
     * Creates new form AddFiremanDialog
     */
    public AddFiremanDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Tilføj en Brandmand");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * Creates a Business Entity from the information entered in the textfields
     */
    private void Add() {
        int ID = 0;
        String forNavn = txtFornavn.getText().trim();
        String efterNavn = txtEfternavn.getText().trim();
        String adresse = txtAddresse.getText().trim();
        String tlfNr = txtTlfNr.getText().trim();
        String callNr = txtCallNr.getText().trim();
        String paymentNr = txtPaymentNr.getText().trim();
        boolean leaderUddannet = false;
        if (chkboxLederUddannet.isSelected()) {
            leaderUddannet = true;
        }
        
        fireman = new BEFireman(ID, forNavn, efterNavn, adresse, tlfNr, callNr, paymentNr, leaderUddannet);
    }

    /**
     *  Returns the Business Entity created from the Add function
     * @return fireman
     */
    public BEFireman getNewFireman() {
        return fireman;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEfternavn = new javax.swing.JLabel();
        lblAddresse = new javax.swing.JLabel();
        lblTlfNr = new javax.swing.JLabel();
        lblCallNr = new javax.swing.JLabel();
        txtTlfNr = new javax.swing.JTextField();
        txtFornavn = new javax.swing.JTextField();
        txtCallNr = new javax.swing.JTextField();
        txtEfternavn = new javax.swing.JTextField();
        chkboxLederUddannet = new javax.swing.JCheckBox();
        lblFornavn = new javax.swing.JLabel();
        txtAddresse = new javax.swing.JTextField();
        btnTilfoej = new javax.swing.JButton();
        btnAnnuller = new javax.swing.JButton();
        txtPaymentNr = new javax.swing.JTextField();
        lblPaymentNr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblEfternavn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEfternavn.setText("Efternavn:");

        lblAddresse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddresse.setText("Addresse:");

        lblTlfNr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTlfNr.setText("Tlf. Nr:");

        lblCallNr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCallNr.setText("Call Nr:");

        chkboxLederUddannet.setText("Leder Uddannet");
        chkboxLederUddannet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkboxLederUddannetActionPerformed(evt);
            }
        });

        lblFornavn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFornavn.setText("Fornavn:");

        btnTilfoej.setText("Tilføj");
        btnTilfoej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTilfoejActionPerformed(evt);
            }
        });

        btnAnnuller.setText("Annuller");
        btnAnnuller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnullerActionPerformed(evt);
            }
        });

        lblPaymentNr.setText("Payment Nr:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFornavn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFornavn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCallNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTlfNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddresse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEfternavn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPaymentNr, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkboxLederUddannet)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPaymentNr)
                                .addComponent(txtAddresse, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(txtEfternavn)
                                .addComponent(txtTlfNr)
                                .addComponent(txtCallNr)))))
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnnuller)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTilfoej, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornavn)
                    .addComponent(txtFornavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEfternavn)
                    .addComponent(txtEfternavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddresse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTlfNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTlfNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCallNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCallNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaymentNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkboxLederUddannet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTilfoej)
                    .addComponent(btnAnnuller))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkboxLederUddannetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkboxLederUddannetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkboxLederUddannetActionPerformed

    private void btnTilfoejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTilfoejActionPerformed
        Add();
        dispose();
    }//GEN-LAST:event_btnTilfoejActionPerformed

    private void btnAnnullerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnullerActionPerformed
        dispose();
    }//GEN-LAST:event_btnAnnullerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnnuller;
    private javax.swing.JButton btnTilfoej;
    private javax.swing.JCheckBox chkboxLederUddannet;
    private javax.swing.JLabel lblAddresse;
    private javax.swing.JLabel lblCallNr;
    private javax.swing.JLabel lblEfternavn;
    private javax.swing.JLabel lblFornavn;
    private javax.swing.JLabel lblPaymentNr;
    private javax.swing.JLabel lblTlfNr;
    private javax.swing.JTextField txtAddresse;
    private javax.swing.JTextField txtCallNr;
    private javax.swing.JTextField txtEfternavn;
    private javax.swing.JTextField txtFornavn;
    private javax.swing.JTextField txtPaymentNr;
    private javax.swing.JTextField txtTlfNr;
    // End of variables declaration//GEN-END:variables
}
