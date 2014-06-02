/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEFireman;
import BLL.BLLFireman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

/**
 *
 * @author Claus
 */
public class AddFiremanDialog extends javax.swing.JDialog {

    private BEFireman fireman = null;
    private static final String batPath = "C:\\Billeder";
    private final int hgt = 120;
    private final int wdt = 110;
    private String path = null;
    private BLLFireman m_fireman = new BLLFireman();

    /**
     * Creates new form AddFiremanDialog
     */
    public AddFiremanDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Tilføj en Brandmand");
        ActionListener BTNAddListener = new AddListener();
        btnAdd.addActionListener(BTNAddListener);
        ActionListener BTNCancelListener = new CancelListener();
        btnCancel.addActionListener(BTNCancelListener);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * Creates a Business Entity from the information entered in the textfields
     */
    private void Add() {
       // int ID = 0;
        String profileImage = path;
        String forNavn = txtFirstName.getText().trim();
        String efterNavn = txtLastName.getText().trim();
        String adresse = txtAddress.getText().trim();
        String tlfNr = txtTelephoneNr.getText().trim();
        String callNr = txtCallNr.getText().trim();
        String paymentNr = txtPaymentNr.getText().trim();
        boolean leaderUddannet = false;
        String hiredDate = ((JTextField) jDateHiredDate.getDateEditor().getUiComponent()).getText();
        if (chkboxIsLeaderTrained.isSelected()) {
            leaderUddannet = true;
        }

        fireman = new BEFireman(profileImage, forNavn, efterNavn, adresse, tlfNr, callNr, paymentNr, leaderUddannet, hiredDate);
    }

    /**
     * Returns the Business Entity created from the Add function
     *
     * @return fireman
     */
    public BEFireman getNewFireman() {
        return fireman;
    }

    /**
     * This method let you browse for an image. 
     */
    private void browseImage(){
        try {
            m_fireman.browseForProfilePicture();
        } catch (Exception ex) {
            Logger.getLogger(AddFiremanDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void profileImage(){
        lblProfilPicture.setIcon(new ImageIcon(m_fireman.returnImage()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLastName = new javax.swing.JLabel();
        lblAddresse = new javax.swing.JLabel();
        lblTelephoneNr = new javax.swing.JLabel();
        lblCallNr = new javax.swing.JLabel();
        txtTelephoneNr = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtCallNr = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPaymentNr = new javax.swing.JTextField();
        lblPaymentNr = new javax.swing.JLabel();
        jDateHiredDate = new com.toedter.calendar.JDateChooser();
        lblHiredDate = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        chkboxIsLeaderTrained = new javax.swing.JCheckBox();
        lblProfilPicture = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastName.setText("Efternavn:");

        lblAddresse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddresse.setText("Addresse:");

        lblTelephoneNr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelephoneNr.setText("Tlf. Nr:");

        lblCallNr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCallNr.setText("Tilkalds Nr:");

        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("Fornavn:");

        lblPaymentNr.setText("Løn nr:");

        lblHiredDate.setText("Ansættelses Dato:");

        btnAdd.setText("Tilføj");

        btnCancel.setText("Annuller");

        chkboxIsLeaderTrained.setText("Leder Uddannet");

        lblProfilPicture.setText("      ");
        lblProfilPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBrowse.setText("Find");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPaymentNr)
                            .addComponent(lblHiredDate)
                            .addComponent(lblCallNr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCallNr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateHiredDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkboxIsLeaderTrained)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                                .addComponent(lblAddresse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(lblTelephoneNr, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBrowse)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPaymentNr)
                                    .addComponent(txtAddress)
                                    .addComponent(txtLastName)
                                    .addComponent(txtTelephoneNr)
                                    .addComponent(txtFirstName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(lblProfilPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfilPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddresse, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelephoneNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelephoneNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCallNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCallNr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPaymentNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaymentNr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateHiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHiredDate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkboxIsLeaderTrained)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
     browseImage();
     profileImage();
      
    }//GEN-LAST:event_btnBrowseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JCheckBox chkboxIsLeaderTrained;
    private com.toedter.calendar.JDateChooser jDateHiredDate;
    private javax.swing.JLabel lblAddresse;
    private javax.swing.JLabel lblCallNr;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblHiredDate;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPaymentNr;
    private javax.swing.JLabel lblProfilPicture;
    private javax.swing.JLabel lblTelephoneNr;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCallNr;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPaymentNr;
    private javax.swing.JTextField txtTelephoneNr;
    // End of variables declaration//GEN-END:variables

    /**
     * anonymous inner class listening on the Add button
     */
    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Add();
            dispose();
        }
    }

    /**
     * anonymous inner class listening on the Cancel button
     */
    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }

    }

}
