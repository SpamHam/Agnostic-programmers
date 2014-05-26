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
        System.out.println("Dalc salary");
        String sql = "insert into SalaryReport values (?,?,?,?,?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setInt(1, e.getODIN());
        ps.setInt(2, e.getFiremanID());
        ps.setString(3, e.getRole());
        ps.setString(4, e.getSalaryCode());
        ps.setDouble(5, e.getHours());
        ps.executeUpdate();
    }

    /**
     * Creates a row in the SalaryReport table.
     *
     * @param e
     * @throws SQLException
     */
    public void OdinReport(BE.BESalary e) throws SQLException {
        String sql = "insert into OdinReport values (?,?,?,?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setInt(1, e.getODIN());
        ps.setString(2, e.getDate());
        ps.setInt(3, e.getTypeOfWork());
        ps.setBoolean(4, e.isIsHoliday());
        ps.executeUpdate();
    }

    /**
     * Creates a row in the SalaryReport table.
     *
     * @param e
     * @throws SQLException
     */
    public void WorkReport(BE.BESalary e) throws SQLException {
        String sql = "insert into WorkReport values (?,?,?)";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setString(1, e.getDate());
        System.out.println("1");
        ps.setInt(2, e.getTypeOfWork());
        System.out.println("2");
        ps.setBoolean(3, e.isIsHoliday());
        System.out.println("3");
        ps.executeUpdate();
        System.out.println("Am i Here ");
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
        if (!stm.execute("select * from SalaryReport inner join OdinReport on OdinReport.OdinNr = SalaryReport.ODINnr \n"
                + "select * from SalaryReport inner join WorkReport on WorkReport.WorkNr = SalaryReport.WORKnr")) {
            Error.Datatable("OdinReport or Salaryreport");
        }
        ResultSet result = stm.getResultSet();
        while (result.next()) {

            int WORK = result.getInt("WORKnr");
            int ODIN = result.getInt("ODINnr");
            int ID = result.getInt("FiremanID");
            String Role = result.getString("Role");
            String SalaryCode = result.getString("SalaryCode");
            double Hours = result.getDouble("Hours");
            String Date = result.getString("Date");
            int TypeOfWork = result.getInt("TypeOfWork");
            boolean isHoliday = result.getBoolean("isHoliday");

            BE.BESalary c = new BE.BESalary(ODIN, WORK, ID, Role, SalaryCode, Hours, Date, TypeOfWork, isHoliday);
            res.add(c);
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
        String sql = "delete * from SalaryReport, OdinReport, WorkReport";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void UpdateOdin(BE.BESalary e) throws SQLException {
        String sql = "update SalaryReport set Hours=? where ODINnr=? and FiremanID=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setDouble(1, e.getHours());
        ps.setInt(2, e.getODIN());
        ps.setInt(3, e.getFiremanID());
        ps.executeUpdate();
    }

    public void UpdateWork(BE.BESalary e) throws SQLException {
        String sql = "update SalaryReport set Hours=? where WORKnr=? and FiremanID=?";
        PreparedStatement ps = m_connection.prepareStatement(sql);
        ps.setDouble(1, e.getHours());
        ps.setInt(2, e.getWORK());
        ps.setInt(3, e.getFiremanID());
        ps.executeUpdate();
    }
}
