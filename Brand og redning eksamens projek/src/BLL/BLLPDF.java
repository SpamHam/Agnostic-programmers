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
    //ArrayList<BETimePlan> m_timePlan = new ArrayList<>();
    //ArrayList<String> m_timePlanColNames = new ArrayList<>();
    PDFGenerator pdfGen;
    @Override
    public void PDFTimePlanPerformed(FormatEventPDF event) {
    pdfGen = new PDFGenerator(event.getTime(),event.getTimeColNames());
        try {
        pdfGen.run();
    } catch (Exception ex) {
        throw new EventExercutionException("PDF kunne ikke genereres");
     }
   }

}
