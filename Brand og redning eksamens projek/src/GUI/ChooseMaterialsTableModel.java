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

    public ChooseMaterialsTableModel(ArrayList<BEMaterial> selectedMaterials) {
        allSelectedMaterials = selectedMaterials;
        fireTableDataChanged();
    }

        @Override
    public int getRowCount() {
        return allSelectedMaterials.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int col) {

        return colNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
         switch (col) {
         case 0: return false;
         case 1: return true;
         default:
             return false;
         }
    }

    public void setMaterialsStatusList(ArrayList<BEMaterial> materialList) {
        allSelectedMaterials = materialList;
    }    
    
     public BEMaterial getTimePlanByRow(int row) {
        return allSelectedMaterials.get(row);
    }
   
     
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BEMaterial e = allSelectedMaterials.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return e.getM_Materiale();
                case 1:
                    return e.getM_Antal();
            }

            return null;
        }     

      @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        BEMaterial row = allSelectedMaterials.get(rowIndex);
        switch (columnIndex){
            case 1: 
              row.setM_Antal((Integer) aValue);
    } 
   }

}
