/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author Claus
 */
public class ODINReport extends javax.swing.JFrame {

    /**
     * Creates new form ODINReport
     */
    public ODINReport() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblHeader = new javax.swing.JLabel();
        lblSubHeader = new javax.swing.JLabel();
        lblIndsatsLeder = new javax.swing.JLabel();
        lblHoldLeder = new javax.swing.JLabel();
        txtIndsatsLeder = new javax.swing.JTextField();
        txtHoldLeder = new javax.swing.JTextField();
        jDateChooserDato = new com.toedter.calendar.JDateChooser();
        lblDato = new javax.swing.JLabel();
        lblAlarmModtaget = new javax.swing.JLabel();
        txtAlarmModtaget = new javax.swing.JTextField();
        lblUgeDag = new javax.swing.JLabel();
        txtUgeDag = new javax.swing.JTextField();
        lblBrandReportNr = new javax.swing.JLabel();
        txtBrandReportNr = new javax.swing.JTextField();
        lblEvaReportNr = new javax.swing.JLabel();
        txtEvaReportNr = new javax.swing.JTextField();
        lblMelding = new javax.swing.JLabel();
        txtMelding = new javax.swing.JTextField();
        chkBoxSkadeslidte = new javax.swing.JCheckBox();
        lblNavn = new javax.swing.JLabel();
        lblAddresse = new javax.swing.JLabel();
        txtNavn = new javax.swing.JTextField();
        txtAddresse = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableIndsatteStyrker = new javax.swing.JTable();
        btnTilfoejMaterialer = new javax.swing.JButton();
        lblMaterialerBrugt = new javax.swing.JLabel();
        btnGem = new javax.swing.JButton();
        btnTilbage = new javax.swing.JButton();
        chkBoxIndsatteStyrker = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtableMaterialer1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(500, 584));

        lblHeader.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 0, 51));
        lblHeader.setText("Brand og Redning");

        lblSubHeader.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblSubHeader.setForeground(new java.awt.Color(255, 0, 51));
        lblSubHeader.setText("Station 4.24");

        lblIndsatsLeder.setText("Indsats Leder:");

        lblHoldLeder.setText("Hold Leder:");

        txtIndsatsLeder.setText("Morten Kofoed");

        txtHoldLeder.setText("Jens Fabricius");

        lblDato.setText("Dato:");

        lblAlarmModtaget.setText("Alarm Modtaget:");

        txtAlarmModtaget.setText("13:25");
        txtAlarmModtaget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlarmModtagetActionPerformed(evt);
            }
        });

        lblUgeDag.setText("Uge Dag:");

        txtUgeDag.setText("Mandag");

        lblBrandReportNr.setText("Brand Report Nr:");

        txtBrandReportNr.setText("1258");

        lblEvaReportNr.setText("EVA Report Nr:");

        lblMelding.setText("Melding:");

        txtMelding.setText("Ilde brand ved brønden");

        chkBoxSkadeslidte.setText("Skadeslidte");

        lblNavn.setText("Navn:");

        lblAddresse.setText("Addresse:");

        jtableIndsatteStyrker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1341", "", null, null},
                {"2338", "", null, null},
                {"2349", "", null, null},
                {"2351", "", null, null},
                {"ST Vagt", null, null, null}
            },
            new String [] {
                "Vogn Nr:", "Kørsel 1 / 2", "Bemanding", "Afvigelse"
            }
        ));
        jScrollPane1.setViewportView(jtableIndsatteStyrker);

        btnTilfoejMaterialer.setText("Tilføj Materialer");

        lblMaterialerBrugt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMaterialerBrugt.setText("Materialer Brugt:");

        btnGem.setText("Gem");

        btnTilbage.setText("Tilbage");

        chkBoxIndsatteStyrker.setText("Indsatte Styrker:");

        jtableMaterialer1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"HT Rør", "2"},
                {"Strålerør", "1"},
                {"Absorbent W", "4"},
                {"Kulsyreslukker", "1"}
            },
            new String [] {
                "Materiale", "Antal"
            }
        ));
        jScrollPane3.setViewportView(jtableMaterialer1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTilbage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAlarmModtaget)
                                .addGap(18, 18, 18)
                                .addComponent(txtAlarmModtaget, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHeader)
                                    .addComponent(lblSubHeader)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDato)
                                        .addGap(60, 60, 60)
                                        .addComponent(jDateChooserDato, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIndsatsLeder)
                                    .addComponent(lblHoldLeder, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUgeDag)
                                    .addComponent(lblMaterialerBrugt))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHoldLeder)
                                    .addComponent(txtIndsatsLeder)
                                    .addComponent(txtUgeDag, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTilfoejMaterialer, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                            .addComponent(chkBoxIndsatteStyrker)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkBoxSkadeslidte)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblBrandReportNr)
                                            .addComponent(lblEvaReportNr)
                                            .addComponent(lblMelding)
                                            .addComponent(lblNavn)
                                            .addComponent(lblAddresse))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMelding, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                            .addComponent(txtEvaReportNr, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBrandReportNr, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNavn)
                                            .addComponent(txtAddresse))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHeader)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblIndsatsLeder)
                                .addComponent(txtIndsatsLeder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubHeader)
                            .addComponent(lblHoldLeder)
                            .addComponent(txtHoldLeder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooserDato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblUgeDag)
                                .addComponent(txtUgeDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAlarmModtaget)
                            .addComponent(txtAlarmModtaget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaterialerBrugt)
                            .addComponent(btnTilfoejMaterialer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBrandReportNr)
                            .addComponent(txtBrandReportNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEvaReportNr)
                            .addComponent(txtEvaReportNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMelding)
                            .addComponent(txtMelding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkBoxSkadeslidte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNavn)
                            .addComponent(txtNavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddresse)
                            .addComponent(txtAddresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(chkBoxIndsatteStyrker)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTilbage)
                    .addComponent(btnGem))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlarmModtagetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlarmModtagetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlarmModtagetActionPerformed

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
            java.util.logging.Logger.getLogger(ODINReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ODINReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ODINReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ODINReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ODINReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGem;
    private javax.swing.JButton btnTilbage;
    private javax.swing.JButton btnTilfoejMaterialer;
    private javax.swing.JCheckBox chkBoxIndsatteStyrker;
    private javax.swing.JCheckBox chkBoxSkadeslidte;
    private com.toedter.calendar.JDateChooser jDateChooserDato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtableIndsatteStyrker;
    private javax.swing.JTable jtableMaterialer1;
    private javax.swing.JLabel lblAddresse;
    private javax.swing.JLabel lblAlarmModtaget;
    private javax.swing.JLabel lblBrandReportNr;
    private javax.swing.JLabel lblDato;
    private javax.swing.JLabel lblEvaReportNr;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblHoldLeder;
    private javax.swing.JLabel lblIndsatsLeder;
    private javax.swing.JLabel lblMaterialerBrugt;
    private javax.swing.JLabel lblMelding;
    private javax.swing.JLabel lblNavn;
    private javax.swing.JLabel lblSubHeader;
    private javax.swing.JLabel lblUgeDag;
    private javax.swing.JTextField txtAddresse;
    private javax.swing.JTextField txtAlarmModtaget;
    private javax.swing.JTextField txtBrandReportNr;
    private javax.swing.JTextField txtEvaReportNr;
    private javax.swing.JTextField txtHoldLeder;
    private javax.swing.JTextField txtIndsatsLeder;
    private javax.swing.JTextField txtMelding;
    private javax.swing.JTextField txtNavn;
    private javax.swing.JTextField txtUgeDag;
    // End of variables declaration//GEN-END:variables
}
