/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEForces;
import BE.BEMaterial;
import BLL.BLLPDF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Claus
 */
public class ODINReport extends javax.swing.JFrame {

    ChooseMaterialsTableModel materialModel;
    ForcesTableModel forcesTableModel; 
    ArrayList<BEMaterial> allMaterials = new ArrayList<>();
    ArrayList<String> materialColNames = new ArrayList<>();
    ArrayList<String> forcesColNames = new ArrayList<>();
    ArrayList<BEForces> allforces = new ArrayList<>();
    TableRowSorter<TableModel> sorter;
    private String currentTime;
    boolean isForcesSelected = false;
    boolean isWounded = false;
    private PDFListener PDFListener; // holds a reference to a class that implements PDFListener
    BLLPDF BLLPDF = new BLLPDF();
    String evaNr, fireNr, received, date, message, name, address, leader, teamLeader, weekday;

    /**
     * Creates new form ODINReport
     */
    public ODINReport() {
        initComponents();
        setPDFListener(BLLPDF); // sets the BLLPDF as observer
        // sets the model for the material table
        materialModel = new ChooseMaterialsTableModel(allMaterials);
        sorter = new TableRowSorter<TableModel>(materialModel);
        //sets the model for the forces table
        forcesTableModel = new ForcesTableModel(allforces);
        tblForces.setModel(forcesTableModel);
        tblForces.getTableHeader().setReorderingAllowed(false);
        
        setTitle("ODIN Report");
        this.setVisible(true);
        ShowForces();
        ShowWounded();
        //sets the ActionListener for the button "save" and addForces
        ActionListener BTNPDFOdinListener = new BTNPDFOdinActionListener();
        btnSave.addActionListener(BTNPDFOdinListener);
        ActionListener BTNAddForces = new BTNAddForcesActionListener();
        btnAddForces.addActionListener(BTNAddForces);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    /**
     * 
     * @param PDFListener 
     */
      public void setPDFListener(PDFListener PDFListener){
        this.PDFListener = PDFListener;
    }
    
    
    /**
     * anonymous inner class listening on the create pdf button
     */
     private class BTNPDFOdinActionListener implements ActionListener {
     @Override
        public void actionPerformed(ActionEvent e) {
               getOdinData();
//              firePDFEvent(new FormatEventPDF(allMaterials, materialColNames, allforces, forcesColNames, date,
//                      received,fireNr,evaNr,message,name,address,leader,teamLeader,weekday));   
        firePDFEvent(new FormatEventPDF(allMaterials,materialColNames,allforces, forcesColNames,date,received));
        }
    }
     
      /**
     * anonymous inner class listening on the create pdf button
     */
     private class BTNAddForcesActionListener implements ActionListener {
     @Override
        public void actionPerformed(ActionEvent e) {
           BEForces emptyLine = new BEForces("", "", ""); //adds a empty row to the table 
           allforces.add(emptyLine);
           forcesTableModel.setForcesList(allforces);
        }
    }
    /**
     * 
     * @param event 
     */
     public void firePDFEvent(FormatEventPDF event){
        if (PDFListener != null){
            try{
              PDFListener.PDFOdinPerformed(event);
             JOptionPane.showMessageDialog(null, "ODIN Rapport blev genereret", "Færdig", JOptionPane.INFORMATION_MESSAGE);
             } catch(EventExercutionException eex){
             JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
          }
     }
        
       /**
        * 
        * @param t 
        */ 
        public void setTime(String t){
            currentTime = t;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dato = currentTime.substring(8, 18);
            String tid = currentTime.substring(19);
        try {
            Date date = formatter.parse(dato);
          txtAlarmModtaget.setText(tid);
          dcDato.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(ODINReport.class.getName()).log(Level.SEVERE, null, ex);
            
        }                   
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
        dcDato = new com.toedter.calendar.JDateChooser();
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
        btnTilfoejMaterialer = new javax.swing.JButton();
        lblMaterialerBrugt = new javax.swing.JLabel();
        btnTilbage = new javax.swing.JButton();
        chkBoxIndsatteStyrker = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMaterial = new javax.swing.JTable();
        jpanelIndsatteStyrker = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblForces = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnAddForces = new javax.swing.JButton();

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
        setResizable(false);

        lblHeader.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 0, 51));
        lblHeader.setText("Brand og Redning");

        lblSubHeader.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblSubHeader.setForeground(new java.awt.Color(255, 0, 51));
        lblSubHeader.setText("Station 4.24");

        lblIndsatsLeder.setText("Indsats Leder:");

        lblHoldLeder.setText("Hold Leder:");

        lblDato.setText("Dato:");

        lblAlarmModtaget.setText("Alarm Modtaget:");

        txtAlarmModtaget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlarmModtagetActionPerformed(evt);
            }
        });

        lblUgeDag.setText("Uge Dag:");

        lblBrandReportNr.setText("Brand Report Nr:");

        lblEvaReportNr.setText("EVA Report Nr:");

        lblMelding.setText("Melding:");

        chkBoxSkadeslidte.setText("Skadeslidte");
        chkBoxSkadeslidte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxSkadeslidteActionPerformed(evt);
            }
        });

        lblNavn.setText("Navn:");

        lblAddresse.setText("Addresse:");

        btnTilfoejMaterialer.setText("Tilføj Materialer");
        btnTilfoejMaterialer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTilfoejMaterialerActionPerformed(evt);
            }
        });

        lblMaterialerBrugt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMaterialerBrugt.setText("Materialer Brugt:");

        btnTilbage.setText("Tilbage");
        btnTilbage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTilbageActionPerformed(evt);
            }
        });

        chkBoxIndsatteStyrker.setText("Indsatte Styrker:");
        chkBoxIndsatteStyrker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxIndsatteStyrkerActionPerformed(evt);
            }
        });

        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materiale", "Antal"
            }
        ));
        jScrollPane3.setViewportView(tblMaterial);

        tblForces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vogn Nr", "Kørsl 1/2", "Bemanding"
            }
        ));
        jScrollPane1.setViewportView(tblForces);

        javax.swing.GroupLayout jpanelIndsatteStyrkerLayout = new javax.swing.GroupLayout(jpanelIndsatteStyrker);
        jpanelIndsatteStyrker.setLayout(jpanelIndsatteStyrkerLayout);
        jpanelIndsatteStyrkerLayout.setHorizontalGroup(
            jpanelIndsatteStyrkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jpanelIndsatteStyrkerLayout.setVerticalGroup(
            jpanelIndsatteStyrkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelIndsatteStyrkerLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnSave.setText("Gem");

        btnAddForces.setText("Tilføj en Styrke");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanelIndsatteStyrker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddForces)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTilbage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBoxIndsatteStyrker)
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
                                    .addComponent(txtAddresse)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtAlarmModtaget, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlarmModtaget)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHeader)
                                    .addComponent(lblSubHeader)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDato)
                                        .addGap(60, 60, 60)
                                        .addComponent(dcDato, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(60, 60, 60)
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
                                    .addComponent(btnTilfoejMaterialer, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(dcDato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(chkBoxIndsatteStyrker)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanelIndsatteStyrker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTilbage)
                    .addComponent(btnSave)
                    .addComponent(btnAddForces))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlarmModtagetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlarmModtagetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlarmModtagetActionPerformed
/**
 * 
 */
    private void getOdinData(){
    getMaterialColNames();
    getForcesColNames();
    evaNr = txtEvaReportNr.getText();
    fireNr = txtBrandReportNr.getText();
    received = txtAlarmModtaget.getText();
    date = ((JTextField) dcDato.getDateEditor().getUiComponent()).getText();
    message = txtMelding.getText();
    name = txtNavn.getText();
    address = txtAddresse.getText();
    leader = txtIndsatsLeder.getText();
    teamLeader = txtHoldLeder.getText();
    weekday = txtUgeDag.getText();
    }
   /**
    * 
    */ 
  private void getMaterialColNames(){
     materialColNames = new ArrayList<>();
     for(int i=0; i<materialModel.getColumnCount(); i++){
        materialColNames.add(materialModel.getColumnName(i));
       }
     }
  
  private void getForcesColNames(){
  for (int i=0; i<forcesTableModel.getColumnCount(); i++){
      forcesColNames.add(forcesTableModel.getColumnName(i));
    }
  }
    
    private void btnTilfoejMaterialerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTilfoejMaterialerActionPerformed
        ChooseMaterialsDialog materialsDialog = new ChooseMaterialsDialog(this, true);
        materialsDialog.setLocationRelativeTo(this);
        materialsDialog.setVisible(true);

        // continue here when the dialog box is closed (disposed).
        ArrayList<BEMaterial> mat = materialsDialog.getValgteMaterials();
        if (mat != null) // a material has been created in the dialog box.
        {
            if (!allMaterials.isEmpty()) {
                for (int i = 0; i < mat.size(); i++) {
                    allMaterials.add(mat.get(i));
                }
            } else {
                allMaterials = mat;
            }
            tblMaterial.setModel(materialModel);
            tblMaterial.setRowSorter(sorter);
            tblMaterial.getTableHeader().setReorderingAllowed(false);

            materialModel.setMaterialsStatusList(allMaterials);
        }
    }//GEN-LAST:event_btnTilfoejMaterialerActionPerformed

    private void btnTilbageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTilbageActionPerformed
        dispose();
        Timeplan timePlanFrame = new Timeplan();
        timePlanFrame.setLocationRelativeTo(this);
        timePlanFrame.setVisible(true);
    }//GEN-LAST:event_btnTilbageActionPerformed

    private void chkBoxIndsatteStyrkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxIndsatteStyrkerActionPerformed
        ShowForces();
    }//GEN-LAST:event_chkBoxIndsatteStyrkerActionPerformed

    private void chkBoxSkadeslidteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxSkadeslidteActionPerformed
        ShowWounded();
    }//GEN-LAST:event_chkBoxSkadeslidteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddForces;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTilbage;
    private javax.swing.JButton btnTilfoejMaterialer;
    private javax.swing.JCheckBox chkBoxIndsatteStyrker;
    private javax.swing.JCheckBox chkBoxSkadeslidte;
    private com.toedter.calendar.JDateChooser dcDato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpanelIndsatteStyrker;
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
    private javax.swing.JTable tblForces;
    private javax.swing.JTable tblMaterial;
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
/*
     A function to Hide/Show the table for Forces
     */
    private void ShowForces() {
        if (chkBoxIndsatteStyrker.isSelected()) {
            isForcesSelected = true;

        } else {
            isForcesSelected = false;

        }
        btnAddForces.setVisible(isForcesSelected);
        jpanelIndsatteStyrker.setVisible(isForcesSelected);

    }

    /*
     A function to Hide/Show the text areas and labels for Wounded
     */
    private void ShowWounded() {
        if (chkBoxSkadeslidte.isSelected()) {
            isWounded = true;
        } else {
            isWounded = false;
        }
        lblNavn.setVisible(isWounded);
        lblAddresse.setVisible(isWounded);
        txtNavn.setVisible(isWounded);
        txtAddresse.setVisible(isWounded);
    }
}
