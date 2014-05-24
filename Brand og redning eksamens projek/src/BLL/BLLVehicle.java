/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BEVehicle;
import DALC.IDALCVehicle;
import GUI.VehicleListener;
import Utility.Error.EventExercutionException;
import java.util.ArrayList;


/**
 *
 * @author peter bærbar
 */
public class BLLVehicle implements VehicleListener{

    IDALCVehicle m_dal; 

    
    public BLLVehicle(){
    }
    
     public void setDAlC(IDALCVehicle m_dal){this.m_dal = m_dal;}

    /**
     * A function that retrieves all fireman info from the database and inserts it into an ArrayList
     * @return res
     * @throws Exception 
     */
    public ArrayList<BE.BEVehicle> getAll() throws Exception {
        ArrayList<BE.BEVehicle> res = new ArrayList<>();
        try {
          res =  m_dal.VehicleReadPerformed();
        } catch (EventExercutionException ex) {
            throw new EventExercutionException(ex.getMessage());
        }
        return res;
    }


    @Override
    public void VehicleCreatePerformed(BEVehicle event) {
            if (event.getM_registrationNr().isEmpty() || event.getM_mærke().isEmpty() || event.getM_model().isEmpty()) {
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
        if (event.getM_registrationNr().isEmpty() || event.getM_mærke().isEmpty() || event.getM_model().isEmpty()) {
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
       return m_dal.VehicleReadPerformed();
    }
    }

