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
public class BESalary {

    private String Role, SalaryCode, Date;
    private int FiremanID, ODIN, WORK, TypeOfWork;
    private double Hours;
    private boolean isHoliday;

    /**
     * Constructor used for creating a monthly salary report
     * @param ODIN int
     * @param WORK int
     * @param ID int
     * @param Role String
     * @param SalaryCode String
     * @param Hours double
     * @param Date String
     * @param TypeOfWork int
     * @param isHoliday boolean
     */
    public BESalary(int ODIN, int WORK, int ID, String Role, String SalaryCode, double Hours, String Date, int TypeOfWork, boolean isHoliday) {
        this.WORK = WORK;
        this.ODIN = ODIN;
        this.FiremanID = ID;
        this.Role = Role;
        this.SalaryCode = SalaryCode;
        this.Hours = Hours;
        this.Date = Date;
        this.TypeOfWork = TypeOfWork;
        this.isHoliday = isHoliday;
    }

    /**
     * Not sure if this constructor is used, please find out and possibly delete if not!
     */
    public BESalary(int ODIN, int WORK, int ID, String Role, String SalaryCode, int Hours, String Date, int TypeOfWork) {
        this.WORK = WORK;
        this.ODIN = ODIN;
        this.FiremanID = ID;
        this.Role = Role;
        this.SalaryCode = SalaryCode;
        this.Hours = Hours;
        this.Date = Date;
        this.TypeOfWork = TypeOfWork;

    }

    /**
     * @return the FiremanID
     */
    public int getFiremanID() {
        return FiremanID;
    }

    /**
     * @param ID the FiremanID to set
     */
    public void setFiremanID(int ID) {
        this.FiremanID = ID;
    }

    /**
     * @return the Role
     */
    public String getRole() {
        return Role;
    }

    /**
     * @param Role the Role to set
     */
    public void setRole(String Role) {
        this.Role = Role;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the TypeOfWork
     */
    public int getTypeOfWork() {
        return TypeOfWork;
    }

    /**
     * @param TypeOfWork the TypeOfWork to set
     */
    public void setTypeOfWork(int TypeOfWork) {
        this.TypeOfWork = TypeOfWork;
    }

    /**
     * @return the SalaryCode
     */
    public String getSalaryCode() {
        return SalaryCode;
    }

    /**
     * @param SalaryCode the SalaryCode to set
     */
    public void setSalaryCode(String SalaryCode) {
        this.SalaryCode = SalaryCode;
    }

    /**
     * @return the Hours
     */
    public double getHours() {
        return Hours;
    }

    /**
     * @param Hours the Hours to set
     */
    public void setHours(double Hours) {
        this.Hours = Hours;
    }

    /**
     * @return the isHoliday
     */
    public boolean isIsHoliday() {
        return isHoliday;
    }

    /**
     * @param isHoliday the isHoliday to set
     */
    public void setIsHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    /**
     * @return the ODIN
     */
    public int getODIN() {
        return ODIN;
    }

    /**
     * @param ODIN the ODIN to set
     */
    public void setODIN(int ODIN) {
        this.ODIN = ODIN;
    }

    /**
     * @return the WORK
     */
    public int getWORK() {
        return WORK;
    }

    /**
     * @param WORK the WORK to set
     */
    public void setWORK(int WORK) {
        this.WORK = WORK;
    }
}
