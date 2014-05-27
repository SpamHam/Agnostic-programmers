/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utility.Event.FormatEventPDF;
import Utility.Error.EventExercutionException;
import BE.BEForces;
import BE.BEMaterial;
import BE.BETimePlan;
import BLL.BLLPDF;
import BLL.BLLPayroll;
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
    ArrayList<BETimePlan> allTime = new ArrayList<>();
    TableRowSorter<TableModel> sorter;
    private String currentTime;
    boolean isForcesSelected = false;
    boolean isWounded = false;
    private PDFListener PDFListener; // holds a reference to a class that implements PDFListener
    ArrayList<PDFListener> APDFListeners = new ArrayList<>();
    BLLPDF BLLPDF = new BLLPDF();
    BLLPayroll BLLPay = new BLLPayroll();
    String evaNr, fireNr, received, date, message, name, address, leader, teamLeader, weekday;

    /**
     * Creates new form ODINReport
     */
    public ODINReport() {
        initComponents();
        setPDFListener(BLLPDF); // sets the BLLPDF as observer
        setPDFListener(BLLPay);
        // sets the model for the material table
        materialModel = new ChooseMaterialsTableModel(allMaterials);
        sorter = new TableRowSorter<TableModel>(materialModel);
        //sets the model for the forces table
        forcesTableModel = new ForcesTableModel(allforces);
        tblForces.setModel(forcesTableModel);
        tblForces.getTableHeader().setReorderingAllowed(false);

        setTitle("ODIN Report");
        this.setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ShowForces();
        ShowWounded();

        //All ActionListeners are listed here
        ActionListener BTNPDFOdinListener = new BTNPDFOdinActionListener();
        btnSave.addActionListener(BTNPDFOdinListener);
        ActionListener BTNAddForces = new BTNAddForcesActionListener();
        btnAddForces.addActionListener(BTNAddForces);
        ActionListener BTNAddMaterial = new BTNAddMaterialActionListener();
        btnAddMaterial.addActionListener(BTNAddMaterial);
        ActionListener BTNBack = new BTNBackListener();
        btnBack.addActionListener(BTNBack);
        ActionListener chkBOXWounded = new chkBoxWoundedListener();
        chkBoxWounded.addActionListener(chkBOXWounded);
        ActionListener chkBOXForces = new chkBoxForcesListener();
        chkBoxForces.addActionListener(chkBOXForces);

    }

    /**
     * sets the PDf listener to a class that implements the PDFListener
     * interface
     *
     * @param PDFListener
     */
//    public void setPDFListener(PDFListener PDFListener) {
//        this.PDFListener = PDFListener;
//    }
    
        /**
     * Sets the PDFListener
     *
     * @param PDFListener
     */
    public void setPDFListener(PDFListener PDFListener) {
        // this.PDFListener = PDFListener;
        APDFListeners.add(PDFListener);
    }

    /**
     * anonymous inner class listening on the create PDF button
     */
    private class BTNPDFOdinActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getOdinData();
            try {
                firePDFEvent(new FormatEventPDF(allTime, allMaterials, materialColNames, allforces, forcesColNames, date,
                        received, fireNr, evaNr, message, name, address, leader, teamLeader, weekday));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * anonymous inner class listening on the create PDF button
     */
    private class BTNAddForcesActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BEForces emptyLine = new BEForces("", "", ""); //makes a empty row for the table 
            allforces.add(emptyLine);
            forcesTableModel.setForcesList(allforces);
        }
    }

    private class BTNBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        dispose();
        Timeplan timePlanFrame = new Timeplan();
        timePlanFrame.setLocationRelativeTo(null);
        timePlanFrame.setVisible(true);
        }
        
    }
    
    /**
     * Fires the event to the BLL
     *
     * @param event
     */
