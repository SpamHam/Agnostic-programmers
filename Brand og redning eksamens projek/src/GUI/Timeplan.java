/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import BE.BETimePlan;
import BLL.BLLPDF;
import BLL.BLLTimePlan;
import Utility.PDFGenerator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Peter
 */
public class Timeplan extends javax.swing.JFrame {

    TimePlanTableModel TimeTableModel;
    TableRowSorter<TableModel> sorter;
    ArrayList<BETimePlan> allTime = new ArrayList<>();
    ArrayList<String> colNames;
    BLLTimePlan MyBLLTimePlan = new BLLTimePlan();
    private PDFListener PDFListener; // holds a reference to a class that implements PDFListener
    BLLPDF BLLPDF = new BLLPDF();
    
    /**
     * Creates new form Timeplan
     */
    public Timeplan() {
        initComponents();
        setPDFListener(BLLPDF); // sets the BLLPDF as observer
        TimeTableModel = new TimePlanTableModel(allTime);
        jtableTeamTabel.setModel(TimeTableModel);// Sets the table model for the JTable
        sorter = new TableRowSorter<TableModel>(TimeTableModel);
        jtableTeamTabel.setRowSorter(sorter);
        jtableTeamTabel.getTableHeader().setReorderingAllowed(false);
        txtAndetTekst.setVisible(false);
        setTitle("Udryknings Skema");
        ActionListener BTNPDFListener = new BTNPDFActionListener();
        btnNextPage.addActionListener(BTNPDFListener);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbTypeIndsats = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableTeamTabel = new javax.swing.JTable();
        txtAndetTekst = new javax.swing.JTextField();
        btnVaelgTeam = new javax.swing.JButton();
        btnLukVindue = new javax.swing.JButton();
        btnNextPage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbTypeIndsats.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Indsats", "Øvelse", "Brandvagt", "Stand-By", "Arbejde Falck", "Følgeskadeindsats", "Andet" }));
        cmbTypeIndsats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeIndsatsActionPerformed(evt);
            }
        });

        jtableTeamTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtableTeamTabel);

        txtAndetTekst.setMinimumSize(new java.awt.Dimension(290, 20));
        txtAndetTekst.setPreferredSize(new java.awt.Dimension(290, 20));
        txtAndetTekst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAndetTekstActionPerformed(evt);
            }
        });

        btnVaelgTeam.setText("Vælg Team");
        btnVaelgTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaelgTeamActionPerformed(evt);
            }
        });

        btnLukVindue.setText("Luk Vindue");
        btnLukVindue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLukVindueActionPerformed(evt);
            }
        });

        btnNextPage.setText("Næste side");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbTypeIndsats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAndetTekst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVaelgTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLukVindue, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTypeIndsats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAndetTekst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVaelgTeam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLukVindue)
                    .addComponent(btnNextPage))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaelgTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaelgTeamActionPerformed
        ChooseTeam chooseTeam = new ChooseTeam(this, true);
        chooseTeam.setVisible(true);
        chooseTeam.setLocationRelativeTo(this);

        // continue here when the dialog box is closed (disposed).
        ArrayList<BETimePlan> plan = chooseTeam.getTeam();
        if (plan != null) // a team has been created in the dialog box.
        {
            if (!allTime.isEmpty()) { // checks if there is entries in the time plan 
                for (int i = 0; i < plan.size(); i++) {
                    allTime.add(plan.get(i));
                }
            } else {
                allTime = plan;
            }

            TimeTableModel.setTimePlanStatusList(allTime);
            jtableTeamTabel.repaint();
        }
    }//GEN-LAST:event_btnVaelgTeamActionPerformed

    private void btnLukVindueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLukVindueActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLukVindueActionPerformed
    
    /**
     * anonymous inner class listening on the create pdf button
     */
     private class BTNPDFActionListener implements ActionListener {
     @Override
        public void actionPerformed(ActionEvent e) {
               getColNames();
               firePDFEvent(new FormatEventPDF(allTime, colNames));   
        }
    }
     /**
      * Fires the PDF event
      * @param event type FormatEventPDF
      */
     public void firePDFEvent(FormatEventPDF event){
        if (PDFListener != null){
               try{
               PDFListener.PDFTimePlanPerformed(event);
             JOptionPane.showMessageDialog(null, "ODIN Rapport blev genereret", "Færdig", JOptionPane.INFORMATION_MESSAGE);
             } catch(EventExercutionException eex){
             JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
          }
     }
    
    
//    private void someMethod(){
//        getColNames();
//        pdfGen = new PDFGenerator(allTime, colNames);
//        try {
//            pdfGen.run();
//            JOptionPane.showMessageDialog(this, "ODIN Rapport blev genereret", "Færdig", JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        dispose();
//        ODINReport odinReport = new ODINReport();
//        odinReport.setVisible(true);
//        odinReport.setLocationRelativeTo(this);
//
//}
    private void cmbTypeIndsatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeIndsatsActionPerformed
        if (cmbTypeIndsats.getSelectedItem().toString().trim().equalsIgnoreCase("Andet")) {
            txtAndetTekst.setVisible(true);
        } else {
            txtAndetTekst.setVisible(false);
        }

    }//GEN-LAST:event_cmbTypeIndsatsActionPerformed

    private void getColNames(){
     colNames = new ArrayList<>();
     for(int i=0; i<TimeTableModel.getColumnCount(); i++){
        colNames.add(TimeTableModel.getColumnName(i));
       }
     }
    
    public void setPDFListener(PDFListener PDFListener){
        this.PDFListener = PDFListener;
    }
    
    private void txtAndetTekstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAndetTekstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAndetTekstActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLukVindue;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnVaelgTeam;
    private javax.swing.JComboBox cmbTypeIndsats;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableTeamTabel;
    private javax.swing.JTextField txtAndetTekst;
    // End of variables declaration//GEN-END:variables
}
