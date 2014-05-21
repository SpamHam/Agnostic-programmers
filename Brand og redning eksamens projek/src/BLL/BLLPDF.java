/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;


import Utility.PDF.PDFMerger;
import Utility.Error.EventExercutionException;
import Utility.Event.FormatEventPDF;
import GUI.PDFListener;
import Utility.PDF.DeleteTempPDF;
import Utility.PDF.PDFCreator;
import java.io.FileNotFoundException;

/**
 *
 * @author peter bærbar
 */
public class BLLPDF implements PDFListener  {
    PDFCreator pdfGen;
    
    @Override
    public void PDFTimePlanPerformed(FormatEventPDF event) {
        pdfGen = new PDFCreator(event.getTime(),event.getTimeColNames(), event.getType());
    if(!event.getType().equalsIgnoreCase("øvelse")&& !event.getType().equalsIgnoreCase("brandvagt") && !event.getType().equalsIgnoreCase("stand-by")){
        try {
        pdfGen.runCreateTimePlanPDF();
    } catch (Exception ex) {
        throw new EventExercutionException("Time plan PDF kunne ikke gemmes");
     }
    } else {try {
        pdfGen.runStationTimePlanPDF();
            } catch (Exception ex) {
             throw new EventExercutionException("Time plan PDF kunne ikke genereres");
            }
        }
   }

    @Override
    public void PDFOdinPerformed(FormatEventPDF event) {
     pdfGen = new PDFCreator(event.getMaterial(), event.getMatrialeColNames(), event.getForces(), event.getForcesColNames(), 
             event.getDate(), event.getReceived(), event.getFireNr(), event.getEvaNr(), event.getMessage(), event.getName(), 
             event.getAddress(), event.getLeader(), event.getTeamLeader(), event.getWeekday());
        try {
        pdfGen.runCreateOdinPDF();
    } catch (Exception ex) {
        throw new EventExercutionException("ODIN Rapport kunne ikke gemmes");
     }
        PDFMerger merger = new PDFMerger();
        try {
            merger.MergePDF(event.getFireNr());
        } catch (FileNotFoundException ex) {
            throw new EventExercutionException("ODIN Rapport PDF kunne ikke genereres");
        } catch (Exception ex) {
            throw new EventExercutionException("ODIN Rapport PDF kunne ikke genereres");
        }
        DeleteTempPDF dtp = new DeleteTempPDF();
        try {
            dtp.runDelete();
        } catch (FileNotFoundException ex) {
          throw new EventExercutionException("ODIN Rapport PDF kunne ikke genereres");
        }
    }
}
