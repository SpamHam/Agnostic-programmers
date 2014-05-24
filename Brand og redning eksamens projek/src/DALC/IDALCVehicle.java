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
public interface IDALCVehicle {
    public void VehicleCreatePerformed(BEVehicle event);
    public void VehicleRemovePerformed(BEVehicle event);
    public void VehicleUpdatePerformed(BEVehicle event);
    public ArrayList<BEVehicle> VehicleReadPerformed();
}
