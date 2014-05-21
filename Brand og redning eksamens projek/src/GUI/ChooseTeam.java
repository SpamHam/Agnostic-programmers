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
        
        /**
         * All ActionListeners are listed here
         */
        ActionListener BTNListener = new BTNMoveActionListener();
        ActionListener BTNFoejListener = new BTNTilfoejActionListener();
        ActionListener BTNCancel= new CancelListener();
        btnCancel.addActionListener(BTNCancel);
        btnAddToTeam.addActionListener(BTNListener);
        btnRemoveFromTeam.addActionListener(BTNListener);
        btnAddTeam.addActionListener(BTNFoejListener);
        
        jlistAllFiremen.setModel(alleFiremenListModel);
        jlistChosenFiremen.setModel(valgteFiremenListModel);
        jlistChooseACar.setModel(alleVehiclesListModel);
        PopulateFiremanList();
        PopulateVehicleList();
        
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
     *
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
     *
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
                int FiremanID = Firemen.get(Integer.parseInt(((String)jlistChosenFiremen.getModel().getElementAt(i)).substring(0,1)) - 1).getID();
                String vehicle = chosenVehicle(jlistChooseACar);
                BETimePlan temp = new BETimePlan(FiremanID, vehicle);
                ValgteFiremen.add(i, temp);
            }
            dispose();
        }
    }

    /**
     * Returns the ArrayList ValgteFiremen
     *
     * @return ValgteFiremen
     */
    public ArrayList<BETimePlan> getTeam() {
        return ValgteFiremen;
    }

    /**
     * Actionlistener for Buttons used for moving items between lists
     */
    private class BTNMoveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAddToTeam) {
                moveItem(jlistAllFiremen, jlistChosenFiremen);
            } else {
                moveItem(jlistChosenFiremen, jlistAllFiremen);
            }
        }
    }

    /**
     * anonymos inner class listening on the Cancel button
     */
    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
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
        int count = 1;
        for (BEFireman m : Firemen) {
            alleFiremenListModel.addElement(count +":"+ m.getFirstName() + " " + m.getLastName());
            count++;
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
        jlistAllFiremen = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistChosenFiremen = new javax.swing.JList();
        btnRemoveFromTeam = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistChooseACar = new javax.swing.JList();
        lblAllFiremen = new javax.swing.JLabel();
        lblChosenTeamMembers = new javax.swing.JLabel();
        lblChooseACar = new javax.swing.JLabel();
        btnAddTeam = new javax.swing.JButton();
        btnAddToTeam = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jlistAllFiremen);

        jScrollPane2.setViewportView(jlistChosenFiremen);

        btnRemoveFromTeam.setText("Fjern fra Team");

        jScrollPane3.setViewportView(jlistChooseACar);

        lblAllFiremen.setText("Alle brændmand:");

        lblChosenTeamMembers.setText("Valgte team medlemmer:");

        lblChooseACar.setText("Vælg en bil:");

        btnAddTeam.setText("Tilføj Team");

        btnAddToTeam.setText("Føj til Team");

        btnCancel.setText("Annuller");

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
                            .addComponent(btnRemoveFromTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddToTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblAllFiremen))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChosenTeamMembers))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChooseACar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddTeam)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChosenTeamMembers)
                            .addComponent(lblAllFiremen)
                            .addComponent(lblChooseACar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnAddToTeam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveFromTeam)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTeam)
                    .addComponent(btnCancel))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTeam;
    private javax.swing.JButton btnAddToTeam;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemoveFromTeam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList jlistAllFiremen;
    private javax.swing.JList jlistChooseACar;
    private javax.swing.JList jlistChosenFiremen;
    private javax.swing.JLabel lblAllFiremen;
    private javax.swing.JLabel lblChooseACar;
    private javax.swing.JLabel lblChosenTeamMembers;
    // End of variables declaration//GEN-END:variables
}
