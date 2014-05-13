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
public class DALCEmergencyStart {
    
    private static DALCEmergencyStart m_instance;
    private final ErrorHandler Error;
    Connection m_connection;
    ArrayList<String> timeStamps = new ArrayList<>();

public static DALCEmergencyStart getInstance() throws SQLServerException{
    
            if (m_instance == null) {
            m_instance = new DALCEmergencyStart();
        }
        return m_instance;
    
}

private DALCEmergencyStart() throws SQLServerException{
    Error = ErrorHandler.getInstance();
    m_connection = DBConnection.getInstance().getConnection();
    
}


 public ArrayList<String> read() throws SQLException {
        ArrayList<String> res = timeStamps;
        Statement stm = m_connection.createStatement();
        if (!stm.execute("select * from Fireman")) {
            Error.Datatable("fireman");
        }
        ResultSet result = stm.getResultSet();
        while (result.next()) {

            String timeStamp = result.getString("TimeStamp");

            
            res.add(timeStamp);
        }
        return res;
    }
 
 
     public void Delete(int index) throws SQLException {
        String sql = "delete from TimeStamp where TimeStamp=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, timeStamps.get(index));
        ps.executeUpdate();
    }
     
     public void Create(int index) throws SQLException {
        String sql = "insert into TimeStamp values (?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, timeStamps.get(index));

        ps.executeUpdate();
    }


}


