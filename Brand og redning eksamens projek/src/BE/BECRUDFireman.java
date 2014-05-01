/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BE;
import java.util.ArrayList;
/**
 *
 * @author Claus
 */
public class BECRUDFireman {
    private String CPR;
    private String Fornavn;
    private String Efternavn;
        
public BECRUDFireman(String CPR, String Fornavn, String Efternavn) {
        this.CPR = CPR;
        this.Fornavn = Fornavn;
        this.Efternavn = Efternavn;
    }    

public BECRUDFireman(){}


    /**
     * @return the CPR
     */
    public String getCPR() {
        return CPR;
    }

    /**
     * @param CPR the CPR to set
     */
    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    /**
     * @return the Fornavn
     */
    public String getFornavn() {
        return Fornavn;
    }

    /**
     * @param Fornavn the Fornavn to set
     */
    public void setFornavn(String Fornavn) {
        this.Fornavn = Fornavn;
    }

    /**
     * @return the Efternavn
     */
    public String getEfternavn() {
        return Efternavn;
    }

    /**
     * @param Efternavn the Efternavn to set
     */
    public void setEfternavn(String Efternavn) {
        this.Efternavn = Efternavn;
    }


}
