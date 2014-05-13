/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;


/**
 *
 * @author peter bærbar & Morten H.
 */
public class BETimePlan {

    
    private String Stilling, navn, Koeretoej, Tidsrum;
    private int Koert, StationsVagt;

    /**
     * Constructor used for packaging Rank, Name,
     * Timeframe, Driven time, Shift at the station and Vehicle for a timesheet
     * @param Stilling String
     * @param navn String
     * @param Tidsrum String
     * @param Koert int
     * @param StationsVagt int
     * @param Koeretoej String
     */
    public BETimePlan(String Stilling, String navn, String Tidsrum, int Koert, int StationsVagt, String Koeretoej) {
        this.Stilling = Stilling;
        this.navn = navn;
        this.Koert = Koert;
        this.Tidsrum = Tidsrum;
        this.StationsVagt = StationsVagt;
        this.Koeretoej = Koeretoej;
    }
    
    /**
     * Constructor used for packaging name and vehicle used for the timesheet
     * @param navn String
     * @param Koeretoej int
     */
    public BETimePlan(String navn, String Koeretoej){
    this.navn = navn;
    this.Koeretoej = Koeretoej;
    }


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

    public String getTidsrum() {
        return Tidsrum;
    }

    public void setTidsrum(String Tidsrum) {
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


