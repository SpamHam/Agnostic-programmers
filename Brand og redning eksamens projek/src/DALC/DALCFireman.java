/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALC;

import Utility.ErrorHandler;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Morten H.
 */
public class DALCFireman {

    private static DALCFireman m_instance;
    private final ErrorHandler Error;
    Connection m_connection;

    /**
     * Singleton
     *
     * @return
     * @throws com.microsoft.sqlserver.jdbc.SQLServerException
     */
    public static DALCFireman getInstance() throws SQLServerException {
        if (m_instance == null) {
            m_instance = new DALCFireman();
        }
        return m_instance;
    }

    /**
     * calls for a new instance of the connection
     *
     */
    private DALCFireman() throws SQLServerException {
        m_connection = DALC.DBConnection.getInstance().getConnection();
        Error = Utility.ErrorHandler.getInstance();
    }

    /**
     * Creates an row in DALCCar table.
     *
     * @param e
     * @throws SQLException
     */
    public void Create(BE.BEFireman e) throws SQLException {
        String sql = "insert into Fireman values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, e.getCPR());
        ps.setString(2, e.getFirstName());
        ps.setString(3, e.getLastName());
        ps.setString(4, e.getAddress());
        ps.setInt(5, e.getPhoneNr());
        ps.setInt(6, e.getCallNr());
        ps.setInt(7, e.getPaymentNr());
        ps.setBoolean(8, e.isLeaderTrained());
        ps.executeUpdate();
    }

    /**
     * Reads all rows from car table.
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<BE.BEFireman> read() throws SQLException {
        ArrayList<BE.BEFireman> res = new ArrayList<>();
        Statement stm = m_connection.createStatement();
        if (!stm.execute("select * from Fireman")) {
            Error.Datatable("fireman");
        }
        ResultSet result = stm.getResultSet();
        while (result.next()) {

            String CPR = result.getString("CPR");
            String FirstName = result.getString("FirstName");
            String LastName = result.getString("LastName");
            String Address = result.getString("Address");
            int PhoneNr = result.getInt("Phone");
            int CallNr = result.getInt("CallNumber");
            int PaymentNr = result.getInt("PaymentNr");
            boolean isLeaderTrained = result.getBoolean("LeaderTrained");

            BE.BEFireman c = new BE.BEFireman(CPR, FirstName, LastName, Address, PhoneNr, CallNr, PaymentNr, isLeaderTrained);
            res.add(c);
        }
        return res;
    }

    /**
     *
     * @param u
     * @throws SQLException
     */
    public void update(BE.BEFireman u) throws SQLException {
        String sql = "update Fireman set FirstName=?, LastName=?, Address=?, Phone=?, CallNumber=?, PaymentNr=?, LeaderTrained=? where CPR=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, u.getFirstName());
        ps.setString(2, u.getLastName());
        ps.setString(3, u.getAddress());
        ps.setInt(4, u.getPhoneNr());
        ps.setInt(5, u.getCallNr());
        ps.setInt(6, u.getPaymentNr());
        ps.setBoolean(7, u.isLeaderTrained());
        ps.setString(8, u.getCPR());
        ps.executeUpdate();
    }

    /**
     * Removes an specifik row from car table.
     *
     * @param e
     * @throws java.sql.SQLException
     */
    public void Delete(BE.BEFireman e) throws SQLException {
        String sql = "delete from Fireman where CPR=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, e.getCPR());
        ps.executeUpdate();
    }
}
