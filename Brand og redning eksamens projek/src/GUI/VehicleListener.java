/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BE.BEVehicle;
import java.util.ArrayList;


/**
 *
 * @author peter bærbar
 */
public interface VehicleListener {
    
               /**
     * implementing classes will have to override these methods 
     * @param event type FormatEventPDF
     */
    public void VehicleCreatePerformed(BEVehicle event);
    public void VehicleRemovePerformed(BEVehicle event);
    public void VehicleUpdatePerformed(BEVehicle event);
    public ArrayList<BEVehicle> VehicleReadPerformed();
    
}
