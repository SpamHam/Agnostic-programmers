/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BE.BEMaterial;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Claus
 */
public class ChooseMaterialsTableModel extends AbstractTableModel {

private String[] colNames = {"Materiale", "Antal"};
private Class[] classes = {String.class, Integer.class};

private ArrayList<BEMaterial> allSelectedMaterials;

/**
 * Sets the content of the table model to the given list of materialList.
 * @param materialList 
 */
    public ChooseMaterialsTableModel(ArrayList<BEMaterial> materialList) {
      allSelectedMaterials = materialList;
        fireTableDataChanged();
    }    
    
/**
 * Returns the number of rows
 * @return allSelectedMaterials.size
 */
        @Override
    public int getRowCount() {
        return allSelectedMaterials.size();
    }

    /**
     * Returns the number of columns
     * @return colNames.length
     */
    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    /**
     * Returns the name of the columns
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
     * @return classes
     */
    @Override
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }
    
    /**
     * Sets wether the cell is edible or not
     * @param row
     * @param col
     * @return 
     */
    @Override
    public boolean isCellEditable(int row, int col) {
         switch (col) {
         case 0: return false;
         case 1: return true;
         default:
             return false;
         }
    }

    /**
     * Sets the Material table and updates it
     * @param materialList 
     */
    public void setMaterialsStatusList(ArrayList<BEMaterial> materialList) {
        allSelectedMaterials = materialList;
        fireTableDataChanged();
    }    
    
    /**
     * Return the material for the selected row
     * @param row
     * @return 
     */
     public BEMaterial getMaterialsByRow(int row) {
        return allSelectedMaterials.get(row);
    }
   
     /**
      * Retrieves the data from the selected row & column
      * @param rowIndex
      * @param columnIndex
      * @return 
      */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BEMaterial e = allSelectedMaterials.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return e.getMaterial();
                case 1:
                    return e.getAmount();
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
        BEMaterial row = allSelectedMaterials.get(rowIndex);
        switch (columnIndex){
            case 1: 
              row.setAmount((Integer) aValue);
    } 
   }

}
