/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.SQLException;

/**
 *
 * @author Son Of Satan
 */
public class ErrorHandler {

    private static ErrorHandler m_instance;

    public static ErrorHandler getInstance() {
        if (m_instance == null) {
            m_instance = new ErrorHandler();
        }
        return m_instance;
    }

    public ErrorHandler() {
    }

    /**
     * Error 001, insuficient data provided.
     *
     * @param n - extra text. e.g. fireman data base.
     * @throws Exception
     */
    public void NotEnougthInfo(String n) throws Exception {
        throw new Exception("Not enougth info are typed in for, " + n);
    }

    /**
     * Error 002, Data Storage not reachable.
     *
     * @param n - extra text. e.g. fireman data base.
     * @throws Exception
     */
    public void StorageUnreachable(String n) throws Exception {
        throw new Exception("Could not connect to data storage" + n);
    }
    
    /**
     * Error 003, Data table unreachable.
     *
     * @param n - which table, e.g fireman.
     * @throws java.sql.SQLException
     */
    public void Datatable(String n) throws SQLException {
        throw new SQLException("Could not find " + n + " table.");
    }
    
    /**
     * Error 004, String couldn't be matched.
     *
     * @param n - the string you want to match.
     * @throws java.sql.SQLException
     */
    public void StringEqualError(String n) throws Exception {
        throw new Exception("There seems to be a problem with finding the matching string " + n + " in the code.");
    }
    
}
