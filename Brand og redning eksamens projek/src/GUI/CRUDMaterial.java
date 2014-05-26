
package GUI;

import BE.BEMaterial;
import BLL.BLLMaterial;
import Utility.Error.EventExercutionException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Peter
 */
public class CRUDMaterial extends javax.swing.JFrame {

    private MaterialListener materialListener; // holds a reference to a class that implements MaterialListener
    CRUDMaterialTableModel materialTableModel;
    TableRowSorter<TableModel> sorter;
    ArrayList<BE.BEMaterial> allMaterials = new ArrayList<>();
    private BLLMaterial m_material = new BLLMaterial();
    //
    private int selectedRow;

    /**
     * Populates the allMaterials ArrayList
     */
    private void initMaterial() {
        try {
            allMaterials = m_material.VehicleReadPerformed();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form CRUDMaterial
     */
    public CRUDMaterial() {
        initComponents();
        initMaterial();
        ActionListener BTNAdd = new AddListener();
        setMaterialListener(m_material);

        /**
         * All ActionListeners are listed here
         */
        btnAdd.addActionListener(BTNAdd);
        ActionListener BTNUpdate = new UpdateListener();
        btnUpdate.addActionListener(BTNUpdate);
        ActionListener BTNRemove = new RemoveListener();
        btnRemove.addActionListener(BTNRemove);
        ActionListener BTNBack = new BackListener();
        btnBack.addActionListener(BTNBack);

        materialTableModel = new CRUDMaterialTableModel(allMaterials);
        tblMaterial.setModel(materialTableModel);
        tblMaterial.setRowSorter(sorter);
        tblMaterial.getTableHeader().setReorderingAllowed(false);
        setTitle("Materiale oversigt");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnUpdate.setEnabled(false);
        UpdateFieldsPanel.setVisible(false);
        tblMaterial.addMouseListener(new java.awt.event.MouseAdapter() {

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
                selectedRow = tblMaterial.getSelectedRow();
                txtMaterial.setText(allMaterials.get(selectedRow).getMaterial());

            }
        });
    }

          /**
     * sets the material listener to a class that implements the materialListener interface
     * @param materialListener 
     */
      public void setMaterialListener(MaterialListener materialListener){
        this.materialListener = materialListener;
    }

    /**
     * anonymous inner class listening on the Add button
     */
    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddMaterialDialog tilføjMaterial = new AddMaterialDialog(null, true);
            tilføjMaterial.setVisible(true);
            // continue here when the dialog box is closed (disposed).
            BE.BEMaterial Material = tilføjMaterial.getMaterial();
            if (Material != null) // a material has been created in the dialog box.
            {
                    fireCreateMaterialEvent(Material);
                    initMaterial();
                materialTableModel.setMaterialList(allMaterials);
                materialTableModel.fireTableDataChanged();

            }
        }

    }
    
          
    /**
     * fires the create event
     * @param event 
     */
     public void fireCreateMaterialEvent(BEMaterial event){
        if (materialListener != null){
            try{
              materialListener.MaterialCreatePerformed(event);
             } catch(EventExercutionException eex){
             JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
          }
     }
     
         /**
     * fires the update event
     * @param event 
     */
     public void fireUpdateMaterialEvent(BEMaterial event){
        if (materialListener != null){
            try{
              materialListener.MaterialUpdatePerformed(event);
             } catch(EventExercutionException eex){
             JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
          }
     }
     
              /**
     * fires the remove event
     * @param event 
     */
     public void fireRemoveMaterialEvent(BEMaterial event){
        if (materialListener != null){
            try{
              materialListener.MaterialRemovePerformed(event);
             } catch(EventExercutionException eex){
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
            try {
               // BLL.BLLMaterial.getInstance().Update(new BE.BEMaterial(allMaterials.get(selectedRow).getEmergencyID(), txtMaterial.getText().trim()));
                BEMaterial event = new BE.BEMaterial(allMaterials.get(selectedRow).getEmergencyID(), txtMaterial.getText().trim());
                fireUpdateMaterialEvent(event);
                allMaterials = m_material.VehicleReadPerformed();
                materialTableModel.setMaterialList(allMaterials);
                materialTableModel.fireTableDataChanged();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            btnUpdate.setEnabled(false);
        }

    }

    /**
     * anonymous inner class listening on the Remove button
     */
    private class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BEMaterial event = new BE.BEMaterial(allMaterials.get(selectedRow).getMaterial());
            fireRemoveMaterialEvent(event);
            allMaterials.remove(selectedRow);
                initMaterial();
                materialTableModel.setMaterialList(allMaterials);
                materialTableModel.fireTableDataChanged();
            
        }

    }
/**
 * anonymous inner class listening on the back button
 */
    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            openAdministrationMenu();
        }

    }
    
        /**
     * Opens the Administration Menu frame
     */
    private void openAdministrationMenu() {
        AdminstrationMenu admin = new AdminstrationMenu();
        admin.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPnlTblMaterials = new javax.swing.JScrollPane();
        tblMaterial = new javax.swing.JTable();
        UpdateFieldsPanel = new javax.swing.JPanel();
        txtMaterial = new javax.swing.JTextField();
        lblMateriale = new javax.swing.JLabel();
        jPanelButtons = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPnlTblMaterials.setViewportView(tblMaterial);

        UpdateFieldsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Opdater Information"));

        lblMateriale.setText("Materiale:");

        javax.swing.GroupLayout UpdateFieldsPanelLayout = new javax.swing.GroupLayout(UpdateFieldsPanel);
        UpdateFieldsPanel.setLayout(UpdateFieldsPanelLayout);
        UpdateFieldsPanelLayout.setHorizontalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addComponent(lblMateriale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UpdateFieldsPanelLayout.setVerticalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMateriale))
                .addGap(31, 31, 31))
        );

        jPanelButtons.setBorder(javax.swing.BorderFactory.createTitledBorder("Funktioner"));

        btnRemove.setText("Fjern");

        btnAdd.setText("Tilføj");

        btnUpdate.setText("Opdater");

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnRemove)
                .addGap(3, 3, 3))
            .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonsLayout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(btnUpdate)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );

        btnBack.setText("Tilbage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPnlTblMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(scrollPnlTblMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UpdateFieldsPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JLabel lblMateriale;
    private javax.swing.JScrollPane scrollPnlTblMaterials;
    private javax.swing.JTable tblMaterial;
    private javax.swing.JTextField txtMaterial;
    // End of variables declaration//GEN-END:variables


}
