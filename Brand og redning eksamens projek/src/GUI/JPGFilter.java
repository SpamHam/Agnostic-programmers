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
public class JPGFilter extends FileFilter implements java.io.FileFilter {

    @Override
    public boolean accept(File f) {
         {
   if (f.getName().toLowerCase().endsWith(".jpeg")) return true;
   if (f.getName().toLowerCase().endsWith(".jpg")) return true;
   if(f.isDirectory())return true;
   return false;
  } }

    @Override
    public String getDescription() {
   return "JPG files";}
    
}
