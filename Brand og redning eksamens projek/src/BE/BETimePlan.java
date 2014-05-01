/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.ArrayList;

/**
 *
 * @author peter bærbar & Morten H.
 */
public class BETimePlan {

    
    private String Stilling;
    private String navn;
    private int Koert;
    private int Tidsrum;
    private int StationsVagt;
    private String Koeretoej;

    public BETimePlan(String Stilling, String navn, int Koert, int Tidsrum, int StationsVagt, String Koeretoej) {
        this.Stilling = Stilling;
        this.navn = navn;
        this.Koert = Koert;
        this.Tidsrum = Tidsrum;
        this.StationsVagt = StationsVagt;
        this.Koeretoej = Koeretoej;
    }
    
    public BETimePlan(){}


    public String getStilling() {
        return Stilling;
    }

    public void setStilling(String Stilling) {
        this.Stilling = Stilling;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getKoert() {
        return Koert;
    }

    public void setKoert(int Koert) {
        this.Koert = Koert;
    }

    public int getTidsrum() {
        return Tidsrum;
    }

    public void setTidsrum(int Tidsrum) {
        this.Tidsrum = Tidsrum;
    }

    public int getStationsVagt() {
        return StationsVagt;
    }

    public void setStationsVagt(int StationsVagt) {
        this.StationsVagt = StationsVagt;
    }

    /**
     * @return the StringStatus
     */
    public String getKoeretoej() {
        return Koeretoej;
    }

    /**
     * @param Status the StringStatus to set
     */
    public void setKoeretoej(String Koeretoej) {
        this.Koeretoej = Koeretoej;
    }

}


