/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility.PDF;

/**
 *
 * @author peter bærbar
 */

import BE.BEForces;
import BE.BEMaterial;
import BE.BETimePlan;
import Utility.DateConverter;
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
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.util.ArrayList;



public class PDFCreator {
   //private String FILE;
  private String FILE = "c:/PDF/temp/";
  private String FILE2 = "c:/PDF/";
  final private static Font Header = new Font(Font.FontFamily.TIMES_ROMAN, 20,
      Font.BOLD);
 final private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 6,
      Font.NORMAL, BaseColor.RED);
  final private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.BOLD);
  final private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.NORMAL);
  final private static Font big = new Font(Font.FontFamily.TIMES_ROMAN, 14,
      Font.BOLD);
  private ArrayList<BETimePlan> allTime;
  private ArrayList<String> colNames; 
  private ArrayList<BEMaterial> allMaterial;
  private ArrayList<String> materialColNames;
  private ArrayList<BEForces> allForces;
  private ArrayList<String> forcesColName;
  private String evaNr, fireNr, received, date, message, name, address, leader, teamLeader, weekday, type;
  
  
  /**
   * Constructor for the Time Plan page
   * @param allTime
   * @param colNames
   * @param type
   */
  public PDFCreator(ArrayList <BETimePlan> allTime, ArrayList<String> colNames, String type){
    this.allTime = allTime;
    this.colNames = colNames;
    this.type = type;
  }
