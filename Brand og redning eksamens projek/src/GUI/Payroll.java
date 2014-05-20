/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Claus
 */
public class Payroll extends javax.swing.JFrame {

    PayrollTableModel Payrollmodel;
    TableRowSorter<TableModel> sorter;
    ArrayList<BE.BETableSalary> allSalary = new ArrayList<>();
    private int SelectedRow;

    /**
     * Creates new form Payroll
     */
    public Payroll() {
        initAllSalary();
        initComponents();
        setTitle("Time oversigt");
        Payrollmodel = new PayrollTableModel(allSalary);
        tblPayroll.setModel(Payrollmodel);
        sorter = new TableRowSorter<TableModel>(Payrollmodel);
        tblPayroll.setRowSorter(sorter);
        tblPayroll.getTableHeader().setReorderingAllowed(rootPaneCheckingEnabled);
        ActionListener btnDet = new DetaljeListener();
        btnDetaljer.addActionListener(btnDet);
        ActionListener btnpdf = new PrintPdfListener();
        btnPrintToPDF.addActionListener(btnpdf);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        tblPayroll.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectedRow = tblPayroll.getSelectedRow();
            }
        });
    }

    private void initAllSalary() {
        try {
            allSalary = BLL.BLLPayroll.getInstance().getAllTableSalary();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     */
    private class DetaljeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                String row = allSalary.get(SelectedRow).getSalaryNumber();
                GUI.PayrollDetails PD = new GUI.PayrollDetails(null, true, row);
                PD.setVisible(true);
                initAllSalary();
                Payrollmodel.setTimePlanStatusList(allSalary);
                Payrollmodel.fireTableDataChanged();
                
            } catch (Exception ex) {
                Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     *
     */
    private class PrintPdfListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BLL.BLLPayroll.getInstance().removeall();
                initAllSalary();
                Payrollmodel.setTimePlanStatusList(allSalary);
                Payrollmodel.fireTableDataChanged();
                
            } catch (Exception ex) {
                Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(EmergencyStart.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmergencyStart.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmergencyStart.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmergencyStart.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payroll().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayroll = new javax.swing.JTable();
        jDateChooserPickADate = new com.toedter.calendar.JDateChooser();
        lblPickADate = new javax.swing.JLabel();
        btnPrintToPDF = new javax.swing.JButton();
        btnDetaljer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPayroll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Navn", "Løn Nr.", "Brand Brandmand", "Brand Holdleder", "Standby station Brandmand", "Standby station Holdleder", "Arb. på station/ Andet", "Øvelse Brandmand", "Øvelse Holdleder", "Vagt Brandmand Helligdag", "Vagt Brandmand Hverdag", "Vagt Helligdag Holdleder", "Vagt Hverdag Holdleder"
            }
        ));
        jScrollPane1.setViewportView(tblPayroll);

        lblPickADate.setText("Vælg en dato:");

        btnPrintToPDF.setText("Print til PDF");
        btnPrintToPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintToPDFActionPerformed(evt);
            }
        });

        btnDetaljer.setText("Detaljer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPickADate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserPickADate, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDetaljer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrintToPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserPickADate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPickADate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrintToPDF)
                    .addComponent(btnDetaljer))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintToPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintToPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintToPDFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetaljer;
    private javax.swing.JButton btnPrintToPDF;
    private com.toedter.calendar.JDateChooser jDateChooserPickADate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPickADate;
    private javax.swing.JTable tblPayroll;
    // End of variables declaration//GEN-END:variables
}
