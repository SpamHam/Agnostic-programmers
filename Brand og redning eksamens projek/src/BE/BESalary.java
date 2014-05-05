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

    private String CPR, Role, Date, TypeOfWork;
    private int SalaryCode, Hours, ODIN;
    private boolean isHoliday;
    
    public BESalary(int ODIN, String CPR, String Role, int SalaryCode, int Hours, String Date, String TypeOfWork, boolean isHoliday){
        this.ODIN = ODIN;
        this.CPR = CPR;
        this.Role = Role;
        this.SalaryCode = SalaryCode;
        this.Hours = Hours;
        this.Date = Date;
        this.TypeOfWork = TypeOfWork;
        this.isHoliday = isHoliday;
    }
    
        public BESalary(int ODIN, String CPR, String Role, int SalaryCode, int Hours, String Date, String TypeOfWork){
        this.ODIN = ODIN;
        this.CPR = CPR;
        this.Role = Role;
        this.SalaryCode = SalaryCode;
        this.Hours = Hours;
        this.Date = Date;
        this.TypeOfWork = TypeOfWork;
        
    }

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
    public String getTypeOfWork() {
        return TypeOfWork;
    }

    /**
     * @param TypeOfWork the TypeOfWork to set
     */
    public void setTypeOfWork(String TypeOfWork) {
        this.TypeOfWork = TypeOfWork;
    }

    /**
     * @return the SalaryCode
     */
    public int getSalaryCode() {
        return SalaryCode;
    }

    /**
     * @param SalaryCode the SalaryCode to set
     */
    public void setSalaryCode(int SalaryCode) {
        this.SalaryCode = SalaryCode;
    }

    /**
     * @return the Hours
     */
    public int getHours() {
        return Hours;
    }

    /**
     * @param Hours the Hours to set
     */
    public void setHours(int Hours) {
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
}
