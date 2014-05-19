/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import java.io.File;

/**
 *
 * @author peter bærbar
 */
public class FileCounterTester {
  static int f = new File("c:/PDF/").listFiles().length;
    
  public static void main(String[] args) {
      System.out.println(f);
  }
}
