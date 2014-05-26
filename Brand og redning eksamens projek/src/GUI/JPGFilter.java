/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Kathrine
 */

//LIDT JAVA DOC HER VILLE IKKE SKADE :D
public class JPGFilter extends FileFilter implements java.io.FileFilter {

    @Override
    public boolean accept(File f) {
         {
   if (f.getName().toLowerCase().endsWith(".jpeg")) return true;
   if (f.getName().toLowerCase().endsWith(".jpg")) return true;
   if(f.isDirectory())return true;
   return false;
  } }

    // SØRG FOR AT SÆTTE JAVA DOC HER PLEASE :D
    @Override
    public String getDescription() {
   return "JPG files";}
    
}
