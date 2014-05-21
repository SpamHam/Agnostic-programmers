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
    private final Utility.Error.ErrorHandler Error;

    /**
     * Singleton to ensure that the class isn't instantiated more than once
     * @return m_instance
     * @throws SQLServerException
     */
    public static BLLMaterial getInstance() throws Exception {
        if (m_instance == null) {
            m_instance = new BLLMaterial();
        }
        return m_instance;
    }

    /**
     * Instantiates the DALC Layer using the Singleton Pattern
     * @throws Exception 
     */
    private BLLMaterial() throws Exception {
        Error = Utility.Error.ErrorHandler.getInstance();
        try {
            DALCMaterial = DALC.DALCMaterial.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    /**
     * Function that calls the Create function from the DALC Layer. If any field is empty the function will return an error
     * @param b
     * @throws Exception 
     */
    public void Create(BE.BEMaterial b) throws Exception {
        if (b.getMaterial().isEmpty()) {
            Error.NotEnougthInfo("creating a material.");
        } else {
            try {
                DALCMaterial.getInstance().Create(b);
            } catch (SQLServerException e) {
            Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * A function that retrieves all material info from the database and inserts it into an ArrayList
     * @return res
     * @throws Exception 
     */
    public ArrayList<BE.BEMaterial> getAll() throws Exception {
        ArrayList<BE.BEMaterial> res = new ArrayList<>();
        try {
            res = DALCMaterial.getInstance().read();
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
    public void Update(BE.BEMaterial b) throws Exception {
        if (b.getMaterial().isEmpty()) {
            Error.NotEnougthInfo("updating a material.");
        } else {
            try {
                DALCMaterial.getInstance().update(b);
            } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * A function that calls the delete function from the DALC Layer using Singleton
     * @throws Exception 
     */
    public void remove(BE.BEMaterial e) throws Exception {
        DALCMaterial.Delete(e);
    }

}
