/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLVehicle {

    private static BLLVehicle m_instance;
    private DALC.DALCVehicle DALCVehicle;
    private final Utility.ErrorHandler Error;

    /**
     * Singleton to ensure that the class isn't instantiated more than once
     *
     * @return m_instance
     * @throws SQLServerException
     */
    public static BLLVehicle getInstance() throws Exception {
        if (m_instance == null) {
            m_instance = new BLLVehicle();
        }
        return m_instance;
    }

    /**
     * Instantiates the DALC Layer using the Singleton Pattern
     * @throws Exception 
     */
    private BLLVehicle() throws Exception {
        Error = Utility.ErrorHandler.getInstance();
        try {
            DALCVehicle = DALC.DALCVehicle.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
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
    public void Update(BE.BEVehicle b) throws Exception {
        if (b.getM_registrationNr().isEmpty() || b.getM_mærke().isEmpty() || b.getM_model().isEmpty()) {
            Error.NotEnougthInfo("updating a vehicle.");
        } else {
            try {
                DALCVehicle.getInstance().update(b);
            } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * A function that calls the delete function from the DALC Layer using Singleton
     * @throws Exception 
     */
    public void remove() throws Exception {
        //TODO after Salary are done.
    }
}
