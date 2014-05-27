/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utility.Event.FormatEventPDF;
import BE.BETimePlan;
import BLL.BLLFireman;
import BLL.BLLPDF;
import BLL.BLLPayroll;
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
    String type;
    int selectedType;
    private PDFListener PDFListener; // holds a reference to a class that implements PDFListener
    ArrayList<PDFListener> APDFListeners = new ArrayList<>();
    BLLPDF BLLPDF = new BLLPDF();
    //BLLFireman BLLFireman = new BLLFireman();
    BLLPayroll BLLPayroll = new BLLPayroll();

    /**
     * Creates new form Timeplan
     */
    public Timeplan() {
        initComponents();
        setPDFListener(BLLPDF); // sets the BLLPDF as observer
        setPDFListener(BLLPayroll);
        TimeTableModel = new TimePlanTableModel(allTime);
        tblTeam.setModel(TimeTableModel);// Sets the table model for the JTable
        sorter = new TableRowSorter<TableModel>(TimeTableModel);
        tblTeam.setRowSorter(sorter);
        tblTeam.getTableHeader().setReorderingAllowed(false);
        txtOtherText.setEnabled(false);
        cmbType.getModel().setSelectedItem("Vælg en type");
        setTitle("Udryknings Skema");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /**
         * All ActionListeners are listed here
         */
        ActionListener BTNPDFListener = new BTNPDFActionListener();
        ActionListener BTNChooseTeam = new ChooseTeamListener();
        ActionListener BTNClose = new CloseListener();
        ActionListener CMBBOXType = new CMBBoxListener();
        btnNextPage.addActionListener(BTNPDFListener);
        btnChooseATeam.addActionListener(BTNChooseTeam);
        btnClose.addActionListener(BTNClose);
        cmbType.addActionListener(CMBBOXType);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbType = new javax.swing.JComboBox();
        scrollPnlTblTeam = new javax.swing.JScrollPane();
        tblTeam = new javax.swing.JTable();
        btnChooseATeam = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnNextPage = new javax.swing.JButton();
        txtOtherText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Indsats", "Stand-By", "Andet", "Arbejde Falck", "Følgeskadeindsats", "Øvelse", "Brandvagt", " ", " " }));

        tblTeam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPnlTblTeam.setViewportView(tblTeam);

        btnChooseATeam.setText("Vælg Team");

        btnClose.setText("Luk Vindue");

        btnNextPage.setText("Næste side");

        txtOtherText.setMinimumSize(new java.awt.Dimension(290, 23));
        txtOtherText.setPreferredSize(new java.awt.Dimension(290, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPnlTblTeam)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOtherText, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChooseATeam, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChooseATeam)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOtherText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPnlTblTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnNextPage))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * anonymous inner class listening on the TypeComboBox
     */
    private class CMBBoxListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cmbType.getSelectedItem().equals("Andet")) {
                txtOtherText.setEnabled(true);
                type = (String) cmbType.getSelectedItem();
                type = type + " - ";
            } else {
                txtOtherText.setEnabled(false);
                type = (String) cmbType.getSelectedItem();
            }

        }

    }

    /**
     * anonymous inner class listening on the Close button
     */
    private class CloseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }

    }

    /**
     * anonymous inner class listening on the ChooseATeam button
     */
    private class ChooseTeamListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ChooseTeam chooseTeam = new ChooseTeam(Timeplan.this, true);
            chooseTeam.setVisible(true);
            chooseTeam.setLocationRelativeTo(null);

            // continue here when the dialog box is closed (disposed).
            ArrayList<BETimePlan> plan = chooseTeam.getTeam();
            if (plan != null) // a team has been created in the dialog box.
            {
                if (!allTime.isEmpty()) { // checks if there already is entries in the time plan arraylist 
                    for (int i = 0; i < plan.size(); i++) {
                        allTime.add(plan.get(i));
                    }
                } else {
                    allTime = plan;
                }

                TimeTableModel.setTimePlanStatusList(allTime);
                tblTeam.repaint();
            }
        }

    }

    /**
     * anonymous inner class listening on the create PDF button
     */
    private class BTNPDFActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getColNames();
            type = type + txtOtherText.getText().trim();
            getSelectedType();
            if (cmbType.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Vælg en type af Indsats", "Manglende information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                firePDFEvent(new FormatEventPDF(allTime, colNames, type, selectedType));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!type.equalsIgnoreCase("øvelse") && !type.equalsIgnoreCase("brandvagt") && !type.equalsIgnoreCase("stand-by")) {
                dispose();
                ODINReport report = new ODINReport();
                report.setVisible(true);
                report.setLocationRelativeTo(null);
            } else {
                dispose();

            }
        }

        private void getSelectedType() {
            selectedType = cmbType.getSelectedIndex();
            if (cmbType.getSelectedIndex() == 3 || cmbType.getSelectedIndex() == 4 || cmbType.getSelectedIndex() == 5) {
                selectedType = 2;
            } else if (cmbType.getSelectedIndex() == 6) {
                selectedType = 3;
            } else if (cmbType.getSelectedIndex() == 7) {
                selectedType = 4;
            }
            selectedType++;
        }
    }

    public void firePDFEvent(FormatEventPDF event) throws Exception {
        if (APDFListeners != null) {
            for (PDFListener listener : APDFListeners) {
                listener.PDFTimePlanPerformed(event);
            }
        }
    }

    /**
     * Returns the Column Names
     */
    private void getColNames() {
        colNames = new ArrayList<>();
        for (int i = 0; i < TimeTableModel.getColumnCount(); i++) {
            colNames.add(TimeTableModel.getColumnName(i));
        }
    }

    /**
     * Sets the PDFListener
     *
     * @param PDFListener
     */
    public void setPDFListener(PDFListener PDFListener) {
        // this.PDFListener = PDFListener;
        APDFListeners.add(PDFListener);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseATeam;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JScrollPane scrollPnlTblTeam;
    private javax.swing.JTable tblTeam;
    private javax.swing.JTextField txtOtherText;
    // End of variables declaration//GEN-END:variables
}
