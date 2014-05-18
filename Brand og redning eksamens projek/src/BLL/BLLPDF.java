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
import Utility.PDFMerger;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter bærbar
 */
public class BLLPDF implements PDFListener  {
    PDFGenerator pdfGen;
    @Override
    public void PDFTimePlanPerformed(FormatEventPDF event) {
    pdfGen = new PDFGenerator(event.getTime(),event.getTimeColNames());
        try {
        pdfGen.runCreateTimePlanPDF();
    } catch (Exception ex) {
        throw new EventExercutionException("Time plan PDF kunne ikke gemmes");
     }
   }

    @Override
    public void PDFOdinPerformed(FormatEventPDF event) {
     pdfGen = new PDFGenerator(event.getMaterial(), event.getMatrialeColNames(), event.getForces(), event.getForcesColNames(), event.getDate(), event.getReceived(), event.getFireNr(), event.getEvaNr(), event.getMessage(), event.getName(), event.getAddress(), event.getLeader(), event.getTeamLeader(), event.getWeekday());
     // pdfGen = new PDFGenerator(event.getMaterial(),event.getMatrialeColNames(),event.getForces(),event.getForcesColNames(),event.getDate(),event.getReceived());
        try {
        pdfGen.runCreateOdinPDF();
    } catch (Exception ex) {
        throw new EventExercutionException("ODIN Rapport kunne ikke gemmes");
     }
        PDFMerger merger = new PDFMerger();
        try {
            merger.MergePDF();
        } catch (FileNotFoundException ex) {
            throw new EventExercutionException("ODIN Rapport PDF kunne ikke genereres");
        }
    }

}
