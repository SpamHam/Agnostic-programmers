/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BE.BETimePlan;
import java.util.ArrayList;

/**
 *
 * @author peter bærbar
 */
public class FormatEventPDF {
 ArrayList<BETimePlan> allTime;
    ArrayList<String> colNames;
    
    public FormatEventPDF(ArrayList<BETimePlan> allTime, ArrayList<String> colNames ){
    this.allTime = allTime;
    this.colNames = colNames;
    }
    
    public ArrayList<BETimePlan> getTime(){
    return allTime;
    }
    public ArrayList<String> getColNames(){
    return colNames;
    }   
}
