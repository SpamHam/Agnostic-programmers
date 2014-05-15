/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author peter bærbar
 */
public interface PDFListener {
   
    /**
     * implementing classes will have to override the PDFTimePlanPerformed method 
     * @param event type FormatEventPDF
     */
    public void PDFTimePlanPerformed(FormatEventPDF event);
    
}
