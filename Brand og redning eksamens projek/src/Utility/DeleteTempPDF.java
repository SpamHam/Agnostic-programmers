/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author peter bærbar
 */
public class DeleteTempPDF {
//    String fileName1 = "c:/PDF/tempTimePlan.pdf";
//    String fileName2 = "c:/PDF/tempODIN.pdf";
//public static void main(String[] args) {
//    String fileName1 = "c:/PDF/tempTimePlan.pdf";
//    String fileName2 = "c:/PDF/tempODIN.pdf";
//    // A File object to represent the filename
//   File f = new File(fileName1);
//   File f2 = new File(fileName2);
//    // Make sure the file or directory exists and isn't write protected
//    if (!f.exists())
//      throw new IllegalArgumentException(
//          "Delete: no such file or directory: " + fileName1);
//    if (!f.canWrite())
//      throw new IllegalArgumentException("Delete: write protected: "
//          + fileName1);
//    
//    // Attempt to delete it
//    boolean success = f.delete();
//
//    if (!success)
//      throw new IllegalArgumentException("Delete: deletion failed");
//  }

//    public static void main(String[] args) {
//    runDelete();
//    }
    
    /**
     * Deletes the temp pdf's
     * @throws FileNotFoundException 
     */
   public void runDelete() throws FileNotFoundException {
    String fileName1 = "c:/PDF/temp/tempTimePlan.pdf";
    String fileName2 = "c:/PDF/temp/tempODIN.pdf";
    File f = new File(fileName1);
    File f2 = new File(fileName2);
       deleteFile(f);
       deleteFile(f2);
   }
   /**
    * Deletes the temp pdf's
    * @param file
    * @throws FileNotFoundException 
    */
private void deleteFile(File file) throws FileNotFoundException {
   if (!file.exists())
      throw new FileNotFoundException(
          "Delete: no such file or directory: " + file);
    if (!file.canWrite())
      throw new IllegalArgumentException("Delete: write protected: "
          + file);
    
    // Attempt to delete it
    boolean success = file.delete();

    if (!success)
      throw new IllegalArgumentException("Delete: deletion failed");
}

}