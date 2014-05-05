/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

/**
 *
 * @author peter bærbar
 */

import BE.BETimePlan;
import java.io.FileOutputStream;
import java.util.Date;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;



public class PDFFactory {
   //private String FILE;
  private String FILE = "c:/th/";
 // DateFactory myDate;
  final private static Font Header = new Font(Font.FontFamily.TIMES_ROMAN, 18,
      Font.BOLD);
 final private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 6,
      Font.NORMAL, BaseColor.RED);
  final private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.BOLD);
  final private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 10,
      Font.BOLD);
  private ArrayList<BETimePlan> allTime;
  private ArrayList<String> colNames;
  
  public PDFFactory(ArrayList <BETimePlan> allTime, ArrayList<String> colNames){
  this.allTime = allTime;
  this.colNames = colNames;
 String fileName = new DateFactory(DateFactory.DAY_MONTH_TIME).getDate();
  FILE = FILE + fileName + ".pdf";
  }
  
  public void run() throws Exception{
      try {
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      createODIN(document);
      document.close();
    } catch (Exception e) {
      throw new Exception ("Kunne ikke generer PDF");
    }
  }

  // iText allows to add metadata to the PDF which can be viewed in your Adobe
  // Reader
  // under File -> Properties
  private void addMetaData(Document document) {
    document.addTitle("ODIN Rapport nr. ");
    document.addSubject("Generated by BORR");
    document.addKeywords("Brand og redning Esbjerg");
    document.addAuthor("BORR");
    document.addCreator("BORR");
  }

  private void createODIN(Document document)
      throws DocumentException {
    Paragraph odinRaport = new Paragraph();
    // We add one empty line
    addEmptyLine(odinRaport, 1);
    // Lets write a big header
    odinRaport.add(new Paragraph("ODIN Rapport nr. 1", Header));
    addEmptyLine(odinRaport, 1);
    odinRaport.add(new Paragraph("Brand & Redning Esbjerg",
        smallBold));
     odinRaport.add(new Paragraph("Vibevej 18, 6705 ESBJERG Ø",
        small));    
    addEmptyLine(odinRaport, 1);
// Will create: Report generated by: _name, _date
    odinRaport.add(new Paragraph("Rapport genereret af: " + System.getProperty("user.name") + ", " + new DateFactory(DateFactory.WEEKDAY_DAY_MONTH_YEAR_TIME).getDate(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        smallBold));
  addEmptyLine(odinRaport, 2);
  odinRaport.add(new Paragraph("Time Plan Table",
        smallBold));
  addEmptyLine(odinRaport, 1);
    createTable(odinRaport, allTime, colNames);
addEmptyLine(odinRaport, 3);
    odinRaport.add(new Paragraph("Dette dokument er lavet i systemet Borr",
        redFont));
    document.add(odinRaport);

  }

  private void createTable(Paragraph para, ArrayList<BETimePlan> rowData, ArrayList<String> colNames)
      throws BadElementException {
    PdfPTable table = new PdfPTable(colNames.size());

    for (String col : colNames){
    PdfPCell c1 = new PdfPCell(new Phrase(col));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
        }
     para.add(table);
    for (BETimePlan row : rowData){
    table.addCell(row.getStilling());
    table.addCell(row.getNavn());
    table.addCell("" + row.getTidsrum());
    table.addCell("" + row.getKoert());
    table.addCell("" + row.getStationsVagt());
    table.addCell(row.getKoeretoej());
}
  }

  private void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }
} 

