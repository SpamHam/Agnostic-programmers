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
public class ODINReportTableModel extends AbstractTableModel{
    
    private ArrayList<?> ODINreport;
    private final String[] colNames = {"Materiale", "Antal"};
    private final Class[] classes = {String.class, Integer.class};
    
    public ODINReportTableModel(ArrayList<?> allODINReports){
        ODINreport = allODINReports;
        fireTableDataChanged();
    }

    /**
     * Returns the number of rows
     * @return ODINreport.size()
     */
    @Override
    public int getRowCount() {
        return ODINreport.size();
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
     * Returns the value of a specific row in a column
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }

    /**
     * Returns wether a column is editable or not.
     * @param row
     * @param col
     * @return false
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
        /**
     * Sets the content of the table model to the given list of ODINReport.
     *
     * @param ODINList
     */
    public void setODINList(ArrayList<?> ODINList) {
       ODINreport = ODINList;
    }
}