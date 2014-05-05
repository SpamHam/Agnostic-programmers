/*
 * To change this template, choose Tools | Templates
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
 * @author Kathrine
 */
public class DALCMaterial {

    private final ErrorHandler Error;
    private static DALCMaterial m_instance;
    Connection m_connection;

    public static DALCMaterial getInstance() throws SQLServerException {
        if (m_instance == null) {
            m_instance = new DALCMaterial();
        }
        return m_instance;
    }

    /**
     * calls for a new instance of the connection
     *
     */
    private DALCMaterial() throws SQLServerException {
        m_connection = DALC.DBConnection.getInstance().getConnection();
        Error = Utility.ErrorHandler.getInstance();
    }

    /**
     * Creates an row in DALCCar table.
     *
     * @param e
     * @throws SQLException
     */
    public void Create(BE.BEMaterial e) throws SQLException {
        String sql = "insert into Materials values (?,?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, e.getM_Materiale());
        ps.setInt(2, e.getM_Antal());
        ps.executeUpdate();
    }

    /**
     * Reads all rows from car table.
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<BE.BEMaterial> read() throws SQLException {
        ArrayList<BE.BEMaterial> res = new ArrayList<>();
        Statement stm = m_connection.createStatement();
        if (!stm.execute("select * from Materials")) {
            Error.Datatable("material");
        }
        ResultSet result = stm.getResultSet();
        while (result.next()) {

            int ID = result.getInt("ID");
            String Materiale = result.getString("Materiale");
            int Antal = result.getInt("Antal");

            BE.BEMaterial c = new BE.BEMaterial(ID, Materiale, Antal);
            res.add(c);
        }
        return res;
    }

    /**
     *
     * @param u
     * @throws SQLException
     */
    public void update(BE.BEMaterial u) throws SQLException {
        String sql = "update Materialz set Materiale=?, Antal=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, u.getM_Materiale());
        ps.setInt(4, u.getM_Antal());
        ps.executeUpdate();
    }

    /**
     * Removes an specifik row from car table.
     *
     * @param e
     * @throws java.sql.SQLException
     */
    public void Delete(BE.BEMaterial e) throws SQLException {
        String sql = "delete from Materials where Materiale=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, e.getM_Materiale());
        ps.executeUpdate();
    }
}
