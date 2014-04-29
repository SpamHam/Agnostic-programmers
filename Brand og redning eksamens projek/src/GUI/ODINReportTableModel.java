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

    @Override
    public int getRowCount() {
        return ODINreport.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return false;
    }
        /**
     * Sets the content of the table model to the given list of ODINReport.
     *
     * @param ODINList
     */
    public void setCarList(ArrayList<?> ODINList) {
       ODINreport = ODINList;
    }

    /**
     * Return the employee instance from the table model with the given row
     * index.
     *
     * @param row the index for the employee in the employees list.
     * @return the employee at the given row index.
     */
    //public ? getSongByRow(int row) {
     //   return rentalAgreements.get(row);
    }
