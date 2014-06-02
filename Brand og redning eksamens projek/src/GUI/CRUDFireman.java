/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BEFireman;
import BLL.BLLFireman;
import Utility.Error.EventExercutionException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sun.awt.image.ImageAccessException;

/**
 *
 * @author Son Of Satan
 */
public class CRUDFireman extends javax.swing.JFrame {

    private CRUDFiremanListener firemanListener; // holds a reference to a class that implements PDFListener
    CRUDFiremanTableModel FiremanTableModel;
    TableRowSorter<TableModel> sorter;
    ArrayList<BE.BEFireman> allFiremans = new ArrayList<>();
    private BLLFireman m_fireman = new BLLFireman();
    //
    private int selectedRow;
    private final int hgt = 160;
    private final int wdt = 148;
    private String path = null;
    private String batPath = "C:\\Billeder";
    
    
   

    /**
     * Populates the allFiremans ArrayList
     */
    private void initFiremans() {
        try {
            allFiremans = m_fireman.getAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Sets the allFiremans ArrayList to the content of Firemans ArrayList
     *
     * @param Firemans
     */
    public void setFiremanList(ArrayList<BEFireman> Firemans) {
        allFiremans = Firemans;
    }

    /**
     * Creates new form CRUDFireman
     */
    public CRUDFireman() {
        initComponents();
        initFiremans();
       
        setFiremanListener(m_fireman);
        FiremanTableModel = new CRUDFiremanTableModel(allFiremans);
        tblFiremen.setModel(FiremanTableModel);// Sets the table model for the JTable
        //sorter = new TableRowSorter<TableModel>(FiremanTableModel);
        //tblFiremen.setRowSorter(sorter);
        tblFiremen.getTableHeader().setReorderingAllowed(false);
        setTitle("Brandmand oversigt");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /**
         * All ActionListeners are listed here
         */
        ActionListener BTNAdd = new AddListener();
        btnAdd.addActionListener(BTNAdd);
        ActionListener BTNUpdate = new UpdateListener();
        btnUpdate.addActionListener(BTNUpdate);
        ActionListener BTNRemove = new RemoveListener();
        btnRemove.addActionListener(BTNRemove);
        ActionListener BTNBack = new BackListener();
        btnBack.addActionListener(BTNBack);
        ActionListener BTNChangeProfileImage = new ChangeProfileImage();
        btnChangeProfileImage.addActionListener(BTNChangeProfileImage);
        btnUpdate.setEnabled(false);
        UpdateFieldsPanel.setVisible(false);
        tblFiremen.addMouseListener(new java.awt.event.MouseAdapter() {

            /**
             * When clicking a row it enables the Update button and Sets the
             * visibility of textfields required for the update function
             *
             * @param evt
             */
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onRowSelected(evt
                );
                btnUpdate.setEnabled(true);
                UpdateFieldsPanel.setVisible(true);
            }

            /**
             * Populates the data in textfields required for the update function
             * when clicking a row in a table
             *
             * @param evt
             */
            private void onRowSelected(MouseEvent evt) {
                selectedRow = tblFiremen.getSelectedRow();
                txtFirstName.setText(allFiremans.get(selectedRow).getFirstName());
                txtLastName.setText(allFiremans.get(selectedRow).getLastName());
                txtAddress.setText(allFiremans.get(selectedRow).getAddress());
                txtTelephoneNr.setText(allFiremans.get(selectedRow).getPhoneNr());
                txtCallNr.setText(allFiremans.get(selectedRow).getCallNr());
                txtPaymentNr.setText(allFiremans.get(selectedRow).getPaymentNr());
                txtHiredDate.setText(allFiremans.get(selectedRow).getHiredDate());
                ChBoxIsLeaderTrained.setSelected(allFiremans.get(selectedRow).isLeaderTrained());
                System.out.println(allFiremans.get(selectedRow).getProfileImage());
                if (allFiremans.get(selectedRow).getProfileImage() != null && !allFiremans.get(selectedRow).getProfileImage().isEmpty() ){
                    try {
                        lblImage.setIcon(new ImageIcon(m_fireman.resizeChangedImage(allFiremans.get(selectedRow).getProfileImage(), wdt, hgt)));
                    } catch (IOException ex) {
                        Logger.getLogger(CRUDFireman.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   return;
               }
                try {
                    lblImage.setIcon(new ImageIcon(m_fireman.resizeChangedImage("C:\\Billeder\\brandmand.jpg", wdt, hgt)));//resize("C:\\Billeder\\brandmand.jpg", wdt, hgt)));
                } catch (IOException ex) {
                    Logger.getLogger(CRUDFireman.class.getName()).log(Level.SEVERE, null, ex);
                }
                            }
            
            
            
        });
    }
    
    private void initPath(){
        path = m_fireman.path();
        System.out.println(path + "123");
    }
    
    public void browseForProfilePicture(){
        JFileChooser fc = new JFileChooser(batPath);
        fc.setFileFilter(new JPGFilter()); 
        int res = fc.showOpenDialog(null);
        BufferedImage originalImage = null;
        
        
        // We have an image!
        try {
            if (res == JFileChooser.APPROVE_OPTION) {
                
                path = fc.getSelectedFile().getPath();
                originalImage = ImageIO.read(new File(path));
                //resizedImage = m_fireman.resize(originalImage, wdt, hgt);
                //lblImage.setIcon(new ImageIcon(resizedImage));
                System.out.println(path + "123");
                
              
            } // Oops!
            else {
                JOptionPane.showMessageDialog(null,
                        "You must select one image to be the reference.", "Aborting...",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception iOException) {
        } 
     
    }
    
    private void browseImage(){
        try {
            m_fireman.browseForProfilePicture();
        } catch (Exception ex) {
            Logger.getLogger(CRUDFireman.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void setProfileImage(){
        try {
            lblImage.setIcon(new ImageIcon(m_fireman.changeImage()));
        } catch (IOException ex) {
            Logger.getLogger(CRUDFireman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    
 

    /**
     * Anonymous inner class listening on the Add Button
     */
    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddFiremanDialog firemanDialog = new AddFiremanDialog(null, true);
            firemanDialog.setVisible(true);
            firemanDialog.setLocationRelativeTo(null);

            BEFireman fireman = firemanDialog.getNewFireman();
            if (fireman != null) // a fireman has been created in the dialog box.
            {
                try {
                    fireCreateFiremanEvent(fireman);
                    allFiremans.add(fireman);
                    initFiremans();
                    FiremanTableModel.setCRUDFiremanList(allFiremans);
                    tblFiremen.repaint();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }

    /**
     * anonymous inner class listening on the Update button
     */
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BEFireman updateFireman = new BEFireman(allFiremans.get(selectedRow).getID(), txtFirstName.getText(), txtLastName.getText(),
                    txtAddress.getText(), txtTelephoneNr.getText(), txtCallNr.getText(), txtPaymentNr.getText(),
                    ChBoxIsLeaderTrained.isSelected(), allFiremans.get(selectedRow).getHiredDate());
            fireUpdateFiremanEvent(updateFireman);
            allFiremans.set(selectedRow, updateFireman);
            FiremanTableModel.setCRUDFiremanList(allFiremans);
        }

    }

    /**
     * anonymous inner class listening on the Remove button
     */
    private class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BEFireman i = allFiremans.get(selectedRow);
            fireRemoveFiremanEvent(i);
            allFiremans.remove(selectedRow);
            FiremanTableModel.setCRUDFiremanList(allFiremans);
        }

    }

    /**
     * Anonymous inner class listening on the Back Button
     */
    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            openAdministrationMenu();

        }

    }

    /**
     * sets the PDf listener to a class that implements the PDFListener
     * interface
     *
     * @param firemanListener
     */
    public void setFiremanListener(CRUDFiremanListener firemanListener) {
        this.firemanListener = firemanListener;
    }

    /**
     * Opens the Administration Menu
     */
    private void openAdministrationMenu() {
        AdminstrationMenu admin = new AdminstrationMenu();
        admin.setVisible(true);
    }

    /**
     * Fires an event the listener when a fireman is created
     *
     * @param event
     */
    public void fireCreateFiremanEvent(BEFireman event) {
        if (firemanListener != null) {
            try {
                firemanListener.FiremanCreatePerformed(event);
            } catch (EventExercutionException eex) {
                JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Fires an event to the listener when a fireman is removed
     *
     * @param event
     */
    public void fireRemoveFiremanEvent(BEFireman event) {

        if (firemanListener != null) {
            try {
                firemanListener.FiremanRemovePerformed(event);
            } catch (EventExercutionException eex) {
                JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Fires an event to the listener when a fireman is updated
     *
     * @param event
     */
    public void fireUpdateFiremanEvent(BEFireman event) {

        if (firemanListener != null) {

            try {
                firemanListener.FiremanUpdatePerformed(event);
            } catch (EventExercutionException eex) {
                JOptionPane.showMessageDialog(null, eex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
        private class ChangeProfileImage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            browseImage();
            initPath();
            
            BEFireman updateFireman = new BEFireman(allFiremans.get(selectedRow).getID(), txtFirstName.getText(), txtLastName.getText(),
                    txtAddress.getText(), txtTelephoneNr.getText(), txtCallNr.getText(), txtPaymentNr.getText(),
                    ChBoxIsLeaderTrained.isSelected(), allFiremans.get(selectedRow).getHiredDate(), path);
            fireUpdateFiremanEvent(updateFireman);
            allFiremans.set(selectedRow, updateFireman);
            FiremanTableModel.setCRUDFiremanList(allFiremans);
            
        }
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPnlTblFiremen = new javax.swing.JScrollPane();
        tblFiremen = new javax.swing.JTable();
        UpdateFieldsPanel = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtCallNr = new javax.swing.JTextField();
        lblCallNr = new javax.swing.JLabel();
        txtTelephoneNr = new javax.swing.JTextField();
        lblTelephoneNr = new javax.swing.JLabel();
        txtPaymentNr = new javax.swing.JTextField();
        lblPaymentNr = new javax.swing.JLabel();
        txtHiredDate = new javax.swing.JTextField();
        lblHiredDate = new javax.swing.JLabel();
        ChBoxIsLeaderTrained = new javax.swing.JCheckBox();
        jpanelButtons = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnChangeProfileImage = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblFiremen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CPR", "Fornavn", "Efternavn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPnlTblFiremen.setViewportView(tblFiremen);

        UpdateFieldsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Opdater Information"));

        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstName.setText("Fornavn:");

        lblLastName.setText("Efternavn:");

        lblAddress.setText("Addresse:");

        lblCallNr.setText("Tilkalds Nr:");

        lblTelephoneNr.setText("Tlf. Nr:");

        lblPaymentNr.setText("Løn Nr:");

        lblHiredDate.setText("Ansat:");

        ChBoxIsLeaderTrained.setText("Leader Uddannet");

        javax.swing.GroupLayout UpdateFieldsPanelLayout = new javax.swing.GroupLayout(UpdateFieldsPanel);
        UpdateFieldsPanel.setLayout(UpdateFieldsPanelLayout);
        UpdateFieldsPanelLayout.setHorizontalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHiredDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelephoneNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelephoneNr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(lblCallNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCallNr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateFieldsPanelLayout.createSequentialGroup()
                        .addComponent(lblPaymentNr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChBoxIsLeaderTrained)
                            .addComponent(txtPaymentNr, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        UpdateFieldsPanelLayout.setVerticalGroup(
            UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFieldsPanelLayout.createSequentialGroup()
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHiredDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelephoneNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelephoneNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCallNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCallNr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaymentNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentNr))
                .addGap(7, 7, 7)
                .addComponent(ChBoxIsLeaderTrained))
        );

        jpanelButtons.setBorder(javax.swing.BorderFactory.createTitledBorder("Funktioner"));

        btnRemove.setText("Fjern");
        btnRemove.setPreferredSize(new java.awt.Dimension(55, 23));

        btnAdd.setText("Tilføj");

        btnUpdate.setText("Opdater");
        btnUpdate.setMaximumSize(new java.awt.Dimension(55, 23));
        btnUpdate.setMinimumSize(new java.awt.Dimension(55, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(55, 23));

        btnChangeProfileImage.setText("Skift profilbilled");

        javax.swing.GroupLayout jpanelButtonsLayout = new javax.swing.GroupLayout(jpanelButtons);
        jpanelButtons.setLayout(jpanelButtonsLayout);
        jpanelButtonsLayout.setHorizontalGroup(
            jpanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnChangeProfileImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanelButtonsLayout.setVerticalGroup(
            jpanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelButtonsLayout.createSequentialGroup()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChangeProfileImage))
        );

        btnBack.setText("Tilbage");
        btnBack.setPreferredSize(new java.awt.Dimension(100, 23));

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(scrollPnlTblFiremen, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(94, 94, 94))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(UpdateFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPnlTblFiremen)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChBoxIsLeaderTrained;
    private javax.swing.JPanel UpdateFieldsPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChangeProfileImage;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jpanelButtons;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCallNr;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblHiredDate;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPaymentNr;
    private javax.swing.JLabel lblTelephoneNr;
    private javax.swing.JScrollPane scrollPnlTblFiremen;
    private javax.swing.JTable tblFiremen;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCallNr;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHiredDate;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPaymentNr;
    private javax.swing.JTextField txtTelephoneNr;
    // End of variables declaration//GEN-END:variables

}
