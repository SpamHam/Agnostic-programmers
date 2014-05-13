/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEFireman;
import BE.BETimePlan;
import BE.BEVehicle;
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
public class ChooseTeam extends javax.swing.JDialog {

    ArrayList<BEFireman> Firemen;
    ArrayList<BEVehicle> Vehicles;
    ArrayList<BETimePlan> ValgteFiremen = new ArrayList<>();
    DefaultListModel alleFiremenListModel = new DefaultListModel();
    DefaultListModel valgteFiremenListModel = new DefaultListModel();
    DefaultListModel alleVehiclesListModel = new DefaultListModel();

    /**
     * Creates new form ChooseTeam
     */
    public ChooseTeam(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        InitializeFiremen();
        InitializeVehicles();
        ActionListener BTNListener = new BTNMoveActionListener();
        ActionListener BTNFoejListener = new BTNTilfoejActionListener();
        btnFoejTilTeam.addActionListener(BTNListener);
        btnFjernFraTeam.addActionListener(BTNListener);
        jlistAlleBraendmaend.setModel(alleFiremenListModel);
        jlistVaelgTeamMedlemmer.setModel(valgteFiremenListModel);
        jlistVaelgEnBil.setModel(alleVehiclesListModel);
        PopulateFiremanList();
        PopulateVehicleList();
    btnTilfoejTeam.addActionListener(BTNFoejListener);
        setTitle("Vælg et team");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Populates the Fireman ArrayList
     */
    public void InitializeFiremen() {
        try {
            Firemen = BLL.BLLFireman.getInstance().getAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Populates the Vehicles ArrayList
     */
    public void InitializeVehicles() {
        try {
            Vehicles = BLL.BLLVehicle.getInstance().getAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * A function that can move item between lists
     * @param source
     * @param target 
     */
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
    
    /**
     * Returns the chosen vehicle from the list
     * @param veh
     * @return element
     */
     private String chosenVehicle(JList veh) {

        int idx = veh.getSelectedIndex();
        if (idx == -1) {
            return null;
        }
        String element = (String) veh.getModel().getElementAt(idx);
        return element;
    }

     /**
      * Sets the firemen & vehicle chosen and packs them into a Business Entity
      */
        private class BTNTilfoejActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < valgteFiremenListModel.getSize(); i++) {
            String fireman = (String) jlistVaelgTeamMedlemmer.getModel().getElementAt(i);
            String vehicle = chosenVehicle(jlistVaelgEnBil);
          BETimePlan temp = new BETimePlan (fireman, vehicle);
             ValgteFiremen.add(i, temp);
            }
            dispose();
        }
    }
      
        /**
         * Returns the ArrayList ValgteFiremen
         * @return ValgteFiremen
         */
      public ArrayList<BETimePlan> getTeam(){
      return ValgteFiremen;
      }
    
      /**
       * Actionlistener for Buttons used for moving items between lists
       */
    private class BTNMoveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnFoejTilTeam) {
                moveItem(jlistAlleBraendmaend, jlistVaelgTeamMedlemmer);
            } else {
                moveItem(jlistVaelgTeamMedlemmer, jlistAlleBraendmaend);
            }
        }
    }

    /**
     * Populates the allVehiclesList
     */
    private void PopulateFiremanList() {
        for (BEVehicle m : Vehicles) {
            alleVehiclesListModel.addElement(m.getM_registrationNr());
        }
    }

    /**
     * Populates the allFiremenList
     */
    private void PopulateVehicleList() {
        for (BEFireman m : Firemen) {
            alleFiremenListModel.addElement(m.getFirstName() + " " + m.getLastName());
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
        jlistAlleBraendmaend = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistVaelgTeamMedlemmer = new javax.swing.JList();
        btnFoejTilTeam = new javax.swing.JButton();
        btnFjernFraTeam = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistVaelgEnBil = new javax.swing.JList();
        lblAlleBraendMaend = new javax.swing.JLabel();
        lblValgteTeamMedlemmer = new javax.swing.JLabel();
        lblVaelgEnBil = new javax.swing.JLabel();
        btnTilfoejTeam = new javax.swing.JButton();
        btnLukVindue = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jlistAlleBraendmaend);

        jScrollPane2.setViewportView(jlistVaelgTeamMedlemmer);

        btnFoejTilTeam.setText("Føj til Team");
        btnFoejTilTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoejTilTeamActionPerformed(evt);
            }
        });

        btnFjernFraTeam.setText("Fjern fra Team");

        jScrollPane3.setViewportView(jlistVaelgEnBil);

        lblAlleBraendMaend.setText("Alle brændmand:");

        lblValgteTeamMedlemmer.setText("Valgte team medlemmer:");

        lblVaelgEnBil.setText("Vælg en bil:");

        btnTilfoejTeam.setText("Tilføj Team");

        btnLukVindue.setText("Luk Vindue");
        btnLukVindue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLukVindueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFjernFraTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFoejTilTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblAlleBraendMaend))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValgteTeamMedlemmer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVaelgEnBil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLukVindue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTilfoejTeam)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValgteTeamMedlemmer)
                            .addComponent(lblAlleBraendMaend)
                            .addComponent(lblVaelgEnBil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnFoejTilTeam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFjernFraTeam)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTilfoejTeam)
                    .addComponent(btnLukVindue))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFoejTilTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoejTilTeamActionPerformed

    }//GEN-LAST:event_btnFoejTilTeamActionPerformed

    private void btnLukVindueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLukVindueActionPerformed
        dispose();
    }//GEN-LAST:event_btnLukVindueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFjernFraTeam;
    private javax.swing.JButton btnFoejTilTeam;
    private javax.swing.JButton btnLukVindue;
    private javax.swing.JButton btnTilfoejTeam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList jlistAlleBraendmaend;
    private javax.swing.JList jlistVaelgEnBil;
    private javax.swing.JList jlistVaelgTeamMedlemmer;
    private javax.swing.JLabel lblAlleBraendMaend;
    private javax.swing.JLabel lblVaelgEnBil;
    private javax.swing.JLabel lblValgteTeamMedlemmer;
    // End of variables declaration//GEN-END:variables
}
