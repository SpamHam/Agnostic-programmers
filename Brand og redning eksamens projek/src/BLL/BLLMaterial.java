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
    DALC.DALCMaterial DALCMaterial;
    
    /**
     * Singleton
     *
     * @return
     * @throws SQLServerException
     */
    public static BLLMaterial getInstance() throws Exception {
        try {
            if (m_instance == null) {
                m_instance = new BLLMaterial();
            }
        } catch (SQLServerException e) {
            throw new Exception("Data store not there...");
        }
        return m_instance;
    }

    private BLLMaterial() throws Exception {
        DALCMaterial = DALC.DALCMaterial.getInstance();
    }

    public void Create(BE.BEMaterial b) throws Exception {
        if (b.getM_Materiale().isEmpty()) {
            throw new Exception("You need to enter all required data if you want to Create a material.");
        } else {
            try {
                DALCMaterial.getInstance().Create(b);
            } catch (SQLServerException e) {
                throw new Exception("Could not get access to storage device.");
            }
        }
    }

    public ArrayList<BE.BEMaterial> getAll() throws Exception {
        ArrayList<BE.BEMaterial> res = new ArrayList<>();
        try {
            res = DALCMaterial.getInstance().read();
        } catch (SQLServerException ex) {
            throw new Exception("Could not get access to storage device.");
        }
        return res;
    }

    public void Update(BE.BEMaterial b) throws Exception {
        if (b.getM_Materiale().isEmpty()) {
            throw new Exception("You need to enter all required data if you want to update a material.");
        } else {
            try {
                DALCMaterial.getInstance().update(b);
            } catch (SQLServerException ex) {
                throw new Exception("Could not get access to storage device.");
            }
        }
    }

    public void remove() throws Exception {
        //TODO after Salary are done.
    }

}
