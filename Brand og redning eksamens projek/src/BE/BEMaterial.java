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
public class BEMaterial {

private int m_UdrykningsID;
private String m_Materiale;
private int m_Antal;

    public BEMaterial(String Materiale, int Antal){
       
        m_Materiale = Materiale;
        m_Antal = Antal;
        
    }
    
    public BEMaterial(){
        
    }
    
    public ArrayList<BEMaterial> getAll(){
        ArrayList<BEMaterial> res = new ArrayList<>();
        BEMaterial a = new BEMaterial("Pulverslukker", 2);
        res.add(a);
        BEMaterial b = new BEMaterial("Flydespærringer", 3);
        res.add(b);
        BEMaterial c = new BEMaterial("Lysmateriel", 4);
        res.add(c);
        BEMaterial d = new BEMaterial("C-slanger", 16);
        res.add(d);
        BEMaterial e = new BEMaterial("Flasker (300 bar)", 12);
        res.add(e);
        return res;
    }

    /**
     * @return the m_UdrykningsID
     */
    public int getM_UdrykningsID() {
        return m_UdrykningsID;
    }

    /**
     * @param m_UdrykningsID the m_UdrykningsID to set
     */
    public void setM_UdrykningsID(int m_UdrykningsID) {
        this.m_UdrykningsID = m_UdrykningsID;
    }

    /**
     * @return the m_Materiale
     */
    public String getM_Materiale() {
        return m_Materiale;
    }

    /**
     * @param m_Materiale the m_Materiale to set
     */
    public void setM_Materiale(String m_Materiale) {
        this.m_Materiale = m_Materiale;
    }

    /**
     * @return the m_Antal
     */
    public int getM_Antal() {
        return m_Antal;
    }

    /**
     * @param m_Antal the m_Antal to set
     */
    public void setM_Antal(int m_Antal) {
        this.m_Antal = m_Antal;
    }
    
}
