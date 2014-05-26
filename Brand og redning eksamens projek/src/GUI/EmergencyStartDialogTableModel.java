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
public class EmergencyStartDialogTableModel extends AbstractTableModel {

    private ArrayList<String> startTimes;

    private String[] colNames = {"Tider"};

    private Class[] classes = {String.class};

    /**
     * Sets the content of the table model to the given list of startingTimes.
     *
     * @param startingTimes
     */
    public EmergencyStartDialogTableModel(ArrayList<String> startingTimes) {
        startTimes = startingTimes;

    }

    /**
     * Returns the number of rows
     *
     * @return startTimes.size()
     */
    @Override
    public int getRowCount() {
        return startTimes.size();
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
     * Returns the names of the columns
     * @param col
     * @return colNames[col]
     */
    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    /**
     * Returns the value of a specific row in a column
     * @param rowIndex
     * @param columnIndex
     * @return startTimes.get(rowIndex)
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return startTimes.get(rowIndex);
    }

    /**
     * When table content is changed, this function sets startTimes to the updated ArrayList and 
     * fires a fireTableDataChanged()
     * @param timeList 
     */
    public void setTimePlanStatusList(ArrayList<String> timeList) {
        startTimes = timeList;
        fireTableDataChanged();

    }

}
