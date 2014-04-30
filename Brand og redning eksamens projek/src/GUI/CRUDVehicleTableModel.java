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
public class CRUDVehicleTableModel extends AbstractTableModel{
    private ArrayList<?> m_allVehicle;
    private final String[] colNames = {"Registration nr.", "Mærke", "Model"};
    private final Class[] classes = {Integer.class, String.class, String.class};
    
    public CRUDVehicleTableModel(ArrayList<?> allVehicle){
        m_allVehicle = allVehicle;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
    return m_allVehicle.size();
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
    public void setCarList(ArrayList<?> VehicleList) {
       m_allVehicle = VehicleList;
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
