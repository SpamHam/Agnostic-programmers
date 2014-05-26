/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BE.BEForces;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author peter bærbar
 */
public class ForcesTableModel extends AbstractTableModel {

private String[] colNames = {"Vogn Nr", "Kørsel 1/2", "Bemanding"};
private Class[] classes = {String.class, String.class, String.class};

private ArrayList<BEForces> allSelectedForces;

/**
 * Sets the table model based on forceList
 * @param forceList 
 */
    public ForcesTableModel(ArrayList<BEForces> forceList) {
      allSelectedForces = forceList;
        fireTableDataChanged();
    }    
    
/**
 * Returns the number of rows
 * @return allSelectedForces.size()
 */
        @Override
    public int getRowCount() {
        return allSelectedForces.size();
    }

    /**
     * Returns the numbers of columns
     * @return colNames.length
     */
    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    /**
     * Returns the names of the columns
     * @param col
     * @return colNames[col]
     */
    @Override
    public String getColumnName(int col) {

        return colNames[col];
    }

    /**
     * Sets which type of data is required for a column
     * @param col
     * @return classes[col] 
     */
    @Override
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }
    
    /**
     * Sets wether the cell is edible or not
     * @param row
     * @param col
     * @return true/false
     */
    @Override
    public boolean isCellEditable(int row, int col) {
         switch (col) {
         case 0: return true;
         case 1: return true;
         case 2: return true;
         default:
             return false;
         }
    }
    

    /**
     * Sets the forces table and updates it
     * @param forcesList 
     */
    public void setForcesList(ArrayList<BEForces> forcesList) {
        allSelectedForces = forcesList;
        fireTableDataChanged();
    }    
    
    /**
     * Return the forces for the selected row
     * @param row
     * @return 
     */
     public BEForces getForcesByRow(int row) {
        return allSelectedForces.get(row);
    }
   
     /**
      * Retrieves the data from the selected row & column
      * @param rowIndex
      * @param columnIndex
      * @return 
      */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BEForces e = allSelectedForces.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return e.getCarID();
                case 1:
                    return e.getTypeOfAlarm();
                case 2:
                    return e.getForces();
            }

            return null;
        }     

    /**
     * Sets the typed value in the selected row
     * @param aValue
     * @param rowIndex
     * @param columnIndex 
     */
      @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        BEForces row = allSelectedForces.get(rowIndex);
        switch (columnIndex){
            case 0: 
              row.setCarID((String) aValue);
                break;
            case 1:
               row.setTypeOfAlarm((String) aValue);
                break;
            case 2:
                row.setForces((String) aValue);
                break;
    }
        
   }

}
    

