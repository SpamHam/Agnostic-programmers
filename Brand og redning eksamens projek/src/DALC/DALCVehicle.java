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
 * @author Claus
 */
public class DALCVehicle {

    private final ErrorHandler Error;
    private static DALCVehicle m_instance;
    Connection M_connection;

    public static DALCVehicle getInstance() throws SQLServerException {
        if (m_instance == null) {
            m_instance = new DALCVehicle();
        }
        return m_instance;
    }

    private DALCVehicle() throws SQLServerException {
        M_connection = DALC.DBConnection.getInstance().getConnection();
        Error = Utility.ErrorHandler.getInstance();
    }

    public void Create(BE.BEVehicle e) throws SQLException {
        String sql = "insert into Vehicle values (?,?,?,?)";
        PreparedStatement ps = M_connection.prepareStatement(sql);
        ps.setString(1, e.getM_registrationNr());
        ps.setString(2, e.getM_mærke());
        ps.setString(3, e.getM_model());
        ps.setString(4, e.getM_description());
        ps.executeUpdate();
    }

    public ArrayList<BE.BEVehicle> read() throws SQLException {
        ArrayList<BE.BEVehicle> res = new ArrayList<>();
        Statement stm = M_connection.createStatement();
        if (!stm.execute("select * from Vehicle")) {
            Error.Datatable("vehicle");
        }
        ResultSet result = stm.getResultSet();
        while (result.next()) {

            String RegistrationNr = result.getString("RegistrationNr");
            String Brand = result.getString("Brand");
            String Model = result.getString("Model");
            String Description = result.getString("Description");

            BE.BEVehicle c = new BE.BEVehicle(RegistrationNr, Brand, Model, Description);
            res.add(c);
        }
        return res;
    }

    public void update(BE.BEVehicle u) throws SQLException {
        String sql = "update Vehicle set Brand=?, Model=?, Description=? where RegistrationNr=?";
        PreparedStatement ps = M_connection.prepareStatement(sql);
        ps.setString(1, u.getM_mærke());
        ps.setString(2, u.getM_model());
        ps.setString(3, u.getM_description());
        ps.setString(4, u.getM_registrationNr());
        ps.executeUpdate();
    }

    public void Delete(BE.BEVehicle e) throws SQLException {
        String sql = "delete from Vehicle where RegistrationNr=?";
        PreparedStatement ps = M_connection.prepareStatement(sql);
        ps.setString(1, e.getM_registrationNr());
        ps.executeUpdate();
    }
}
