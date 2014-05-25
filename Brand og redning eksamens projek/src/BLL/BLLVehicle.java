/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BEVehicle;
import DALC.DALCVehicle;
import DALC.IDALCVehicle;
import GUI.VehicleListener;
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
public class BLLVehicle implements VehicleListener{

    IDALCVehicle m_dal; 

    
    public BLLVehicle(IDALCVehicle d) {
     m_dal = d;
    }
    


    @Override
    public void VehicleCreatePerformed(BEVehicle event) {
            if (event.getM_registrationNr().isEmpty() || event.getM_brand().isEmpty() || event.getM_model().isEmpty()) {
            throw new EventExercutionException("Ikke nok info til at oprette Køretøj");
        } else {
            try {
                m_dal.VehicleCreatePerformed(event);
            } catch (EventExercutionException e) {
            throw new EventExercutionException(e.getMessage());
            }
        }
    }

    @Override
    public void VehicleRemovePerformed(BEVehicle event) {
            try {
               // DALCVehicle.Delete(event);
                m_dal.VehicleRemovePerformed(event);
            } catch (EventExercutionException ex) {
            throw new EventExercutionException(ex.getMessage());
            }
        }

    @Override
    public void VehicleUpdatePerformed(BEVehicle event) {
        if (event.getM_registrationNr().isEmpty() || event.getM_brand().isEmpty() || event.getM_model().isEmpty()) {
            throw new EventExercutionException("Ikke nok info til at oprette Køretøj");
        } else {
            try {
                m_dal.VehicleUpdatePerformed(event);
            } catch (EventExercutionException ex) {
            throw new EventExercutionException(ex.getMessage());
            }
        }
    }

    @Override
    public ArrayList<BEVehicle> VehicleReadPerformed() {
        try {
            return m_dal.VehicleReadPerformed();
        } catch (EventExercutionException ex) {
            throw new EventExercutionException(ex.getMessage());
            }
        }
    }

