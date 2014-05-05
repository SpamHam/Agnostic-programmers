/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Son Of Satan
 */
public class CRUDMaterial extends javax.swing.JFrame {

    CRUDMaterialTableModel materialTableModel;
    TableRowSorter<TableModel> sorter;
    ArrayList<BE.BEMaterial> allMateriale = new ArrayList<>();
    //
    private int selectedRow;

    private void initMaterial() {
        allMateriale = BLL.BLLMaterial.getInstance.getAll();
    }

    /**
     * Creates new form CRUDMaterial
     */
    public CRUDMaterial() {
        initComponents();
        initMaterial();
        materialTableModel = new CRUDMaterialTableModel(allMateriale);
        jTable1.setModel(materialTableModel);
        jTable1.setRowSorter(sorter);
        jTable1.getTableHeader().setReorderingAllowed(false);
        setTitle("Materiale oversigt");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnOpdatere.setEnabled(false);
        UpdateFieldsPanel.setVisible(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onRowSelected(evt
                );
                btnOpdatere.setEnabled(true);
                UpdateFieldsPanel.setVisible(true);
            }

            private void onRowSelected(MouseEvent evt) {
                selectedRow = jTable1.getSelectedRow();
                txtMaterial.setText(allMateriale.get(selectedRow).getM_Materiale());
                txtAntal.setText(Integer.toString(allMateriale.get(selectedRow).getM_Antal()));
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

        btnFjern = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnTilbage = new javax.swing.JButton();
        btnTilføj = new javax.swing.JButton();
        btnOpdatere = new javax.swing.JButton();
        UpdateFieldsPanel = new javax.swing.JPanel();
        txtAntal = new javax.swing.JTextField();
        txtMaterial = new javax.swing.JTextField();
        lblMaterial = new javax.swing.JLabel();
        lblAntal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFjern.setText("Fjern");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Material", "Antal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnTilbage.setText("Tilbage");
        btnTilbage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTilbageActionPerformed(evt);
            }
        });

        btnTilføj.setText("Tilføj");
        btnTilføj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTilføjActionPerformed(evt);
            }
        });

        btnOpdatere.setText("Opdatere");
        btnOpdatere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpdatereActionPerformed(evt);
            }
        });

        lblMaterial.setText("Material");

        lblAntal.setText("Antal");

        javax.swing.GroupLayout UpdateFieldsPanelLayout = new javax.swing.GroupLayout(UpdateFieldsPanel);
        UpdateFieldsPanel.setLayout(UpdateFieldsPanelLayout);
        UpdateFieldsPanelLayout.setHorizontalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(lblAntal)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(lblMaterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAntal)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UpdateFieldsPanelLayout.setVerticalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaterial)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAntal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAntal))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTilbage, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(btnFjern, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpdatere, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(btnTilføj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnTilføj)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnOpdatere)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnFjern)
                            .addGap(168, 168, 168)
                            .addComponent(btnTilbage))
                        .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTilføjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTilføjActionPerformed
        AddMaterialDialog tilføjMaterial = new AddMaterialDialog(this, true);
        tilføjMaterial.setVisible(true);
    }//GEN-LAST:event_btnTilføjActionPerformed

    private void btnOpdatereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpdatereActionPerformed

    }//GEN-LAST:event_btnOpdatereActionPerformed

    private void btnTilbageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTilbageActionPerformed
        dispose();
        AdminstrationMenu admin = new AdminstrationMenu();
        admin.setVisible(true);
    }//GEN-LAST:event_btnTilbageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UpdateFieldsPanel;
    private javax.swing.JButton btnFjern;
    private javax.swing.JButton btnOpdatere;
    private javax.swing.JButton btnTilbage;
    private javax.swing.JButton btnTilføj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAntal;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JTextField txtAntal;
    private javax.swing.JTextField txtMaterial;
    // End of variables declaration//GEN-END:variables
}
