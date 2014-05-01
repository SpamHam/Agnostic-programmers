/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BE;

/**
 *
 * @author Claus
 */
public class BEPayroll {
private String Navn;
private int LønNr;
private int BrandBrandmand;
private int BrandHoldleder;
private int StandbyStationBrandmand;
private int StandbyStationHoldleder;
private int ArbPåStation;
private int ØvelseBrandmand;
private int ØvelseHoldleder;
private int VagtHelligdagBrandmand;
private int VagtHverdagBrandmand;
private int VagtHelligdagHoldleder;
private int VagtHverdagHoldleder;


    public BEPayroll(String Navn, int LønNr, int BrandBrandmand, int BrandHoldleder,
                     int StandbyStationBrandmand, int StandbyStationHoldleder, int ArbPåStation, 
                     int ØvelseBrandmand, int ØvelseHoldleder, int VagtHelligdagBrandmand, 
                     int VagtHverdagBrandmand, int VagtHelligdagHoldleder, int VagtHverdagHoldleder) {
    
        this.Navn = Navn;
        this.LønNr = LønNr;
        this.BrandBrandmand = BrandBrandmand;
        this.BrandHoldleder = BrandHoldleder;
        this.StandbyStationBrandmand = StandbyStationBrandmand;
        this.StandbyStationHoldleder = StandbyStationHoldleder;
        this.ArbPåStation = ArbPåStation;
        this.ØvelseBrandmand = ØvelseBrandmand;
        this.ØvelseHoldleder = ØvelseHoldleder;
        this.VagtHelligdagBrandmand = VagtHelligdagBrandmand;
        this.VagtHverdagBrandmand = VagtHverdagBrandmand;
        this.VagtHelligdagHoldleder = VagtHelligdagHoldleder;
        this.VagtHverdagHoldleder = VagtHverdagHoldleder;
    
    }

    /**
     * @return the Navn
     */
    public String getNavn() {
        return Navn;
    }

    /**
     * @param Navn the Navn to set
     */
    public void setNavn(String Navn) {
        this.Navn = Navn;
    }

    /**
     * @return the LønNr
     */
    public int getLønNr() {
        return LønNr;
    }

    /**
     * @param LønNr the LønNr to set
     */
    public void setLønNr(int LønNr) {
        this.LønNr = LønNr;
    }

    /**
     * @return the BrandBrandmand
     */
    public int getBrandBrandmand() {
        return BrandBrandmand;
    }

    /**
     * @param BrandBrandmand the BrandBrandmand to set
     */
    public void setBrandBrandmand(int BrandBrandmand) {
        this.BrandBrandmand = BrandBrandmand;
    }

    /**
     * @return the BrandHoldleder
     */
    public int getBrandHoldleder() {
        return BrandHoldleder;
    }

    /**
     * @param BrandHoldleder the BrandHoldleder to set
     */
    public void setBrandHoldleder(int BrandHoldleder) {
        this.BrandHoldleder = BrandHoldleder;
    }

    /**
     * @return the StandbyStationBrandmand
     */
    public int getStandbyStationBrandmand() {
        return StandbyStationBrandmand;
    }

    /**
     * @param StandbyStationBrandmand the StandbyStationBrandmand to set
     */
    public void setStandbyStationBrandmand(int StandbyStationBrandmand) {
        this.StandbyStationBrandmand = StandbyStationBrandmand;
    }

    /**
     * @return the StandbyStationHoldleder
     */
    public int getStandbyStationHoldleder() {
        return StandbyStationHoldleder;
    }

    /**
     * @param StandbyStationHoldleder the StandbyStationHoldleder to set
     */
    public void setStandbyStationHoldleder(int StandbyStationHoldleder) {
        this.StandbyStationHoldleder = StandbyStationHoldleder;
    }

    /**
     * @return the ArbPåStation
     */
    public int getArbPåStation() {
        return ArbPåStation;
    }

    /**
     * @param ArbPåStation the ArbPåStation to set
     */
    public void setArbPåStation(int ArbPåStation) {
        this.ArbPåStation = ArbPåStation;
    }

    /**
     * @return the ØvelseBrandmand
     */
    public int getØvelseBrandmand() {
        return ØvelseBrandmand;
    }

    /**
     * @param ØvelseBrandmand the ØvelseBrandmand to set
     */
    public void setØvelseBrandmand(int ØvelseBrandmand) {
        this.ØvelseBrandmand = ØvelseBrandmand;
    }

    /**
     * @return the ØvelseHoldleder
     */
    public int getØvelseHoldleder() {
        return ØvelseHoldleder;
    }

    /**
     * @param ØvelseHoldleder the ØvelseHoldleder to set
     */
    public void setØvelseHoldleder(int ØvelseHoldleder) {
        this.ØvelseHoldleder = ØvelseHoldleder;
    }

    /**
     * @return the VagtHelligdagBrandmand
     */
    public int getVagtHelligdagBrandmand() {
        return VagtHelligdagBrandmand;
    }

    /**
     * @param VagtHelligdagBrandmand the VagtHelligdagBrandmand to set
     */
    public void setVagtHelligdagBrandmand(int VagtHelligdagBrandmand) {
        this.VagtHelligdagBrandmand = VagtHelligdagBrandmand;
    }

    /**
     * @return the VagtHverdagBrandmand
     */
    public int getVagtHverdagBrandmand() {
        return VagtHverdagBrandmand;
    }

    /**
     * @param VagtHverdagBrandmand the VagtHverdagBrandmand to set
     */
    public void setVagtHverdagBrandmand(int VagtHverdagBrandmand) {
        this.VagtHverdagBrandmand = VagtHverdagBrandmand;
    }

    /**
     * @return the VagtHelligdagHoldleder
     */
    public int getVagtHelligdagHoldleder() {
        return VagtHelligdagHoldleder;
    }

    /**
     * @param VagtHelligdagHoldleder the VagtHelligdagHoldleder to set
     */
    public void setVagtHelligdagHoldleder(int VagtHelligdagHoldleder) {
        this.VagtHelligdagHoldleder = VagtHelligdagHoldleder;
    }

    /**
     * @return the VagtHverdagHoldleder
     */
    public int getVagtHverdagHoldleder() {
        return VagtHverdagHoldleder;
    }

    /**
     * @param VagtHverdagHoldleder the VagtHverdagHoldleder to set
     */
    public void setVagtHverdagHoldleder(int VagtHverdagHoldleder) {
        this.VagtHverdagHoldleder = VagtHverdagHoldleder;
    }
}
