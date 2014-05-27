/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility.Event;

import BE.BEForces;
import BE.BEMaterial;
import BE.BETimePlan;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class FormatEventPDF {
    private ArrayList<BETimePlan> allTime;
    ArrayList<BEMaterial> allMaterial;
    ArrayList<BEForces> allForces;
    private ArrayList<String> timeColNames;
    private ArrayList<String> matrialeColNames;
    private ArrayList<String> forcesColNames;
    private String evaNr, fireNr, received, date, message, name, address, leader, teamLeader, weekday, type;
    private int selectedType;
  
    /**
     * constructor for packing events
     * @param allTime
     * @param timeColNames
     * @param type 
     * @param selectedType 
     */
    public FormatEventPDF(ArrayList<BETimePlan> allTime, ArrayList<String> timeColNames, String type, int selectedType){
    this.allTime = allTime;
    this.timeColNames = timeColNames;
    this.type = type;
    this.selectedType = selectedType;
    }

   /**
    * constructor for packing events
    * @param allMaterial
    * @param materialColNames
    * @param allForces
    * @param forcesColNames
    * @param date
    * @param received
    * @param fireNr
    * @param evaNr
    * @param message
    * @param name
    * @param address
    * @param leader
    * @param teamLeader
    * @param weekday 
    */
  public FormatEventPDF(ArrayList<BETimePlan> allTime,ArrayList<BEMaterial> allMaterial, ArrayList<String> materialColNames,ArrayList<BEForces> allForces,
         ArrayList<String> forcesColNames,String date, String received,String fireNr, String evaNr, String message,
        String name, String address, String leader, String teamLeader, String weekday){
      this.date = date;
      this.received = received;
      this.allMaterial = allMaterial;
      this.matrialeColNames = materialColNames;
      this.allForces = allForces;
      this.forcesColNames = forcesColNames;
      this.fireNr = fireNr;
      this.evaNr = evaNr;
      this.message = message;
      this.name = name;
      this.address = address;
      this.leader = leader;
      this.teamLeader = teamLeader;
      this.weekday = weekday;
       this.allTime = allTime;
  }
  
    public ArrayList<BETimePlan> getTime(){
    return allTime;
    }
    public ArrayList<String> getMatrialeColNames(){
    return matrialeColNames;
    }
    
    public ArrayList<BEMaterial> getMaterial(){
    return allMaterial;
    }
    public ArrayList<BEForces> getForces(){
    return allForces;
    }
    
  public String getDate(){
  return date;
  }
  
   public String getReceived(){
  return received;
  }
   
  public String getFireNr(){
  return fireNr;
  }
  
  public String getEvaNr(){
  return evaNr;
  }
  
  public String getMessage(){
  return message;
  }
  
   public String getName(){
  return name;
  }
   
  public String getAddress(){
  return address;
  }
  
   public String getLeader(){
  return leader;
  }
  public String getTeamLeader(){
  return teamLeader;
  }
  
  public String getWeekday(){
  return weekday;
  }   

    /**
     * @return the forcesColNames
     */
    public ArrayList<String> getForcesColNames() {
        return forcesColNames;
    }

    /**
     * @return the timeColNames
     */
    public ArrayList<String> getTimeColNames() {
        return timeColNames;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the selectedType
     */
    public int getSelectedType() {
        return selectedType;
    }
}
