/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.PDFListener;
import Utility.DateConverter;
import Utility.Error.EventExercutionException;
import Utility.Event.FormatEventPDF;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;

/**
 *
 * @author Morten H.
 */
public class BLLPayroll implements PDFListener {

    private DALC.DALCSalary DALCSalary;
    private final Utility.Error.ErrorHandler Error;

    public BLLPayroll() {
        Error = Utility.Error.ErrorHandler.getInstance();
    }

    /**
     * Creates a row in SalaryReport database for each fireman who have been included in timeplan, 
     * 
     * Shortly just creates a row in SalaryReport.
     *
     * @param salary
     * @throws Exception
     */
    public void CreateSalaryReport(BE.BESalary salary) throws Exception {
        if (salary.getRole().isEmpty() || salary.getSalaryCode().isEmpty() || salary.getHours() == 0) {
            Error.NotEnougthInfo("creating a SalaryReport.");
        } else {
            try {
                DALCSalary.getInstance().SalaryReport(salary);
            } catch (SQLServerException ex) {
                Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * Creates an row in OdinReport,
     * an uses @CreateSalaryReport to fill in report that relate to the just created odin report.
     *
     * @param b
     * @throws Exception
     */
    public void CreateOdinReport(ArrayList<BE.BESalary> b) throws Exception {
        int ID = b.get(0).getODIN();
        if (b.get(0).getDate().isEmpty() || (b.get(0).getODIN() == 0 && b.get(0).getIsItOdin())) {
            Error.NotEnougthInfo("creating a OdinReport.");
        } else {
            try {
                if (b.get(0).getIsItOdin()) {
                    DALCSalary.getInstance().OdinReport(b.get(0));
                } else {
                    ID = DALCSalary.getInstance().WorkReport(b.get(0));
                }
                for (int idx = 0; idx < b.size(); idx++) {
                    b.get(idx).setODIN(ID);
                    CreateSalaryReport(b.get(idx));
                }
            } catch (SQLServerException ex) {
                Error.StorageUnreachable("." + ex);
            }
        }
    }

    /**
     * gather all date from the salary and odin report that are stored in the database.
     *
     * @return @throws Exception
     */
    public ArrayList<BE.BESalary> getAll() throws Exception {
        ArrayList<BE.BESalary> res = new ArrayList<>();
        try {
            res = DALCSalary.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

    /**
     * this is a method that takes the date from @UncompressedTable and compress them
     * so each fireman has one row on the payroll table.
     *
     * @return @throws Exception
     */
    public ArrayList<BE.BETableSalary> getAllTableSalary() throws Exception {
        ArrayList<BE.BETableSalary> CompressedTable = new ArrayList<>(), UncompressedTable = convertToTable();
        ArrayList<String> Unique = new ArrayList<>();
        for (BE.BETableSalary a : UncompressedTable) {
            if (Unique.isEmpty() || !Unique.contains(a.getNavn())) {
                CompressedTable.add(new BE.BETableSalary(a.getNavn(), a.getSalaryNumber(), getAllDataForGivenFireman(UncompressedTable, a)));
                Unique.add(a.getNavn());
            }
        }
        return CompressedTable;
    }

    /**
     * this function are used for the detail report - its importent to that they 
     * dont get compressed to one BElayer since its mostly for micro managing.
     *
     * @param UncompressedTable
     * @param a
     * @param Unique
     * @return
     */
    private double[] getAllDataForGivenFireman(ArrayList<BE.BETableSalary> UncompressedTable, BE.BETableSalary a) {
        double[] Index = new double[12];
        for (BE.BETableSalary b : UncompressedTable) {
            if (a.getNavn().equalsIgnoreCase(b.getNavn())) {
                for (int i = 0; i <= 11; i++) {
                    Index[i] = Index[i] + b.getIndex()[i];
                }
            }
        }
        return Index;
    }

    /**
     * Removes all reports in the tables of SalaryReport and OdinReports.
     * @throws Exception 
     */
    public void removeall() throws Exception {
        try {
            for (BE.BESalary s : getAll()) {
                DALC.DALCSalary.getInstance().Delete(s);
            }
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    /**
     * gets an arraylist from every salary report that have been converted to 
     * tablereport
     *
     * @return @throws Exception
     */
    private ArrayList<BE.BETableSalary> convertToTable() throws Exception {
        ArrayList<BE.BETableSalary> TableSalarys = new ArrayList<>();
        for (BE.BESalary S : getAll()) {
            BE.BETableSalary ts = SalaryTotableSalary(S);
            TableSalarys.add(ts);
        }
        return TableSalarys;
    }

    /**
     * Convert a salaryReport to an tableSalaryReport, it need to be converted
     * for the table to become representive in the table form they have been 
     * given us.
     *
     * @param s
     * @return
     * @throws Exception
     */
    private BE.BETableSalary SalaryTotableSalary(BE.BESalary s) throws Exception {
        BLLFireman g = new BLLFireman();
        BE.BEFireman f = g.FiremanFromID(s.getFiremanID());
        double[] Index = new double[12];
        int IndexLocation = 0;
        IndexLocation += 2 * s.getTypeOfWork(); //BrandBrandmand = 0 BrandHoldleder = 1 StandbyStationBrandmand = 2 StandbyStationHoldleder = 3 ArbejdeStationAndet = 4 ØvelserBrandmand = 6 ØvelserHoldleder = 6 VagtBrandmandHeligdage = 8 VagtBrandmandHverdage = 9 VagtHoldledereHeligdage = 10 VagtHoldlederHverdage = 11;        
        if (s.getRole().trim().equalsIgnoreCase("Holdleder") && s.getTypeOfWork() != 2) {//if its "andet" then there are no differents if he is a "Holdleder". 
            IndexLocation += 1; //Holdleder
        }
        Index[IndexLocation] = s.getHours();
        BE.BETableSalary ts = new BE.BETableSalary(f.getFirstName() + " " + f.getLastName(), s.getSalaryCode(), Index);
        return ts;
    }

    /**
     * updates a salary, mostly just hours worked.
     * 
     * @param e
     * @throws Exception 
     */
    public void update(BE.BESalary e) throws Exception {
        try {
            DALC.DALCSalary.getInstance().UpdateSalary(e);
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    /**
     * this listen to when the button in timeplan are clicked, then it will try 
     * produce an arraylist of salaryReport that will be send to the database.
     * 
     * it will only create a arraylist, if its not an odin report or there are some
     * StationVagt marked in timeplan.
     * 
     * @param event 
     */
    @Override
    public void PDFTimePlanPerformed(FormatEventPDF event) {
        ArrayList<BE.BESalary> Salary = new ArrayList<>();
        ArrayList<BE.BESalary> StationSalary = new ArrayList<>();
        String time = Utility.DateConverter.getDate(DateConverter.DATE_HOURS_MINUTES_SECONDS);
        try {
            BLLFireman bllFire = new BLLFireman();
            for (BE.BETimePlan c : event.getTime()) {
                if (c.getTime() != null) {
                    time = Utility.DateConverter.getDate(DateConverter.MONTH_DAY) + "/" + Utility.DateConverter.getDate(DateConverter.YEAR) + " " + c.getTime();
                }
                if ((event.getType().equalsIgnoreCase("øvelse") || event.getType().equalsIgnoreCase("brandvagt")
                        || event.getType().equalsIgnoreCase("stand-by")) && c.getHours() != 0) {
                    BE.BEFireman f = bllFire.FiremanFromID(c.getFiremanID());
                    String holdleder = isLeader(f);
                    BE.BESalary s = new BE.BESalary(0, false, f.getID(), holdleder, f.getPaymentNr(), c.getHours(), time, event.getSelectedType(), false);
                    Salary.add(s);
                }
                if (c.getStationHours() != 0) {
                    BE.BEFireman f = bllFire.FiremanFromID(c.getFiremanID());
                    String holdleder = isLeader(f);
                    BE.BESalary s = new BE.BESalary(0, false, f.getID(), holdleder, f.getPaymentNr(), c.getStationHours(), time, BLL.BLLTimePlan.getInstance().getTypeOfWorkFromString("Andet"), false);
                    StationSalary.add(s);
                }
            }
            if (!StationSalary.isEmpty()) {
                CreateOdinReport(StationSalary);
            }
            if (!Salary.isEmpty()) {
                CreateOdinReport(Salary);
            }
        } catch (Exception ex) {
            throw new EventExercutionException(ex.getMessage());
        }
    }

    /**
     * just a simple function that finds out if the fireman are leader or not.
     * 
     * @param f
     * @return 
     */
    private String isLeader(BE.BEFireman f) {
        if (f.isLeaderTrained()) {
            return "Holdleder";
        }
        return "Brandmand";
    }

    /**
     * this listen to when the button in ODINReport are clicked, then it will try 
     * produce an arraylist of salaryReport that will be send to the database.
     *
     * @param event 
     */
    @Override
    public void PDFOdinPerformed(FormatEventPDF event) {
        ArrayList<BE.BESalary> salary = new ArrayList<>();
        BLLFireman bllFire = new BLLFireman();
        BE.BETimePlan T = event.getTime().get(0);
        try {
            for (BE.BETimePlan c : event.getTime()) {
                if (c.getHours() > 0 && (event.getType().equalsIgnoreCase("indsats") || event.getType().equalsIgnoreCase("arbejde falck") || event.getType().equalsIgnoreCase("følgeskadeindsats") || event.getType().equalsIgnoreCase("andet"))) {
                    BE.BEFireman f = bllFire.FiremanFromID(c.getFiremanID());
                    String holdleder = isLeader(f);
                    BE.BESalary s = new BE.BESalary(Integer.parseInt(event.getFireNr()), true, f.getID(), holdleder, f.getPaymentNr(), c.getHours(), event.getDate(), event.getSelectedType(), false);
                    salary.add(s);
                }
            }
            CreateOdinReport(salary);
        } catch (Exception ex) {
            throw new EventExercutionException(ex.getMessage());
        }
    }
}
