/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Kathrine
 */
public class BEMaterial {

    private int m_emergencyID, m_Amount;
    private String m_Material;

    /**
     * Constructor used for packaging Materiale and Antal for Materials
     * @param Materiale String
     * @param Antal int
     */
    public BEMaterial(String Materiale, int Antal) {

        m_Material = Materiale;
        m_Amount = Antal;

    }
    
    /**
     * Constructor used for packaging ID, Materiale and Antal for a Fireman
     * @param ID int
     * @param Materiale String
     * @param Antal int
     */
    public BEMaterial(int ID, String Materiale, int Antal) {

        m_emergencyID = ID;
        m_Material = Materiale;
        m_Amount = Antal;

    }
    
    /**
     * Constructor used for packaging Materiale name only
     * @param Materiale String
     */
      public BEMaterial(String Materiale) {
        m_Material = Materiale;
    }

    /**
     * @return the m_UdrykningsID
     */
    public int getM_ID() {
        return m_emergencyID;
    }

    /**
     * @param m_UdrykningsID the m_UdrykningsID to set
     */
    public void setM_UdrykningsID(int m_UdrykningsID) {
        this.m_emergencyID = m_UdrykningsID;
    }

    /**
     * @return the m_Materiale
     */
    public String getM_Materiale() {
        return m_Material;
    }

    /**
     * @param m_Materiale the m_Materiale to set
     */
    public void setM_Materiale(String m_Materiale) {
        this.m_Material = m_Materiale;
    }

    /**
     * @return the m_Antal
     */
    public int getM_Antal() {
        return m_Amount;
    }

    /**
     * @param m_Antal the m_Antal to set
     */
    public void setM_Antal(int m_Antal) {
        this.m_Amount = m_Antal;
    }

}
