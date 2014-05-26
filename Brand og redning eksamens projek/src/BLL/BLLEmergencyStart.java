/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DALC.DALCEmergencyStart;
import GUI.EmergencyStartDialog;
import Utility.DateConverter;
import Utility.Error.ErrorHandler;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kathrine
 */
public class BLLEmergencyStart {
    
    private static BLLEmergencyStart m_instance;
    private DALC.DALCEmergencyStart DALCeStart;
    private final Utility.Error.ErrorHandler Error;
    ArrayList<String> startTider = new ArrayList<>();
    ArrayList<String> res = new ArrayList<>();
    
    
    /**
     * Instantiates BLLEmergencyStart
     * @return
     * @throws SQLServerException 
     */
    public static BLLEmergencyStart getInstance() throws SQLServerException{
       if (m_instance == null) {
            m_instance = new BLLEmergencyStart();
        }
        return m_instance;  
    }
    
    /**
     * Instantiates the ErrorHandler and DALCEmergencyStart
     * @throws SQLServerException 
     */
    private BLLEmergencyStart() throws SQLServerException{
        Error = ErrorHandler.getInstance();
        DALCeStart = DALCEmergencyStart.getInstance();
    }
    
    /**
     * Calls the function Create from DALCEmergencyStart
     * @param timeStamp
     * @param time
     * @throws Exception 
     */
    public void Create(ArrayList<String> timeStamp, String time) throws Exception{
//        if(timeStamp.isEmpty()){
//            Error.NotEnougthInfo("creating timestamp");
//        }
        DALCeStart.getInstance().Create(time);
        System.out.println("jacob er lækker");
        
    }
    
    /**
     * Calls the read function from DALCEmergencyStart and populates the ArrayList res
     * @return res
     * @throws Exception 
     */
    public ArrayList<String> getAll() throws Exception{
        ArrayList<String> res = new ArrayList<>();
        res = DALCeStart.getInstance().read();
        return  res;
    }
    
    /**
     * Calls the Delete function from DALCEmergencyStart
     * @param time
     * @throws SQLException 
     */
    public void remove(String time) throws SQLException{
       DALCeStart.Delete(time);
    }
    
    // Jacob hvad skal denne funktion gøre?? Refactor name og skriv lige javadoc til tak :D
    public ArrayList<String> test() throws SQLException{
   
    
    startTider.clear();
    startTider = DALCeStart.getInstance().read();
        //System.out.println(startTider.size() + "jacobtest");
        for(String i : startTider){
           
            String year = i.substring(6, 10);
            String month = i.substring(0, 2);
            String day = i.substring(3, 5);
            String time = i.substring(11, 19);
            int currentDay = Integer.parseInt(day);
            int removeDay = Integer.parseInt(DateConverter.getDate(DateConverter.DAY )) -2;
            String deadLine = Integer.toString(removeDay);
            
            if(year.compareToIgnoreCase(DateConverter.getDate(DateConverter.YEAR)) >= 0 || DateConverter.getDate(DateConverter.MONTH_DAY).equalsIgnoreCase("12/31") ){
                
                if(month.compareToIgnoreCase(DateConverter.getDate(DateConverter.MONTH)) <= 0){  //day.equalsIgnoreCase("28") || day.equalsIgnoreCase("29") || day.equalsIgnoreCase("30") || day.equalsIgnoreCase("31")){
                 
                       
                   if((day.equalsIgnoreCase("29") || day.equalsIgnoreCase("30")) && checkForEvenOrAudMonth(month) == false){  
                     removeDay = evenMonth(day);
                     
                       if(currentDay <= removeDay && time.compareToIgnoreCase(DateConverter.getDate(DateConverter.TIME)) <= 0){
                           
                           removeTime(i);
                     
                       }
                       
                   }else if((day.equalsIgnoreCase("30") || day.equalsIgnoreCase("31")) && checkForEvenOrAudMonth(month) == true){
                       removeDay = AudMonth(day);
                       //System.out.println(i + " " + removeDay + " b");
                       if(currentDay >= removeDay && time.compareToIgnoreCase(DateConverter.getDate(DateConverter.TIME)) <= 0){
                           
                           removeTime(i);
                          
                       }
                   }else if(currentDay <= removeDay && time.compareToIgnoreCase(DateConverter.getDate(DateConverter.TIME)) <= 0){
                       removeTime(i);      
                       
                   }else if((day.equalsIgnoreCase("27") && month.equalsIgnoreCase("02")) || (day.equalsIgnoreCase("27") && month.equalsIgnoreCase("02"))){
                       removeDay = februarMonth(i);
                       if(currentDay >= removeDay && time.compareToIgnoreCase(DateConverter.getDate(DateConverter.TIME)) <= 0){
                           removeTime(i);
                       }
                   }
                        else{
                       res.add(i);
                       //System.out.println(i + " de resterende tider");
                   }
                 
                   
                }else{
                    res.add(i);
                    //System.out.println(i + " er større end nuværende måned");
                }
                
            }else{
                    res.add(i);
                    //System.out.println(i + " er større end nuværende år");
                }

        }
        System.out.println(res.size() + " jacobtest");
        return res;
        
    }
    
    /**
     * A function that checks wether a month is equal / unequal
     * @param time
     * @return 
     */
    private boolean checkForEvenOrAudMonth(String time){
     
        int currentMonth = Integer.parseInt(time);
            if(currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7 || currentMonth == 8 || currentMonth == 10 || currentMonth == 12){ //|| month == 08){
           
            return true;
            }
              
              return false;
           
        }
    
    /**
     * Calls the remove function from BLLEmergencyStart
     * @param time 
     */
    private void removeTime(String time){
        try {
            BLL.BLLEmergencyStart.getInstance().remove(time);
        } catch (SQLException ex) {
            Logger.getLogger(EmergencyStartDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
     
   /**
    * Returns the final date of even months
    * @param a
    * @return currentRemoveDay
    */     
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
        
        /**
         * Returns the final date on an odd Month
         * @param a
         * @return currentRemoveDay
         */
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
        
        /**
         * Returns the final date of February on leap year
         * @param a
         * @return currentRemoveDay
         */
       private int februarMonth(String a){
       int currentRemoveDay = Integer.parseInt(a);
       if(skudÅr() == false){
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
        }else{
            switch(currentRemoveDay){
            case 27:
                currentRemoveDay = 1;
                break;
            case 28:
                currentRemoveDay = 2;
                break;
            default:
                currentRemoveDay = currentRemoveDay;
                break;  
       } 
       }     
        return currentRemoveDay;
        }
       
       /**
        * Checks if it is leap year or not
        * @return 
        */
              private boolean skudÅr(){
           int year = Integer.parseInt(DateConverter.getDate(DateConverter.YEAR));
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
    
    
    
}
