package GUI;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kathrine
 */
public class CRUDMaterialTableModel extends AbstractTableModel{
    private ArrayList<BE.BEMaterial> m_allMaterial;
    private final String[] colNames = {"Material", "Antal"};
    private final Class[] classes = {String.class, Integer.class};
    
    public CRUDMaterialTableModel(ArrayList<BE.BEMaterial> allMaterial){
        m_allMaterial = allMaterial;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
    return m_allMaterial.size();
    }

    @Override
    public int getColumnCount() {
    return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
              BE.BEMaterial e = m_allMaterial.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return e.getM_Materiale();
                case 1:
                    return e.getM_Antal();
                

            }

            return null; }
    
       
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
    public void setMaterialList(ArrayList<BE.BEMaterial> MaterialList) {
       m_allMaterial = MaterialList;
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
