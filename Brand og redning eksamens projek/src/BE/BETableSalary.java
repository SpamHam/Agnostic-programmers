/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.ArrayList;

/**
 *
 * @author Morten H.
 */
public class BETableSalary {

    private String Navn, SalaryNumber;
    private double[] Index;

    /**
     * Constructor used for converting BESalary to fit in the right table column
     * @param Navn String
     * @param SalaryNumber String
     * @param Index double Array
     */
    public BETableSalary(String Navn, String SalaryNumber, double[] Index) {
        this.Navn = Navn;
        this.SalaryNumber = SalaryNumber;
        this.Index = Index;
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
     * @return the Index
     */
    public double[] getIndex() {
        return Index;
    }

    /**
     * @param Index the Index to set
     */
    public void setIndex(double[] Index) {
        this.Index = Index;
    }
}
