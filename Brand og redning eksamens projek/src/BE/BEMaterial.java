/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Peter
 */
public class BEMaterial {

    private int emergencyID, amount;
    private String material;

    /**
     * Constructor used for packaging Material and amount for Materials
     * @param material String
     * @param amount int
     */
    public BEMaterial(String material, int amount) {

        this.material = material;
        this.amount = amount;

    }
    
    /**
     * Constructor used for packaging ID, Material and Antal for a Fireman
     * @param emergencyID int
     * @param material String
     */
    public BEMaterial(int emergencyID, String material) {

        this.emergencyID = emergencyID;
        this.material = material;

    }
    
    /**
     * Constructor used for packaging Material name only
     * @param material String
     */
      public BEMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the emergencyID
     */
    public int getEmergencyID() {
        return emergencyID;
    }

    /**
     * @param emergencyID the int emergencyID to set
     */
    public void setEmergencyID(int emergencyID) {
        this.emergencyID = emergencyID;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
