/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.table.AbstractTableModel;
import BE.BESalary;
import java.util.ArrayList;


/**
 *
 * @author Kathrine
 */
public class PayrollTableModel extends AbstractTableModel {
    
    ArrayList<BESalary> allSalary;
    String [] colNames = {"ODIN", "CPR", "Role", "Salary Code", "Hours", "Date", "Type of work", "isHoliday"};  
    Class [] classes = {Integer.class, String.class, Integer.class, Integer.class, String.class, String.class, Boolean.class};
     
    public PayrollTableModel(ArrayList<BESalary> salary){
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
        BESalary e = allSalary.get(rowIndex);
        switch(columnIndex){
            case 0:
                return e.getODIN(); 
            case 1: 
                return e.getCPR();
            case 2:
                return e.getRole();
            case 3:
                return e.getSalaryCode();
            case 4: 
                return e.getHours();
            case 5:
                return e.getDate();
            case 6:    
                return e.getTypeOfWork();
            case 7: 
                
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
         case 0: return false;
         case 1: return false;
         case 2: return true;
         case 3: return true;
         case 4: return true;
         case 5: return false;
         default:
             return false;
         }
    }

    /**
     * Sets the content of the table model to the given list of cars.
     *
     * @param carList the list of employees to show in the JTable.
     */
    public void setTimePlanStatusList(ArrayList<BESalary> salaryList) {
        allSalary = salaryList;
    }

    /**
     * Return the employee instance from the table model with the given row
     * index.
     *
     * @param row the index for the employee in the employees list.
     * @return the employee at the given row index.
     */
    public BESalary getTimePlanByRow(int row) {
        return allSalary.get(row);
    }
    
}
