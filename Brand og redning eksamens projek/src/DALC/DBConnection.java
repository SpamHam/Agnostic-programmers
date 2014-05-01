/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DALC;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author Morten.
 */
public class DBConnection {

    private final Connection M_Connection;
    private static DBConnection M_Instance = null;

    /**
     * get the connection to the database
     * @throws SQLServerException
     */
    private DBConnection() throws SQLServerException {

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setApplicationName("jdbc:sqlserver://");
        ds.setServerName("localhost");
        ds.setInstanceName("SQLEXPRESS");
        ds.setDatabaseName("CarRentalAssignment");
        ds.setPortNumber(1433);
        ds.setUser("test");
        ds.setPassword("test123");

        M_Connection = ds.getConnection();
    }

    /**
     * returns the database connection
     * @return M_Connection
     */
    public Connection getConnection() {
        return M_Connection;
    }

    /**
     * checks, using singelton, whether a instance has already been created 
     * @return SchoolDBConnection
     */
    public static DBConnection getInstance() throws SQLServerException {
        if (M_Instance == null) {
            M_Instance = new DBConnection();
        }
        return M_Instance;
    }
}
