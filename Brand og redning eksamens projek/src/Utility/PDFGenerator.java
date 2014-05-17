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

import BE.BEForces;
import BE.BEMaterial;
import BE.BETimePlan;
import java.io.FileOutputStream;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;

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



public class PDFGenerator {
   //private String FILE;
  private String FILE = "c:/PDF/";
 // DateFactory myDate;
  final private static Font Header = new Font(Font.FontFamily.TIMES_ROMAN, 18,
      Font.BOLD);
 final private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 6,
      Font.NORMAL, BaseColor.RED);
  final private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.BOLD);
  final private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 10,
      Font.NORMAL);
  private ArrayList<BETimePlan> allTime;
  private ArrayList<String> colNames;
  public static final int CREATE_TIME_PLAN_PDF = 0; 
  private ArrayList<BEMaterial> allMaterial;
  private ArrayList<String> materialColNames;
  private ArrayList<BEForces> allForces;
  private ArrayList<String> forcesColName;
  private String evaNr, fireNr, received, date, message, name, address, leader, teamLeader, weekday;
  
  
  /**
   * Constructor for Time Plan page
   * @param allTime
   * @param colNames 
   */
  public PDFGenerator(ArrayList <BETimePlan> allTime, ArrayList<String> colNames){
    this.allTime = allTime;
    this.colNames = colNames;
  }
  
  public PDFGenerator(ArrayList<BEMaterial> allMaterial, ArrayList<String> materialColName,ArrayList<BEForces> allForces,
          ArrayList<String> forcesColName, String date, String received){
    this.allMaterial = allMaterial;
    this.materialColNames = materialColName;
    this.allForces = allForces;
    this.forcesColName = forcesColName;
    this.date = date;
    this.received = received;
  }
  

  public PDFGenerator(ArrayList<BEMaterial> allMaterial, ArrayList<String>materialColName, ArrayList<BEForces> allForces,
          ArrayList<String> forcesColName, String date, String received,String fireNr, String evaNr, String message, 
          String name, String address, String leader, String teamLeader, String weekday){
        this.allMaterial = allMaterial;
        this.materialColNames = materialColName;
        this.allForces = allForces;
        this.forcesColName = forcesColName;
        this.date = date;
        this.received = received;
        this.fireNr = fireNr;
        this.evaNr = evaNr;
        this.message = message;
        this.name = name;
        this.address = address;
        this.leader = leader;
        this.teamLeader = teamLeader;
        this.weekday = weekday;
  }
  
  
  
  public void runCreateTimePlanPDF() throws Exception{
     FILE = FILE + DateConverter.getDate(DateConverter.DAY_MONTH_TIME) + ".pdf";
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      createTimePlanPage(document);
      document.close();
    }
  
   public void runCreateOdinPDF() throws Exception{
     FILE = FILE + DateConverter.getDate(DateConverter.DAY_MONTH_TIME)+ "O" + ".pdf";
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      createOdinPage(document);
      document.close();
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

  /**
   * Generator the time plan section of the PDF
   * @param document
   * @throws DocumentException 
   */
  private void createTimePlanPage(Document document)
      throws DocumentException {
    Paragraph odinRaport = new Paragraph();
    // We add one empty line
    addEmptyLine(odinRaport, 1);
    // Lets write a big header
    Paragraph title = new Paragraph("ODIN Rapport", Header); 
    title.setAlignment(Element.ALIGN_CENTER);
    odinRaport.add(title);
    addEmptyLine(odinRaport, 1);
    odinRaport.add(new Paragraph("Brand & Redning Esbjerg",
        smallBold));
     odinRaport.add(new Paragraph("Vibevej 18, 6705 ESBJERG Ø",
        small));    
    addEmptyLine(odinRaport, 1);
    // Will create: Report generated by: _name, _date
    odinRaport.add(new Paragraph("Rapport genereret af: " + System.getProperty("user.name") + ", " 
      + DateConverter.getDate(DateConverter.WEEKDAY_DAY_MONTH_YEAR_TIME), 
        smallBold));
  addEmptyLine(odinRaport, 2);
  odinRaport.add(new Paragraph("Time Plan Table",
        smallBold));
  addEmptyLine(odinRaport, 1);
    createTable(odinRaport, allTime, colNames);
  addEmptyLine(odinRaport, 3);
    odinRaport.add(new Paragraph("Dette dokument er lavet i systemet Borr",
        redFont));
    //document.newPage(); // new page
    //ODINBackPage(odinRaport, title);   
    document.add(odinRaport);

  }

    private void createOdinPage(Document document) 
        throws DocumentException {
        Paragraph odinRaport = new Paragraph(); 
        Paragraph title = new Paragraph("ODIN Rapport", Header); 
         title.setAlignment(Element.ALIGN_CENTER);
        odinRaport.add(title);
        addEmptyLine(odinRaport, 2);
       //odinRaport.add(new Paragraph("Dato: " + date,
         //       small));
       
        odinRaport.add(new Chunk("Dato: ",smallBold));
        odinRaport.add(new Phrase(date,
                small));
//        addEmptyLine(odinRaport, 1);
//        odinRaport.add(new Paragraph("Indsats Leder: " + leader,
//                small));
//        addEmptyLine(odinRaport, 1);
//        odinRaport.add(new Paragraph("Hold Leder: " + teamLeader,
//                small));
//        addEmptyLine(odinRaport, 1);
//        odinRaport.add(new Paragraph("Uge dag: " + weekday,
//                small));
        addEmptyLine(odinRaport, 1);
        odinRaport.add(new Paragraph("Alarm Modtaget: " + received,
                small));
//        addEmptyLine(odinRaport, 1);
//        odinRaport.add(new Paragraph("Brand Rapport Nr: " + fireNr,
//                small));
//        addEmptyLine(odinRaport, 1);
//        odinRaport.add(new Paragraph("EVA Nr: " + evaNr,
//                small));
//        addEmptyLine(odinRaport, 1);
//        odinRaport.add(new Paragraph("Skadslidte",
//                smallBold));
//        odinRaport.add(new Paragraph("Navn: " + name,
//                small));
//        addEmptyLine(odinRaport, 1);
//        odinRaport.add(new Paragraph("Adresse" + address,
//                small));
//        addEmptyLine(odinRaport, 2);
//        odinRaport.add(new Paragraph("Materialer Brugt",
//                smallBold));
        addEmptyLine(odinRaport, 1);
        createMaterialTable(odinRaport, allMaterial, materialColNames);
        addEmptyLine(odinRaport, 2);
        createForcesTable(odinRaport, allForces, forcesColName);
        document.add(odinRaport);
    }
  
  /**
   * generates the time table for the time plan section of the pdf
   * @param para type IText paragraph
   * @param rowData type ArrayList<BETimePlan>
   * @param colNames type ArrayList<String>
   * @throws BadElementException 
   */

  private void createTable(Paragraph para, ArrayList<BETimePlan> rowData, ArrayList<String> colNames)
      throws BadElementException {
    PdfPTable table = new PdfPTable(colNames.size());

    for (String col : colNames){
    PdfPCell c1 = new PdfPCell(new Phrase(col,smallBold));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
     }
     para.add(table);
    for (BETimePlan row : rowData){
    PdfPCell pos = new PdfPCell(new Phrase(row.getStilling(),small));
    pos.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(pos);
    PdfPCell name = new PdfPCell(new Phrase(row.getNavn(),small));
    name.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(name);
    PdfPCell time = new PdfPCell(new Phrase(row.getTidsrum(),small));
    time.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(time);
    PdfPCell road = new PdfPCell(new Phrase(""+row.getKoert(),small));
    road.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(road);
    PdfPCell stat = new PdfPCell(new Phrase("" + row.getStationsVagt(),small));
    stat.setHorizontalAlignment(Element.ALIGN_CENTER);   
    table.addCell(stat);
    PdfPCell veh = new PdfPCell(new Phrase(row.getKoeretoej(),small));
    veh.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(veh);
    }
  }
  
  
  private void createMaterialTable(Paragraph para, ArrayList<BEMaterial> rowData, ArrayList<String> colNames)
      throws BadElementException {
    PdfPTable table = new PdfPTable(colNames.size());

    for (String col : colNames){
    PdfPCell c1 = new PdfPCell(new Phrase(col,smallBold));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
     }
     para.add(table);
    for (BEMaterial row : rowData){
    PdfPCell data1 = new PdfPCell(new Phrase(row.getM_Materiale(),small));
    data1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(data1);
    PdfPCell data = new PdfPCell(new Phrase(""+row.getM_Antal(),small));
    data.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(data);
    //table.addCell("" + row.getM_Antal());
    }
  }
  
    private void createForcesTable(Paragraph para, ArrayList<BEForces> rowData, ArrayList<String> colNames)
      throws BadElementException {
    PdfPTable table = new PdfPTable(colNames.size());

    for (String col : colNames){
    PdfPCell c1 = new PdfPCell(new Phrase(col,smallBold));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
     }
     para.add(table);
    for (BEForces row : rowData){
    PdfPCell car = new PdfPCell(new Phrase(row.getCarID(),small));
    car.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(car);
    PdfPCell type = new PdfPCell(new Phrase(row.getTypeOfAlarm(),small));
    type.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(type);
    PdfPCell force = new PdfPCell(new Phrase(row.getForces(),small));
    force.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(force);
    //table.addCell("" + row.getM_Antal());
    }
  }
/**
 * adds an empty line
 * @param paragraph
 * @param number 
 */
  private void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }
} 