/**
 * Constructor for the ODIN Page
 * @param allMaterial
 * @param materialColName
 * @param allForces
 * @param forcesColName
 * @param date
 * @param received
 * @param fireNr
 * @param evaNr
 * @param message
 * @param name
 * @param address
 * @param leader
 * @param teamLeader
 * @param weekday 
 */
  public PDFCreator(ArrayList<BEMaterial> allMaterial, ArrayList<String>materialColName, ArrayList<BEForces> allForces,
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
  
  
  /**
   * Generates the time plan PDF
   * @throws Exception 
   */
  public void runCreateTimePlanPDF() throws Exception{
     FILE = FILE + "tempTimePlan.pdf";
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      createTimePlanPage(document);
      document.close();
    }
  
  /**
   * Generates the ODIN PDF
   * @throws Exception 
   */
   public void runCreateOdinPDF() throws Exception{
     FILE = FILE + "tempODIN.pdf";
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      createOdinPage(document);
      document.close();
    }
   
  /**
   * Generates the station time plan PDF
   * @throws Exception 
   */
  public void runStationTimePlanPDF() throws Exception{
     FILE2 = FILE2 + DateConverter.getDate(DateConverter.DAY_MONTH_TIME)+ "-" + type + " time plan" + ".pdf";
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE2));
      document.open();
      addMetaData(document);
      createTimePlanPage(document);
      document.close();
    }
 
  /**
   * iText allows to add metadata to the PDF which can be viewed in your Adobe
   * Reader
   * under File -> Properties
   * @param document 
   */
  private void addMetaData(Document document) {
    document.addTitle("ODIN Rapport");
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
      throws DocumentException, Exception {
    Paragraph odinRaport = new Paragraph();
    // We add one empty line
    addEmptyLine(odinRaport, 1);
    // Lets write a big header
    Paragraph title = new Paragraph("ODIN Rapport", Header); 
    title.setAlignment(Element.ALIGN_CENTER);
    odinRaport.add(title);
    addEmptyLine(odinRaport, 1);
    odinRaport.add(new Paragraph("Brand & Redning Esbjerg",smallBold));
     odinRaport.add(new Paragraph("Vibevej 18, 6705 ESBJERG Ø",small));    
    addEmptyLine(odinRaport, 1);
    // Will create: Report generated by: _name, _date
    odinRaport.add(new Paragraph("Rapport genereret af: " + System.getProperty("user.name") + ", " 
      + DateConverter.getDate(DateConverter.WEEKDAY_DAY_MONTH_YEAR_TIME), smallBold));
    addEmptyLine(odinRaport, 2);
    
    odinRaport.add(new Chunk("Type Indsats: " , smallBold));
    odinRaport.add(new Phrase( type,small));
    addEmptyLine(odinRaport, 2);
    
    odinRaport.add(new Paragraph("Time Plan:",big));
    addEmptyLine(odinRaport, 1);
    createTimeTable(odinRaport, allTime, colNames);
    addEmptyLine(odinRaport, 3);
    odinRaport.add(new Paragraph("Dette dokument er lavet i systemet BORR",
        redFont));
    document.add(odinRaport);

  }

    private void createOdinPage(Document document) 
        throws DocumentException {
        Chunk tab1 = new Chunk(new VerticalPositionMark(), 200, true);// creates tabs
        Chunk tab2 = new Chunk(new VerticalPositionMark(), 310, true);// creates tabs
        Paragraph odinRaport = new Paragraph(); 
        Paragraph title = new Paragraph("ODIN Rapport", Header); 
         title.setAlignment(Element.ALIGN_CENTER);
        odinRaport.add(title);
        addEmptyLine(odinRaport, 2);
        addDate(odinRaport);
        addEmptyLine(odinRaport, 1);
        addLeaders(odinRaport, tab2);    
        addEmptyLine(odinRaport, 1);
        addReceived(odinRaport, tab2);
        addEmptyLine(odinRaport, 1);
        addSpecification(odinRaport, tab2);
        addEmptyLine(odinRaport, 1);
        addMessage(odinRaport);
        addEmptyLine(odinRaport, 2);
        odinRaport.add(new Chunk("Skadeslidte: " , big));
        addEmptyLine(odinRaport, 1);
        addWounded(odinRaport, tab1);
        addEmptyLine(odinRaport, 1);
        odinRaport.add(new Chunk("Brugte materialer: " , big));
        createMaterialTable(odinRaport, allMaterial, materialColNames);
        addEmptyLine(odinRaport, 2);
        odinRaport.add(new Chunk("Indsatte Styrker: " , big));
        createForcesTable(odinRaport, allForces, forcesColName);
        addEmptyLine(odinRaport, 3);
        odinRaport.add(new Paragraph("Dette dokument er lavet i systemet BORR",
        redFont));
        document.add(odinRaport);
    }

    private void addMessage(Paragraph odinRaport) {
        odinRaport.add(new Chunk("Melding: " , smallBold));
        odinRaport.add(new Phrase( message,small));
    }

    private void addDate(Paragraph odinRaport) {
        odinRaport.add(new Chunk("Dato: ", smallBold));
        odinRaport.add(new Phrase(date, small));
    }

    private void addWounded(Paragraph odinRaport, Chunk tab1) {
        odinRaport.add(new Chunk("Navn: " , smallBold));
        odinRaport.add(new Phrase( name,
                small));
        odinRaport.add(new Chunk(tab1));
        odinRaport.add(new Chunk("Adresse: " , smallBold));
        odinRaport.add(new Phrase( address,
                small));
    }

    private void addSpecification(Paragraph odinRaport, Chunk tab2) {
        odinRaport.add(new Chunk("Brand report Nr: " , smallBold));
        odinRaport.add(new Phrase( fireNr,
                small));
        odinRaport.add(new Chunk(tab2));
        odinRaport.add(new Chunk("EVA Nr: " , smallBold));
        odinRaport.add(new Phrase( evaNr,
                small));
    }

    private void addReceived(Paragraph odinRaport, Chunk tab2) {
        odinRaport.add(new Chunk("Alarm Modtaget: " , smallBold));
        odinRaport.add(new Phrase( received,
                small));
        odinRaport.add(new Chunk(tab2));
        odinRaport.add(new Chunk("Uge dag: " , smallBold));
        odinRaport.add(new Phrase( weekday,
                small));
    }

    private void addLeaders(Paragraph odinRaport, Chunk tab2) {
        odinRaport.add(new Chunk("Indsats Leder: ",smallBold));
        odinRaport.add(new Phrase(teamLeader,
                small));
        odinRaport.add(new Chunk(tab2));
        odinRaport.add(new Chunk("Hold Leder: " , smallBold));
        odinRaport.add(new Phrase( leader,
                small));
    }
  
  /**
   * generates the time table for the time plan section of the pdf
   * @param para type IText paragraph
   * @param rowData type ArrayList<BETimePlan>
   * @param colNames type ArrayList<String>
   * @throws BadElementException 
   */

  private void createTimeTable(Paragraph para, ArrayList<BETimePlan> rowData, ArrayList<String> colNames)
      throws BadElementException, Exception {
    PdfPTable table = new PdfPTable(colNames.size());

    for (String col : colNames){
    PdfPCell c1 = new PdfPCell(new Phrase(col,smallBold));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
     }
     para.add(table);
    for (BETimePlan row : rowData){
    PdfPCell pos = new PdfPCell(new Phrase(row.getTitle(),small));
    pos.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(pos);
    BE.BEFireman f = BLL.BLLFireman.getInstance().FiremanFromID(row.getFiremanID());
    PdfPCell name = new PdfPCell(new Phrase(f.getFirstName() + " " + f.getLastName(),small));
    name.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(name);
    PdfPCell time = new PdfPCell(new Phrase(row.getTime(),small));
    time.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(time);
    PdfPCell road = new PdfPCell(new Phrase(""+row.getHours(),small));
    road.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(road);
    PdfPCell stat = new PdfPCell(new Phrase("" + row.getStationHours(),small));
    stat.setHorizontalAlignment(Element.ALIGN_CENTER);   
    table.addCell(stat);
    PdfPCell veh = new PdfPCell(new Phrase(row.getVehicle(),small));
    veh.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(veh);
    }
  }
  
  /**
   * generates the material table for the Material section of the pdf
   * @param para type Itext Paragraph
   * @param rowData ArrayList<BEMaterial>
   * @param colNames ArrayList<String>
   * @throws BadElementException 
   */
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
    PdfPCell mat = new PdfPCell(new Phrase(row.getMaterial(),small));
    mat.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(mat);
    PdfPCell amount = new PdfPCell(new Phrase(""+row.getAmount(),small));
    amount.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(amount);
    }
  }
  
  /**
   * generates the forces table for the forces section of the pdf
   * @param para type Itext Paragraph
   * @param rowData ArrayList<BEForces>
   * @param colNames ArrayList<String>
   * @throws BadElementException 
   */
  
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

