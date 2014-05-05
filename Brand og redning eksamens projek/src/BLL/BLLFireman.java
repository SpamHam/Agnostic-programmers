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
public class BLLFireman {

    private static BLLFireman m_instance;
    DALC.DALCFireman DALCFireman;

    /**
     * Singleton
     *
     * @return
     * @throws SQLServerException
     */
    public static BLLFireman getInstance() throws Exception {
        try {
            if (m_instance == null) {
                m_instance = new BLLFireman();
            }
        } catch (SQLServerException e) {
            throw new Exception("Data store not there...");
        }
        return m_instance;
    }

    private BLLFireman() throws SQLServerException {
        DALCFireman = DALC.DALCFireman.getInstance();
    }

    public void Create(BE.BEFireman b) throws Exception {
        if (b.getFirstName().isEmpty() || b.getLastName().isEmpty() || b.getCPR().isEmpty() || b.getAddress().isEmpty() || b.getPhoneNr() == 0 || b.getPaymentNr() == 0) {
            throw new Exception("You need to enter all required data if you want to Create a fireman.");
        } else {
            try {
                DALC.DALCFireman.getInstance().Create(b);
            } catch (SQLServerException e) {
                throw new Exception("Could not get access to storage device.");
            }
        }
    }

    public ArrayList<BE.BEFireman> getAll() throws Exception {
        ArrayList<BE.BEFireman> res = new ArrayList<>();
        try {
            res = DALC.DALCFireman.getInstance().read();
        } catch (SQLServerException ex) {
            throw new Exception("Could not get access to storage device.");
        }
        return res;
    }

    public void Update(BE.BEFireman b) throws Exception {
        if (b.getFirstName().isEmpty() || b.getLastName().isEmpty() || b.getCPR().isEmpty() || b.getAddress().isEmpty() || b.getPhoneNr() == 0 || b.getPaymentNr() == 0) {
            throw new Exception("You need to enter all required data if you want to update the fireman.");
        } else {
            try {
                DALC.DALCFireman.getInstance().update(b);
            } catch (SQLServerException ex) {
                throw new Exception("Could not get access to storage device.");
            }
        }
    }

    public void remove() throws Exception {
        //TODO after Salary are done.
    }
}
