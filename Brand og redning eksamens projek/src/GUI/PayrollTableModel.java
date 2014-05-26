/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Kathrine
 */
public class PayrollTableModel extends AbstractTableModel {

    ArrayList<BE.BETableSalary> allSalary;
    String[] colNames = {"<html>Brandmand<br>Navn<br>&nbsp", "<html>Løn nr.<br>&nbsp<br>&nbsp", "<html>Brand<br>Brandmand<br>&nbsp", "<html>Brand<br>Holdleder<br>&nbsp", "<html>Standby<br>Station<br>Brandmand", "<html>Standby<br>Station<br>Holdleder", "<html>Arb på<br>station/andet<br>&nbsp", "<html>Øvelser<br>Brandmnad<br>&nbsp", "<html>Øvelser<br>Holdleder<br>&nbsp", "<html>Vagt<br>Brandmand<br>Helligdage", "<html>Vagt<br>Brandmand<br>Hverdage", "<html>Vagt<br>Holdleder<br>Helligdage", "<html>Vagt<br>Holdleder<br>Hverdage"};
    Class[] classes = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};

    public PayrollTableModel(ArrayList<BE.BETableSalary> salary) {
        allSalary = salary;
        fireTableDataChanged();
    }

    /**
     * Returns the number of rows
     * @return allSalary
     */
    @Override
    public int getRowCount() {
        return allSalary.size();
    }

    /**
     * Returns the numbers of columns
     * @return colNames
     */
    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    /**
     * Returns the value of a specific row in a column
     * @param rowIndex
     * @param columnIndex
     * @return e.getIndex
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BE.BETableSalary e = allSalary.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getNavn();
            case 1:
                return e.getSalaryNumber();
            case 2:
                return e.getIndex()[0];
            case 3:
                return e.getIndex()[1];
            case 4:
                return e.getIndex()[2];
            case 5:
                return e.getIndex()[3];
            case 6:
                return e.getIndex()[4];
            case 7:
                return e.getIndex()[6];
            case 8:
                return e.getIndex()[7];
            case 9:
                return e.getIndex()[8];
            case 10:
                return e.getIndex()[9];
            case 11:
                return e.getIndex()[10];
            case 12:
                return e.getIndex()[11];
        }
        return false;
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
     * @return true/false
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        switch (col) {
            case 0:
                return false;
            case 1:
                return false;
            default:
                return true;
        }
    }

    /**
     * Sets the content of the table model to the given list of salary.
     *
     * @param salaryList
     */
    public void setTimePlanStatusList(ArrayList<BE.BETableSalary> salaryList) {
        allSalary = salaryList;
    }

    /**
     * Return the employee instance from the table model with the given row
     * index.
     *
     * @param row the index for the employee in the employees list.
     * @return the employee at the given row index.
     */
    public BE.BETableSalary getTimePlanByRow(int row) {
        return allSalary.get(row);
    }

    /**
     * Sets the value of a specific row in a column
     * @param aValue
     * @param rowIndex
     * @param columnIndex 
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        BE.BETableSalary row = allSalary.get(rowIndex);
        double[] idx = row.getIndex();
        switch (columnIndex) {
            case 2:
                idx[0] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 3:
                idx[1] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 4:
                idx[2] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 5:
                idx[3] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 6:
                idx[4] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 7:
                idx[5] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 8:
                idx[6] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 9:
                idx[7] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 10:
                idx[8] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 11:
                idx[9] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 12:
                idx[10] = ((double) aValue);
                row.setIndex(idx);
                break;
            case 13:
                idx[11] = ((double) aValue);
                row.setIndex(idx);
                break;

        }
    }
}
