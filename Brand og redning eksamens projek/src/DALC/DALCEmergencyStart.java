/*
 * To change this template, choose Tools | Templates
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

/**
 *
 * @author Kathrine
 */
public class DALCEmergencyStart {

    private static DALCEmergencyStart m_instance;
    private final ErrorHandler Error;
    Connection m_connection;
    ArrayList<String> timeStamps = new ArrayList<>();

    /**
     * Singleton to ensure that the class isn't instantiated more than once
     *
     * @return
     * @throws SQLServerException
     */
    public static DALCEmergencyStart getInstance() throws SQLServerException {

        if (m_instance == null) {
            m_instance = new DALCEmergencyStart();
        }
        return m_instance;

    }

    /**
     * Calls for an instance of the ErrorHandler class & DBConnection.
     *
     * @throws SQLServerException
     */
    private DALCEmergencyStart() throws SQLServerException {
        Error = ErrorHandler.getInstance();
        m_connection = DBConnection.getInstance().getConnection();

    }

    /**
     * Reads all rows from the EmergencyStamp table.
     *
     * @return res
     * @throws SQLException
     */
    public ArrayList<String> read() throws SQLException {
        ArrayList<String> res = timeStamps;
        Statement stm = m_connection.createStatement();
        if (!stm.execute("select * from EmergencyStamp")) {
            Error.Datatable("emergencystamp");
        }
        ResultSet result = stm.getResultSet();
        while (result.next()) {

            String timeStamp = result.getString("eStart");

            res.add(timeStamp);

        }

        return res;

    }

    /**
     * Removes an specific row from EmergencyStamp table.
     *
     * @param time
     * @throws SQLException
     */
    public void Delete(String time) throws SQLException {
        String sql = "delete from EmergencyStamp where eStart=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, time);
        ps.executeUpdate();
    }

    /**
     * Creates an row in EmergencyStamp table.
     * @param time
     * @throws SQLException
     */
    public void Create(String time) throws SQLException {
        String sql = "insert into EmergencyStamp values (?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, time);

        ps.executeUpdate();
    }

}
