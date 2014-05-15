/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Claus
 */
public class PayrollDetails extends javax.swing.JDialog {

    DefaultListModel salaryListModel = new DefaultListModel();
    private String SalaryNumber;
    ArrayList<BE.BESalary> allSalarys = new ArrayList<>();

    /**
     * Creates new form AddFiremanDialog
     *
     * @param parent
     * @param modal
     */
    public PayrollDetails(java.awt.Frame parent, boolean modal, String SalaryNumber) throws Exception {
        super(parent, modal);
        initComponents();
        this.SalaryNumber = SalaryNumber;
        setTitle("Detaljer for salaryReports");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        salaryListModelRenewal();
        lstSalaryRapport.setModel(salaryListModel);
        txtTimer.setKeymap(JTextComponent.getKeymap("1234567890."));
        btnUpdate.setEnabled(false);
        txtArbejdsform.setEditable(false);
        txtBrandmandNavn.setEditable(false);
        txtOdinNr.setEditable(false);
        txtRolle.setEditable(false);
        lstSalaryRapport.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filldata();
                btnUpdate.setEnabled(true);

            }
        });
    }

    /**
     * 
     */
    private void filldata() {
        try {
            txtOdinNr.setText(Integer.toString(allSalarys.get(lstSalaryRapport.getSelectedIndex()).getODIN()));
            BE.BEFireman f = BLL.BLLFireman.getInstance().FiremanFromID(allSalarys.get(lstSalaryRapport.getSelectedIndex()).getID());
            txtBrandmandNavn.setText(f.getFirstName() + " " + f.getLastName());
            txtRolle.setText(allSalarys.get(lstSalaryRapport.getSelectedIndex()).getRole());
            txtArbejdsform.setText(BLL.BLLTimePlan.getInstance().getTypeOfWorkFromInt(allSalarys.get(lstSalaryRapport.getSelectedIndex()).getTypeOfWork()));
            txtTimer.setText(Double.toString(allSalarys.get(lstSalaryRapport.getSelectedIndex()).getHours()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSalaryRapport = new javax.swing.JList();
        jPanelInformation = new javax.swing.JPanel();
        lblRolle = new javax.swing.JLabel();
        txtBrandmandNavn = new javax.swing.JTextField();
        txtOdinNr = new javax.swing.JTextField();
        lblOdinNr = new javax.swing.JLabel();
        lblBrandmandNavn = new javax.swing.JLabel();
        txtRolle = new javax.swing.JTextField();
        lblTimer = new javax.swing.JLabel();
        txtTimer = new javax.swing.JTextField();
        lblArbejdsform = new javax.swing.JLabel();
        txtArbejdsform = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstSalaryRapport);

        jPanelInformation.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        lblRolle.setText("Rolle");

        lblOdinNr.setText("Odin Nr:");

        lblBrandmandNavn.setText("Brandmand Navn");

        lblTimer.setText("Timer");

        lblArbejdsform.setText("Arbejdsform");

        jLabel1.setText("Personen er Holdleder uddannet");

        javax.swing.GroupLayout jPanelInformationLayout = new javax.swing.GroupLayout(jPanelInformation);
        jPanelInformation.setLayout(jPanelInformationLayout);
        jPanelInformationLayout.setHorizontalGroup(
            jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformationLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblBrandmandNavn)
                        .addComponent(lblOdinNr)
                        .addComponent(lblRolle)
                        .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtOdinNr, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBrandmandNavn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArbejdsform, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTimer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtArbejdsform, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRolle, javax.swing.GroupLayout.Alignment.LEADING)))))
        );
        jPanelInformationLayout.setVerticalGroup(
            jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformationLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblOdinNr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOdinNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBrandmandNavn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBrandmandNavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRolle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRolle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblArbejdsform)
                .addGap(6, 6, 6)
                .addComponent(txtArbejdsform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnback)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            BE.BESalary s = allSalarys.get(lstSalaryRapport.getSelectedIndex());
            s.setHours(Double.parseDouble(txtTimer.getText()));
            BLL.BLLPayroll.getInstance().update(s);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArbejdsform;
    private javax.swing.JLabel lblBrandmandNavn;
    private javax.swing.JLabel lblOdinNr;
    private javax.swing.JLabel lblRolle;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JList lstSalaryRapport;
    private javax.swing.JTextField txtArbejdsform;
    private javax.swing.JTextField txtBrandmandNavn;
    private javax.swing.JTextField txtOdinNr;
    private javax.swing.JTextField txtRolle;
    private javax.swing.JTextField txtTimer;
    // End of variables declaration//GEN-END:variables

    private void salaryListModelRenewal() throws Exception {
        allSalarys.clear();
        for (BE.BESalary s : BLL.BLLPayroll.getInstance().getAll()) {
            if (SalaryNumber.equalsIgnoreCase(s.getSalaryCode().trim())) {
                allSalarys.add(s);
            }
            salaryListModel.addElement(s.getODIN() + "-" + BLL.BLLTimePlan.getInstance().getTypeOfWorkFromInt(s.getTypeOfWork()));
        }
    }
}