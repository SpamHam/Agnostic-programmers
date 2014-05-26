/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BETimePlan;
import BLL.BLLFireman;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kathrine
 */
public class TimePlanTableModel extends AbstractTableModel {

    private ArrayList<BETimePlan> timePlan;

    private String[] colNames = {"Stilling", "Navn", "Tidsrum", "Kørt", "Stations Vagt", "Køretøj"};

    private Class[] classes = {String.class, String.class, String.class, Integer.class, Integer.class, String.class};

    public TimePlanTableModel(ArrayList<BETimePlan> allTimePlans) {
        timePlan = allTimePlans;
        fireTableDataChanged();
    }

    /**
     * Returns the number of rows
     * @return timePlan.size()
     */
    @Override
    public int getRowCount() {
        return timePlan.size();
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
     * @return colNames
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
    public Class<BETimePlan> getColumnClass(int col) {
        return classes[col];
    }

    /**
     * Returns wether a column is editable or not.
     * @param row
     * @param col
     * @return true/false
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        switch (col) {
            case 0:
                return true;
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
            default:
                return false;
        }
    }

    /**
     * Sets the content of the table model to the given list of times.
     * @param timeList 
     */
    public void setTimePlanStatusList(ArrayList<BETimePlan> timeList) {
        timePlan = timeList;
        fireTableDataChanged();
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

    /**
     * Returns the value of a specific row in a column
     * @param rowIndex
     * @param columnIndex
     * @return e.<Time / Hours / StationHours / Vehicle / Null> 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BETimePlan e = timePlan.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getTitle();
            case 1:
                try {
                    BLLFireman g = new BLLFireman();
                    BE.BEFireman f = g.FiremanFromID(e.getFiremanID());
                    return f.getFirstName() + " " + f.getLastName();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            case 2:
                return e.getTime();
            case 3:
                return e.getHours();
            case 4:
                return e.getStationHours();
            case 5:
                return e.getVehicle();
        }

        return null;
    }

    /**
     * Sets the value of a specific row in a column
     * @param aValue
     * @param rowIndex
     * @param columnIndex 
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        BETimePlan row = timePlan.get(rowIndex);
        switch (columnIndex) {
            case 0:
                row.setTitle((String) aValue);
                break;
            case 2:
                row.setTime((String) aValue);
                break;
            case 3:
                row.setHours((Integer) aValue);
                break;
            case 4:
                row.setStationHours((Integer) aValue);
                break;
        }
    }

}
