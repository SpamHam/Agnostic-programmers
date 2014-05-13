/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Claus
 */
public class CRUDFiremanTableModel extends AbstractTableModel {

    private ArrayList<BE.BEFireman> firemanList;

    private String[] colNames = {"Fornavn", "Efternavn"};
    private Class[] classes = {String.class, String.class};

 /**
  * Replace the firemanList with the data from allFiremanLists
  * @param allFiremanLists 
  */
    public CRUDFiremanTableModel(ArrayList<BE.BEFireman> allFiremanLists) {
        firemanList = allFiremanLists;

    }

    @Override
    public int getRowCount() {
        return firemanList.size();
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
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    /**
     * Sets the Fireman table and updates it
     * @param fireList 
     */
    public void setCRUDFiremanList(ArrayList<BE.BEFireman> fireList) {
        firemanList = fireList;
        fireTableDataChanged();
    }

    /**
     * Retrieves the data from the selected row & column
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BE.BEFireman e = firemanList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getFirstName();
            case 1:
                return e.getLastName();
        }
            return null;
    }
}