/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BE.BEMaterial;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public interface MaterialListener {
    
            /**
     * implementing classes will have to override these methods 
     * @param event type FormatEventPDF
     */
    public void MaterialCreatePerformed(BEMaterial event);
    public void MaterialRemovePerformed(BEMaterial event);
    public void MaterialUpdatePerformed(BEMaterial event);
    public ArrayList<BEMaterial> VehicleReadPerformed();
    
}
