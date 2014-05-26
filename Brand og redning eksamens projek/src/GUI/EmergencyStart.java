/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utility.DateConverter;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kathrine
 */
public class EmergencyStart extends javax.swing.JFrame {
    
    ArrayList<String> Udrykningstider = new ArrayList<>();
    
   
 

    /**
     * Creates new form EmergencyStart
     */
    public EmergencyStart() {
        initComponents();
        
        System.out.println(Udrykningstider.size());
        setTitle("Emergency Start");
        
    }
    
 
    
    
  
    public String currentTime(){
       
         
         return DateConverter.getDate(DateConverter.DATE_HOURS_MINUTES_SECONDS);
        
    }
    
    private void AddTime(){
        txtLastCall.setText(currentTime());
        //Udrykningstider.add(currentTime());
        try {
            BLL.BLLEmergencyStart.getInstance().Create(Udrykningstider, currentTime());
        } catch (Exception ex) {
            Logger.getLogger(EmergencyStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(Udrykningstider.size());
        
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        lblLastCall = new javax.swing.JLabel();
        txtLastCall = new javax.swing.JTextField();
        btnFinishACall = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStart.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        lblLastCall.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLastCall.setText("Sidste udrykning:");
        lblLastCall.setToolTipText("");

        txtLastCall.setBackground(javax.swing.UIManager.getDefaults().getColor("menu"));
        txtLastCall.setBorder(null);

        btnFinishACall.setText("Afslut en udrykning");
        btnFinishACall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishACallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblLastCall)
                        .addGap(18, 18, 18)
                        .addComponent(txtLastCall, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFinishACall, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLastCall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLastCall))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinishACall))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
       AddTime();
     
      

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnFinishACallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishACallActionPerformed
        
        EmergencyStartDialog start = new EmergencyStartDialog(this, true, Udrykningstider);
        start.setVisible(true);
        Udrykningstider.clear();
        dispose();
        
    }//GEN-LAST:event_btnFinishACallActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmergencyStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmergencyStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmergencyStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmergencyStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmergencyStart().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinishACall;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lblLastCall;
    private javax.swing.JTextField txtLastCall;
    // End of variables declaration//GEN-END:variables
}
