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
public final class BEFireman {

    private String CPR, FirstName, LastName, Address, PhoneNr, CallNr, PaymentNr;
    private boolean LeaderTrained;

    /**
     * Constructor used for packaging CPR, First Name and Last Name for a Fireman
     * @param CPR String
     * @param FirstName String
     * @param LastName String
     */
    public BEFireman(String CPR, String FirstName, String LastName) {
        this.CPR = CPR;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    /**
     * Constructor used for packaging First Name and Last Name for a Fireman
     * @param FirstName String
     * @param LastName String
     */
    public BEFireman(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    /**
     * Constructor used for creating / updating a fireman
     * @param CPR String
     * @param FirstName String
     * @param LastName String
     * @param Address String
     * @param PhoneNr String
     * @param CallNr String
     * @param PaymentNr String
     * @param LeaderTrained Boolean
     */
    public BEFireman(String CPR, String FirstName, String LastName, String Address,
                     String PhoneNr, String CallNr, String PaymentNr, boolean LeaderTrained) {
        this.setCPR(CPR);
        this.setFirstName(FirstName);
        this.setLastName(LastName);
        this.setAddress(Address);
        this.setPhoneNr(PhoneNr);
        this.setCallNr(CallNr);
        this.setPaymentNr(PaymentNr);
        this.setLeaderTrained(LeaderTrained);
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
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the PhoneNr
     */
    public String getPhoneNr() {
        return PhoneNr;
    }

    /**
     * @param PhoneNr the PhoneNr to set
     */
    public void setPhoneNr(String PhoneNr) {
        this.PhoneNr = PhoneNr;
    }

    /**
     * @return the CallNr
     */
    public String getCallNr() {
        return CallNr;
    }

    /**
     * @param CallNr the CallNr to set
     */
    public void setCallNr(String CallNr) {
        this.CallNr = CallNr;
    }

    /**
     * @return the PaymentNr
     */
    public String getPaymentNr() {
        return PaymentNr;
    }

    /**
     * @param PaymentNr the PaymentNr to set
     */
    public void setPaymentNr(String PaymentNr) {
        this.PaymentNr = PaymentNr;
    }

    /**
     * @return the LeaderTrained
     */
    public boolean isLeaderTrained() {
        return LeaderTrained;
    }

    /**
     * @param LeaderTrained the LeaderTrained to set
     */
    public void setLeaderTrained(boolean LeaderTrained) {
        this.LeaderTrained = LeaderTrained;
    }

}
