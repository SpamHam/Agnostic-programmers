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
     * implementing classes will have to override the PDFPerformed method 
     * @param event from the PDF_formatEvent class
     */
    public void PDFPerformed(FormatEventPDF event);
}
