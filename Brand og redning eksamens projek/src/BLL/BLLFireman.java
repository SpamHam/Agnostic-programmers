/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BEFireman;

import GUI.CRUDFiremanListener;
import GUI.JPGFilter;
import Utility.Error.EventExercutionException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author peter bærbar
 */
public class BLLFireman implements CRUDFiremanListener {

    private DALC.DALCFireman DALCFireman;
    private final Utility.Error.ErrorHandler Error;
    private final int hgt = 120;
    private final int wdt = 110;
    private String path = null;
    private static final String batPath = "C:\\Billeder";
    private BufferedImage resizedImage = null;
    

    /**
     * Instantiates errorHandler
     *
     */
    public BLLFireman() {
        Error = Utility.Error.ErrorHandler.getInstance();
    }

    /**
     * Function that calls the create function from the DALC Layer. If any field
     * is empty the function will return an error
     *
     * @param b
     * @throws Exception
     */
    public void Create(BE.BEFireman b) throws Exception {
        if (b.getFirstName().isEmpty() || b.getLastName().isEmpty() || b.getAddress().isEmpty() || b.getPhoneNr().isEmpty() || b.getPaymentNr().isEmpty() || b.getHiredDate().isEmpty()) {
            Error.NotEnougthInfo("creating a fireman.");
        } else {
            try {
                DALCFireman.getInstance().Create(b);
            } catch (SQLServerException e) {
                Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * A function that retrieves all fireman info from the database and inserts
     * it into an ArrayList
     *
     * @return res
     * @throws Exception
     */
    public ArrayList<BE.BEFireman> getAll() throws Exception {
        ArrayList<BE.BEFireman> res = new ArrayList<>();
        try {
            res = DALCFireman.getInstance().read();
        } catch (SQLServerException ex) {
            Error.StorageUnreachable(".");
        }
        return res;
    }

    /**
     * A function that calls the update function from the DALC Layer using
     * Singleton If any field is left blank it will return an error
     *
     * @param b
     * @throws Exception
     */
    public void Update(BE.BEFireman b) throws Exception {
        
        if (b.getFirstName().isEmpty() || b.getLastName().isEmpty() || b.getAddress().isEmpty() || b.getPhoneNr().isEmpty() || b.getPaymentNr().isEmpty() || b.getHiredDate().isEmpty()) {
            Error.NotEnougthInfo("updating a fireman.");
        } else {
            try {
                DALCFireman.getInstance().update(b);
            } catch (SQLServerException ex) {
                Error.StorageUnreachable(".");
            }
        }
    }

    /**
     * A function that calls the delete function from the DALC Layer using
     * Singleton
     *
     * @param e
     * @throws Exception
     */
    public void remove(BE.BEFireman e) throws Exception {
        for (BE.BESalary b : new BLLPayroll().getAll()) {
            if (b.getFiremanID() == e.getID()) {
                throw new Exception("Denne brandman har stadig ubetalte timer, få dem printet til pdf først inden du kan slette ham.");
            }
        }
        DALCFireman.getInstance().Delete(e);
    }

    /**
     * Returns a fireman from a specific ID
     *
     * @param ID
     * @return f
     * @throws Exception
     */
    public BEFireman FiremanFromID(int ID) throws Exception {
        for (BE.BEFireman f : getAll()) {
            if (ID == f.getID()) {
                return f;
            }
        }
        Error.StringEqualError("" + ID);
        return null;
    }
    /**
     * This method browse for an image on your computer.
     * @throws Exception 
     */
    public void browseForProfilePicture() throws Exception {
        
        JFileChooser fc = new JFileChooser(batPath);
        fc.setFileFilter(new JPGFilter());
        int res = fc.showOpenDialog(null);
        BufferedImage originalImage = null;
        //BufferedImage resizedImage = null;
        // We have an image!
        try {
            if (res == JFileChooser.APPROVE_OPTION) {
                //File file = fc.getSelectedFile();
                path = fc.getSelectedFile().getPath();
                originalImage = ImageIO.read(new File(path));
                resizedImage = resize(originalImage, wdt, hgt);
            } // Oops!
        } catch (Exception iOException) {
            throw new Exception("Du skal væge et billed.");
        }
    }
    
    /**
     * 
     * @return the resized image. 
     */
    public BufferedImage returnImage(){
        return resizedImage;
        
    }
    

    /**
     * 
     * @return the path of the chosen image. 
     */
    public String path(){
        return path;
    }

    /**
     * set the size of the image.
     * 
     * @param image
     * @param width
     * @param height
     * @return 
     */
    public BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    /**
     * Set the size of the changed image.
     * @param path
     * @param width
     * @param height
     * @return
     * @throws IOException 
     */
    public BufferedImage resizeChangedImage(String path,int width, int height) throws IOException {
    BufferedImage image = null;
    image = ImageIO.read(new File(path));
    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
    Graphics2D g2d = (Graphics2D) bi.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(image, 0, 0, width, height, null);
    g2d.dispose();
    return bi;
}

    /**
     * Calls the Create function from DALCFireman and check wether any of the
     * textfields are left empty
     *
     * @param event
     */
    @Override
    public void FiremanCreatePerformed(BEFireman event) {
        if (event.getFirstName().isEmpty() || event.getLastName().isEmpty() || event.getAddress().isEmpty()
                || event.getPhoneNr().isEmpty() || event.getPaymentNr().isEmpty() || event.getHiredDate().isEmpty()) {
            throw new EventExercutionException("Ikke nok info til at oprette en brandmand");
        } else {
            try {
                DALCFireman.getInstance().Create(event);
            } catch (SQLException ex) {
                throw new EventExercutionException("Kunne ikke få forbindelse til server");
            }

        }
    }

    /**
     * Calls the Remove function from DALCFireman
     *
     * @param event
     */
    @Override
    public void FiremanRemovePerformed(BEFireman event) {
        try {
            remove(event);
        } catch (Exception ex) {
            throw new EventExercutionException("<html>Kunne ikke slette brandmand.<br>Hvis manden stadig har ubetalte timer skal de printes til pdf først.<br>Tjek om du har forbindelse til nettet eller databasen.");
        }
    }

    /**
     * Calls the Update function from DALCFireman
     *
     * @param event
     */
    @Override
    public void FiremanUpdatePerformed(BEFireman event) {
        try {
            Update(event);
        } catch (Exception ex) {
            throw new EventExercutionException("Kunne ikke redigere brandmand");
        }
    }
}
