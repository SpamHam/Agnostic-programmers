/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kathrine
 */
public class EmergencyStartDialogTableModel extends AbstractTableModel{
    
    
    private ArrayList<String>  startTider;
    
    private String [] colNames = {"Tider"};
    
    private Class [] classes = {String.class};
    
   
    
    public EmergencyStartDialogTableModel(ArrayList<String> pik){
        startTider = pik;
        
    }

    @Override
    public int getRowCount() {
       return startTider.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    @Override
    public String getColumnName(int col){
        return colNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return startTider.get(rowIndex);    }
    
    public void setTimePlanStatusList(ArrayList<String> timeList) {
        startTider = timeList;
        fireTableDataChanged();
        
    }

    }


