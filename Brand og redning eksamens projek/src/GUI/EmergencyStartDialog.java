/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utility.DateConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Kathrine
 */
public class EmergencyStartDialog extends javax.swing.JDialog {
    
    EmergencyStart start = new EmergencyStart();
    private ArrayList<String> startTider = new ArrayList<>();
    private ArrayList<String> nyeTider = new ArrayList<>();
    EmergencyStartDialogTableModel StartTableModel;
    TableRowSorter<TableModel> sorter;
    
    
    

        
        
    

    /**
     * Creates new form EmergencyStartDialog
     */
    public EmergencyStartDialog(java.awt.Frame parent, boolean modal, ArrayList<String> tider) {
        super(parent, modal);
        initComponents();
        nyeTider = tider;
        iniTimeStamps();
        //mergeTimeList();
        System.out.println(startTider.size());
        System.out.println("a");
        System.out.println(nyeTider.size());
        StartTableModel = new EmergencyStartDialogTableModel(startTider);
        tableUdrykningsOversigt.setModel(StartTableModel);
        sorter = new TableRowSorter<TableModel>(StartTableModel);
        tableUdrykningsOversigt.setRowSorter(sorter);
        setTitle("Liste over udrykningstider");
      
        tableUdrykningsOversigt.getTableHeader().setReorderingAllowed(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    }
    
            private void iniTimeStamps(){
                try {
            startTider = BLL.BLLEmergencyStart.getInstance().getAll();
            for(String i : nyeTider){
            startTider.add(i);
            }
            for(String i : startTider){
                System.out.println(i);
            }
        } catch (Exception ex) {
            Logger.getLogger(EmergencyStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mergeTimeList(){
        iniTimeStamps();
        for(String i : nyeTider){
            startTider.add(i);
            
            //System.out.println(i);
        }
        
    }

   
    
    public void hej(){
         
     	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//String a = startTider.get(tableUdrykningsOversigt.getSelectedRow()).toString();
        String dateInString = "12/12/2012";//a.substring(8, 18);
        
 
	try {
 
		Date date = formatter.parse(dateInString);
                //date.getTime();
		System.out.println(date.compareTo(date) < 0);
		//System.out.println(formatter.format(date));
 
	} catch (ParseException e) {
		e.printStackTrace();
	}
        
    }
    
    private void test(){
        
        for(String i : startTider){
            System.out.println(DateConverter.getDate(DateConverter.MONTH )+ "jacob");
            
            String year = i.substring(6, 10);
            String month = i.substring(0, 2);
            String day = i.substring(3, 5);
            String time = i.substring(11, 19);
            int CurrentDay = Integer.parseInt(DateConverter.getDate(DateConverter.DAY )) -2;
            String deadLine = Integer.toString(CurrentDay);
            
            if(year.compareToIgnoreCase(DateConverter.getDate(DateConverter.YEAR)) >= 0 || DateConverter.getDate(DateConverter.MONTH_DAY).equalsIgnoreCase("12/31") ){
                //System.out.println(time + "hej");
                if(month.compareToIgnoreCase(DateConverter.getDate(DateConverter.MONTH)) == 0 || day.equalsIgnoreCase("28") || day.equalsIgnoreCase("29") || day.equalsIgnoreCase("30") || day.equalsIgnoreCase("31")){
                  // System.out.println(i + " 2");
                   if(checkForEvenOrAudMonth(month, CurrentDay)){
                       
                       
                   if(day.compareToIgnoreCase(deadLine) >= 0 && time.compareToIgnoreCase(DateConverter.getDate(DateConverter.TIME)) <= 0){
                       
                       System.out.println(i + " er større end" + deadLine);
                       
                   }
                       System.out.println(i + " er lige måneder");
                   }
                }
                
            }

        }
    }
    
    
    
    private boolean checkForEvenOrAudMonth(String time, int currentDay){
     
        int currentMonth = Integer.parseInt(time);
            if(currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7 || currentMonth == 8 || currentMonth == 10 || currentMonth == 12){ //|| month == 08){
            currentDay = 29;
            return true;
            }
              currentDay = 28;
              return false;
           
        }
    
    private void removeTime(){
        int a = 2;
        if(test2(a)){
            System.out.println(a);
        }
    }
        private boolean test2(int b){
            b = 23;
            return true;
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
        btnBack = new javax.swing.JButton();
        btbTest = new javax.swing.JButton();

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

        btnAfslut.setText("Lav ODINRapport");
        btnAfslut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfslutActionPerformed(evt);
            }
        });

        btnBack.setText("Tilbage");
        btnBack.setToolTipText("");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btbTest.setText("Test");
        btbTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbTestActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAfslut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAfslut)
                    .addComponent(btnBack)
                    .addComponent(btbTest))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    EmergencyStart startMenu = new EmergencyStart();
    startMenu.setVisible(true);
    dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAfslutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfslutActionPerformed
     //ODINReport report = new ODINReport(tableUdrykningsOversigt.getSelectedRow(), startTider);
     ODINReport report = new ODINReport();
     report.setTime(startTider.get(tableUdrykningsOversigt.getSelectedRow()).toString());
     report.setVisible(true);
     
     dispose();
    }//GEN-LAST:event_btnAfslutActionPerformed

    private void btbTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbTestActionPerformed
        test();
    }//GEN-LAST:event_btbTestActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbTest;
    private javax.swing.JButton btnAfslut;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUdrykningsOversigt;
    // End of variables declaration//GEN-END:variables
}
