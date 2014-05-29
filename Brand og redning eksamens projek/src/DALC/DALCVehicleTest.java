/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DALC;

import BE.BEVehicle;
import java.util.ArrayList;


/**
 *
 * @author peter bærbar
 */
public class DALCVehicleTest implements IDALCVehicle {
    ArrayList<BEVehicle> allV = new ArrayList<>();
    
    public DALCVehicleTest(){
    }

/**
 * A function that Simulates the creation of a vehicle and prints the information to the system.
 * @param event 
 */
    @Override
    public void VehicleCreatePerformed(BEVehicle event) {
        allV.add(event);
    }

    /**
     * A function that Simulates the removal of a vehicle and prints the information to the system.
     * @param event 
     */
    @Override
    public void VehicleRemovePerformed(BEVehicle event) {
         allV.remove(event);
    }
    
    /**
     * A function that Simulates an update of a vehicle and prints the information to the system.
     * @param event 
     */
    @Override
    public void VehicleUpdatePerformed(BEVehicle event) {
        System.out.println("VehicleUpdatePerformed");

        allV.set(0, event);
    }

    /**
     * A function that simulates that returns an ArrayList
     * @return allV
     */
    @Override
    public ArrayList<BEVehicle> VehicleReadPerformed() {
        return allV;
    }
    
}
