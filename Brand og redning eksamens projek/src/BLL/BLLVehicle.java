/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BEVehicle;
import DALC.IDALCVehicle;
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

    IDALCVehicle m_dal; 
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
    
     public void setDAlC(IDALCVehicle m_dal){this.m_dal = m_dal;}

    /**
     * Function that calls the create function from the DALC Layer. If any field is empty the function will return an error
     * @param b
     * @throws Exception 
     */
//    public void Create(BE.BEVehicle b) throws Exception {
//        if (b.getM_registrationNr().isEmpty() || b.getM_mærke().isEmpty() || b.getM_model().isEmpty()) {
//            Error.NotEnougthInfo("creating a vehicle");
//        } else {
//            try {
//                DALCVehicle.Create(b);
//            } catch (SQLServerException e) {
//            Error.StorageUnreachable(".");
//            }
//        }
//    }

    /**
     * A function that retrieves all fireman info from the database and inserts it into an ArrayList
     * @return res
     * @throws Exception 
     */
    public ArrayList<BE.BEVehicle> getAll() throws Exception {
        ArrayList<BE.BEVehicle> res = new ArrayList<>();
        try {
           // res = DALCVehicle.read();
          res =  m_dal.VehicleReadPerformed();
        } catch (EventExercutionException ex) {
           // Error.StorageUnreachable(".");
            throw new EventExercutionException(ex.getMessage());
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
               // DALCVehicle.Create(event);
               // DALCVehicle.VehicleCreatePerformed(event);
                m_dal.VehicleCreatePerformed(event);
            } catch (EventExercutionException e) {
            throw new EventExercutionException(e.getMessage());
            }
        }
    }

    @Override
    public void VehicleRemovePerformed(BEVehicle event) {
            try {
               // DALCVehicle.Delete(event);
                m_dal.VehicleRemovePerformed(event);
            } catch (EventExercutionException ex) {
            throw new EventExercutionException(ex.getMessage());
            }
        }

    @Override
    public void VehicleUpdatePerformed(BEVehicle event) {
        if (event.getM_registrationNr().isEmpty() || event.getM_mærke().isEmpty() || event.getM_model().isEmpty()) {
            throw new EventExercutionException("Ikke nok info til at oprette Køretøj");
        } else {
            try {
                //DALCVehicle.update(event);
                m_dal.VehicleUpdatePerformed(event);
            } catch (EventExercutionException ex) {
            throw new EventExercutionException(ex.getMessage());
            }
        }
    }

    @Override
    public ArrayList<BEVehicle> VehicleReadPerformed() {
       return m_dal.VehicleReadPerformed();
    }
    }

