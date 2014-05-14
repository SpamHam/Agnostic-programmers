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

    /**
     * Singleton to ensure that the class isn't instantiated more than once
     * @return
     * @throws SQLServerException 
     */
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
     * Creates an row in Material table.
     *
     * @param e
     * @throws SQLException
     */
    public void Create(BE.BEMaterial e) throws SQLException {
        String sql = "insert into Materials values (?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, e.getM_Materiale());
        ps.executeUpdate();
    }

    /**
     * Reads all rows from Material table.
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

            BE.BEMaterial c = new BE.BEMaterial(ID, Materiale);
            res.add(c);
        }
        return res;
    }

    /**
     * Update a row on selected ID in Material table
     * @param u
     * @throws SQLException
     */
    public void update(BE.BEMaterial u) throws SQLException {
        String sql = "update Materials set Materiale=? where ID=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, u.getM_Materiale());
        ps.setInt(2, u.getM_ID());
        ps.executeUpdate();
    }

    /**
     * Removes an specific row from Material table.
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
