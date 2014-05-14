/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

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

    /**
     * 
     * @throws Exception 
     */
    private BLLPayroll() throws Exception {
        Error = Utility.ErrorHandler.getInstance();
        try {
            DALCSalary = DALC.DALCSalary.getInstance();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    /**
     * 
     * @param b
     * @throws Exception 
     */
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

    /**
     * 
     * @param b
     * @throws Exception 
     */
    public void CreateMonthly(BE.BESalary b) throws Exception {
        if (b.getODIN() == 0 || b.getRole().isEmpty() || b.getSalaryCode().isEmpty() || b.getHours() == 0) {
            Error.NotEnougthInfo("creating a SalaryReport.");
        } else {
            try {
                DALCSalary.getInstance().CreateSalary(b);
            } catch (SQLServerException ex) {
                Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * 
     * @return
     * @throws Exception 
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
     * 
     * @return
     * @throws Exception 
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
     * 
     * @param s
     * @return
     * @throws Exception 
     */
    private BE.BETableSalary SalaryTotableSalary(BE.BESalary s) throws Exception {
        BE.BEFireman f = BLL.BLLFireman.getInstance().FiremanFromCPR(s.getID());
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

    public void remove() throws Exception {
        //TODO after Salary are done.
    }
}
