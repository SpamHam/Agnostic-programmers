/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BEFireman;
import GUI.CRUDFireman;
import GUI.CRUDFiremanListener;
import GUI.PDFListener;
import Utility.Error.EventExercutionException;
import Utility.Event.FormatEventPDF;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter bærbar
 */
public class BLLFireman implements CRUDFiremanListener, PDFListener {

    private DALC.DALCFireman DALCFireman;
    private final Utility.Error.ErrorHandler Error;

    /**
     * Instantiates errorHandler
     *
     */
    public BLLFireman() {
        Error = Utility.Error.ErrorHandler.getInstance();
    }

    /**
     * Function that calls the create function from the DALC Layer. If any field
     * is empty the function will return an error
     *
     * @param b
     * @throws Exception
     */
    public void Create(BE.BEFireman b) throws Exception {
        if (b.getFirstName().isEmpty() || b.getLastName().isEmpty() || b.getAddress().isEmpty() || b.getPhoneNr().isEmpty() || b.getPaymentNr().isEmpty() || b.getHiredDate().isEmpty()) {
            Error.NotEnougthInfo("creating a fireman.");
        } else {
            try {
                DALCFireman.getInstance().Create(b);
            } catch (SQLServerException e) {
                Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * A function that retrieves all fireman info from the database and inserts
     * it into an ArrayList
     *
     * @return res
     * @throws Exception
     */
    public ArrayList<BE.BEFireman> getAll() throws Exception {
        ArrayList<BE.BEFireman> res = new ArrayList<>();
        try {
            res = DALCFireman.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

    /**
     * A function that calls the update function from the DALC Layer using
     * Singleton If any field is left blank it will return an error
     *
     * @param b
     * @throws Exception
     */
    public void Update(BE.BEFireman b) throws Exception {
        if (b.getFirstName().isEmpty() || b.getLastName().isEmpty() || b.getAddress().isEmpty() || b.getPhoneNr().isEmpty() || b.getPaymentNr().isEmpty() || b.getHiredDate().isEmpty()) {
            Error.NotEnougthInfo("updating a fireman.");
        } else {
            try {
                DALCFireman.getInstance().update(b);
            } catch (SQLServerException ex) {
                Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * A function that calls the delete function from the DALC Layer using
     * Singleton
     *
     * @param e
     * @throws Exception
     */
    public void remove(BE.BEFireman e) throws Exception {
//        for (BE.BESalary b : BLL.BLLPayroll.getInstance().getAll()) {
//            if (b.getFiremanID() == e.getID()) {
//                throw new Exception("Denne brandman har stadig ubetalte timer, få dem printet til pdf først inden du kan slette ham.");
//            }
//        }
        DALCFireman.getInstance().Delete(e);
    }

    /**
     * Possiby not used for anything. Not sure!?
     *
     * @param ID
     * @return
     * @throws Exception
     */
    public BEFireman FiremanFromID(int ID) throws Exception {
        for (BE.BEFireman f : getAll()) {
            if (ID == f.getID()) {
                return f;
            }
        }
        Error.StringEqualError("" + ID);
        return null;
    }

    @Override
    public void PDFTimePlanPerformed(FormatEventPDF event) {
        ArrayList<BE.BESalary> salary = new ArrayList<>();
        System.out.println("Rigtig registreret 1");
        for (BE.BETimePlan c : event.getTime()) {
            BE.BEFireman f;
            try {
                f = FiremanFromID(c.getFiremanID());
                System.out.println(c.getFiremanID());
            } catch (Exception ex) {
                throw new EventExercutionException(ex.getMessage());
            }
            String holdleder = "Brandmand";
            if (f.isLeaderTrained()) {
                holdleder = "Holdleder";
            }
            System.out.println(f.getID());
            System.out.println(f.getPaymentNr());
            System.out.println(c.getHours());
            System.out.println(event.getType());
            System.out.println(event.getSelectedType());
            BE.BESalary s = new BE.BESalary(0, f.getID(), holdleder, f.getPaymentNr(), c.getHours(),
                    new Date().toString(), event.getSelectedType(), false);
            salary.add(s);
        }
        if (event.getType().equalsIgnoreCase("øvelse") || event.getType().equalsIgnoreCase("brandvagt")
                || event.getType().equalsIgnoreCase("stand-by")) {
            System.out.println("Rigtig registreret");
            try {
                BLL.BLLPayroll.getInstance().CreateSalary(salary);
            } catch (Exception ex) {
                throw new EventExercutionException(ex.getMessage());
            }
        }
    }

    @Override
    public void PDFOdinPerformed(FormatEventPDF event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void FiremanCreatePerformed(BEFireman event) {
        if (event.getFirstName().isEmpty() || event.getLastName().isEmpty() || event.getAddress().isEmpty()
                || event.getPhoneNr().isEmpty() || event.getPaymentNr().isEmpty() || event.getHiredDate().isEmpty()) {
            throw new EventExercutionException("Ikke nok info til at oprette en brandmand");
        } else {
            try {
                DALCFireman.getInstance().Create(event);
            } catch (SQLException ex) {
                throw new EventExercutionException("Kunne ikke få forbindelse til server");
            }

        }
    }

    @Override
    public void FiremanRemovePerformed(BEFireman event) {
        try {
            remove(event);
        } catch (Exception ex) {
            throw new EventExercutionException("<html>Kunne ikke slette brandmand.<br>Hvis manden stadig har ubetalte timer skal de printes til pdf først.<br>Tjek om du har forbindelse til nettet eller databasen.");
        }
    }
        

 

    @Override
    public void FiremanUpdatePerformed(BEFireman event) {
        try {
            Update(event);
        } catch (Exception ex) {
            throw new EventExercutionException("Kunne ikke redigere brandmand");
        }
    }
}
