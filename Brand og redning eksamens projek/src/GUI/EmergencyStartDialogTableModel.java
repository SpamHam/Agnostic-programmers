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
    
    
    private ArrayList<Object>  startTider;
    
    private String [] colNames = {"Tider"};
    
    private Class [] classes = {String.class};
    
   
    
    public EmergencyStartDialogTableModel(ArrayList<Object> pik){
        
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        return startTider.get(rowIndex);
    }
}