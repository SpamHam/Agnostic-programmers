/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Son Of Satan
 */
public class AdminstrationMenu extends javax.swing.JFrame {

    /**
     * Creates new form AdminstrationMenu
     */
    public AdminstrationMenu() {
        initComponents();
    }
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
            java.util.logging.Logger.getLogger(AdminstrationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminstrationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminstrationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminstrationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminstrationMenu().setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        btnFiremanMenu = new javax.swing.JButton();
        btnVehicleMenu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnMaterialMenu = new javax.swing.JButton();
        jPanelFiremanMenu = new javax.swing.JPanel();
        lblFiremanMenu1 = new javax.swing.JLabel();
        lblFiremanMenu2 = new javax.swing.JLabel();
        lblFiremanMenu3 = new javax.swing.JLabel();
        lblFiremanMenu4 = new javax.swing.JLabel();
        jPanelVehicleMenu = new javax.swing.JPanel();
        lblVehicleMenu1 = new javax.swing.JLabel();
        lblVehicleMenu2 = new javax.swing.JLabel();
        lblVehicleMenu3 = new javax.swing.JLabel();
        lblVehicleMenu4 = new javax.swing.JLabel();
        jPanelMaterialMenu = new javax.swing.JPanel();
        lblMaterialMenu1 = new javax.swing.JLabel();
        lblMaterialMenu2 = new javax.swing.JLabel();
        lblMaterialMenu3 = new javax.swing.JLabel();
        lblMaterialMenu4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Adminstration Menu");

        btnFiremanMenu.setText("Brandmand Menu");
        btnFiremanMenu.setMaximumSize(new java.awt.Dimension(115, 25));
        btnFiremanMenu.setMinimumSize(new java.awt.Dimension(115, 25));
        btnFiremanMenu.setPreferredSize(new java.awt.Dimension(115, 25));
        btnFiremanMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiremanMenuActionPerformed(evt);
            }
        });

        btnVehicleMenu.setText("Brandbil Menu");
        btnVehicleMenu.setMaximumSize(new java.awt.Dimension(100, 25));
        btnVehicleMenu.setMinimumSize(new java.awt.Dimension(100, 25));
        btnVehicleMenu.setPreferredSize(new java.awt.Dimension(100, 25));
        btnVehicleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehicleMenuActionPerformed(evt);
            }
        });

        btnMaterialMenu.setText("Matriale Menu");
        btnMaterialMenu.setMaximumSize(new java.awt.Dimension(115, 25));
        btnMaterialMenu.setMinimumSize(new java.awt.Dimension(115, 25));
        btnMaterialMenu.setPreferredSize(new java.awt.Dimension(115, 25));
        btnMaterialMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialMenuActionPerformed(evt);
            }
        });

        jPanelFiremanMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblFiremanMenu1.setText("- Se de forskellige Brandbiler.");

        lblFiremanMenu2.setText("- Tilføj en ny Brandbil.");

        lblFiremanMenu3.setText("- Opdater info om en Brandbil.");

        lblFiremanMenu4.setText("- Fjern en Brandbil");

        javax.swing.GroupLayout jPanelFiremanMenuLayout = new javax.swing.GroupLayout(jPanelFiremanMenu);
        jPanelFiremanMenu.setLayout(jPanelFiremanMenuLayout);
        jPanelFiremanMenuLayout.setHorizontalGroup(
            jPanelFiremanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiremanMenuLayout.createSequentialGroup()
                .addGroup(jPanelFiremanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFiremanMenu1)
                    .addComponent(lblFiremanMenu2)
                    .addComponent(lblFiremanMenu3)
                    .addComponent(lblFiremanMenu4))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelFiremanMenuLayout.setVerticalGroup(
            jPanelFiremanMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiremanMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFiremanMenu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFiremanMenu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFiremanMenu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFiremanMenu4)
                .addGap(7, 7, 7))
        );

        jPanelVehicleMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblVehicleMenu1.setText("- Se de forskellige Brandmænd");

        lblVehicleMenu2.setText("- Tilføj en ny Brandmand");

        lblVehicleMenu3.setText("- Opdater info om en Brandmand");

        lblVehicleMenu4.setText("- Fjern en Brandmand");

        javax.swing.GroupLayout jPanelVehicleMenuLayout = new javax.swing.GroupLayout(jPanelVehicleMenu);
        jPanelVehicleMenu.setLayout(jPanelVehicleMenuLayout);
        jPanelVehicleMenuLayout.setHorizontalGroup(
            jPanelVehicleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVehicleMenuLayout.createSequentialGroup()
                .addGroup(jPanelVehicleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVehicleMenu1)
                    .addComponent(lblVehicleMenu2)
                    .addComponent(lblVehicleMenu3)
                    .addComponent(lblVehicleMenu4))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelVehicleMenuLayout.setVerticalGroup(
            jPanelVehicleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVehicleMenuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblVehicleMenu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVehicleMenu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVehicleMenu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVehicleMenu4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMaterialMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMaterialMenu1.setText("- Se de forskellige Materialer");

        lblMaterialMenu2.setText("- Tilføj et nyt Materiale");

        lblMaterialMenu3.setText("- Opdater et Materiale");

        lblMaterialMenu4.setText("- Fjern et Materiale");

        javax.swing.GroupLayout jPanelMaterialMenuLayout = new javax.swing.GroupLayout(jPanelMaterialMenu);
        jPanelMaterialMenu.setLayout(jPanelMaterialMenuLayout);
        jPanelMaterialMenuLayout.setHorizontalGroup(
            jPanelMaterialMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaterialMenuLayout.createSequentialGroup()
                .addGroup(jPanelMaterialMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaterialMenu1)
                    .addComponent(lblMaterialMenu2)
                    .addComponent(lblMaterialMenu3)
                    .addComponent(lblMaterialMenu4))
                .addGap(0, 105, Short.MAX_VALUE))
        );
        jPanelMaterialMenuLayout.setVerticalGroup(
            jPanelMaterialMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaterialMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaterialMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaterialMenu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaterialMenu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaterialMenu4)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFiremanMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelFiremanMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnVehicleMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMaterialMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(6, 6, 6)
                                        .addComponent(jPanelVehicleMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelMaterialMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFiremanMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelFiremanMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVehicleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addComponent(jPanelVehicleMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMaterialMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaterialMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiremanMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiremanMenuActionPerformed
        openFiremanFrame();
        dispose();
    }//GEN-LAST:event_btnFiremanMenuActionPerformed

    private void btnVehicleMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehicleMenuActionPerformed
        openVehicleFrame();
        dispose();    }//GEN-LAST:event_btnVehicleMenuActionPerformed

    private void btnMaterialMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialMenuActionPerformed
        openMaterialsFrame();
        dispose();
    }//GEN-LAST:event_btnMaterialMenuActionPerformed

    /**
     * Opens the CRUDFireman frame
     */
    private void openFiremanFrame() {
        CRUDFireman CRUDFiremanFrame = new CRUDFireman();
        CRUDFiremanFrame.setLocationRelativeTo(this);
        CRUDFiremanFrame.setVisible(true);
    }

    /**
     * Opens the CRUDVehicle frame
     */
    private void openVehicleFrame() {
        CRUDVehicle CRUDVehicleFrame = new CRUDVehicle();
        CRUDVehicleFrame.setLocationRelativeTo(this);
        CRUDVehicleFrame.setVisible(true);
    }

    /**
     * Opens the CRUDMaterial frame
     */
    private void openMaterialsFrame() {
        CRUDMaterial CRUDMaterialFrame = new CRUDMaterial();
        CRUDMaterialFrame.setLocationRelativeTo(this);
        CRUDMaterialFrame.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiremanMenu;
    private javax.swing.JButton btnMaterialMenu;
    private javax.swing.JButton btnVehicleMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelFiremanMenu;
    private javax.swing.JPanel jPanelMaterialMenu;
    private javax.swing.JPanel jPanelVehicleMenu;
    private javax.swing.JLabel lblFiremanMenu1;
    private javax.swing.JLabel lblFiremanMenu2;
    private javax.swing.JLabel lblFiremanMenu3;
    private javax.swing.JLabel lblFiremanMenu4;
    private javax.swing.JLabel lblMaterialMenu1;
    private javax.swing.JLabel lblMaterialMenu2;
    private javax.swing.JLabel lblMaterialMenu3;
    private javax.swing.JLabel lblMaterialMenu4;
    private javax.swing.JLabel lblVehicleMenu1;
    private javax.swing.JLabel lblVehicleMenu2;
    private javax.swing.JLabel lblVehicleMenu3;
    private javax.swing.JLabel lblVehicleMenu4;
    // End of variables declaration//GEN-END:variables
}
