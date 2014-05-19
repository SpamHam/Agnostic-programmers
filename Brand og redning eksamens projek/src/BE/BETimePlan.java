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

    
    private String title, name, vehicle, time;
    private int hours, stationHours;
    
    /**
     * Constructor used for packaging title, name,
     * time, hours,stationHours and Vehicle
     * @param title String
     * @param name String
     * @param time String
     * @param hours int
     * @param StationHours int
     * @param vehicle String
     */
    public BETimePlan(String title, String name, String time, int hours, int StationHours, String vehicle) {
        this.title = title;
        this.name = name;
        this.hours = hours;
        this.time = time;
        this.stationHours = StationHours;
        this.vehicle = vehicle;
    }
    
    /**
     * Constructor used for packaging name and vehicle used for the timesheet
     * @param name String
     * @param vehicle int
     */
    public BETimePlan(String name, String vehicle){
    this.name = name;
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
 * @return String name 
 */
    public String getName() {
        return name;
    }
    /**
     * 
     * @param name the string name to set 
     */

    public void setName(String name) {
        this.name = name;
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


