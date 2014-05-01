/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLVehicle {

    private static BLLVehicle M_instance;
    DALC.DALCVehicle DALCVehicle;

    public static BLLVehicle getInstance() throws Exception {
        try {
            if (M_instance == null) {
                M_instance = new BLLVehicle();
            }
        } catch (SQLServerException e) {
            throw new Exception("Data store not there...");
        }
        return M_instance;
    }

    private BLLVehicle() throws Exception {
        DALCVehicle = DALC.DALCVehicle.getInstance();
    }

    public ArrayList<BE.BEVehicle> getAllVehicles() throws Exception {
        ArrayList<BE.BEVehicle> Vehicles;
        try {
            Vehicles = DALCVehicle.read();
        } catch (SQLException ex) {
            throw new Exception("Could not retrieve data from data store.");
        }
        return Vehicles;
    }

}
