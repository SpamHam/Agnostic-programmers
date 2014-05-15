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
    private final Utility.ErrorHandler Error;
    String[] TypeOfWork = new String[]{"Brand", "Standby", "Andet", "Øvelse", "Vagt"};

    /**
     * Singleton
     *
     * @return
     * @throws SQLServerException
     */
    public static BLLTimePlan getInstance() throws Exception {
        if (m_instance == null) {
            m_instance = new BLLTimePlan();
        }
        return m_instance;
    }

    /**
     *
     * @throws Exception
     */
    private BLLTimePlan() throws Exception {
        Error = Utility.ErrorHandler.getInstance();
        try {
            DALCSalary = DALC.DALCSalary.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    /**
     *
     * @param role
     * @return
     */
    public String getTypeOfWorkFromInt(int role) {
        return TypeOfWork[role - 1];
    }

    /**
     *
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
