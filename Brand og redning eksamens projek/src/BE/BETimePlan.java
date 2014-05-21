/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;


/**
 *
 * @author peter bærbar & Morten H.
 */
public class BETimePlan {

    
    private String title, vehicle, time;
    private int FiremanID, hours, stationHours;
    
    /**
     * Constructor used for packaging title, name,
     * time, hours,stationHours and Vehicle
     * @param title String
     * @param FiremanID int
     * @param time String
     * @param hours int
     * @param StationHours int
     * @param vehicle String
     */
    public BETimePlan(String title, int FiremanID, String time, int hours, int StationHours, String vehicle) {
        this.title = title;
        this.FiremanID = FiremanID;
        this.hours = hours;
        this.time = time;
        this.stationHours = StationHours;
        this.vehicle = vehicle;
    }
    
    /**
     * Constructor used for packaging name and vehicle used for the timesheet
     * @param FiremanID int
     * @param vehicle int
     */
    public BETimePlan(int FiremanID, String vehicle){
    this.FiremanID = FiremanID;
    this.vehicle = vehicle;
    }

    /**
     * 
     * @return the string title 
     */
    public String getTitle() {
        return title;
    }
/**
 * 
 * @param title the string title to set 
 */
    public void setTitle(String title) {
        this.title = title;
    }
/**
 * 
 * @return int FiremanID 
 */
    public int getFiremanID() {
        return FiremanID;
    }
    /**
     * 
     * @param FiremanID the int FiremanID to set 
     */

    public void setFiremanID(int FiremanID) {
        this.FiremanID = FiremanID;
    }
/**
 * 
 * @return the int hours 
 */
    public int getHours() {
        return hours;
    }
/**
 * 
 * @param hours the int hours to set  
 */
    public void setHours(int hours) {
        this.hours = hours;
    }
/**
 * 
 * @return the string time 
 */
    public String getTime() {
        return time;
    }
/**
 * 
 * @param time the string time to set  
 */
    public void setTime(String time) {
        this.time = time;
    }
/**
 * 
 * @return the string stationHours 
 */
    public int getStationHours() {
        return stationHours;
    }
/**
 * 
 * @param stationHours the int stationHours to set
 */
    public void setStationHours(int stationHours) {
        this.stationHours = stationHours;
    }

    /**
     * @return the String vehicle
     */
    public String getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle the String vehicle to set
     */
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

}


