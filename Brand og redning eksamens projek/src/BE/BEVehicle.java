/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Kathrine
 */
public class BEVehicle {

    private String m_registrationNr, m_brand, m_model, m_description;

    /**
     * Constructor used for creating / updating a vehicle
     * @param registrationNr
     * @param mærke
     * @param model
     * @param description 
     */
    public BEVehicle(String registrationNr, String mærke, String model, String description) {
        m_registrationNr = registrationNr;
        m_brand = mærke;
        m_model = model;
        m_description = description;

    }

    /**
     * @return the m_registrationNr
     */
    public String getM_registrationNr() {
        return m_registrationNr;
    }

    /**
     * @param m_registrationNr the m_registrationNr to set
     */
    public void setM_registrationNr(String m_registrationNr) {
        this.m_registrationNr = m_registrationNr;
    }

    /**
     * @return the m_brand
     */
    public String getM_brand() {
        return m_brand;
    }

    /**
     * @param m_brand the m_brand to set
     */
    public void setM_brand(String m_brand) {
        this.m_brand = m_brand;
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

    /**
     * @return the m_description
     */
    public String getM_description() {
        return m_description;
    }

    /**
     * @param m_description the m_description to set
     */
    public void setM_description(String m_description) {
        this.m_description = m_description;
    }

}
