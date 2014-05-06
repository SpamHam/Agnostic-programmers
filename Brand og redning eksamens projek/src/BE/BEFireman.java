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

    private String CPR, FirstName, LastName, Address;
    private int PhoneNr, CallNr, PaymentNr;
    private boolean LeaderTrained;

    public BEFireman(String CPR, String FirstName, String LastName) {
        this.CPR = CPR;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public BEFireman(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public BEFireman(String CPR, String FirstName, String LastName, String Address,
                     int PhoneNr, int CallNr, int PaymentNr, boolean LeaderTrained) {
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
    public int getPhoneNr() {
        return PhoneNr;
    }

    /**
     * @param PhoneNr the PhoneNr to set
     */
    public void setPhoneNr(int PhoneNr) {
        this.PhoneNr = PhoneNr;
    }

    /**
     * @return the CallNr
     */
    public int getCallNr() {
        return CallNr;
    }

    /**
     * @param CallNr the CallNr to set
     */
    public void setCallNr(int CallNr) {
        this.CallNr = CallNr;
    }

    /**
     * @return the PaymentNr
     */
    public int getPaymentNr() {
        return PaymentNr;
    }

    /**
     * @param PaymentNr the PaymentNr to set
     */
    public void setPaymentNr(int PaymentNr) {
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
