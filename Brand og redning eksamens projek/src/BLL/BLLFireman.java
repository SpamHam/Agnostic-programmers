/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BEFireman;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class BLLFireman {

    private static BLLFireman m_instance;
    private DALC.DALCFireman DALCFireman;
    private final Utility.ErrorHandler Error;

    /**
     * Singleton
     *
     * @return
     * @throws SQLServerException
     */
    public static BLLFireman getInstance() throws Exception {
        if (m_instance == null) {
            m_instance = new BLLFireman();
        }
        return m_instance;
    }

    private BLLFireman() throws Exception {
        Error = Utility.ErrorHandler.getInstance();
        try {
            DALCFireman = DALC.DALCFireman.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    public void Create(BE.BEFireman b) throws Exception {
        if (b.getFirstName().isEmpty() || b.getLastName().isEmpty() || b.getCPR().isEmpty() || b.getAddress().isEmpty() || b.getPhoneNr().isEmpty() || b.getPaymentNr().isEmpty()) {
            Error.NotEnougthInfo("creating a fireman.");
        } else {
            try {
                DALCFireman.getInstance().Create(b);
            } catch (SQLServerException e) {
                Error.StorageUnreachable(".");
            }
        }
    }

    public ArrayList<BE.BEFireman> getAll() throws Exception {
        ArrayList<BE.BEFireman> res = new ArrayList<>();
        try {
            res = DALCFireman.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

    public void Update(BE.BEFireman b) throws Exception {
        if (b.getFirstName().isEmpty() || b.getLastName().isEmpty() || b.getCPR().isEmpty() || b.getAddress().isEmpty() || b.getPhoneNr().isEmpty() || b.getPaymentNr().isEmpty()) {
            Error.NotEnougthInfo("updating a fireman.");
        } else {
            try {
                DALCFireman.getInstance().update(b);
            } catch (SQLServerException ex) {
                Error.StorageUnreachable(".");
            }
        }
    }

    public void remove() throws Exception {
        //TODO after Salary are done.
    }

    BEFireman FiremanFromCPR(String cpr) throws Exception {
        for (BE.BEFireman f : getAll()) {
            if (cpr.equalsIgnoreCase(f.getCPR())) {
                return f;
            }
        }
        Error.StringEqualError(cpr);
        return null;
    }
}
