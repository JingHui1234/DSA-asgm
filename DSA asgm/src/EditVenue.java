/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import adt.ArrayList;
import adt.ListInterface;
import entity.Venue;
import javax.swing.JOptionPane;

/**
 *
 * @author Ang Chia Ling
 */
public class EditVenue extends javax.swing.JFrame {

    // variable declaration
    private static ListInterface<Venue> venueList = new ArrayList<>();
    VenueFile venuefile = new VenueFile();

    /**
     * Creates new form EditVenue
     */
    public EditVenue() {
        initComponents();
        jTextFieldVenueName.setEditable(false);
        jTextFieldCapacity.setEditable(false);
    }

    // pass in the venueName as parameter to modify
    public EditVenue(String venueName) {
        initComponents();
        jTextFieldVenueName.setEditable(false);
        jTextFieldVenueName.setText(venueName);
        jTextFieldCapacity.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jLabelEditVenue = new javax.swing.JLabel();
        jLabelVenueName = new javax.swing.JLabel();
        jTextFieldVenueName = new javax.swing.JTextField();
        jLabelVenueType = new javax.swing.JLabel();
        jComboBoxVenueType = new javax.swing.JComboBox<>();
        jLabelEmptyVenue = new javax.swing.JLabel();
        jLabelCapacity = new javax.swing.JLabel();
        jTextFieldCapacity = new javax.swing.JTextField();
        jLabelOther = new javax.swing.JLabel();
        jTextFieldOther = new javax.swing.JTextField();
        jButtonAddNewType = new javax.swing.JButton();
        jLabelEmptyType = new javax.swing.JLabel();
        jLabelEmptyCapacity = new javax.swing.JLabel();
        jButtonEditVenue = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelEmptyOther = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelEditVenue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEditVenue.setText("Edit Venue Details");

        jLabelVenueName.setText("Venue Name:");

        jTextFieldVenueName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldVenueNameMouseClicked(evt);
            }
        });

        jLabelVenueType.setText("Type:");

        jComboBoxVenueType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLEASE CHOOSE ONE OF THE OPTIONS", "SMALL-SIZED CLASSROOM", "BIG-SIZED CLASSROOM", "SMALL-SIZED LECTURE HALL", "MEDIUM-SIZED LECTURE HALL", "BIG-SIZED LECTURE HALL" }));
        jComboBoxVenueType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxVenueTypeItemStateChanged(evt);
            }
        });

        jLabelEmptyVenue.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEmptyVenue.setText(" ");

        jLabelCapacity.setText("Capacity:");

        jTextFieldCapacity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCapacityKeyReleased(evt);
            }
        });

        jLabelOther.setText("Other: ");

        jButtonAddNewType.setText("Add");
        jButtonAddNewType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewTypeActionPerformed(evt);
            }
        });

        jLabelEmptyType.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEmptyType.setText(" ");

        jLabelEmptyCapacity.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEmptyCapacity.setText(" ");

        jButtonEditVenue.setText("Confirm");
        jButtonEditVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditVenueActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelEmptyOther.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEmptyOther.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelVenueType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVenueName, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmptyType, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelEmptyVenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxVenueType, 0, 219, Short.MAX_VALUE)
                                .addComponent(jTextFieldVenueName))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditVenue)
                            .addComponent(jLabelEmptyCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCapacity))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelOther)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldOther, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAddNewType)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabelEmptyOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelEditVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEditVenue)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVenueName)
                    .addComponent(jTextFieldVenueName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabelEmptyVenue)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVenueType)
                    .addComponent(jComboBoxVenueType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOther)
                    .addComponent(jTextFieldOther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddNewType))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmptyType)
                    .addComponent(jLabelEmptyOther))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCapacity)
                    .addComponent(jTextFieldCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmptyCapacity)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditVenue)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddNewTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewTypeActionPerformed
        // TODO add your handling code here:
        if (jTextFieldOther.getText().trim().isEmpty()) {
            jLabelEmptyOther.setText("Please enter valid venue type!");
        } else {
            String newType = jTextFieldOther.getText().toUpperCase();
            jComboBoxVenueType.addItem(newType);
        }
    }//GEN-LAST:event_jButtonAddNewTypeActionPerformed

    private void jButtonEditVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditVenueActionPerformed
        // TODO add your handling code here:
        // read file and store into arraylist(venueList)
        venueList = venuefile.reader("VenueFile.txt");
        boolean successful = false;

        // validation for empty field
        if (jComboBoxVenueType.getSelectedIndex() == 0 && jTextFieldCapacity.getText().trim().equals("")) {
            jLabelEmptyType.setText("Venue type cannot be empty!");
            jLabelEmptyCapacity.setText("Venue capacity cannot be empty!");
        } else if (jComboBoxVenueType.getSelectedIndex() == 0) {
            jLabelEmptyType.setText("Venue type cannot be empty!");
        } else if (jTextFieldCapacity.getText().trim().equals("")) {
            jLabelEmptyCapacity.setText("Venue capacity cannot be empty!");
        } else {
            // proceed if no empty field
            try {
                String name = jTextFieldVenueName.getText();
                String type = (String) jComboBoxVenueType.getEditor().getItem();
                int capacity = Integer.parseInt(jTextFieldCapacity.getText());
                name = name.toUpperCase();
                type = type.toUpperCase();
                Venue editedVenue = new Venue(name, type, capacity);

                // check whether the entry is matched with any element in the array list, if successful, then just edit the element
                for (int i = 1; i <= venueList.length(); i++) {
                    if (name.equals(venueList.getEntry(i).getVenueName())) {
                        successful = venueList.replace(i, editedVenue);
                        break;
                    }
                }

                // if can  be found and edited successfully, prompt message; otherwise prompt another message
                if (successful) {
                    venuefile.rewrite((ArrayList<Venue>) venueList, "VenueFile.txt");
                    JOptionPane.showMessageDialog(null, "Venue edited successfully!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to edit existing venue!");
                }
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
    }//GEN-LAST:event_jButtonEditVenueActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        new VenueManagement().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jTextFieldVenueNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldVenueNameMouseClicked
        // TODO add your handling code here:
        jLabelEmptyVenue.setText("Venue name cannot be modified!");
    }//GEN-LAST:event_jTextFieldVenueNameMouseClicked

    private void jComboBoxVenueTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxVenueTypeItemStateChanged
        // TODO add your handling code here:
        // set the capacity based on the type of venue
        jLabelEmptyType.setText("");
        if (jComboBoxVenueType.getSelectedIndex() == 0) {
            jLabelEmptyType.setText("Please choose a valid type!");
        }
        switch (jComboBoxVenueType.getSelectedIndex()) {
            case 0:
                jLabelEmptyType.setText("Please choose a valid type!");
                break;
            case 1:
                jTextFieldCapacity.setText("30");
                break;
            case 2:
                jTextFieldCapacity.setText("50");
                break;
            case 3:
                jTextFieldCapacity.setText("100");
                break;
            case 4:
                jTextFieldCapacity.setText("300");
                break;
            case 5:
                jTextFieldCapacity.setText("500");
                break;
            default:
                jTextFieldCapacity.setEditable(true);
                jTextFieldCapacity.setText("");
                break;
        }
    }//GEN-LAST:event_jComboBoxVenueTypeItemStateChanged

    private void jTextFieldCapacityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCapacityKeyReleased
        // TODO add your handling code here:
        jLabelEmptyCapacity.setText("");
    }//GEN-LAST:event_jTextFieldCapacityKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditVenue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNewType;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonEditVenue;
    private javax.swing.JComboBox<String> jComboBoxVenueType;
    private javax.swing.JLabel jLabelCapacity;
    private javax.swing.JLabel jLabelEditVenue;
    private javax.swing.JLabel jLabelEmptyCapacity;
    private javax.swing.JLabel jLabelEmptyOther;
    private javax.swing.JLabel jLabelEmptyType;
    private javax.swing.JLabel jLabelEmptyVenue;
    private javax.swing.JLabel jLabelOther;
    private javax.swing.JLabel jLabelVenueName;
    private javax.swing.JLabel jLabelVenueType;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextFieldCapacity;
    private javax.swing.JTextField jTextFieldOther;
    private javax.swing.JTextField jTextFieldVenueName;
    // End of variables declaration//GEN-END:variables

}