/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEFireman;
import BLL.BLLFireman;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Son Of Satan
 */
public class CRUDFireman extends javax.swing.JFrame {

    CRUDFiremanTableModel FiremanTableModel;
    TableRowSorter<TableModel> sorter;
    ArrayList<BE.BEFireman> allFiremans = new ArrayList<>();
    //
    private int selectedRow;

    /**
     * Populates the allFiremans ArrayList
     */
    private void initFiremans() {
        try {
            allFiremans = BLL.BLLFireman.getInstance().getAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {

            /**
             * When clicking a row it enables the Update button and Sets the
             * visibility of textfields required for the update function
             *
             * @param evt
             */
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onRowSelected(evt
                );
                UpdateButton.setEnabled(true);
                UpdateFieldsPanel.setVisible(true);
            }

            /**
             * Populates the data in textfields required for the update function
             * when clicking a row in a table
             *
             * @param evt
             */
            private void onRowSelected(MouseEvent evt) {
                selectedRow = jTable1.getSelectedRow();
                lblsetCPR.setText(allFiremans.get(selectedRow).getCPR());
                TxtFornavn.setText(allFiremans.get(selectedRow).getFirstName());
                TxtEfternavn.setText(allFiremans.get(selectedRow).getLastName());
                TxtAddress.setText(allFiremans.get(selectedRow).getAddress());
                TxtTlf.setText(allFiremans.get(selectedRow).getPhoneNr());
                TxtCall.setText(allFiremans.get(selectedRow).getCallNr());
                txtPaymentNr.setText(allFiremans.get(selectedRow).getPaymentNr());
                ChBoxLeader.setSelected(allFiremans.get(selectedRow).isLeaderTrained());
            }
        });
    }

    /**
     * Retrieves the information from textfields and packs them into a Business
     * Entity. Then updates the SQL and table afterwards
     */
    private void updateFireman() {
        try {
            BEFireman updateFireman = new BEFireman(allFiremans.get(selectedRow).getCPR(), TxtFornavn.getText(), TxtEfternavn.getText(),
                    TxtAddress.getText(), TxtTlf.getText(), TxtCall.getText(),
                    txtPaymentNr.getText(), ChBoxLeader.isSelected());
            BLL.BLLFireman.getInstance().Update(updateFireman);
            allFiremans.set(selectedRow, updateFireman);
            allFiremans = BLL.BLLFireman.getInstance().getAll();
            FiremanTableModel.setCRUDFiremanList(allFiremans);
            FiremanTableModel.fireTableDataChanged();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Deletes a firemen in table & SQL from the selected row in the table
     */
    private void DeleteFireman() {
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
        jLabelFornavn = new javax.swing.JLabel();
        jLabelEfternavn = new javax.swing.JLabel();
        TxtEfternavn = new javax.swing.JTextField();
        TxtFornavn = new javax.swing.JTextField();
        jLabelAddresse = new javax.swing.JLabel();
        TxtAddress = new javax.swing.JTextField();
        TxtCall = new javax.swing.JTextField();
        jLabelCall = new javax.swing.JLabel();
        TxtTlf = new javax.swing.JTextField();
        jLabelTlf = new javax.swing.JLabel();
        txtPaymentNr = new javax.swing.JTextField();
        lblPaymentNr = new javax.swing.JLabel();
        ChBoxLeader = new javax.swing.JCheckBox();
        lblCPR = new javax.swing.JLabel();
        lblsetCPR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RemoveButton.setText("Fjern");
        RemoveButton.setPreferredSize(new java.awt.Dimension(55, 23));

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
        BackButton.setPreferredSize(new java.awt.Dimension(55, 23));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Tilføj");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update");
        UpdateButton.setMaximumSize(new java.awt.Dimension(55, 23));
        UpdateButton.setMinimumSize(new java.awt.Dimension(55, 23));
        UpdateButton.setPreferredSize(new java.awt.Dimension(55, 23));
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        jLabelFornavn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelFornavn.setText("Fornavn:");

        jLabelEfternavn.setText("Efternavn:");

        jLabelAddresse.setText("Addresse:");

        jLabelCall.setText("Call Nr:");

        jLabelTlf.setText("Tlf. Nr:");

        lblPaymentNr.setText("Løn Nr:");

        ChBoxLeader.setText("Leader Uddannet");
        ChBoxLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChBoxLeaderActionPerformed(evt);
            }
        });

        lblCPR.setText("CPR:");

        lblsetCPR.setToolTipText("");

        javax.swing.GroupLayout UpdateFieldsPanelLayout = new javax.swing.GroupLayout(UpdateFieldsPanel);
        UpdateFieldsPanel.setLayout(UpdateFieldsPanelLayout);
        UpdateFieldsPanelLayout.setHorizontalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEfternavn, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(lblPaymentNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChBoxLeader)
                            .addComponent(TxtEfternavn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(txtPaymentNr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(jLabelCall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtCall, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAddresse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTlf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFornavn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                                .addComponent(lblCPR)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtFornavn, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(lblsetCPR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        UpdateFieldsPanelLayout.setVerticalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPR)
                    .addComponent(lblsetCPR))
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
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaymentNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChBoxLeader))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(RemoveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        BEFireman fireman = firemanDialog.getNewFireman();
        if (fireman != null) // a team has been created in the dialog box.
        {
            try {
                BLLFireman.getInstance().Create(fireman);
                allFiremans.add(fireman);
                FiremanTableModel.setCRUDFiremanList(allFiremans);
                jTable1.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        updateFireman();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void ChBoxLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChBoxLeaderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChBoxLeaderActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        dispose();
        openAdministrationMenu();
    }//GEN-LAST:event_BackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JCheckBox ChBoxLeader;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JTextField TxtAddress;
    private javax.swing.JTextField TxtCall;
    private javax.swing.JTextField TxtEfternavn;
    private javax.swing.JTextField TxtFornavn;
    private javax.swing.JTextField TxtTlf;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JPanel UpdateFieldsPanel;
    private javax.swing.JLabel jLabelAddresse;
    private javax.swing.JLabel jLabelCall;
    private javax.swing.JLabel jLabelEfternavn;
    private javax.swing.JLabel jLabelFornavn;
    private javax.swing.JLabel jLabelTlf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCPR;
    private javax.swing.JLabel lblPaymentNr;
    private javax.swing.JLabel lblsetCPR;
    private javax.swing.JTextField txtPaymentNr;
    // End of variables declaration//GEN-END:variables

    private void openAdministrationMenu() {
        AdminstrationMenu admin = new AdminstrationMenu();
        admin.setVisible(true);
    }

}
