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
    int arraySize;
    
    public DALCVehicleTest(){
       BEVehicle e = new BEVehicle("c7887", "toyota", "2", "Nice car");
       BEVehicle f = new BEVehicle("h4566", "nissan", "1", "another car");
       allV.add(e);
       allV.add(f);
       arraySize = allV.size();
    }

/**
 * A function that Simulates the creation of a vehicle and prints the information to the system.
 * @param event 
 */
    @Override
    public void VehicleCreatePerformed(BEVehicle event) {
        System.out.println("VehicleCreatePerformed");
        int expResult = arraySize + 1;      
        System.out.println("------------");
        int result = allV.size();
        System.out.println("registerings: " + event.getM_registrationNr());
        System.out.println("Brand: " + event.getM_brand());
        System.out.println("Model: " + event.getM_model());
        System.out.println("Description: " + event.getM_description());
        System.out.println("");
        System.out.println("expResult: " + expResult);
        System.out.println("result: " + result);
    }

    /**
     * A function that Simulates the removal of a vehicle and prints the information to the system.
     * @param event 
     */
    @Override
    public void VehicleRemovePerformed(BEVehicle event) {
        System.out.println("VehicleRemovePerformed");
        System.out.println("registerings: " + event.getM_registrationNr());
        System.out.println("Brand: " + event.getM_brand());
        System.out.println("Model: " + event.getM_model());
        System.out.println("Description: " + event.getM_description());
         int expResult = arraySize - 1;
         allV.remove(event);
         int result = allV.size();
        System.out.println("");
        System.out.println("expResult: " + expResult);
        System.out.println("result: " + result);
    }
    
    /**
     * A function that Simulates an update of a vehicle and prints the information to the system.
     * @param event 
     */
    @Override
    public void VehicleUpdatePerformed(BEVehicle event) {
        System.out.println("VehicleUpdatePerformed");
        int expResult = arraySize;
       // allV.set(allV.indexOf(event), event);
        int result = allV.size();
        System.out.println("registerings: " + event.getM_registrationNr());
        System.out.println("Brand: " + event.getM_brand());
        System.out.println("Model: " + event.getM_model());
        System.out.println("Description: " + event.getM_description());
        System.out.println("");
        System.out.println("expResult: " + expResult);
        System.out.println("result: " + result);
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
