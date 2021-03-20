package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import adt.SortedLinkedList;
import entity.Society;
import entity.MemberRegistration;
import entity.Student;
import java.awt.Font;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import adt.InfiniteSortedListInterface;
import adt.SortedArrayList;
import adt.SortedListInterface;

/**
 *
 * @author Quah Tze Wei
 */
public class MemberManagement extends javax.swing.JFrame {

    private static InfiniteSortedListInterface<MemberRegistration> memberRegistrationList = new SortedLinkedList<MemberRegistration>();
    private static InfiniteSortedListInterface<MemberRegistration> societyMemberList = new SortedLinkedList<MemberRegistration>();
    MemberRegFile memberRegistrationFile = new MemberRegFile();
    private String storeJoinedDate = "";
    private String storeStudentID = "";
    private Society societyInfo = new Society();
    private final SocietyFile societyFile = new SocietyFile();
    
    private SortedListInterface<Society> societyList = new SortedArrayList<>();
    
    /**
     * Creates new form MemberManagement
     */
    public MemberManagement() {
        initComponents();
    }

    public MemberManagement(Society society) {
        initComponents();
        societyList = societyFile.reader("SocietyList.txt");
         
        societyInfo = society;
        txtSocietyName.setText(societyInfo.getSocietyName());
        txtSocietyName.setEditable(false);

        // read file, store into memberRegistrationList
        memberRegistrationList = memberRegistrationFile.reader("memberRegistration.txt");

        //System.out.println("Display List: " + memberRegistrationList);
        // update table
        DefaultTableModel memberTable = (DefaultTableModel) jTableMemberList.getModel();
        while (memberTable.getRowCount() > 0) {
            memberTable.removeRow(0);
        }

        String name = "";
        String studentID = "";
        String contactNo = "";
        String programme = "";
        String societyName = "";
        String position = "";
        String joinedDate = "";

        for (int i = 1; i <= memberRegistrationList.getLength(); i++) {
            if (memberRegistrationList.getEntry(i).getSociety().getSocietyName().contains(societyInfo.getSocietyName())) {
                name = memberRegistrationList.getEntry(i).getStudent().getName();
                studentID = memberRegistrationList.getEntry(i).getStudent().getStudentID();
                contactNo = memberRegistrationList.getEntry(i).getStudent().getContactNo();
                programme = memberRegistrationList.getEntry(i).getStudent().getProgramme();
                societyName = memberRegistrationList.getEntry(i).getSociety().getSocietyName();
                position = memberRegistrationList.getEntry(i).getPosition();
                joinedDate = memberRegistrationList.getEntry(i).getJoinedDate();

                String data[] = {name, studentID, contactNo, programme, societyName, position, joinedDate};
                memberTable.addRow(data);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        jComboBox_programme = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtSocietyName = new javax.swing.JTextField();
        jComboBox_position = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMemberList = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnMemberList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MEMBER MANAGEMENT");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Student ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Society");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Contact No.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Programme");

        jComboBox_programme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select", "RDS", "RSD", "RIT", "RSF" }));
        jComboBox_programme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_programmeActionPerformed(evt);
            }
        });

        jLabel7.setText("Position");

        txtSocietyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSocietyNameActionPerformed(evt);
            }
        });

        jComboBox_position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select", "Member", "President", "Secretary", "Commitee Member" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jTableMemberList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Student ID", "Contact No.", "Programme", "Society", "Position", "Joined Date"
            }
        ));
        jTableMemberList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMemberListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMemberList);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnMemberList.setText("Display Member List");
        btnMemberList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtStudentID)
                            .addComponent(txtContactNo)
                            .addComponent(jComboBox_programme, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSocietyName)
                                    .addComponent(jComboBox_position, 0, 228, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRemove)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(225, 225, 225)
                                .addComponent(btnMemberList)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack)
                    .addComponent(btnMemberList))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4)
                                                .addComponent(txtSocietyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jComboBox_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox_programme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate)
                        .addComponent(btnAdd)))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnClear))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSocietyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSocietyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSocietyNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String studentID = txtStudentID.getText();
        String contactNo = txtContactNo.getText();
        String programme = jComboBox_programme.getSelectedItem().toString();
        String position = jComboBox_position.getSelectedItem().toString();
        //SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String joinedDate = LocalDate.now().toString();
        boolean memberValidity = false;

        //System.out.println("Display: " + memberRegistrationList);
        // check empty fields
        if (name.trim().equals(""))
            JOptionPane.showMessageDialog(null, "Empty Field Detected: Please enter the Name", "Alert", JOptionPane.WARNING_MESSAGE);
        else if (studentID.trim().equals(""))
            JOptionPane.showMessageDialog(null, "Empty Field Detected: Please Enter the Student ID", "Alert", JOptionPane.WARNING_MESSAGE);
        else if (contactNo.trim().equals(""))
            JOptionPane.showMessageDialog(null, "Empty Field Detected: Please Enter the Contact Number", "Alert", JOptionPane.WARNING_MESSAGE);
        else if (programme.equals("Please Select"))
            JOptionPane.showMessageDialog(null, "Empty Field Detected: Please Select a Programme", "Alert", JOptionPane.WARNING_MESSAGE);
        else if (position.equals("Please Select"))
            JOptionPane.showMessageDialog(null, "Empty Field Detected: Please Select a Position", "Alert", JOptionPane.WARNING_MESSAGE);
        else {
            // check for duplicated members
            for (int i = 1; i <= memberRegistrationList.getLength(); i++) {
                //System.out.println("TEST: " + memberRegistrationList.getEntry(i));
                if (studentID.equals(memberRegistrationList.getEntry(i).getStudent().getStudentID()) && societyInfo.getSocietyName().equals(memberRegistrationList.getEntry(i).getSociety().getSocietyName())) {
                    JOptionPane.showMessageDialog(null, "This member already exist", "Registration Failed", JOptionPane.WARNING_MESSAGE);
                    memberValidity = false;
                    break;
                } else {
                    memberValidity = true;
                }
            }

            if (memberValidity) {
                try {
                    //add to list
                    Student student = new Student(name, studentID, contactNo, programme);
                    
                    MemberRegistration registration = new MemberRegistration(student, societyInfo, position, joinedDate);
                    memberRegistrationList.add(registration);
               
                    //insert into text file
                    memberRegistrationFile.writer(registration, "memberRegistration.txt");
           
                    //add to table
                    String data[] = {name, studentID, contactNo, programme, societyInfo.getSocietyName(), position, joinedDate};
                    DefaultTableModel memberTable = (DefaultTableModel) jTableMemberList.getModel();
                    memberTable.addRow(data);

                    JOptionPane.showMessageDialog(null, "Registration Complete! Member has been added to the list", "Register Successful", JOptionPane.INFORMATION_MESSAGE);
                    clearField();

                } catch (Exception e) {
                    System.out.println("" + e);
                    JOptionPane.showMessageDialog(null, "Registration Failed! Please try again", "Register Failed", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void clearField() {
        txtName.setText("");
        txtStudentID.setText("");
        txtContactNo.setText("");
        jComboBox_programme.setSelectedIndex(0);
        jComboBox_position.setSelectedIndex(0);
    }

    private void jComboBox_programmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_programmeActionPerformed
        // TODO add your handling code here:
        //String programme = jComboBox_programme.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBox_programmeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new SocietyMemberManagement().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        String studentID = txtStudentID.getText();
        String societyName = txtSocietyName.getText();
        boolean removed = false;
        DefaultTableModel memberTable = (DefaultTableModel) jTableMemberList.getModel();

        if (jTableMemberList.getSelectedRowCount() == 1) {

            for (int i = 1; i <= memberRegistrationList.getLength(); i++) {
                if (studentID.equals(memberRegistrationList.getEntry(i).getStudent().getStudentID()) && societyName.equals(memberRegistrationList.getEntry(i).getSociety().getSocietyName())) {
                    //System.out.println("display before: " + memberRegistrationList);
                    //remove from list
                    memberRegistrationList.remove(memberRegistrationList.getEntry(i));

                    //System.out.println("display after: " + memberRegistrationList);
                    //remove from text file
                    memberRegistrationFile.rewrite((SortedLinkedList<MemberRegistration>) memberRegistrationList, "memberRegistration.txt");
                  
                    //remove from table
                    memberTable.removeRow(jTableMemberList.getSelectedRow());
                    removed = true;
                    clearField();
                    break;
                }
            }
            if (!removed) {
                JOptionPane.showMessageDialog(null, "This member does not exist!", "Remove Failed", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (jTableMemberList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is empty!", "Delete Failed", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete", "Delete Failed", JOptionPane.INFORMATION_MESSAGE);
        }

        
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jTableMemberListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMemberListMouseClicked
        // TODO add your handling code here:
        int i = jTableMemberList.getSelectedRow();
        DefaultTableModel memberTable = (DefaultTableModel) jTableMemberList.getModel();
        txtName.setText(memberTable.getValueAt(i, 0).toString());
        txtStudentID.setText(memberTable.getValueAt(i, 1).toString());
        storeStudentID = txtStudentID.getText();
        txtContactNo.setText(memberTable.getValueAt(i, 2).toString());
        
        String programme = memberTable.getValueAt(i, 3).toString();
        //System.out.println("" + programme);
        for (int a = 0; a < jComboBox_programme.getItemCount(); a++){
            if(jComboBox_programme.getItemAt(a).toString().equalsIgnoreCase(programme)){
                jComboBox_programme.setSelectedIndex(a);
            }
        }
        
        String position = memberTable.getValueAt(i, 5).toString();
        //System.out.println("" + position);
        for (int a = 0; a < jComboBox_position.getItemCount(); a++){
            if(jComboBox_position.getItemAt(a).toString().equalsIgnoreCase(position)){
                jComboBox_position.setSelectedIndex(a);
            }
        }
        storeJoinedDate = memberTable.getValueAt(i, 6).toString();
 
    }//GEN-LAST:event_jTableMemberListMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        
        String societyName = txtSocietyName.getText();
        boolean cleared = false;
        DefaultTableModel memberTable = (DefaultTableModel) jTableMemberList.getModel();
        
        if (jTableMemberList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is empty!", "Clear Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            for (int i = 1; i <= memberRegistrationList.getLength(); i++) {
                if (memberRegistrationList.getEntry(i).getSociety().getSocietyName().contains(societyName)) {
                    //System.out.println(memberRegistrationList.getEntry(i));
                    memberRegistrationList.remove(memberRegistrationList.getEntry(i));
                    i--;
                    memberRegistrationFile.rewrite((SortedLinkedList<MemberRegistration>) memberRegistrationList, "memberRegistration.txt");              
                }
            }
            //memberRegistrationFile.rewrite((SortedLinkedList<SocietyMemberRegistration>) memberRegistrationList, "memberRegistration.txt");
            while (memberTable.getRowCount() > 0) {
                for (int i = 0; i < memberTable.getRowCount(); i++) {
                    memberTable.removeRow(i);
                }
                cleared = true;
            }
        }
        
        if(cleared){
            JOptionPane.showMessageDialog(null, "All entries has been cleared", "Clear Successfull", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String studentID = txtStudentID.getText();
        String contactNo = txtContactNo.getText();
        String programme = jComboBox_programme.getSelectedItem().toString();
        String societyName = txtSocietyName.getText();
        String position = jComboBox_position.getSelectedItem().toString();
        String joinedDate = storeJoinedDate;
        //String joinedDate = LocalDate.now().toString();
        boolean memberValidity = false;
        boolean remove = false;
        boolean add = false;

        DefaultTableModel memberTable = (DefaultTableModel) jTableMemberList.getModel();

        if (jTableMemberList.getSelectedRowCount() == 1) {

            for (int i = 1; i <= memberRegistrationList.getLength(); i++) {
                if (storeStudentID.equals(memberRegistrationList.getEntry(i).getStudent().getStudentID()) && societyName.equals(memberRegistrationList.getEntry(i).getSociety().getSocietyName())) {
                    // check empty
                    if (name.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Empty Field Detected: Please enter the Name", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else if (studentID.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Empty Field Detected: Please Enter the Student ID", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else if (contactNo.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Empty Field Detected: Please Enter the Contact Number", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else if (programme.equals("Please Select")) {
                        JOptionPane.showMessageDialog(null, "Empty Field Detected: Please Select a Programme", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else if (position.equals("Please Select")) {
                        JOptionPane.showMessageDialog(null, "Empty Field Detected: Please Select a Position", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        // check for duplicated members
                        for (int a = 1; a <= memberRegistrationList.getLength(); a++) {
                            //System.out.println("TEST: " + memberRegistrationList.getEntry(i));
                            if (studentID.equals(storeStudentID) && societyName.equals(memberRegistrationList.getEntry(a).getSociety().getSocietyName())) {
                                memberValidity = true;
                                break;
                            } else if (studentID.equals(memberRegistrationList.getEntry(a).getStudent().getStudentID()) && societyName.equals(memberRegistrationList.getEntry(a).getSociety().getSocietyName())) {
                                JOptionPane.showMessageDialog(null, "This member already exist", "Update Failed", JOptionPane.WARNING_MESSAGE);
                                memberValidity = false;
                                break;
                            } else {
                                memberValidity = true;
                            }
                        }
                    }
                    
                    if (memberValidity){
                        //remove from list
                        memberRegistrationList.remove(memberRegistrationList.getEntry(i));
                        //remove from text file
                        memberRegistrationFile.rewrite((SortedLinkedList<MemberRegistration>) memberRegistrationList, "memberRegistration.txt");
                        //remove from table
                        memberTable.removeRow(jTableMemberList.getSelectedRow());
                        remove = true;
                    }
                    
                    if(remove){
                        try {
                            //add to list
                            Student student = new Student(name, studentID, contactNo, programme);                          
                            MemberRegistration registration = new MemberRegistration(student, societyInfo, position, joinedDate);
                            memberRegistrationList.add(registration);

                            //insert into text file
                            memberRegistrationFile.writer(registration, "memberRegistration.txt");

                            //add to table
                            String data[] = {name, studentID, contactNo, programme, societyInfo.getSocietyName(), position, joinedDate};
                            memberTable.addRow(data);

                            JOptionPane.showMessageDialog(null, "Member details have been updated", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
                            clearField();

                        } catch (Exception e) {
                            System.out.println("" + e);
                            JOptionPane.showMessageDialog(null, "Unable to update member details", "Update Failed", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        } else if (jTableMemberList.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is empty!", "Update Failed", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to update", "Update Failed", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnMemberListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberListActionPerformed
        // TODO add your handling code here:
        String societyName_key = txtSocietyName.getText();
        
        JTextArea jtaMemberList = new JTextArea(100, 200);
        String str = String.format("%140s %s\n",societyName_key, "MEMBER LIST\n");
        
        str += String.format("%s\t\t %s\t\t %s\t\t %s\t\t %s\t\t\t %s\n",
                "Name", "Student ID", "Contact No.", "Programme", "Society Name", "Position");
        
        str += String.format("%s\n", "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        for(int i = 1; i <= memberRegistrationList.getLength(); i++){
            if (societyName_key.equals(memberRegistrationList.getEntry(i).getSociety().getSocietyName())) {
                societyMemberList.add(memberRegistrationList.getEntry(i));
            }
        }
        
        //System.out.println("society Member" + societyMemberList);
        
        for (int i = 1; i <= societyMemberList.getLength(); i++){
            String name = societyMemberList.getEntry(i).getStudent().getName();
            String studentID = societyMemberList.getEntry(i).getStudent().getStudentID();
            String contactNo = societyMemberList.getEntry(i).getStudent().getContactNo();
            String programme = societyMemberList.getEntry(i).getStudent().getProgramme();
            String societyName = societyMemberList.getEntry(i).getSociety().getSocietyName();
            String position = societyMemberList.getEntry(i).getPosition();
            String joinedDate = societyMemberList.getEntry(i).getJoinedDate();
            
            str += String.format("%s\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\n", name, studentID, contactNo, programme, societyName, position, joinedDate);
        }
        
        societyMemberList.clear();
        
        Font memberListFont = new Font("Arial", Font.BOLD, 14);
        jtaMemberList.setText(str);
        jtaMemberList.setEditable(false);
        jtaMemberList.setFont(memberListFont);
        JFrame listFrame = new JFrame();
        listFrame.add(jtaMemberList);
        listFrame.setSize(1300, 800);
        listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listFrame.setVisible(true);
    }//GEN-LAST:event_btnMemberListActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(MemberManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnMemberList;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> jComboBox_position;
    private javax.swing.JComboBox<String> jComboBox_programme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMemberList;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSocietyName;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}
