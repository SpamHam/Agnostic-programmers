/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALC;

import Utility.Error.ErrorHandler;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import BE.BEFireman;

/**
 *
 * @author Morten H.
 */
public class DALCFireman {

    private static DALCFireman m_instance;
    private final ErrorHandler Error;
    Connection m_connection;

    /**
     * Singleton to ensure that the class isn't instantiated more than once
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
        Error = Utility.Error.ErrorHandler.getInstance();
    }

    /**
     * Creates an row in Fireman table.
     *
     * @param e
     * @throws SQLException
     */
    public void Create(BE.BEFireman e) throws SQLException {
        String sql = "insert into Fireman values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, e.getFirstName());
        ps.setString(2, e.getLastName());
        ps.setString(3, e.getAddress());
        ps.setString(4, e.getPhoneNr());
        ps.setString(5, e.getCallNr());
        ps.setString(6, e.getPaymentNr());
        ps.setBoolean(7, e.isLeaderTrained());
        ps.setString(8, e.getHiredDate());
        ps.setString(9, e.getProfileImage());
        ps.executeUpdate();
    }

    /**
     * Reads all rows from the Fireman table.
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

            int ID = result.getInt("ID");
            String FirstName = result.getString("FirstName");
            String LastName = result.getString("LastName");
            String Address = result.getString("Address");
            String PhoneNr = result.getString("Phone");
            String CallNr = result.getString("CallNumber");
            String PaymentNr = result.getString("PaymentNr");
            boolean isLeaderTrained = result.getBoolean("LeaderTrained");
            String HiredDate = result.getString("HiredDate");
            String ProfileImage = result.getString("ProfileImage");
            BEFireman c = new BEFireman(ID, FirstName, LastName, Address, PhoneNr, CallNr, PaymentNr, isLeaderTrained, HiredDate, ProfileImage);
            res.add(c);
        }
        return res;
    }

    /**
     * Updates a row on the selected CPR in Fireman table
     *
     * @param u
     * @throws SQLException
     */
    public void update(BE.BEFireman u) throws SQLException {

        String sql = "update Fireman set FirstName=?, LastName=?, Address=?, Phone=?, CallNumber=?, PaymentNr=?, LeaderTrained=?, HiredDate=?, ProfileImage=? where ID=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, u.getFirstName());
        ps.setString(2, u.getLastName());
        ps.setString(3, u.getAddress());
        ps.setString(4, u.getPhoneNr());
        ps.setString(5, u.getCallNr());
        ps.setString(6, u.getPaymentNr());
        ps.setBoolean(7, u.isLeaderTrained());
        ps.setString(8, u.getHiredDate());
        ps.setString(9, u.getProfileImage());
        ps.setInt(10, u.getID());
        ps.executeUpdate();
    }

    /**
     * Removes an specific row from Fireman table.
     *
     * @param e
     * @throws java.sql.SQLException
     */
    public void Delete(BE.BEFireman e) throws SQLException {
        String sql = "delete from Fireman where ID=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setInt(1, e.getID());
        ps.executeUpdate();
    }
}
