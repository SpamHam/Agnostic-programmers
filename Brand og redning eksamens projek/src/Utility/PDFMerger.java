/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class PDFMerger {
 
//    public static void main(String[] args) {
//        try {
//            List<InputStream> pdfs = new ArrayList<InputStream>();
//            pdfs.add(new FileInputStream("c:/PDF/1.pdf"));
//            pdfs.add(new FileInputStream("c:/PDF/2.pdf"));
//            OutputStream output = new FileOutputStream("c:/PDF/merge.pdf");
//            PDFMerger.concatPDFs(pdfs, output, true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public void MergePDF() throws FileNotFoundException, Exception{
        
            int f = new File("c:/PDF/").listFiles().length; //gets the current number of files and folders in the pdf directory;
                                                            //minimum file in this folder = 1(temp folder)
            List<InputStream> pdfs = new ArrayList<InputStream>();
            pdfs.add(new FileInputStream("c:/PDF/temp/tempTimePlan.pdf"));
            pdfs.add(new FileInputStream("c:/PDF/temp/tempODIN.pdf"));
            OutputStream output = new FileOutputStream("c:/PDF/ODIN Nr "+f+".pdf");
            concatPDFs(pdfs, output, true);
    }
 
    private void concatPDFs(List<InputStream> streamOfPDFFiles,
            OutputStream outputStream, boolean paginate) throws Exception {
 
        Document document = new Document();
        try {
            inputConcat(streamOfPDFFiles, document, outputStream, paginate);
            outputStream.flush();
            document.close();
            outputStream.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (document.isOpen())
                document.close();
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException ioe) {
                throw new Exception(ioe.getMessage());
            }
        }
    }

    private void inputConcat(List<InputStream> streamOfPDFFiles, Document document, OutputStream outputStream, boolean paginate) throws DocumentException, IOException {
        List<InputStream> pdfs = streamOfPDFFiles;
        List<PdfReader> readers = new ArrayList<PdfReader>();
        int totalPages = 0;
        Iterator<InputStream> iteratorPDFs = pdfs.iterator();
        totalPages = createReaders(iteratorPDFs, readers, totalPages);
        createWriter(document, outputStream, readers, paginate, totalPages);
    }

    private void createWriter(Document document, OutputStream outputStream, List<PdfReader> readers, boolean paginate, int totalPages) throws DocumentException, IOException {
        // Create a writer for the outputstream
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        
        document.open();
        
        PdfImportedPage page;
        int currentPageNumber = 0;
        int pageOfCurrentReaderPDF = 0;
        Iterator<PdfReader> iteratorPDFReader = readers.iterator();
        addToOutput(iteratorPDFReader, pageOfCurrentReaderPDF, document, currentPageNumber, writer, paginate, totalPages);        
    }

    private void addToOutput(Iterator<PdfReader> iteratorPDFReader, int pageOfCurrentReaderPDF, Document document, int currentPageNumber, PdfWriter writer, boolean paginate, int totalPages) throws DocumentException, IOException {
       PdfContentByte cb = writer.getDirectContent(); // Holds the PDF
        // data
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
        BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        PdfImportedPage page;
        // Loop through the PDF files and add to the output.
        while (iteratorPDFReader.hasNext()) {
            PdfReader pdfReader = iteratorPDFReader.next();
            
            // Create a new page in the target for each source page.
            while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
                document.newPage();
                pageOfCurrentReaderPDF++;
                currentPageNumber++;
                page = writer.getImportedPage(pdfReader,
                        pageOfCurrentReaderPDF);
                cb.addTemplate(page, 0, 0);
                
                // Code for pagination.
                if (paginate) {
                    cb.beginText();
                    cb.setFontAndSize(bf, 9);
                    cb.showTextAligned(PdfContentByte.ALIGN_CENTER, ""
                            + currentPageNumber + " of " + totalPages, 520,
                            5, 0);
                    cb.endText();
                }
            }
            pageOfCurrentReaderPDF = 0;
        }
    }

    private int createReaders(Iterator<InputStream> iteratorPDFs, List<PdfReader> readers, int totalPages) throws IOException {
        // Create Readers for the pdfs.
        while (iteratorPDFs.hasNext()) {
            InputStream pdf = iteratorPDFs.next();
            PdfReader pdfReader = new PdfReader(pdf);
            readers.add(pdfReader);
            totalPages += pdfReader.getNumberOfPages();
        }
        return totalPages;
    }
}