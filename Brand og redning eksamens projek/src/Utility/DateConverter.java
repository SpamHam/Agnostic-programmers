/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
/**
 *
 * @author peter bærbar
 */ 
public class DateConverter {
DateFormatSymbols symbols;
DateFormat format;
public static final int WEEKDAY_DAY_MONTH_YEAR_TIME = 0;
public static final int DAY_MONTH_TIME = 1;

  String[] MONTHS = {"januar", "februar", "marts", "april", "maj", "juni",
  "juli", "august", "september", "oktober", "november", "december"};
  String[] ShortMONTHS = {"jan", "feb", "mar", "apr", "maj", "jun",
  "jul", "aug", "sep", "okt", "nov", "dec"};
  String[] Weekdays = {"", "mandag", "tirsdag", "onsdag",
    "torsdag", "fredag", "lørdag", "søndag"};
  String[] shortWeekdays = {"", "man", "tir", "ons", "tor", "fre", "lør", "søn"};
  
  public DateConverter(int typeFormat){
  symbols = new DateFormatSymbols();
  symbols.setMonths(MONTHS);
  symbols.setShortMonths(ShortMONTHS);
  symbols.setWeekdays(Weekdays);
  symbols.setShortWeekdays(shortWeekdays);
  String type = typeOfFormat(typeFormat);
  format = new SimpleDateFormat(type, symbols);
    }
  
  public String getDate(){
  return format.format(new Date());
  }
  
  public void getprint(){
      System.out.println(format.format(new Date()));
  }

    private String typeOfFormat(int typeFormat) {
            switch (typeFormat) {
         case 0: return "EEE dd MMM yyyy HH:mm";
         case 1: return "dd-MMM HH.mm";
         } return null;
    }
}
