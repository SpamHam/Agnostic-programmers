/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BE;

/**
 *
 * @author Son Of Satan
 */
public class BETableSalary {
    private String Navn, SalaryNumber;
    private double BrandBrandmand, BrandHoldleder, StandbyStationBrandmand, StandbyStationHoldleder, ArbejdeStationAndet, ØvelserBrandmand, ØvelserHoldeder, VagtBrandmandHeligdage, VagtBrandmandHverdage, VagtHoldledereHeligdage, VagtHoldledereHverdage; 

    public BETableSalary(String Navn, String SalaryNumber, double BrandBrandmand, double BrandHoldleder, double StandbyStationBrandmand, double StandbyStationHoldleder, double ArbejdeStationAndet, double ØvelserBrandmand, double ØvelserHoldeder, double VagtBrandmandHeligdage, double VagtBrandmandHverdage, double VagtHoldledereHeligdage, double VagtHoldledereHverdage){
        this.Navn = Navn;
        this.SalaryNumber = SalaryNumber;
        this.BrandBrandmand = BrandBrandmand;
        this.BrandHoldleder = BrandHoldleder;
        this.StandbyStationBrandmand = StandbyStationBrandmand;
        this.StandbyStationHoldleder = StandbyStationHoldleder;
        this.ArbejdeStationAndet = ArbejdeStationAndet;
        this.ØvelserBrandmand = ØvelserBrandmand;
        this.ØvelserHoldeder = ØvelserHoldeder;
        this.VagtBrandmandHeligdage = VagtBrandmandHeligdage;
        this.VagtBrandmandHverdage = VagtBrandmandHverdage;
        this.VagtHoldledereHeligdage = VagtHoldledereHeligdage;
        this.VagtHoldledereHverdage = VagtHoldledereHverdage; 
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
     * @return the SalaryNumber
     */
    public String getSalaryNumber() {
        return SalaryNumber;
    }

    /**
     * @param SalaryNumber the SalaryNumber to set
     */
    public void setSalaryNumber(String SalaryNumber) {
        this.SalaryNumber = SalaryNumber;
    }

    /**
     * @return the BrandBrandmand
     */
    public double getBrandBrandmand() {
        return BrandBrandmand;
    }

    /**
     * @param BrandBrandmand the BrandBrandmand to set
     */
    public void setBrandBrandmand(double BrandBrandmand) {
        this.BrandBrandmand = BrandBrandmand;
    }

    /**
     * @return the BrandHoldleder
     */
    public double getBrandHoldleder() {
        return BrandHoldleder;
    }

    /**
     * @param BrandHoldleder the BrandHoldleder to set
     */
    public void setBrandHoldleder(double BrandHoldleder) {
        this.BrandHoldleder = BrandHoldleder;
    }

    /**
     * @return the StandbyStationBrandmand
     */
    public double getStandbyStationBrandmand() {
        return StandbyStationBrandmand;
    }

    /**
     * @param StandbyStationBrandmand the StandbyStationBrandmand to set
     */
    public void setStandbyStationBrandmand(double StandbyStationBrandmand) {
        this.StandbyStationBrandmand = StandbyStationBrandmand;
    }

    /**
     * @return the StandbyStationHoldleder
     */
    public double getStandbyStationHoldleder() {
        return StandbyStationHoldleder;
    }

    /**
     * @param StandbyStationHoldleder the StandbyStationHoldleder to set
     */
    public void setStandbyStationHoldleder(double StandbyStationHoldleder) {
        this.StandbyStationHoldleder = StandbyStationHoldleder;
    }

    /**
     * @return the ArbejdeStationAndet
     */
    public double getArbejdeStationAndet() {
        return ArbejdeStationAndet;
    }

    /**
     * @param ArbejdeStationAndet the ArbejdeStationAndet to set
     */
    public void setArbejdeStationAndet(double ArbejdeStationAndet) {
        this.ArbejdeStationAndet = ArbejdeStationAndet;
    }

    /**
     * @return the ØvelserBrandmand
     */
    public double getØvelserBrandmand() {
        return ØvelserBrandmand;
    }

    /**
     * @param ØvelserBrandmand the ØvelserBrandmand to set
     */
    public void setØvelserBrandmand(double ØvelserBrandmand) {
        this.ØvelserBrandmand = ØvelserBrandmand;
    }

    /**
     * @return the ØvelserHoldeder
     */
    public double getØvelserHoldeder() {
        return ØvelserHoldeder;
    }

    /**
     * @param ØvelserHoldeder the ØvelserHoldeder to set
     */
    public void setØvelserHoldeder(double ØvelserHoldeder) {
        this.ØvelserHoldeder = ØvelserHoldeder;
    }

    /**
     * @return the VagtBrandmandHeligdage
     */
    public double getVagtBrandmandHeligdage() {
        return VagtBrandmandHeligdage;
    }

    /**
     * @param VagtBrandmandHeligdage the VagtBrandmandHeligdage to set
     */
    public void setVagtBrandmandHeligdage(double VagtBrandmandHeligdage) {
        this.VagtBrandmandHeligdage = VagtBrandmandHeligdage;
    }

    /**
     * @return the VagtBrandmandHverdage
     */
    public double getVagtBrandmandHverdage() {
        return VagtBrandmandHverdage;
    }

    /**
     * @param VagtBrandmandHverdage the VagtBrandmandHverdage to set
     */
    public void setVagtBrandmandHverdage(double VagtBrandmandHverdage) {
        this.VagtBrandmandHverdage = VagtBrandmandHverdage;
    }

    /**
     * @return the VagtHoldledereHeligdage
     */
    public double getVagtHoldledereHeligdage() {
        return VagtHoldledereHeligdage;
    }

    /**
     * @param VagtHoldledereHeligdage the VagtHoldledereHeligdage to set
     */
    public void setVagtHoldledereHeligdage(double VagtHoldledereHeligdage) {
        this.VagtHoldledereHeligdage = VagtHoldledereHeligdage;
    }

    /**
     * @return the VagtHoldledereHverdage
     */
    public double getVagtHoldledereHverdage() {
        return VagtHoldledereHverdage;
    }

    /**
     * @param VagtHoldledereHverdage the VagtHoldledereHverdage to set
     */
    public void setVagtHoldledereHverdage(double VagtHoldledereHverdage) {
        this.VagtHoldledereHverdage = VagtHoldledereHverdage;
    }
    
}
