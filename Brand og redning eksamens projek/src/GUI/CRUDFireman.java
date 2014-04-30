/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BECRUDFireman;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Son Of Satan
 */
public class CRUDFireman extends javax.swing.JFrame {

    CRUDFiremanTableModel FiremanTableModel;
    TableRowSorter<TableModel> sorter;
    ArrayList<BECRUDFireman> allFiremans = new ArrayList<>();
    BECRUDFireman myBEFireman = new BECRUDFireman();

    private void initFiremans() {
        allFiremans = myBEFireman.getAll();
    }

    /**
     * Creates new form CRUDFireman
     */
    public CRUDFireman() {
        initComponents();
        initFiremans();
        FiremanTableModel = new CRUDFiremanTableModel(allFiremans);
        jTable1.setModel(FiremanTableModel);// Sets the table model for the JTable
        sorter = new TableRowSorter<TableModel>(FiremanTableModel);
        jTable1.setRowSorter(sorter);
        jTable1.getTableHeader().setReorderingAllowed(false);
        setTitle("Brandmand oversigt");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        UpdateButton.setEnabled(false);
        UpdateFieldsPanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RemoveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        UpdateFieldsPanel = new javax.swing.JPanel();
        jLabelCPR = new javax.swing.JLabel();
        jLabelFornavn = new javax.swing.JLabel();
        jLabelEfternavn = new javax.swing.JLabel();
        TxtCPR = new javax.swing.JTextField();
        TxtEfternavn = new javax.swing.JTextField();
        TxtFornavn = new javax.swing.JTextField();
        jLabelAddresse = new javax.swing.JLabel();
        TxtAddress = new javax.swing.JTextField();
        TxtCall = new javax.swing.JTextField();
        jLabelCall = new javax.swing.JLabel();
        TxtTlf = new javax.swing.JTextField();
        ChBoxLeader = new javax.swing.JCheckBox();
        jLabelTlf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RemoveButton.setText("Fjern");
        RemoveButton.setPreferredSize(new java.awt.Dimension(60, 23));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CPR", "Fornavn", "Efternavn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BackButton.setText("Tilbage");
        BackButton.setPreferredSize(new java.awt.Dimension(60, 23));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Tilføj");
        AddButton.setPreferredSize(new java.awt.Dimension(60, 23));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update");
        UpdateButton.setPreferredSize(new java.awt.Dimension(60, 23));
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        jLabelCPR.setText("CPR");

        jLabelFornavn.setText("Fornavn");

        jLabelEfternavn.setText("Efternavn");

        jLabelAddresse.setText("Addresse");

        jLabelCall.setText("Call Nr.");

        ChBoxLeader.setText("Leader Uddannet");
        ChBoxLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChBoxLeaderActionPerformed(evt);
            }
        });

        jLabelTlf.setText("Tlf. Nr.");

        javax.swing.GroupLayout UpdateFieldsPanelLayout = new javax.swing.GroupLayout(UpdateFieldsPanel);
        UpdateFieldsPanel.setLayout(UpdateFieldsPanelLayout);
        UpdateFieldsPanelLayout.setHorizontalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addComponent(jLabelAddresse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEfternavn)
                    .addComponent(jLabelFornavn)
                    .addComponent(jLabelCPR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TxtFornavn, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtCPR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtEfternavn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCall)
                    .addComponent(jLabelTlf))
                .addGap(16, 16, 16)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChBoxLeader)
                    .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TxtTlf)
                        .addComponent(TxtCall, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        UpdateFieldsPanelLayout.setVerticalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCPR)
                    .addComponent(TxtCPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFornavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFornavn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEfternavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEfternavn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddresse)
                    .addComponent(TxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTlf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCall))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChBoxLeader)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(RemoveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        AddFiremanDialog firemanDialog = new AddFiremanDialog(this, true);
        firemanDialog.setVisible(true);
        firemanDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void ChBoxLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChBoxLeaderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChBoxLeaderActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JCheckBox ChBoxLeader;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JTextField TxtAddress;
    private javax.swing.JTextField TxtCPR;
    private javax.swing.JTextField TxtCall;
    private javax.swing.JTextField TxtEfternavn;
    private javax.swing.JTextField TxtFornavn;
    private javax.swing.JTextField TxtTlf;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JPanel UpdateFieldsPanel;
    private javax.swing.JLabel jLabelAddresse;
    private javax.swing.JLabel jLabelCPR;
    private javax.swing.JLabel jLabelCall;
    private javax.swing.JLabel jLabelEfternavn;
    private javax.swing.JLabel jLabelFornavn;
    private javax.swing.JLabel jLabelTlf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
