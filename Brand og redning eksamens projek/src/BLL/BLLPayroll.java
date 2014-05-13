/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BESalary;
import BE.BETableSalary;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;

/**
 *
 * @author Morten H.
 */
public class BLLPayroll {

    private static BLLPayroll m_instance;
    private DALC.DALCSalary DALCSalary;
    private final Utility.ErrorHandler Error;

    /**
     * Singleton
     *
     * @return
     * @throws SQLServerException
     */
    public static BLLPayroll getInstance() throws Exception {
        if (m_instance == null) {
            m_instance = new BLLPayroll();
        }
        return m_instance;
    }

    private BLLPayroll() throws Exception {
        Error = Utility.ErrorHandler.getInstance();
        try {
            DALCSalary = DALC.DALCSalary.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    public void CreateSalary(BE.BESalary b) throws Exception {
        if (b.getODIN() == 0 || b.getDate().isEmpty()) {
            Error.NotEnougthInfo("creating a SalaryReport.");
        } else {
            try {
                DALCSalary.getInstance().CreateSalary(b);
            } catch (SQLServerException ex) {
                Error.StorageUnreachable(".");
            }
        }
    }

    public void CreateMonthly(BE.BESalary b) throws Exception {
        if (b.getODIN() == 0 || b.getCPR().isEmpty() || b.getRole().isEmpty() || b.getSalaryCode().isEmpty() || b.getHours() == 0) {
            Error.NotEnougthInfo("creating a SalaryReport.");
        } else {
            try {
                DALCSalary.getInstance().CreateSalary(b);
            } catch (SQLServerException ex) {
                Error.StorageUnreachable(".");
            }
        }
    }

    public ArrayList<BE.BESalary> getAll() throws Exception {
        ArrayList<BE.BESalary> res = new ArrayList<>();
        try {
            System.out.println("1");
            res = DALCSalary.getInstance().read();
        } catch (SQLServerException ex) {
            System.out.println("2");
            Error.StorageUnreachable(".");
        }
        return res;
    }

    /**
     *
     * @return @throws Exception
     */
    public ArrayList<BE.BETableSalary> getAllTableSalary() throws Exception {
        ArrayList<BE.BETableSalary> CompressedTable = new ArrayList<>();
        ArrayList<BE.BETableSalary> UncompressedTable = convertToTable();
        ArrayList<Double> Index = new ArrayList<>();
        ArrayList<String> Unique = new ArrayList<>();
        for (BE.BETableSalary a : UncompressedTable) {
            for (BE.BETableSalary b : UncompressedTable) {
                if (a.getNavn().equalsIgnoreCase(b.getNavn()) && (Unique.isEmpty() || !Unique.contains(a.getNavn()))) {
                    Index.addAll(b.getIndex());
                    Index.toString();
                }
            }
            Index.clear();
            Unique.add(a.getNavn());
            CompressedTable.add(new BETableSalary(a.getNavn(), a.getSalaryNumber(), Index));
        }
        return CompressedTable;
    }

    /**
     *
     * @return @throws Exception
     */
    private ArrayList<BE.BETableSalary> convertToTable() throws Exception {
        ArrayList<BE.BETableSalary> TableSalarys = new ArrayList<>();
        for (BE.BESalary S : getAll()) {
            BETableSalary ts = SalaryTotableSalary(S);
            TableSalarys.add(ts);
        }
        return TableSalarys;
    }

    private BETableSalary SalaryTotableSalary(BESalary s) throws Exception {
        BE.BEFireman f = BLL.BLLFireman.getInstance().FiremanFromCPR(s.getCPR());
        ArrayList<Double> Index = new ArrayList<>();
        int IndexLocation = 0;
        IndexLocation += 2 * s.getTypeOfWork(); //BrandBrandmand = 0 BrandHoldleder = 1 StandbyStationBrandmand = 2 StandbyStationHoldleder = 3 ArbejdeStationAndet = 4 ØvelserBrandmand = 6 ØvelserHoldleder = 6 VagtBrandmandHeligdage = 8 VagtBrandmandHverdage = 9 VagtHoldledereHeligdage = 10 VagtHoldlederHverdage = 11;        
        if (s.getRole().trim().equalsIgnoreCase("Holdleder") && s.getTypeOfWork() != 2) {//if its "andet" then there are no differents if he is a "Holdleder". 
            IndexLocation += 1; //Holdleder
        }
        Index.add(IndexLocation, s.getHours());
        BE.BETableSalary ts = new BE.BETableSalary(f.getFirstName() + " " + f.getLastName(), s.getSalaryCode(), Index);
        return ts;
    }

    public void remove() throws Exception {
        //TODO after Salary are done.
    }
}
