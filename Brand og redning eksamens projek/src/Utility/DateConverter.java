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
private static DateFormatSymbols symbols;
private static DateFormat format;
public static final int WEEKDAY_DAY_MONTH_YEAR_TIME = 0;
public static final int DAY_MONTH_TIME = 1;
public static final int DATE_HOURS_MINUTES_SECONDS = 2;
public static final int YEAR = 3;
public static final int MONTH_DAY = 4;
public static final int MONTH = 5;

private static final  String[] MONTHS = {"januar", "februar", "marts", "april", "maj", "juni",
  "juli", "august", "september", "oktober", "november", "december"};
private static final  String[] ShortMONTHS = {"jan", "feb", "mar", "apr", "maj", "jun",
  "jul", "aug", "sep", "okt", "nov", "dec"};
private static final  String[] Weekdays = {"", "mandag", "tirsdag", "onsdag",
    "torsdag", "fredag", "lørdag", "søndag"};
 private static final String[] shortWeekdays = {"", "man", "tir", "ons", "tor", "fre", "lør", "søn"};
  
  private DateConverter(){
    }
  
  public static String getDate(int typeFormat){
  symbols = new DateFormatSymbols();
  symbols.setMonths(MONTHS);
  symbols.setShortMonths(ShortMONTHS);
  symbols.setWeekdays(Weekdays);
  symbols.setShortWeekdays(shortWeekdays);
  String type = typeOfFormat(typeFormat);
  format = new SimpleDateFormat(type, symbols);
  return format.format(new Date());
  }

    private static String typeOfFormat(int typeFormat) {
            switch (typeFormat) {
         case 0: 
             return "EEE dd MMM yyyy HH:mm";
         case 1:
             return "dd-MMM HH.mm";
         case 2: 
             return "MM/dd/yyyy hh:mm:ss";
         case 3:
             return "yyyy";
         case 4:
             return "MM/dd";
         case 5:
             return "MM";
         default:
            throw new IllegalArgumentException("Incorrect typeFormat code value");
            }
      }
}
