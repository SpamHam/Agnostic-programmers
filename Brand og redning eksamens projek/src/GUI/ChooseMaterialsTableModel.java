/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Claus
 */
public class ChooseMaterialsTableModel extends AbstractTableModel {

private String[] colNames = {"Materiale", "Antal"};
private Class[] classes = {String.class, Integer.class};

    @Override
    public boolean isCellEditable(int row, int col) {
         switch (col) {
         case 0: return false;
         case 1: return true;
         default:
             return false;
         }
    }
    
}
