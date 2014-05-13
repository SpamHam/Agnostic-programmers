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
    String[] colNames = {"Navn", "Løn nr.", "Brand Brandmand", "Brand Holdleder", "Standby Station Brandmand", "Standby Station Holdleder", "Arb på station/andet", "Øvelser Brandmnad", "Øvelser Holdleder", "Vagt Brandmand Helligdage", "Vagt Brandmand Hverdage", "Vagt Holdleder Helligdage", "Vagt Holdleder Hverdage"};
    Class[] classes = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};

    public PayrollTableModel(ArrayList<BE.BETableSalary> salary) {
        allSalary = salary;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return allSalary.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

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
        switch (col) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return false;
            default:
                return false;
        }
    }

    /**
     * Sets the content of the table model to the given list of cars.
     *
     * @param carList the list of employees to show in the JTable.
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

}
