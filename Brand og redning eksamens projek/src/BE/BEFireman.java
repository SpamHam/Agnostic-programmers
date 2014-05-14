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

    private String FirstName, LastName, Address, PhoneNr, CallNr, PaymentNr, HiredDate;
    private int ID;
    private boolean LeaderTrained;

    /**
     * Constructor used for packaging CPR, First Name and Last Name for a Fireman
     * @param ID Int
     * @param FirstName String
     * @param LastName String
     */
    public BEFireman(int ID, String FirstName, String LastName) {
        this.ID = ID;
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
     * @param ID int
     * @param HiredDate String
     * @param FirstName String
     * @param LastName String
     * @param Address String
     * @param PhoneNr String
     * @param CallNr String
     * @param PaymentNr String
     * @param LeaderTrained Boolean
     */
    public BEFireman(int ID, String FirstName, String LastName, String Address,
                     String PhoneNr, String CallNr, String PaymentNr, boolean LeaderTrained, String HiredDate) {
        this.setID(ID);
        this.setFirstName(FirstName);
        this.setLastName(LastName);
        this.setAddress(Address);
        this.setPhoneNr(PhoneNr);
        this.setCallNr(CallNr);
        this.setPaymentNr(PaymentNr);
        this.setLeaderTrained(LeaderTrained);
        this.setHiredDate(HiredDate);
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
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

    /**
     * @return the HiredDate
     */
    public String getHiredDate() {
        return HiredDate;
    }

    /**
     * @param HiredDate the HiredDate to set
     */
    public void setHiredDate(String HiredDate) {
        this.HiredDate = HiredDate;
    }

}
