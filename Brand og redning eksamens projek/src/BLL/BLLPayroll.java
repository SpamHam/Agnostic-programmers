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
     *
     * @param b
     * @throws Exception
     */
    public void CreateOdinReport(ArrayList<BE.BESalary> b) throws Exception {
        if (b.get(0).getDate().isEmpty() || b.get(0).getODIN() == 0) {
            Error.NotEnougthInfo("creating a OdinReport.");
        } else {
            try {
                DALCSalary.getInstance().OdinReport(b.get(0));
                for (int idx = 0; idx <= b.size(); idx++) {
                    CreateSalaryReport(b.get(idx));
                }
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
    public void CreateWorkReport(ArrayList<BE.BESalary> b) throws Exception {
        try {
            int ID = DALCSalary.getInstance().WorkReport(b.get(0));
            System.out.println(ID);
            for (BE.BESalary c : b) {
                c.setWORK(ID);
                CreateSalaryReport(c);
            }
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    /**
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

    public void update(BE.BESalary e) throws Exception {
        try {
            if (e.getODIN() != 0) {
                DALC.DALCSalary.getInstance().UpdateOdin(e);
            } else {
                DALC.DALCSalary.getInstance().UpdateWork(e);
            }
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
    }

    @Override
    public void PDFTimePlanPerformed(FormatEventPDF event) {

        ArrayList<BE.BESalary> salary = new ArrayList<>();
        BLLFireman bllFire = new BLLFireman();
        for (BE.BETimePlan c : event.getTime()) {
            BE.BEFireman f;
            try {
                f = bllFire.FiremanFromID(c.getFiremanID());
            } catch (Exception ex) {
                throw new EventExercutionException(ex.getMessage());
            }
            String holdleder = "Brandmand";
            if (f.isLeaderTrained()) {
                holdleder = "Holdleder";
            }
            BE.BESalary s = new BE.BESalary(0, 0, f.getID(), holdleder, f.getPaymentNr(), c.getHours(), Utility.DateConverter.getDate(DateConverter.DATE_HOURS_MINUTES_SECONDS), event.getSelectedType(), false);
            salary.add(s);
        }
        if (event.getType().equalsIgnoreCase("øvelse") || event.getType().equalsIgnoreCase("brandvagt")
                || event.getType().equalsIgnoreCase("stand-by")) {
            try {
                CreateWorkReport(salary);
            } catch (Exception ex) {
                throw new EventExercutionException(ex.getMessage());
            }
        }
    }

    @Override
    public void PDFOdinPerformed(FormatEventPDF event) {

        ArrayList<BE.BESalary> salary = new ArrayList<>();
        BLLFireman bllFire = new BLLFireman();
        for (BE.BETimePlan c : event.getTime()) {
            BE.BEFireman f;
            try {
                f = bllFire.FiremanFromID(c.getFiremanID());
            } catch (Exception ex) {
                throw new EventExercutionException(ex.getMessage());
            }
            String holdleder = "Brandmand";
            if (f.isLeaderTrained()) {
                holdleder = "Holdleder";
            }
            BE.BESalary s = new BE.BESalary(Integer.parseInt(event.getFireNr()), 0, f.getID(), holdleder, f.getPaymentNr(), c.getHours(), Utility.DateConverter.getDate(DateConverter.DATE_HOURS_MINUTES_SECONDS), event.getSelectedType(), false);
            salary.add(s);
        }
        if (event.getType().equalsIgnoreCase("indsats") || event.getType().equalsIgnoreCase("arbejde falck")
                || event.getType().equalsIgnoreCase("følgeskadeindsats") || event.getType().equalsIgnoreCase("andet")) {
            try {
                CreateOdinReport(salary);
            } catch (Exception ex) {
                throw new EventExercutionException(ex.getMessage());
            }
        }
    }
}
