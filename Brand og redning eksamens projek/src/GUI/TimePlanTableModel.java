/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BETimePlan;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Kathrine
 */
public class TimePlanTableModel extends AbstractTableModel {

   private ArrayList<BETimePlan> timePlan;

    private String[] colNames = {"Stilling", "Navn", "Tidsrum", "Kørt", "Stations Vagt", "Køretøj"};

    private Class[] classes = {String.class, String.class, Integer.class, Integer.class, Integer.class, String.class};

    public TimePlanTableModel(ArrayList<BETimePlan> allTimePlans) {
        timePlan = allTimePlans;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return timePlan.size();
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
         case 1: return false;
         case 2: return true;
         case 3: return true;
         case 4: return true;
         case 5: return false;
         default:
             return false;
         }
    }

    /**
     * Sets the content of the table model to the given list of cars.
     *
     * @param carList the list of employees to show in the JTable.
     */
    public void setTimePlanStatusList(ArrayList<BETimePlan> timeList) {
        timePlan = timeList;
    }

    /**
     * Return the employee instance from the table model with the given row
     * index.
     *
     * @param row the index for the employee in the employees list.
     * @return the employee at the given row index.
     */
    public BETimePlan getTimePlanByRow(int row) {
        return timePlan.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BETimePlan e = timePlan.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return e.getStilling();
                case 1:
                    return e.getNavn();
                case 2:
                    return e.getTidsrum();
                case 3:
                    return e.getKoert();
                case 4:
                    return e.getStationsVagt();
                case 5:
                    return e.getKoeretoej();
            }

            return null;
        }
    
      @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        BETimePlan row = timePlan.get(rowIndex);
        switch (columnIndex){
            case 2: 
              row.setTidsrum((Integer) aValue);
            case 3: 
             row.setKoert((Integer) aValue);
            case 4:
               row.setStationsVagt((Integer) aValue);
    } 
   }

}
