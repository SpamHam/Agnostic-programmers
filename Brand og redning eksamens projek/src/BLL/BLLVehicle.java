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
     * Singleton
     *
     * @return
     * @throws SQLServerException
     */
    public static BLLVehicle getInstance() throws Exception {
        if (m_instance == null) {
            m_instance = new BLLVehicle();
        }
        return m_instance;
    }

    private BLLVehicle() throws Exception {
        Error = Utility.ErrorHandler.getInstance();
        try {
            DALCVehicle = DALC.DALCVehicle.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

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

    public ArrayList<BE.BEVehicle> getAll() throws Exception {
        ArrayList<BE.BEVehicle> res = new ArrayList<>();
        try {
            res = DALCVehicle.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

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

    public void remove() throws Exception {
        //TODO after Salary are done.
    }
}
