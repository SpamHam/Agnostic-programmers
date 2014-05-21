/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utility.DateConverter;
import java.sql.SQLException;
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
        //System.out.println(startTider.size());
        //System.out.println("a");
        System.out.println(nyeTider.size() + " nye tider");
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
            
            startTider = BLL.BLLEmergencyStart.getInstance().test();
             for(String i : nyeTider){
              System.out.println(i + " nye tider");
              startTider.add(i);
            }
          
        } catch (Exception ex) {
            Logger.getLogger(EmergencyStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


   
    
    public void hej(){
         
     	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//String a = startTider.get(tableUdrykningsOversigt.getSelectedRow()).toString();
        String dateInString = "12/12/2012";//a.substring(8, 18);
        
 
	try {
 
		Date date = formatter.parse(dateInString);
                //date.getTime();
		//System.out.println(date.compareTo(date) < 0);
		//System.out.println(formatter.format(date));
 
	} catch (ParseException e) {
		e.printStackTrace();
	}
        
    }
    
    private void test(){
    
        for(String i : startTider){
           
            String year = i.substring(6, 10);
            String month = i.substring(0, 2);
            String day = i.substring(3, 5);
            String time = i.substring(11, 19);
            int currentDay = Integer.parseInt(day);
            int removeDay = Integer.parseInt(DateConverter.getDate(DateConverter.DAY )) -2;
            String deadLine = Integer.toString(removeDay);
            
            if(year.compareToIgnoreCase(DateConverter.getDate(DateConverter.YEAR)) >= 0 || DateConverter.getDate(DateConverter.MONTH_DAY).equalsIgnoreCase("12/31") ){
                //System.out.println(time + "hej");
                if(month.compareToIgnoreCase(DateConverter.getDate(DateConverter.MONTH)) <= 0){  //day.equalsIgnoreCase("28") || day.equalsIgnoreCase("29") || day.equalsIgnoreCase("30") || day.equalsIgnoreCase("31")){
                  // System.out.println(i + " 2");
                    //System.out.println(day);
                       
                   if((day.equalsIgnoreCase("29") || day.equalsIgnoreCase("30")) && checkForEvenOrAudMonth(month) == false){  
                     removeDay = evenMonth(day);
                       //System.out.println(i + " " + removeDay + " a");
                       if(currentDay <= removeDay && time.compareToIgnoreCase(DateConverter.getDate(DateConverter.TIME)) <= 0){
                           startTider.remove(i);
                           removeTime(i);
                          // System.out.println(i + " hejsa");
                       }
                       
                   }else if((day.equalsIgnoreCase("30") || day.equalsIgnoreCase("31")) && checkForEvenOrAudMonth(month) == true){
                       removeDay = AudMonth(day);
                       //System.out.println(i + " " + removeDay + " b");
                       if(currentDay >= removeDay && time.compareToIgnoreCase(DateConverter.getDate(DateConverter.TIME)) <= 0){
                           startTider.remove(i);
                           removeTime(i);
                          // System.out.println(i + " dav");
                       }
                   }else if(currentDay <= removeDay && time.compareToIgnoreCase(DateConverter.getDate(DateConverter.TIME)) <= 0){
                          startTider.remove(i);
                          removeTime(i);      
                       //System.out.println(i+ " hej");
                   }else{
                       //res.add(i);
                       //System.out.println(i + " de resterende tider");
                   }
                 
                   
                }else{
                    //res.add(i);
                    //System.out.println(i + " er større end nuværende måned");
                }
                
            }else{
                    //res.add(i);
                    //System.out.println(i + " er større end nuværende år");
                }

        }
        
    }

    
    
    
    private boolean checkForEvenOrAudMonth(String time){
     
        int currentMonth = Integer.parseInt(time);
            if(currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7 || currentMonth == 8 || currentMonth == 10 || currentMonth == 12){ //|| month == 08){
           
            return true;
            }
              
              return false;
           
        }
    
    private void removeTime(String time){
        try {
            BLL.BLLEmergencyStart.getInstance().remove(time);
        } catch (SQLException ex) {
            Logger.getLogger(EmergencyStartDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        private int evenMonth(String a){
        int currentRemoveDay = Integer.parseInt(a);
        switch(currentRemoveDay){
            case 29:
                currentRemoveDay = 1;
                break;
            case 30:
                currentRemoveDay = 2;
                break;
            default:
                currentRemoveDay = currentRemoveDay;
                break;
                
        }
            return currentRemoveDay;
           
            
        }
        
        private int AudMonth(String a){
        int currentRemoveDay = Integer.parseInt(a);
            switch(currentRemoveDay){
            case 30:
                currentRemoveDay = 1;
                break;
            case 31:
                currentRemoveDay = 2;
                break;
            default:
                currentRemoveDay = currentRemoveDay;
                break;
                
        }
        return currentRemoveDay;
        }
        
        
       private int februarMonth(String a){
       int currentRemoveDay = Integer.parseInt(a);    
            switch(currentRemoveDay){
            case 26:
                currentRemoveDay = 1;
                break;
            case 27:
                currentRemoveDay = 2;
                break;
            default:
                currentRemoveDay = currentRemoveDay;
                break;
                
        }
        return currentRemoveDay;
        }
       
       private boolean skudÅr(){
           int year = 2012;
           boolean skudår = false;
           if(year % 4 == 0){
               skudår = true;
               
               if(year % 100 == 0){
                   
                   skudår = false;
                   if(year % 400 == 0){
                       skudår = true;
                   }
               }
               
           }
           
        return skudår;
          
       }
       private void test2(){
        ArrayList<String> res = new ArrayList<>();
           for(String i : nyeTider){
               res.add(i);
           }
           //System.out.println(nyeTider.size());
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
    startTider.clear();
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
    test2();
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
