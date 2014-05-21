/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BE.BEFireman;



/**
 *
 * @author peter bærbar
 */
public interface CRUDFiremanListener {
    
        /**
     * implementing classes will have to override the PDFTimePlanPerformed & PDFOdinPerformed method 
     * @param event type FormatEventPDF
     */
    public void FiremanCreatePerformed(BEFireman event);
    public void FiremanRemovePerformed(BEFireman event);
    public void FiremanUpdatePerformed(BEFireman event);
    public void FiremanReadPerformed(BEFireman event);
}
