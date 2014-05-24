/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEVehicle;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kathrine
 */
public class CRUDVehicleTableModel extends AbstractTableModel{
    private ArrayList<BE.BEVehicle> m_allVehicle;
    private final String[] colNames = {"Registration nr.", "Mærke", "Model"};
    private final Class[] classes = {String.class, String.class, String.class};
    
    public CRUDVehicleTableModel(ArrayList<BE.BEVehicle> allVehicle){
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

    /**
     * Retrieves the data from the selected row & column
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           BEVehicle e = m_allVehicle.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return e.getM_registrationNr();
                case 1:
                    return e.getM_brand();
                case 2:
                    return e.getM_model();

            }

            return null;
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
     * Sets the content of the table model to the given list of VehicleList.
     *
     * @param VehicleList
     */
    public void setVehicleList(ArrayList<BE.BEVehicle> VehicleList) {
       m_allVehicle = VehicleList;
       fireTableDataChanged();
    }

    
}
