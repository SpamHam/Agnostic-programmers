/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 *
 * @author Morten H.
 */
public class BLLTimePlan {

    private static BLLTimePlan m_instance;
    private DALC.DALCSalary DALCSalary;
    private final Utility.Error.ErrorHandler Error;
    String[] TypeOfWork = new String[]{"Brand", "Standby", "Andet", "Øvelse", "Vagt"};

    /**
     * Singleton
     *
     * @return m_instance;
     * @throws SQLServerException
     */
    public static BLLTimePlan getInstance() throws Exception {
        if (m_instance == null) {
            m_instance = new BLLTimePlan();
        }
        return m_instance;
    }

    /**
     * Instantiates the ErrorHandler and the DALCSalary
     * @throws Exception
     */
    private BLLTimePlan() throws Exception {
        Error = Utility.Error.ErrorHandler.getInstance();
        try {
            DALCSalary = DALC.DALCSalary.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    /**
     * Returns the Type of Work
     * @param role
     * @return TypeOfWork
     */
    public String getTypeOfWorkFromInt(int role) {
        return TypeOfWork[role - 1];
    }

    /**
     * Returns the Type of Work from the TypeOfWork String
     * @param TypeOfWork
     * @return
     */
    public int getTypeOfWorkFromString(String TypeOfWork) throws Exception {
        for (int idx = 0; idx <= this.TypeOfWork.length; idx++) {
            if (this.TypeOfWork[idx].equalsIgnoreCase(TypeOfWork.trim())) {
                return idx;
            }
        }
        Error.StringEqualError(TypeOfWork);
        return -1;
    }

}
