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
public class BLLMaterial {

    private static BLLMaterial m_instance;
    private DALC.DALCMaterial DALCMaterial;
    private final Utility.ErrorHandler Error;

    /**
     * Singleton
     *
     * @return
     * @throws SQLServerException
     */
    public static BLLMaterial getInstance() throws Exception {
        if (m_instance == null) {
            m_instance = new BLLMaterial();
        }
        return m_instance;
    }

    private BLLMaterial() throws Exception {
        Error = Utility.ErrorHandler.getInstance();
        try {
            DALCMaterial = DALC.DALCMaterial.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    public void Create(BE.BEMaterial b) throws Exception {
        if (b.getM_Materiale().isEmpty()) {
            Error.NotEnougthInfo("creating a material.");
        } else {
            try {
                DALCMaterial.getInstance().Create(b);
            } catch (SQLServerException e) {
            Error.StorageUnreachable(".");
            }
        }
    }

    public ArrayList<BE.BEMaterial> getAll() throws Exception {
        ArrayList<BE.BEMaterial> res = new ArrayList<>();
        try {
            res = DALCMaterial.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

    public void Update(BE.BEMaterial b) throws Exception {
        if (b.getM_Materiale().isEmpty()) {
            Error.NotEnougthInfo("updating a material.");
        } else {
            try {
                DALCMaterial.getInstance().update(b);
            } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
            }
        }
    }

    public void remove() throws Exception {
        //TODO after Salary are done.
    }

}
