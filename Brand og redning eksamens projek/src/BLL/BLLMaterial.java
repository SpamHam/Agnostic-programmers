/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BEMaterial;
import GUI.MaterialListener;
import Utility.Error.EventExercutionException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter bærbar
 */
public class BLLMaterial implements MaterialListener {

    private DALC.DALCMaterial DALCMaterial;
    private final Utility.Error.ErrorHandler Error;

    
    public BLLMaterial(){ Error = Utility.Error.ErrorHandler.getInstance();}


    /**
     * A function that retrieves all material info from the database and inserts it into an ArrayList
     * @return res
     * @throws Exception 
     */
    public ArrayList<BE.BEMaterial> getAll() throws Exception {
        ArrayList<BE.BEMaterial> res = new ArrayList<>();
        try {
            res = DALCMaterial.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

 
/**
 * Function that calls the Create function from DALC. If any field is empty the function will return an error
 * @param event 
 */
    @Override
    public void MaterialCreatePerformed(BEMaterial event) {
              if (event.getMaterial().isEmpty()) {
           throw new EventExercutionException("Ikke nok info til at oprette materialet");
        } else {
            try {
                DALCMaterial.getInstance().Create(event);
            } catch (SQLException e) {
            throw new EventExercutionException("kunne ikke få forbindelse til server");
            }
        }
    }
/**
 * A function that calls the delete function from DALC
 * @param event 
 */
    @Override
    public void MaterialRemovePerformed(BEMaterial event) {
        try {
            DALCMaterial.getInstance().Delete(event);
        } catch (SQLException ex) {
           throw new EventExercutionException("kunne ikke få forbindelse til server");
        }
    }
/**
      * A function that calls the update function from DALC 
     * If any field is left blank it will return an error 
 * @param event 
 */
    @Override
    public void MaterialUpdatePerformed(BEMaterial event) {
               if (event.getMaterial().isEmpty()) {
         throw new EventExercutionException("Ikke nok info til at oprette materialet");
        } else {
            try {
                DALCMaterial.getInstance().update(event);
            } catch (SQLException ex) {
            throw new EventExercutionException("Kunne ikke få forbindelse til server");
            }
        }
    }

}
