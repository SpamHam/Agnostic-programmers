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
    private final String[] colNames = {"Material"};
    private final Class[] classes = {String.class};
    
    /**
     * Sets the Material table and updates it
     * @param allMaterial 
     */
    public CRUDMaterialTableModel(ArrayList<BE.BEMaterial> allMaterial){
        m_allMaterial = allMaterial;
        fireTableDataChanged();
    }

    /**
     * Returns the number of rows
     * @return m_allMaterial.size
     */
    @Override
    public int getRowCount() {
    return m_allMaterial.size();
    }

    /**
     * Returns the number of Columns
     * @return colNames.length
     */
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
              BE.BEMaterial e = m_allMaterial.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return e.getMaterial();           
            }

            return null; }
    
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
     * Sets wether a cell is editable or not
     * @param col
     * @return classes
     */
    @Override
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }

    /**
     * Sets wether a cell is editable or not
     * @param row
     * @param col
     * @return false
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
        /**
     * Sets the content of the table model to the given list of Material.
     * @param MaterialList
     */
    public void setMaterialList(ArrayList<BE.BEMaterial> MaterialList) {
       m_allMaterial = MaterialList;
    }
    
}
