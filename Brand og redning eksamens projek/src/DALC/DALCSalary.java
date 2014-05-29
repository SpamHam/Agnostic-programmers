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

/**
 *
 * @author Morten H.
 */
public class DALCSalary {

    private final ErrorHandler Error;
    private static DALCSalary m_instance;
    Connection m_connection;

    /**
     * Singleton to ensure that the class isn't instantiated more than once
     *
     * @return
     * @throws com.microsoft.sqlserver.jdbc.SQLServerException
     */
    public static DALCSalary getInstance() throws SQLServerException {
        if (m_instance == null) {
            m_instance = new DALCSalary();
        }
        return m_instance;
    }

    /**
     * calls for a new instance of the connection
     *
     */
    private DALCSalary() throws SQLServerException {
        m_connection = DALC.DBConnection.getInstance().getConnection();
        Error = Utility.Error.ErrorHandler.getInstance();
    }

    /**
     * Creates an row in MonthlySalary table.
     *
     * @param e
     * @throws SQLException
     */
    public void SalaryReport(BE.BESalary e) throws SQLException {
        String sql = "insert into SalaryReport values (?,?,?,?,?,?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setBoolean(1, e.getIsItOdin());
        ps.setInt(2, e.getODIN());
        ps.setInt(3, e.getFiremanID());
        ps.setString(4, e.getRole());
        ps.setString(5, e.getSalaryCode());
        ps.setDouble(6, e.getHours());
        ps.executeUpdate();
    }

    /**
     * Creates a row in the SalaryReport table.
     *
     * @param e
     * @throws SQLException
     */
    public void OdinReport(BE.BESalary e) throws SQLException {
        PreparedStatement ps;
        ps = m_connection.prepareStatement("set identity_insert OdinReport on insert into OdinReport(IsItOdin, OdinNr, Date, TypeOfWork, IsHoliday) values (?,?,?,?,?) set identity_insert OdinReport off");
        ps.setBoolean(1, e.getIsItOdin());
        ps.setInt(2, e.getODIN());
        ps.setString(3, e.getDate());
        ps.setInt(4, e.getTypeOfWork());
        ps.setBoolean(5, e.getIsHoliday());
        ps.executeUpdate();
    }

    /**
     * Creates a row in the SalaryReport table.
     *
     * @param e
     * @return
     * @throws SQLException
     */
    public int WorkReport(BE.BESalary e) throws SQLException {
        PreparedStatement ps;
        ps = m_connection.prepareStatement("insert into OdinReport(IsItOdin, Date, TypeOfWork, IsHoliday) "
                + "values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setBoolean(1, e.getIsItOdin());
        ps.setString(2, e.getDate());
        ps.setInt(3, e.getTypeOfWork());
        ps.setBoolean(4, e.getIsHoliday());
        ps.executeUpdate();
        ResultSet ID = ps.getGeneratedKeys();
        ID.next();
        return ID.getInt(1);
    }

    /**
     * Reads all rows from MonthlySalary table.
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<BE.BESalary> read() throws SQLException {
        ArrayList<BE.BESalary> res = new ArrayList<>();
        Statement stm = m_connection.createStatement();
        if (!stm.execute("select * from SalaryReport inner join OdinReport on OdinReport.OdinNr = SalaryReport.ODINnr")) {
            Error.Datatable("OdinReport or Salaryreport");
        } else {
            ResultSet result = stm.getResultSet();
            while (result.next()) {

                boolean IsItOdin = result.getBoolean("IsItOdin");
                int OdinNr = result.getInt("OdinNr");
                int ID = result.getInt("FiremanID");
                String Role = result.getString("Role");
                String SalaryCode = result.getString("SalaryCode");
                double Hours = result.getDouble("Hours");
                String Date = result.getString("Date");
                int TypeOfWork = result.getInt("TypeOfWork");
                boolean isHoliday = result.getBoolean("isHoliday");

                BE.BESalary c = new BE.BESalary(OdinNr, IsItOdin, ID, Role, SalaryCode, Hours, Date, TypeOfWork, isHoliday);
                res.add(c);
            }
        }
        return res;
    }

    /**
     * Removes an specific row from MonthlySalary table.
     *
     * @param e
     * @throws java.sql.SQLException
     */
    public void Delete(BE.BESalary e) throws SQLException {
        String sql = "delete.SalaryReport delete.OdinReport";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void UpdateSalary(BE.BESalary e) throws SQLException {
        String sql = "update SalaryReport set Hours=? where IsItOdin=? and OdinNr=? and FiremanID=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setDouble(1, e.getHours());
        ps.setBoolean(2, e.getIsItOdin());
        ps.setInt(3, e.getODIN());
        ps.setInt(4, e.getFiremanID());
        ps.executeUpdate();
    }
}
