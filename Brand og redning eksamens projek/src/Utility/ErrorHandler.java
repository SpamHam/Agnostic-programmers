/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

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
}
