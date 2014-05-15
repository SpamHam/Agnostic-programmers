/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEFireman;
import BLL.BLLFireman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private BLLFireman m_fireman;
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
        tblFiremen.setModel(FiremanTableModel);// Sets the table model for the JTable
        sorter = new TableRowSorter<TableModel>(FiremanTableModel);
        tblFiremen.setRowSorter(sorter);
        tblFiremen.getTableHeader().setReorderingAllowed(false);
        setTitle("Brandmand oversigt");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /**
         * All ActionListeners are listed here
         */
        ActionListener BTNAdd = new AddListener();
        btnAdd.addActionListener(BTNAdd);
        ActionListener BTNUpdate = new UpdateListener();
        btnUpdate.addActionListener(BTNUpdate);
        ActionListener BTNRemove = new RemoveListener();
        btnRemove.addActionListener(BTNRemove);
        ActionListener BTNBack = new BackListener();
        btnBack.addActionListener(BTNBack);

        btnUpdate.setEnabled(false);
        UpdateFieldsPanel.setVisible(false);
        tblFiremen.addMouseListener(new java.awt.event.MouseAdapter() {

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
                btnUpdate.setEnabled(true);
                UpdateFieldsPanel.setVisible(true);
            }

            /**
             * Populates the data in textfields required for the update function
             * when clicking a row in a table
             *
             * @param evt
             */
            private void onRowSelected(MouseEvent evt) {
                selectedRow = tblFiremen.getSelectedRow();
                txtFirstName.setText(allFiremans.get(selectedRow).getFirstName());
                txtLastName.setText(allFiremans.get(selectedRow).getLastName());
                txtAddress.setText(allFiremans.get(selectedRow).getAddress());
                txtTelephoneNr.setText(allFiremans.get(selectedRow).getPhoneNr());
                txtCallNr.setText(allFiremans.get(selectedRow).getCallNr());
                txtPaymentNr.setText(allFiremans.get(selectedRow).getPaymentNr());
                txtHiredDate.setText(allFiremans.get(selectedRow).getHiredDate());
                ChBoxIsLeaderTrained.setSelected(allFiremans.get(selectedRow).isLeaderTrained());
            }
        });
    }

    /**
     * Retrieves the information from textfields and packs them into a Business
     * Entity. Then updates the SQL and table afterwards
     */
    private void updateFireman() {
        try {
            BEFireman updateFireman = new BEFireman(allFiremans.get(selectedRow).getID(), txtFirstName.getText(), txtLastName.getText(),
                    txtAddress.getText(), txtTelephoneNr.getText(), txtCallNr.getText(),
                    txtPaymentNr.getText(), ChBoxIsLeaderTrained.isSelected(), allFiremans.get(selectedRow).getHiredDate());
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
        try {
            m_fireman.getInstance().remove(allFiremans.get(selectedRow));
            allFiremans = BLL.BLLFireman.getInstance().getAll();
            FiremanTableModel.setCRUDFiremanList(allFiremans);
            FiremanTableModel.fireTableDataChanged();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddFiremanDialog firemanDialog = new AddFiremanDialog(null, true);
            firemanDialog.setVisible(true);
            firemanDialog.setLocationRelativeTo(null);

            BEFireman fireman = firemanDialog.getNewFireman();
            if (fireman != null) // a team has been created in the dialog box.
            {
                try {
                    BLLFireman.getInstance().Create(fireman);
                    allFiremans.add(fireman);
                    FiremanTableModel.setCRUDFiremanList(allFiremans);
                    tblFiremen.repaint();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }

    /**
     * anonymous inner class listening on the Update button
     */
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateFireman();
        }

    }

    /**
     * anonymous inner class listening on the Remove button
     */
    private class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteFireman();
        }

    }

    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            openAdministrationMenu();
            

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFiremen = new javax.swing.JTable();
        UpdateFieldsPanel = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtCallNr = new javax.swing.JTextField();
        lblCallNr = new javax.swing.JLabel();
        txtTelephoneNr = new javax.swing.JTextField();
        lblTelephoneNr = new javax.swing.JLabel();
        txtPaymentNr = new javax.swing.JTextField();
        lblPaymentNr = new javax.swing.JLabel();
        txtHiredDate = new javax.swing.JTextField();
        lblHiredDate = new javax.swing.JLabel();
        ChBoxIsLeaderTrained = new javax.swing.JCheckBox();
        jpanelButtons = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblFiremen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFiremen);

        UpdateFieldsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Opdater Information"));

        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstName.setText("Fornavn:");

        lblLastName.setText("Efternavn:");

        lblAddress.setText("Addresse:");

        lblCallNr.setText("Tilkalds Nr:");

        lblTelephoneNr.setText("Tlf. Nr:");

        lblPaymentNr.setText("Løn Nr:");

        lblHiredDate.setText("Ansat:");

        ChBoxIsLeaderTrained.setText("Leader Uddannet");

        javax.swing.GroupLayout UpdateFieldsPanelLayout = new javax.swing.GroupLayout(UpdateFieldsPanel);
        UpdateFieldsPanel.setLayout(UpdateFieldsPanelLayout);
        UpdateFieldsPanelLayout.setHorizontalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHiredDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelephoneNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelephoneNr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(lblCallNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCallNr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(lblPaymentNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChBoxIsLeaderTrained)
                            .addComponent(txtPaymentNr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        UpdateFieldsPanelLayout.setVerticalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHiredDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelephoneNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelephoneNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCallNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCallNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaymentNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentNr))
                .addGap(7, 7, 7)
                .addComponent(ChBoxIsLeaderTrained))
        );

        jpanelButtons.setBorder(javax.swing.BorderFactory.createTitledBorder("Funktioner"));

        btnRemove.setText("Fjern");
        btnRemove.setPreferredSize(new java.awt.Dimension(55, 23));

        btnAdd.setText("Tilføj");

        btnUpdate.setText("Opdater");
        btnUpdate.setMaximumSize(new java.awt.Dimension(55, 23));
        btnUpdate.setMinimumSize(new java.awt.Dimension(55, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(55, 23));

        javax.swing.GroupLayout jpanelButtonsLayout = new javax.swing.GroupLayout(jpanelButtons);
        jpanelButtons.setLayout(jpanelButtonsLayout);
        jpanelButtonsLayout.setHorizontalGroup(
            jpanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanelButtonsLayout.setVerticalGroup(
            jpanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelButtonsLayout.createSequentialGroup()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnBack.setText("Tilbage");
        btnBack.setPreferredSize(new java.awt.Dimension(100, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jpanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(148, 148, 148)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChBoxIsLeaderTrained;
    private javax.swing.JPanel UpdateFieldsPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelButtons;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCallNr;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblHiredDate;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPaymentNr;
    private javax.swing.JLabel lblTelephoneNr;
    private javax.swing.JTable tblFiremen;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCallNr;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHiredDate;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPaymentNr;
    private javax.swing.JTextField txtTelephoneNr;
    // End of variables declaration//GEN-END:variables

    private void openAdministrationMenu() {
        AdminstrationMenu admin = new AdminstrationMenu();
        admin.setVisible(true);
    }

}
