/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.ArrayList;

/**
 *
 * @author Kathrine
 */
public class BEVehicle {
    
    private int m_registrationNr;
    private String m_mærke;
    private String m_model;
    
    public BEVehicle(int registrationNr, String mærke, String model){
        m_registrationNr = registrationNr;
        m_mærke = mærke;
        m_model = model;
        
    }
    
    public BEVehicle(){
        
    }
    
    public ArrayList<BEVehicle> getAll(){
        ArrayList<BEVehicle> res = new ArrayList<>();
        BEVehicle c = new BEVehicle(12345, "Man", "a3");
        res.add(c);
        BEVehicle b = new BEVehicle(34211, "BMW", "m3");
        res.add(b);
        return res;           
                   
    }

    /**
     * @return the m_registrationNr
     */
    public int getM_registrationNr() {
        return m_registrationNr;
    }

    /**
     * @param m_registrationNr the m_registrationNr to set
     */
    public void setM_registrationNr(int m_registrationNr) {
        this.m_registrationNr = m_registrationNr;
    }

    /**
     * @return the m_mærke
     */
    public String getM_mærke() {
        return m_mærke;
    }

    /**
     * @param m_mærke the m_mærke to set
     */
    public void setM_mærke(String m_mærke) {
        this.m_mærke = m_mærke;
    }

    /**
     * @return the m_model
     */
    public String getM_model() {
        return m_model;
    }

    /**
     * @param m_model the m_model to set
     */
    public void setM_model(String m_model) {
        this.m_model = m_model;
    }
    
}
