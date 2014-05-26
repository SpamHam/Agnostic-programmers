/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BE;

/**
 *
 * @author peter bærbar
 */
public class BEForces {
    private String carID;
    private String typeOfAlarm;
    private String forces;
 
 /**
  * Constructor used for adding a force to a table
  * @param carID String
  * @param typeOfAlarm String
  * @param forces String
  */   
 public BEForces(String carID, String typeOfAlarm, String forces){
 this.carID = carID;
 this.typeOfAlarm = typeOfAlarm;
 this.forces = forces;
 }

    /**
     * @return the carID
     */
    public String getCarID() {
        return carID;
    }

    /**
     * @param carID the carID to set
     */
    public void setCarID(String carID) {
        this.carID = carID;
    }

    /**
     * @return the typeOfAlarm
     */
    public String getTypeOfAlarm() {
        return typeOfAlarm;
    }

    /**
     * @param typeOfAlarm the typeOfAlarm to set
     */
    public void setTypeOfAlarm(String typeOfAlarm) {
        this.typeOfAlarm = typeOfAlarm;
    }

    /**
     * @return the forces
     */
    public String getForces() {
        return forces;
    }

    /**
     * @param forces the forces to set
     */
    public void setForces(String forces) {
        this.forces = forces;
    }
}
