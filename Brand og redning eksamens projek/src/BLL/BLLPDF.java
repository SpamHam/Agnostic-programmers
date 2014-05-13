/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import GUI.EventExercutionException;
import GUI.FormatEventPDF;
import GUI.PDFListener;
import Utility.PDFGenerator;

/**
 *
 * @author peter bærbar
 */
public class BLLPDF implements PDFListener  {
    PDFGenerator pdfGen;
    @Override
    public void PDFPerformed(FormatEventPDF event) {
    pdfGen = new PDFGenerator(event.getTime(), event.getColNames());
    try {
        pdfGen.run();
    } catch (Exception ex) {
        throw new EventExercutionException("PDF kunne ikke genereres");
    }
    }
}
