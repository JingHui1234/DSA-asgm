package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import adt.ArrayList;
import adt.ListInterface;
import entity.BookingDetails;
import entity.Event;
import entity.Venue;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Ang Chia Ling
 */
public class VenueBooking extends javax.swing.JFrame {

    // variable declaration
    private static ListInterface<BookingDetails> bookingList = new ArrayList<>();
    private static ListInterface<Venue> venueList = new ArrayList<>();
    private static String avaVenue[] = new String[99];
    private static int num;
    private Event v_event;
    // dummy data 
//    Event v_event = new Event("English Society", "Jing Hui", "TPL", "Competition", LocalDate.of(2021, 06, 20), LocalTime.of(12, 00), LocalTime.of(14, 30), 30);
    BookingDetailsFile bookingfile = new BookingDetailsFile();
    VenueFile venuefile = new VenueFile();
    private final EventFile eventFile = new EventFile();

    /**
     * Creates new form venueBooking
     */
    public VenueBooking() {

    }

    public VenueBooking(Event v_event) {
        initComponents();
        this.v_event = v_event;
        // disable the text field, let the data auto entry itself
        jTextFieldEventName.setEditable(false);
        jTextFieldDate.setEditable(false);
        jTextFieldStartTime.setEditable(false);
        jTextFieldEndTime.setEditable(false);
        jTextFieldNum.setEditable(false);
        jComboBoxVenue2.setEnabled(false);
        jComboBoxVenue3.setEnabled(false);

        jTextFieldEventName.setText(v_event.getName());
        jTextFieldDate.setText(v_event.getDate().toString());
        jTextFieldStartTime.setText(v_event.getStartTime().toString());
        jTextFieldEndTime.setText(v_event.getEndTime().toString());
        jTextFieldNum.setText(Integer.toString(v_event.getNumOfParticipant()));

        // read file and store into arraylist(venueList and bookingList)
        venueList = venuefile.reader("VenueFile.txt");
        bookingList = bookingfile.reader("BookingDetailsFile.txt");

        // check which venue available for listing for user to choose, matched date, matched time, available time
        boolean available = true;
        num = 0;
        for (int i = 1; i <= venueList.length(); i++) {
            for (int j = 1; j <= bookingList.length(); j++) {
                if (venueList.getEntry(i).getVenueName().equals(bookingList.getEntry(j).getBookedVenue())) {
                    if (v_event.getDate().isEqual(bookingList.getEntry(j).getEvent().getDate())) {
                        if (v_event.getStartTime().isAfter(bookingList.getEntry(j).getEvent().getEndTime()) || v_event.getEndTime().isBefore(bookingList.getEntry(j).getEvent().getStartTime())) {
                            available = true;
                        } else {
                            available = false;
                            break;
                        }
                    } else {
                        available = true;
                    }
                } else {
                    available = true;
                }
            }

            // loop those available venue into the drop down list
            if (available) {
                if (v_event.getNumOfParticipant() <= venueList.getEntry(i).getCapacity()) {
                    avaVenue[num] = venueList.getEntry(i).getVenueName();
                    num++;
                }
                // if no venue available, prompt a message              
            }
        }

        if (num == 0) {
            JOptionPane.showMessageDialog(null, "No venue available, please make a new registration.");
            new EventRegistrationDriver().setVisible(true);

            this.dispose();

            // go back jing hui part
        }

        for (int k = 0; k < num; k++) {
            jComboBoxVenue1.addItem(avaVenue[k]);
            jComboBoxVenue2.addItem(avaVenue[k]);
            jComboBoxVenue3.addItem(avaVenue[k]);
        }

    }

//    public VenueBooking(Event event) {
//        initComponents();
//        jTextFieldEventName.setEditable(false);
//        jTextFieldDate.setEditable(false);
//        jTextFieldStartTime.setEditable(false);
//        jTextFieldEndTime.setEditable(false);
//        jTextFieldNum.setEditable(false);
//
//        jTextFieldEventName.setText(event.getName());
//        jTextFieldDate.setText(event.getDate().toString());
//        jTextFieldStartTime.setText(event.getStartTime().toString());
//        jTextFieldEndTime.setText(event.getEndTime().toString());
//        jTextFieldNum.setText(Integer.toString(event.getNumOfParticipant()));
//
//        venueList = venuefile.reader("VenueFile.txt");
//        bookingList = bookingfile.reader("BookingDetailsFile.txt");
//
//        boolean available = true;
//        num = 0;
//        for (int i = 1; i <= venueList.length(); i++) {
//            for (int j = 1; j <= bookingList.length(); j++) {
//                if (venueList.getEntry(i).getVenueName().equals(bookingList.getEntry(j).getBookedVenue1()) || venueList.getEntry(i).getVenueName().equals(bookingList.getEntry(j).getBookedVenue2()) || venueList.getEntry(i).getVenueName().equals(bookingList.getEntry(j).getBookedVenue3())) {
//                    if (event.getDate().isEqual(bookingList.getEntry(j).getEvent().getDate())) {
//                        if (event.getStartTime().isAfter(bookingList.getEntry(j).getEvent().getEndTime()) || event.getEndTime().isBefore(bookingList.getEntry(j).getEvent().getStartTime())) {
//                            available = true;
//                        } else {
//                            available = false;
//                            break;
//                        }
//                    } else {
//                        available = true;
//                    }
//                } else {
//                    available = true;
//                }
//
//            }
//            if (available) {
//                if (event.getNumOfParticipant() <= venueList.getEntry(i).getCapacity()) {
//                    avaVenue[num] = venueList.getEntry(i).getVenueName();
//                    num++;
//                }
//            }
//        }
//
//        for (int k = 0; k < num; k++) {
//            jComboBoxVenue1.addItem(avaVenue[k]);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jComboBoxVenue1 = new javax.swing.JComboBox<>();
        jLabelVenue1 = new javax.swing.JLabel();
        jLabelEventName = new javax.swing.JLabel();
        jTextFieldEventName = new javax.swing.JTextField();
        jLabelEventDate = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jLabelStartTime = new javax.swing.JLabel();
        jLabelEndTime = new javax.swing.JLabel();
        jTextFieldEndTime = new javax.swing.JTextField();
        jLabelNum = new javax.swing.JLabel();
        jButtonConfirm = new javax.swing.JButton();
        jTextFieldNum = new javax.swing.JTextField();
        jLabelVenue2 = new javax.swing.JLabel();
        jComboBoxVenue2 = new javax.swing.JComboBox<>();
        jLabelVenue3 = new javax.swing.JLabel();
        jComboBoxVenue3 = new javax.swing.JComboBox<>();
        jLabelBookingVenue = new javax.swing.JLabel();
        jTextFieldStartTime = new javax.swing.JTextField();
        jLabelEmptyVenue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jComboBoxVenue1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please choose:" }));
        jComboBoxVenue1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxVenue1ItemStateChanged(evt);
            }
        });

        jLabelVenue1.setText("Available Venue 1:");

        jLabelEventName.setText("Event Name:");

        jLabelEventDate.setText("Date:");

        jLabelStartTime.setText("Start Time:");

        jLabelEndTime.setText("End Time:");

        jLabelNum.setText("Number of Participants");

        jButtonConfirm.setText("Confirm");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });

        jLabelVenue2.setText("Available Venue 2: ");

        jComboBoxVenue2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please choose" }));
        jComboBoxVenue2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxVenue2ItemStateChanged(evt);
            }
        });

        jLabelVenue3.setText("Available Venue 3:");

        jComboBoxVenue3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please choose" }));

        jLabelBookingVenue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelBookingVenue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBookingVenue.setText("Booking Venue");

        jLabelEmptyVenue.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEmptyVenue.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelBookingVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelEventDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEventName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldEventName, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDate))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldStartTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNum, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelVenue3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelVenue1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxVenue1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelVenue2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxVenue3, 0, 258, Short.MAX_VALUE)
                                    .addComponent(jComboBoxVenue2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelEmptyVenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabelBookingVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEventName)
                    .addComponent(jTextFieldEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEventDate)
                    .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEndTime)
                    .addComponent(jTextFieldEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStartTime)
                    .addComponent(jTextFieldStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNum)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVenue1)
                    .addComponent(jComboBoxVenue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVenue2)
                    .addComponent(jComboBoxVenue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVenue3)
                    .addComponent(jComboBoxVenue3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEmptyVenue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButtonConfirm)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        // TODO add your handling code here:
        // validation of empty field and any duplicated fields
        if (jComboBoxVenue1.getSelectedIndex() == 0) {
            jLabelEmptyVenue.setText("Venue 1 cannot be null!");
        } else if (jComboBoxVenue1.getSelectedIndex() != 0 && jComboBoxVenue2.getSelectedIndex() != 0 && jComboBoxVenue3.getSelectedIndex() != 0) {
            if (jComboBoxVenue1.getSelectedIndex() == jComboBoxVenue2.getSelectedIndex() || jComboBoxVenue2.getSelectedIndex() == jComboBoxVenue3.getSelectedIndex() || jComboBoxVenue1.getSelectedIndex() == jComboBoxVenue3.getSelectedIndex()) {
                jLabelEmptyVenue.setText("Duplicated venue found!");
            } else {
                if (jComboBoxVenue1.getSelectedIndex() != 0) {
                    String society = v_event.getSociety();
                    String organizer = v_event.getOrganizer();
                    String name = v_event.getName();
                    String category = v_event.getCategory();
                    LocalDate date = v_event.getDate();
                    LocalTime startTime = v_event.getStartTime();
                    LocalTime endTime = v_event.getEndTime();
                    int numOfParticipants = v_event.getNumOfParticipant();
                    String bookedVenue1 = (String) jComboBoxVenue1.getEditor().getItem();
                    String bookedVenue2 = (String) jComboBoxVenue2.getEditor().getItem();
                    String bookedVenue3 = (String) jComboBoxVenue3.getEditor().getItem();

                    Event event = new Event(society, organizer, name, category, date, startTime, endTime, numOfParticipants);
                    BookingDetails bookedDetails = new BookingDetails(event, bookedVenue1);

                    bookingList.insert(bookedDetails);

                    if (jComboBoxVenue2.getSelectedIndex() != 0) {
                        bookedDetails = new BookingDetails(event, bookedVenue2);
                        bookingList.insert(bookedDetails);

                    }
                    if (jComboBoxVenue3.getSelectedIndex() != 0) {
                        bookedDetails = new BookingDetails(event, bookedVenue3);
                        bookingList.insert(bookedDetails);

                    }

                    bookingfile.rewrite((ArrayList) bookingList, "BookingDetailsFile.txt");
                    eventFile.writer(event, "Event.dat");
                    JOptionPane.showMessageDialog(null, "Venue booked successfully!");
                    this.dispose();
                } else {
                    jLabelEmptyVenue.setText("Venue 1 cannot be null!");
                }
            }

        } else if (jComboBoxVenue1.getSelectedIndex() != 0 && jComboBoxVenue2.getSelectedIndex() != 0) {
            if (jComboBoxVenue1.getSelectedIndex() == jComboBoxVenue2.getSelectedIndex()) {
                jLabelEmptyVenue.setText("Duplicated venue found!");
            } else {
                if (jComboBoxVenue1.getSelectedIndex() != 0) {
                    String society = v_event.getSociety();
                    String organizer = v_event.getOrganizer();
                    String name = v_event.getName();
                    String category = v_event.getCategory();
                    LocalDate date = v_event.getDate();
                    LocalTime startTime = v_event.getStartTime();
                    LocalTime endTime = v_event.getEndTime();
                    int numOfParticipants = v_event.getNumOfParticipant();
                    String bookedVenue1 = (String) jComboBoxVenue1.getEditor().getItem();
                    String bookedVenue2 = (String) jComboBoxVenue2.getEditor().getItem();
                    String bookedVenue3 = (String) jComboBoxVenue3.getEditor().getItem();

                    Event event = new Event(society, organizer, name, category, date, startTime, endTime, numOfParticipants);
                    BookingDetails bookedDetails = new BookingDetails(event, bookedVenue1);

                    bookingList.insert(bookedDetails);

                    if (jComboBoxVenue2.getSelectedIndex() != 0) {
                        bookedDetails = new BookingDetails(event, bookedVenue2);
                        bookingList.insert(bookedDetails);

                    }
                    if (jComboBoxVenue3.getSelectedIndex() != 0) {
                        bookedDetails = new BookingDetails(event, bookedVenue3);
                        bookingList.insert(bookedDetails);

                    }

                    bookingfile.rewrite((ArrayList) bookingList, "BookingDetailsFile.txt");
                    eventFile.writer(event, "Event.dat");
                    JOptionPane.showMessageDialog(null, "Venue booked successfully!");
                    this.dispose();
                } else {
                    jLabelEmptyVenue.setText("Venue 1 cannot be null!");
                }
            }
        } else if (jComboBoxVenue1.getSelectedIndex() != 0 && jComboBoxVenue2.getSelectedIndex() == 0 && jComboBoxVenue3.getSelectedIndex() == 0) {
            if (jComboBoxVenue1.getSelectedIndex() != 0) {
                String society = v_event.getSociety();
                String organizer = v_event.getOrganizer();
                String name = v_event.getName();
                String category = v_event.getCategory();
                LocalDate date = v_event.getDate();
                LocalTime startTime = v_event.getStartTime();
                LocalTime endTime = v_event.getEndTime();
                int numOfParticipants = v_event.getNumOfParticipant();
                String bookedVenue1 = (String) jComboBoxVenue1.getEditor().getItem();
                String bookedVenue2 = (String) jComboBoxVenue2.getEditor().getItem();
                String bookedVenue3 = (String) jComboBoxVenue3.getEditor().getItem();

                Event event = new Event(society, organizer, name, category, date, startTime, endTime, numOfParticipants);
                BookingDetails bookedDetails = new BookingDetails(event, bookedVenue1);

                bookingList.insert(bookedDetails);

                if (jComboBoxVenue2.getSelectedIndex() != 0) {
                    bookedDetails = new BookingDetails(event, bookedVenue2);
                    bookingList.insert(bookedDetails);

                }
                if (jComboBoxVenue3.getSelectedIndex() != 0) {
                    bookedDetails = new BookingDetails(event, bookedVenue3);
                    bookingList.insert(bookedDetails);

                }

                bookingfile.rewrite((ArrayList) bookingList, "BookingDetailsFile.txt");
                eventFile.writer(event, "Event.dat");
                JOptionPane.showMessageDialog(null, "Venue booked successfully!");
                this.dispose();
            } else {
                jLabelEmptyVenue.setText("Venue 1 cannot be null!");
            }
        }
    }//GEN-LAST:event_jButtonConfirmActionPerformed

    private void jComboBoxVenue1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxVenue1ItemStateChanged
        // TODO add your handling code here:
        // enable the text field if venue 1 is chosen
        jComboBoxVenue2.setEnabled(true);

    }//GEN-LAST:event_jComboBoxVenue1ItemStateChanged

    private void jComboBoxVenue2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxVenue2ItemStateChanged
        // TODO add your handling code here:
        // enable the text field if venue 2 is chosen
        jComboBoxVenue3.setEnabled(true);
    }//GEN-LAST:event_jComboBoxVenue2ItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(VenueBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VenueBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VenueBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VenueBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenueBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JComboBox<String> jComboBoxVenue1;
    private javax.swing.JComboBox<String> jComboBoxVenue2;
    private javax.swing.JComboBox<String> jComboBoxVenue3;
    private javax.swing.JLabel jLabelBookingVenue;
    private javax.swing.JLabel jLabelEmptyVenue;
    private javax.swing.JLabel jLabelEndTime;
    private javax.swing.JLabel jLabelEventDate;
    private javax.swing.JLabel jLabelEventName;
    private javax.swing.JLabel jLabelNum;
    private javax.swing.JLabel jLabelStartTime;
    private javax.swing.JLabel jLabelVenue1;
    private javax.swing.JLabel jLabelVenue2;
    private javax.swing.JLabel jLabelVenue3;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldEndTime;
    private javax.swing.JTextField jTextFieldEventName;
    private javax.swing.JTextField jTextFieldNum;
    private javax.swing.JTextField jTextFieldStartTime;
    // End of variables declaration//GEN-END:variables
}
