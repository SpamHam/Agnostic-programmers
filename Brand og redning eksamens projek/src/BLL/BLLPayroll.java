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
        if (b.getODIN() == 0 || b.getTypeOfWork().isEmpty() || b.getDate().isEmpty()) {
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
        if (b.getODIN() == 0 || b.getCPR().isEmpty() || b.getRole().isEmpty() || b.getSalaryCode() == 0 || b.getHours() == 0) {
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
            res = DALCSalary.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

    public ArrayList<BE.BETableSalary> convertToTable() throws Exception {
        ArrayList<BE.BETableSalary> TableSalarys = new ArrayList<>();
        for (BE.BESalary S : getAll()) {
            BETableSalary ts = SalaryTotableSalary(S);
            TableSalarys.add(ts);
        }
        return TableSalarys;
    }

    private BETableSalary SalaryTotableSalary(BESalary S) throws Exception {
        double BrandBrandmand = 0, BrandHoldleder = 0, StandbyStationBrandmand = 0, StandbyStationHoldleder = 0, ArbejdeStationAndet = 0, ØvelserBrandmand = 0, ØvelserHoldeder = 0, VagtBrandmandHeligdage = 0, VagtBrandmandHverdage = 0, VagtHoldledereHeligdage = 0, VagtHoldledereHverdage = 0;
        BE.BEFireman f = BLL.BLLFireman.getInstance().FiremanFromCPR(S.getCPR());
        if (S.getTypeOfWork().equalsIgnoreCase("Øvelse")) {
            if (S.getRole().equalsIgnoreCase("Holdleder")) {
                ØvelserHoldeder = 1;
            } else {
                ØvelserBrandmand = 1;
            }
        } else if (S.getTypeOfWork().equalsIgnoreCase("Indsats")) {
            if (S.getRole().equalsIgnoreCase("Holdleder")) {
                BrandHoldleder = 1;
            } else {
                BrandBrandmand = 1;
            }
        } else if (S.getTypeOfWork().equalsIgnoreCase("Stand-By")) {
            if (S.getRole().equalsIgnoreCase("Holdleder")) {
                StandbyStationHoldleder = 1;
            } else {
                StandbyStationBrandmand = 1;
            }
        } else if (S.getTypeOfWork().equalsIgnoreCase("Andet")) {
            ArbejdeStationAndet = 1;
        } else if (S.getTypeOfWork().equalsIgnoreCase("Vagt") && S.isIsHoliday()) {
            if (S.getRole().equalsIgnoreCase("Holdleder")) {
                VagtHoldledereHeligdage = 1;
            } else {
                VagtBrandmandHeligdage = 1;
            }
        } else if (S.getTypeOfWork().equalsIgnoreCase("Vagt") && !S.isIsHoliday()) {
            if (S.getRole().equalsIgnoreCase("Holdleder")) {
                VagtHoldledereHverdage = 1;
            } else {
                VagtBrandmandHverdage = 1;
            }
        }
        BE.BETableSalary ts = new BE.BETableSalary(f.getFirstName() + " " + f.getLastName(), Integer.toString(f.getPaymentNr()), BrandBrandmand * S.getHours(), BrandHoldleder * S.getHours(), StandbyStationBrandmand * S.getHours(), StandbyStationHoldleder * S.getHours(), ArbejdeStationAndet * S.getHours(), ØvelserBrandmand * S.getHours(), ØvelserHoldeder * S.getHours(), VagtBrandmandHeligdage * S.getHours(), VagtBrandmandHverdage * S.getHours(), VagtHoldledereHeligdage * S.getHours(), VagtHoldledereHverdage * S.getHours());
        return ts;
    }

    public void remove() throws Exception {
        //TODO after Salary are done.
    }
}
