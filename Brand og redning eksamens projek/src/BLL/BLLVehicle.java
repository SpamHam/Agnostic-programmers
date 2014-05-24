/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BEVehicle;
import GUI.VehicleListener;
import Utility.Error.EventExercutionException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter bærbar
 */
public class BLLVehicle implements VehicleListener{

   // private static BLLVehicle m_instance;
    private DALC.DALCVehicle DALCVehicle;
    private final Utility.Error.ErrorHandler Error;

    /**
     * Singleton to ensure that the class isn't instantiated more than once
     *
     * @return m_instance
     * @throws SQLServerException
     */
//    public static BLLVehicle getInstance() throws Exception {
//        if (m_instance == null) {
//            m_instance = new BLLVehicle();
//        }
//        return m_instance;
//    }

    /**
     * Instantiates the DALC Layer using the Singleton Pattern
     * @throws Exception 
     */
//    private BLLVehicle() throws Exception {
//        Error = Utility.Error.ErrorHandler.getInstance();
//        try {
//            DALCVehicle = DALC.DALCVehicle.getInstance();
//        } catch (SQLServerException ex) {
//            Error.StorageUnreachable(".");
//        }
//    }
    
    public BLLVehicle(){
    Error = Utility.Error.ErrorHandler.getInstance();
    }

    /**
     * Function that calls the create function from the DALC Layer. If any field is empty the function will return an error
     * @param b
     * @throws Exception 
     */
    public void Create(BE.BEVehicle b) throws Exception {
        if (b.getM_registrationNr().isEmpty() || b.getM_mærke().isEmpty() || b.getM_model().isEmpty()) {
            Error.NotEnougthInfo("creating a vehicle");
        } else {
            try {
                DALCVehicle.getInstance().Create(b);
            } catch (SQLServerException e) {
            Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * A function that retrieves all fireman info from the database and inserts it into an ArrayList
     * @return res
     * @throws Exception 
     */
    public ArrayList<BE.BEVehicle> getAll() throws Exception {
        ArrayList<BE.BEVehicle> res = new ArrayList<>();
        try {
            res = DALCVehicle.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

    /**
     * A function that calls the update function from the DALC Layer using Singleton
     * If any field is left blank it will return an error
     * @param b
     * @throws Exception 
     */
//    public void Update(BE.BEVehicle b) throws Exception {
//        if (b.getM_registrationNr().isEmpty() || b.getM_mærke().isEmpty() || b.getM_model().isEmpty()) {
//            Error.NotEnougthInfo("updating a vehicle.");
//        } else {
//            try {
//                DALCVehicle.getInstance().update(b);
//            } catch (SQLServerException ex) {
//            Error.StorageUnreachable(".");
//            }
//        }
//    }

    /**
     * A function that calls the delete function from the DALC Layer using Singleton
     * @throws Exception 
     */
//    public void remove(BE.BEVehicle e) throws Exception {
//        DALCVehicle.Delete(e);
//    }

    @Override
    public void VehicleCreatePerformed(BEVehicle event) {
            if (event.getM_registrationNr().isEmpty() || event.getM_mærke().isEmpty() || event.getM_model().isEmpty()) {
            throw new EventExercutionException("Ikke nok info til at oprette Køretøj");
        } else {
            try {
                DALCVehicle.getInstance().Create(event);
            } catch (SQLException e) {
            throw new EventExercutionException("Kunne ikke få forbindelse til server");
            }
        }
    }

    @Override
    public void VehicleRemovePerformed(BEVehicle event) {
            try {
                DALCVehicle.getInstance().Delete(event);
            } catch (SQLException ex) {
            throw new EventExercutionException("Kunne ikke få forbindelse til server");
            }
        }

    @Override
    public void VehicleUpdatePerformed(BEVehicle event) {
        if (event.getM_registrationNr().isEmpty() || event.getM_mærke().isEmpty() || event.getM_model().isEmpty()) {
            throw new EventExercutionException("Ikke nok info til at oprette Køretøj");
        } else {
            try {
                DALCVehicle.getInstance().update(event);
            } catch (SQLException ex) {
            throw new EventExercutionException("Kunne ikke få forbindelse til server");
            }
        }
    }
    }