//    public void firePDFEvent(FormatEventPDF event) {
//        if (PDFListener != null) {
//            try {
//                PDFListener.PDFOdinPerformed(event);
//                JOptionPane.showMessageDialog(null, "ODIN Rapport blev genereret", "Færdig", JOptionPane.INFORMATION_MESSAGE);
//            } catch (EventExercutionException eex) {
//                JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
    
        public void firePDFEvent(FormatEventPDF event) throws Exception {
        if (APDFListeners != null) {
            for (PDFListener listener : APDFListeners) {
                listener.PDFOdinPerformed(event);
            }
        }
    }

    /**
     * Sets the time and date in the txtRecieved field & the dcDate field
     *
     * @param t
     */
    public void setTime(String t) {
        currentTime = t;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dato = currentTime.substring(8, 18);
        String tid = currentTime.substring(19);
        try {
            Date date = formatter.parse(dato);
            txtRecived.setText(tid);
            dcDate.setDate(date);
        } catch (ParseException ex) {

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
        scrollPnlTblMaterial = new javax.swing.JScrollPane();
        tblMaterial = new javax.swing.JTable();
        jpanelDeployedForces = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblForces = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnAddForces = new javax.swing.JButton();

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

        lblWeekday.setText("Uge Dag:");

        lblFiretNr.setText("Brand Report Nr:");

        lblEvaReportNr.setText("EVA Report Nr:");

        lblMessage.setText("Melding:");

        chkBoxWounded.setText("Skadeslidte");

        lblName.setText("Navn:");

        lblAddress.setText("Addresse:");

        btnAddMaterial.setText("Tilføj Materialer");

        lblMaterialUsed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMaterialUsed.setText("Materialer Brugt:");

        btnBack.setText("Tilbage");

        chkBoxForces.setText("Indsatte Styrker:");

        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materiale", "Antal"
            }
        ));
        scrollPnlTblMaterial.setViewportView(tblMaterial);

        tblForces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblForces);

        javax.swing.GroupLayout jpanelDeployedForcesLayout = new javax.swing.GroupLayout(jpanelDeployedForces);
        jpanelDeployedForces.setLayout(jpanelDeployedForcesLayout);
        jpanelDeployedForcesLayout.setHorizontalGroup(
            jpanelDeployedForcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jpanelDeployedForcesLayout.setVerticalGroup(
            jpanelDeployedForcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDeployedForcesLayout.createSequentialGroup()
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
                    .addComponent(jpanelDeployedForces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(scrollPnlTblMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(scrollPnlTblMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(chkBoxForces)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanelDeployedForces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSave)
                    .addComponent(btnAddForces))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     *
     */

    /**
     * Is used for creating a PDF. Stores all the data from the different
     * fields.
     */
    private void getOdinData() {
        Timeplan TimeUI = new Timeplan();
        getMaterialColNames();
        getForcesColNames();
        allTime = TimeUI.getTimePlans();
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
     * Retrieves the name of the column for materials. Is needed to create a
     * PDF.
     */
    private void getMaterialColNames() {
        materialColNames = new ArrayList<>();
        for (int i = 0; i < materialModel.getColumnCount(); i++) {
            materialColNames.add(materialModel.getColumnName(i));
        }
    }

    /**
     * Retrieves the name of the columns for forces. Is needed to create a PDF.
     */
    private void getForcesColNames() {
        for (int i = 0; i < forcesTableModel.getColumnCount(); i++) {
            forcesColNames.add(forcesTableModel.getColumnName(i));
        }
    }

    /**
     * anonymous inner class listening on the chkboxWounded
     */
    private class chkBoxWoundedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowWounded();
        }

    }

    /**
     * anonymous inner class listening on the chkboxForces
     */
    private class chkBoxForcesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowForces();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddForces;
    private javax.swing.JButton btnAddMaterial;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkBoxForces;
    private javax.swing.JCheckBox chkBoxWounded;
    private com.toedter.calendar.JDateChooser dcDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelDeployedForces;
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
    private javax.swing.JScrollPane scrollPnlTblMaterial;
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
        jpanelDeployedForces.setVisible(isForcesSelected);

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
