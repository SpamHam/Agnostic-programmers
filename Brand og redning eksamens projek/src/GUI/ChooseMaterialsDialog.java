/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEMaterial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Claus
 */
public class ChooseMaterialsDialog extends javax.swing.JDialog {

    ArrayList<BEMaterial> Materials;
    ArrayList<BEMaterial> valgteMaterials;
    DefaultListModel alleListModel = new DefaultListModel();
    DefaultListModel valgteListModel = new DefaultListModel();

    /**
     * Creates new form ChooseMaterialsDialog
     */
    public void InitializeMaterials() {
        try {
            Materials = BLL.BLLMaterial.getInstance().getAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ChooseMaterialsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        InitializeMaterials();
        setTitle("Materiale Oversigt");
        ActionListener BTNListener = new BTNMoveActionListener();
        ActionListener BTNTilfoejListener = new BTNTilfoejActionListener();
        btnFoejTilMaterialer.addActionListener(BTNListener);
        btnFjernFraMaterialer.addActionListener(BTNListener);
        btnTilfoejMaterialer.addActionListener(BTNTilfoejListener);
        jlistAlleMaterialer.setModel(alleListModel);
        jlistValgteMaterialer.setModel(valgteListModel);
        PopulateList();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void moveItem(JList source, JList target) {

        int idx = source.getSelectedIndex();
        if (idx == -1) {
            return;
        }
        String element = (String) source.getModel().getElementAt(idx);
        DefaultListModel modelTarget = (DefaultListModel) target.getModel();
        modelTarget.addElement(element);
        DefaultListModel modelSource = (DefaultListModel) source.getModel();
        modelSource.remove(idx);
    }
    
    public ArrayList<BEMaterial> getValgteMaterials(){
    return valgteMaterials;
    }

    private class BTNMoveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnFoejTilMaterialer) {
                moveItem(jlistAlleMaterialer, jlistValgteMaterialer); 
            } else {
                moveItem(jlistValgteMaterialer, jlistAlleMaterialer);
            }
        }
    }
    
       private class BTNTilfoejActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           for(int i=0; i< valgteListModel.getSize(); i++){
           BEMaterial temp = new BEMaterial((String) jlistValgteMaterialer.getModel().getElementAt(i));
           valgteMaterials.add(i,temp);
           }
        }
    }

    private void PopulateList() {
        for (BEMaterial m : Materials) {
            alleListModel.addElement(m.getM_Materiale());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jlistValgteMaterialer = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistAlleMaterialer = new javax.swing.JList();
        btnFjernFraMaterialer = new javax.swing.JButton();
        btnFoejTilMaterialer = new javax.swing.JButton();
        lblValgteMaterialer = new javax.swing.JLabel();
        btnTilfoejMaterialer = new javax.swing.JButton();
        btnAnnuller = new javax.swing.JButton();
        lblAlleMaterialer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setViewportView(jlistValgteMaterialer);

        jlistAlleMaterialer.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "HT-Rør", "Strålerør", "B-Slanger", "C-Slanger", "Røgdykkerapp.", "Flasker (300 bar)", "Frigørelsesmaterial", "Overtryksventilator", "Vandforbrug", "Skumvæske", "Lysmaterial", "Pulverslukker", "Kulsyreslukker", "Flydespærringer", "Absordan/\"kattegrus\"", "Arbsobent W", "Engangspressinger" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlistAlleMaterialer);

        btnFjernFraMaterialer.setText("Fjern fra Materialer");

        btnFoejTilMaterialer.setText("Føj til Materialer");
        btnFoejTilMaterialer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoejTilMaterialerActionPerformed(evt);
            }
        });

        lblValgteMaterialer.setText("Valgte Materialer:");

        btnTilfoejMaterialer.setText("Tilføj Materialer");
        btnTilfoejMaterialer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTilfoejMaterialerActionPerformed(evt);
            }
        });

        btnAnnuller.setText("Annuller");
        btnAnnuller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnullerActionPerformed(evt);
            }
        });

        lblAlleMaterialer.setText("Alle Materialer:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnFjernFraMaterialer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFoejTilMaterialer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAlleMaterialer)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnnuller)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTilfoejMaterialer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValgteMaterialer)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnFoejTilMaterialer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFjernFraMaterialer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValgteMaterialer)
                            .addComponent(lblAlleMaterialer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTilfoejMaterialer)
                    .addComponent(btnAnnuller))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFoejTilMaterialerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoejTilMaterialerActionPerformed

    }//GEN-LAST:event_btnFoejTilMaterialerActionPerformed

    private void btnTilfoejMaterialerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTilfoejMaterialerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTilfoejMaterialerActionPerformed

    private void btnAnnullerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnullerActionPerformed
        dispose();
    }//GEN-LAST:event_btnAnnullerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnnuller;
    private javax.swing.JButton btnFjernFraMaterialer;
    private javax.swing.JButton btnFoejTilMaterialer;
    private javax.swing.JButton btnTilfoejMaterialer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList jlistAlleMaterialer;
    private javax.swing.JList jlistValgteMaterialer;
    private javax.swing.JLabel lblAlleMaterialer;
    private javax.swing.JLabel lblValgteMaterialer;
    // End of variables declaration//GEN-END:variables
}
