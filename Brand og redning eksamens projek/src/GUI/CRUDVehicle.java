/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEVehicle;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import BLL.BLLVehicle;
import DALC.DALCVehicle;
import DALC.DALCVehicleTest;
import Utility.Error.EventExercutionException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Son Of Satan
 */
public class CRUDVehicle extends javax.swing.JFrame {

    private VehicleListener vehicleListener; // holds a reference to a class that implements VehicleListener

    CRUDVehicleTableModel vehicleTableModel;
    TableRowSorter<TableModel> sorter;
    ArrayList<BE.BEVehicle> allVehicle = new ArrayList<>();
    private BLLVehicle BLLvehicle;
    //
    private int selectedRow;

    /**
     * Populates the allVehicle ArrayList
     */
    private void initVehicle() {

        try {
            allVehicle = BLLvehicle.VehicleReadPerformed();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Initializes DALCVehicle
     */
    private void initDALC() {

        try {
            BLLvehicle = new BLLVehicle(new DALCVehicle());
        } catch (SQLServerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Initializes DALCTest
     */
    private void initDALCTest() {
        BLLvehicle = new BLLVehicle(new DALCVehicleTest());
    }

    /**
     * Creates new form CRUDVehicle
     */
    public CRUDVehicle() {
        initComponents();
        initDALC(); //Only one of these (initDALC/initDALCTest) should be uncommented
        //initDALCTest(); //Only one of these (initDALC/initDALCTest) should be uncommented
        setVehicleListener(BLLvehicle);
        initVehicle();

        vehicleTableModel = new CRUDVehicleTableModel(allVehicle);
        tblVehicle.setModel(vehicleTableModel);
        tblVehicle.setRowSorter(sorter);
        tblVehicle.getTableHeader().setReorderingAllowed(false);

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

        setTitle("Brandbils oversigt");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnUpdate.setEnabled(false);
        jpanelUpdateFields.setVisible(false);
        tblVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override

            /**
             * When clicking a row it enables the Update button and Sets the
             * visibility of textfields required for the update function
             */
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onRowSelected(evt
                );
                btnUpdate.setEnabled(true);
                jpanelUpdateFields.setVisible(true);
            }

            /**
             * Populates the data in textfields required for the update function
             * when clicking a row in a table
             *
             * @param evt
             */
            private void onRowSelected(MouseEvent evt) {
                selectedRow = tblVehicle.getSelectedRow();
                lblRegistrationNr.setText(allVehicle.get(selectedRow).getM_registrationNr());
                txtBrand.setText(allVehicle.get(selectedRow).getM_brand());
                txtModel.setText(allVehicle.get(selectedRow).getM_model());
                txtDescription.setText(allVehicle.get(selectedRow).getM_description());
            }
        });
    }

    /**
     * sets the vehicle listener to a class that implements the vehicleListener
     * interface
     *
     * @param vehicleListener
     */
    public void setVehicleListener(VehicleListener vehicleListener) {
        this.vehicleListener = vehicleListener;
    }

    private void openAdministrationMenu() {
        AdminstrationMenu admin = new AdminstrationMenu();
        admin.setVisible(true);
    }

    /**
     * anonymous inner class listening on the Add button
     */
    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddVehicleDialog addVehicle = new AddVehicleDialog(null, true);
            addVehicle.setVisible(true);

            // continue here when the dialog box is closed (disposed).
            BEVehicle vehicle = addVehicle.getVehicle();
            if (vehicle != null) // a vehicle has been created in the dialog box.
            {
                allVehicle.add(vehicle);
                vehicleTableModel.setVehicleList(allVehicle);
                tblVehicle.repaint();
                fireCreateVehicleEvent(vehicle);
            }
        }

    }

    /**
     * fires the create event
     *
     * @param event
     */
    public void fireCreateVehicleEvent(BEVehicle event) {
        if (vehicleListener != null) {
            try {
                vehicleListener.VehicleCreatePerformed(event);
            } catch (EventExercutionException eex) {
                JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * anonymous inner class listening on the Update button
     */
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BEVehicle updateVehicle = new BEVehicle(lblRegistrationNr.getText(), txtBrand.getText(), txtModel.getText(), txtDescription.getText()
            );
            fireUpdateVehicleEvent(updateVehicle);
            allVehicle.set(selectedRow, updateVehicle);
            vehicleTableModel.setVehicleList(allVehicle);
            vehicleTableModel.fireTableDataChanged();
            tblVehicle.repaint();
        }

    }

    /**
     * fires the update event
     *
     * @param event
     */
    public void fireUpdateVehicleEvent(BEVehicle event) {
        if (vehicleListener != null) {
            try {
                vehicleListener.VehicleUpdatePerformed(event);
            } catch (EventExercutionException eex) {
                JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * fires the remove event
     *
     * @param event
     */
    public void fireRemoveVehicleEvent(BEVehicle event) {
        if (vehicleListener != null) {
            try {
                vehicleListener.VehicleRemovePerformed(event);
            } catch (EventExercutionException eex) {
                JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * anonymous inner class listening on the Remove button
     */
    private class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BEVehicle event = allVehicle.get(selectedRow);
            fireRemoveVehicleEvent(event);
            initVehicle();
            vehicleTableModel.setVehicleList(allVehicle);
            vehicleTableModel.fireTableDataChanged();

        }

    }

    /**
     * anonymous inner class listening on the Back button
     */
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

        scrollPnlTblVehicle = new javax.swing.JScrollPane();
        tblVehicle = new javax.swing.JTable();
        jpanelUpdateFields = new javax.swing.JPanel();
        scrollPnlDescription = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblDescription = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        lblModel = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        lblBrand = new javax.swing.JLabel();
        lblRegistrationNr = new javax.swing.JLabel();
        lblRegNr = new javax.swing.JLabel();
        jPanelFunctions = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 300));

        tblVehicle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registration Nr.", "Brand", "Model"
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
        scrollPnlTblVehicle.setViewportView(tblVehicle);

        jpanelUpdateFields.setBorder(javax.swing.BorderFactory.createTitledBorder("Opdater information"));

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        scrollPnlDescription.setViewportView(txtDescription);

        lblDescription.setText("Beskrivelse:");

        lblModel.setText("Model:");

        lblBrand.setText("Mærke:");

        lblRegNr.setText("Reg. Nr:");

        javax.swing.GroupLayout jpanelUpdateFieldsLayout = new javax.swing.GroupLayout(jpanelUpdateFields);
        jpanelUpdateFields.setLayout(jpanelUpdateFieldsLayout);
        jpanelUpdateFieldsLayout.setHorizontalGroup(
            jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelUpdateFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelUpdateFieldsLayout.createSequentialGroup()
                        .addGroup(jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescription)
                            .addComponent(scrollPnlDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelUpdateFieldsLayout.createSequentialGroup()
                        .addGroup(jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelUpdateFieldsLayout.createSequentialGroup()
                                .addGroup(jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jpanelUpdateFieldsLayout.createSequentialGroup()
                                .addComponent(lblRegNr)
                                .addGap(39, 39, 39)))
                        .addGroup(jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRegistrationNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txtModel))))
                .addContainerGap())
        );
        jpanelUpdateFieldsLayout.setVerticalGroup(
            jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelUpdateFieldsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistrationNr, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBrand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelUpdateFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPnlDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelFunctions.setBorder(javax.swing.BorderFactory.createTitledBorder("Funktioner"));

        btnRemove.setText("Fjern");

        btnAdd.setText("Tilføj");

        btnUpdate.setText("Opdatere");

        javax.swing.GroupLayout jPanelFunctionsLayout = new javax.swing.GroupLayout(jPanelFunctions);
        jPanelFunctions.setLayout(jPanelFunctionsLayout);
        jPanelFunctionsLayout.setHorizontalGroup(
            jPanelFunctionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelFunctionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
        );
        jPanelFunctionsLayout.setVerticalGroup(
            jPanelFunctionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFunctionsLayout.createSequentialGroup()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnRemove))
            .addGroup(jPanelFunctionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFunctionsLayout.createSequentialGroup()
                    .addContainerGap(29, Short.MAX_VALUE)
                    .addComponent(btnUpdate)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );

        btnBack.setText("Tilbage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPnlTblVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                .addComponent(jpanelUpdateFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelFunctions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelFunctions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addComponent(scrollPnlTblVehicle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jpanelUpdateFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanelFunctions;
    private javax.swing.JPanel jpanelUpdateFields;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblRegNr;
    private javax.swing.JLabel lblRegistrationNr;
    private javax.swing.JScrollPane scrollPnlDescription;
    private javax.swing.JScrollPane scrollPnlTblVehicle;
    private javax.swing.JTable tblVehicle;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtModel;
    // End of variables declaration//GEN-END:variables
}
