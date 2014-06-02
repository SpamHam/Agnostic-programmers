/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utility.DateConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Kathrine
 */
public class EmergencyStartDialog extends javax.swing.JDialog {

    EmergencyStart start = new EmergencyStart();
    private ArrayList<String> startTider = new ArrayList<>();
    private ArrayList<String> nyeTider = new ArrayList<>();
    EmergencyStartDialogTableModel StartTableModel;
    TableRowSorter<TableModel> sorter;

    /**
     * Creates new form EmergencyStartDialog
     */
    public EmergencyStartDialog(java.awt.Frame parent, boolean modal, ArrayList<String> tider) {
        super(parent, modal);
        initComponents();
        nyeTider = tider;
        iniTimeStamps();

        StartTableModel = new EmergencyStartDialogTableModel(startTider);
        tblCallOverview.setModel(StartTableModel);
        sorter = new TableRowSorter<TableModel>(StartTableModel);
        tblCallOverview.setRowSorter(sorter);
        setTitle("Liste over udrykningstider");
        tblCallOverview.getTableHeader().setReorderingAllowed(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //All ActionListeners are listed here
        ActionListener BTNBack = new BTNBackListener();
        btnBack.addActionListener(BTNBack);
        ActionListener BTNMakeOdinReport = new BTNMakeOdinReportListener();
        btnMakeAnODINReport.addActionListener(BTNMakeOdinReport);
    }

    /**
     * Initializes the Timestamps
     */
    private void iniTimeStamps() {
        try {

            startTider = BLL.BLLEmergencyStart.getInstance().RemoveOldDates();
            for (String i : nyeTider) {

                startTider.add(i);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class BTNBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            startTider.clear();
            EmergencyStart startMenu = new EmergencyStart();
            startMenu.setVisible(true);
            dispose();
        }
    }

    private class BTNMakeOdinReportListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ODINReport report = new ODINReport();
            report.setTime(startTider.get(tblCallOverview.getSelectedRow()).toString());
            report.setVisible(true);
            dispose();
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

        scrollPnlCallOverview = new javax.swing.JScrollPane();
        tblCallOverview = new javax.swing.JTable();
        btnMakeAnODINReport = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblCallOverview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollPnlCallOverview.setViewportView(tblCallOverview);

        btnMakeAnODINReport.setText("Lav ODINRapport");

        btnBack.setText("Tilbage");
        btnBack.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(scrollPnlCallOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMakeAnODINReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(scrollPnlCallOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMakeAnODINReport)
                    .addComponent(btnBack))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMakeAnODINReport;
    private javax.swing.JScrollPane scrollPnlCallOverview;
    private javax.swing.JTable tblCallOverview;
    // End of variables declaration//GEN-END:variables
}
