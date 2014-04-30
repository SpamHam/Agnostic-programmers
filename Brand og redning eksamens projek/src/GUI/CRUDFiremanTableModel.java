/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BECRUDFireman;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Claus
 */
public class CRUDFiremanTableModel extends AbstractTableModel {

    private ArrayList<BECRUDFireman> firemanList;

    private String[] colNames = {"CPR", "Fornavn", "Efternavn"};
    private Class[] classes = {Integer.class, String.class, String.class};

    public CRUDFiremanTableModel(ArrayList<BECRUDFireman> allFiremanLists) {
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

    public void setCRUDFiremanList(ArrayList<BECRUDFireman> fireList) {
        firemanList = fireList;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BECRUDFireman e = firemanList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getCPR();
            case 1:
                return e.getFornavn();
            case 2:
                return e.getEfternavn();
        }
            return null;
    }
}