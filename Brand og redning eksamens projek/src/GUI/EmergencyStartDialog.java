/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Kathrine
 */
public class EmergencyStartDialog extends javax.swing.JDialog {
    
    EmergencyStart start = new EmergencyStart();
    private ArrayList<Object> startTider = new ArrayList<>();
    EmergencyStartDialogTableModel StartTableModel;
    TableRowSorter<TableModel> sorter;
    
    
    

    /**
     * Creates new form EmergencyStartDialog
     */
    public EmergencyStartDialog(java.awt.Frame parent, boolean modal, ArrayList<Object> hej) {
        super(parent, modal);
        initComponents();
        startTider = hej;
        StartTableModel = new EmergencyStartDialogTableModel(startTider);
        tableUdrykningsOversigt.setModel(StartTableModel);
        sorter = new TableRowSorter<TableModel>(StartTableModel);
        tableUdrykningsOversigt.setRowSorter(sorter);
        tableUdrykningsOversigt.getTableHeader().setReorderingAllowed(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }
    
    private void hej(){
        for(int i = 0; i < startTider.size(); i++){
        System.out.println(startTider.get(i));
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
        tableUdrykningsOversigt = new javax.swing.JTable();
        btnAfslut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableUdrykningsOversigt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableUdrykningsOversigt);

        btnAfslut.setText("Afslut udrykning");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnAfslut)
                        .addGap(39, 39, 39)
                        .addComponent(jButton1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAfslut)
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfslut;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUdrykningsOversigt;
    // End of variables declaration//GEN-END:variables
}
