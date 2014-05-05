/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DALC.DALCVehicle;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLVehicle {
    private static BLLVehicle m_instance;
    DALC.DALCVehicle DALCVehicle;
    
      /**
     * Singleton
     *
     * @return
     * @throws SQLServerException
     */
    public static BLLVehicle getInstance() throws Exception {
        try {
            if (m_instance == null) {
                m_instance = new BLLVehicle();
            }
        } catch (SQLServerException e) {
            throw new Exception("Data store not there...");
        }
        return m_instance;
    }
    
    private BLLVehicle() throws SQLServerException{
        DALCVehicle = DALC.DALCVehicle.getInstance();
    }
    
    public void Create(BE.BEVehicle b) throws Exception {
        if (b.getM_registrationNr().isEmpty() || b.getM_mærke().isEmpty() || b.getM_model().isEmpty()) {
            throw new Exception("You need to enter all required data if you want to Create a Vehicle.");
        } else {
            try {
                DALC.DALCVehicle.getInstance().Create(b);
            } catch (SQLServerException e) {
                throw new Exception("Could not get access to storage device.");
            }
        }
    }

    public ArrayList<BE.BEVehicle> getAll() throws Exception {
        ArrayList<BE.BEVehicle> res = new ArrayList<>();
        try {
            res = DALC.DALCVehicle.getInstance().read();
        } catch (SQLServerException ex) {
            throw new Exception("Could not get access to storage device.");
        }
        return res;
    }

    public void Update(BE.BEVehicle b) throws Exception {
        if (b.getM_registrationNr().isEmpty() || b.getM_mærke().isEmpty() || b.getM_model().isEmpty()) {
            throw new Exception("You need to enter all required data if you want to update the Vehicle.");
        } else {
            try {
                DALC.DALCVehicle.getInstance().update(b);
            } catch (SQLServerException ex) {
                throw new Exception("Could not get access to storage device.");
            }
        }
    }

    public void remove() throws Exception {
        //TODO after Salary are done.
    }    
}
