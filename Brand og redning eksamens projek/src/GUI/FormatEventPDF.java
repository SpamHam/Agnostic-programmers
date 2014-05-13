/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BE.BEMaterial;
import BE.BETimePlan;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class FormatEventPDF {
    ArrayList<BETimePlan> allTime;
    ArrayList<BEMaterial> allMaterial;
    ArrayList<String> allForces;
    ArrayList<String> colNames;
   private String evaNr, fireNr, received, date, message, name, address, leader, teamLeader, weekday;
    
    public FormatEventPDF(ArrayList<BETimePlan> allTime, ArrayList<String> colNames ){
    this.allTime = allTime;
    this.colNames = colNames;
    }
    
    public FormatEventPDF(ArrayList<BEMaterial> allMaterial, ArrayList<String> allForces, String date, String received,
                      String fireNr, String evaNr, String message, String name, String address, String leader, 
                      String teamLeader, String weekday){
  this.allMaterial = allMaterial;
  this.allForces = allForces;
  this.date = date;
  this.received = received;
  this.fireNr = fireNr;
  this.evaNr = evaNr;
  this.message = message;
  this.name = name;
  this.address = address;
  this.leader = leader;
  this.teamLeader = teamLeader;
  this.weekday = weekday;
  }
    
    public ArrayList<BETimePlan> getTime(){
    return allTime;
    }
    public ArrayList<String> getColNames(){
    return colNames;
    }
    
    public ArrayList<BEMaterial> getMaterial(){
    return allMaterial;
    }
    public ArrayList<String> getForces(){
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
}
