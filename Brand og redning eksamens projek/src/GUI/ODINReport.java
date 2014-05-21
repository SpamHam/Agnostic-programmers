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
        ActionListener BTNAddMaterial = new BTNAddMaterialActionListener();
        btnAddMaterial.addActionListener(BTNAddMaterial);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    /**
     * sets the PDf listener to a class that implements the PDFListener interface
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
        firePDFEvent(new FormatEventPDF(allMaterials,materialColNames,allforces, forcesColNames,date,
                        received,fireNr,evaNr,message,name,address,leader,teamLeader,weekday));
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
          txtRecived.setText(tid);
          dcDate.setDate(date);
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
        lblTeamLeader = new javax.swing.JLabel();
        lblLeader = new javax.swing.JLabel();
        txtTeamLeader = new javax.swing.JTextField();
        txtLeader = new javax.swing.JTextField();
        dcDate = new com.toedter.calendar.JDateChooser();
        lblDate = new javax.swing.JLabel();
        lblRecived = new javax.swing.JLabel();
        txtRecived = new javax.swing.JTextField();
        lblWeekday = new javax.swing.JLabel();
        txtWeekday = new javax.swing.JTextField();
        lblFiretNr = new javax.swing.JLabel();
        txtFireNr = new javax.swing.JTextField();
        lblEvaReportNr = new javax.swing.JLabel();
        txtEvaNr = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        chkBoxWounded = new javax.swing.JCheckBox();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnAddMaterial = new javax.swing.JButton();
        lblMaterialUsed = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        chkBoxForces = new javax.swing.JCheckBox();
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

        lblTeamLeader.setText("Indsats Leder:");

        lblLeader.setText("Hold Leder:");

        lblDate.setText("Dato:");

        lblRecived.setText("Alarm Modtaget:");

        txtRecived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecivedActionPerformed(evt);
            }
        });

        lblWeekday.setText("Uge Dag:");

        lblFiretNr.setText("Brand Report Nr:");

        lblEvaReportNr.setText("EVA Report Nr:");

        lblMessage.setText("Melding:");

        chkBoxWounded.setText("Skadeslidte");
        chkBoxWounded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxWoundedActionPerformed(evt);
            }
        });

        lblName.setText("Navn:");

        lblAddress.setText("Addresse:");

        btnAddMaterial.setText("Tilføj Materialer");

        lblMaterialUsed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMaterialUsed.setText("Materialer Brugt:");

        btnBack.setText("Tilbage");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        chkBoxForces.setText("Indsatte Styrker:");
        chkBoxForces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxForcesActionPerformed(evt);
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

            },
            new String [] {

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
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBoxForces)
                            .addComponent(chkBoxWounded)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFiretNr)
                                    .addComponent(lblEvaReportNr)
                                    .addComponent(lblMessage)
                                    .addComponent(lblName)
                                    .addComponent(lblAddress))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(txtEvaNr, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFireNr, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName)
                                    .addComponent(txtAddress)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtRecived, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRecived)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHeader)
                                    .addComponent(lblSubHeader)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDate)
                                        .addGap(60, 60, 60)
                                        .addComponent(dcDate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTeamLeader)
                                    .addComponent(lblLeader, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblWeekday)
                                    .addComponent(lblMaterialUsed))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLeader)
                                    .addComponent(txtTeamLeader)
                                    .addComponent(txtWeekday, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
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
                        .addComponent(lblTeamLeader)
                        .addComponent(txtTeamLeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubHeader)
                    .addComponent(lblLeader)
                    .addComponent(txtLeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dcDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblWeekday)
                        .addComponent(txtWeekday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecived)
                    .addComponent(txtRecived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaterialUsed)
                    .addComponent(btnAddMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFiretNr)
                            .addComponent(txtFireNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEvaReportNr)
                            .addComponent(txtEvaNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMessage)
                            .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkBoxWounded)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(chkBoxForces)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanelIndsatteStyrker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSave)
                    .addComponent(btnAddForces))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRecivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecivedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecivedActionPerformed
/**
 * 
 */
    private void getOdinData(){
    getMaterialColNames();
    getForcesColNames();
    evaNr = txtEvaNr.getText();
    fireNr = txtFireNr.getText();
    received = txtRecived.getText();
    date = ((JTextField) dcDate.getDateEditor().getUiComponent()).getText();
    message = txtMessage.getText();
    name = txtName.getText();
    address = txtAddress.getText();
    teamLeader = txtTeamLeader.getText();
    leader = txtLeader.getText();
    weekday = txtWeekday.getText();
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
  
    /**
     * anonymous inner class listening on the add material button
     */
     private class BTNAddMaterialActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        ChooseMaterialsDialog materialsDialog = new ChooseMaterialsDialog(null, true);
        materialsDialog.setLocationRelativeTo(null);
        materialsDialog.setVisible(true);

        // continue here when the dialog box is closed (disposed).
        ArrayList<BEMaterial> mat = materialsDialog.getValgteMaterials();
        //System.out.println(mat.get(0).getMaterial());
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
        }
     
     }  
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
        Timeplan timePlanFrame = new Timeplan();
        timePlanFrame.setLocationRelativeTo(this);
        timePlanFrame.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void chkBoxForcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxForcesActionPerformed
        ShowForces();
    }//GEN-LAST:event_chkBoxForcesActionPerformed

    private void chkBoxWoundedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxWoundedActionPerformed
        ShowWounded();
    }//GEN-LAST:event_chkBoxWoundedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddForces;
    private javax.swing.JButton btnAddMaterial;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkBoxForces;
    private javax.swing.JCheckBox chkBoxWounded;
    private com.toedter.calendar.JDateChooser dcDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpanelIndsatteStyrker;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEvaReportNr;
    private javax.swing.JLabel lblFiretNr;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLeader;
    private javax.swing.JLabel lblMaterialUsed;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRecived;
    private javax.swing.JLabel lblSubHeader;
    private javax.swing.JLabel lblTeamLeader;
    private javax.swing.JLabel lblWeekday;
    private javax.swing.JTable tblForces;
    private javax.swing.JTable tblMaterial;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEvaNr;
    private javax.swing.JTextField txtFireNr;
    private javax.swing.JTextField txtLeader;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRecived;
    private javax.swing.JTextField txtTeamLeader;
    private javax.swing.JTextField txtWeekday;
    // End of variables declaration//GEN-END:variables
/*
     A function to Hide/Show the table for Forces
     */
    private void ShowForces() {
        if (chkBoxForces.isSelected()) {
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
        if (chkBoxWounded.isSelected()) {
            isWounded = true;
        } else {
            isWounded = false;
        }
        lblName.setVisible(isWounded);
        lblAddress.setVisible(isWounded);
        txtName.setVisible(isWounded);
        txtAddress.setVisible(isWounded);
    }
}
