package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import adt.ArrayList;
import entity.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Ang Chia Ling
 */
public class BookingDetailsFile {

    // reading file
    public ArrayList<BookingDetails> reader(String fileName) {
        ArrayList<BookingDetails> bookingList = new ArrayList<>();
        BufferedReader reader = null;

        try {
            String currentLine;
            reader = new BufferedReader(new FileReader(fileName));

            while ((currentLine = reader.readLine()) != null) {
                String[] bookingDetails = currentLine.split("\\|");

                 // organizer
                String name = bookingDetails[0];
                String studentID = bookingDetails[1];
                String contactNo = bookingDetails[2];
                String programme = bookingDetails[3];              
                
               
                 // society         
                int societyID = Integer.parseInt(bookingDetails[4]);
                String societyName = bookingDetails[5];
                String dateReg = bookingDetails[6];
                double feesPerPerson = Double.parseDouble(bookingDetails[7]);
                int targetMemNum = Integer.parseInt(bookingDetails[8]);
                
                
                String position = bookingDetails[9];
                String joinedDate = bookingDetails[10];

                // event            
                String eventName = bookingDetails[11];
                String category = bookingDetails[12];
                LocalDate date = LocalDate.parse(bookingDetails[13]);
                LocalTime startTime = LocalTime.parse(bookingDetails[14]);
                LocalTime endTime = LocalTime.parse(bookingDetails[15]);
                int partiNo = Integer.parseInt(bookingDetails[16]);
                
                String venueName = bookingDetails[17];
                String type = bookingDetails[18];
                int capacity = Integer.parseInt(bookingDetails[19]);
                
                Student student = new Student(name, studentID, contactNo, programme);
                Society society = new Society(societyID, societyName, dateReg,feesPerPerson,targetMemNum);
                MemberRegistration registration = new MemberRegistration(student, society, position, joinedDate);
                Event event = new Event(registration, eventName, category, date, startTime, endTime, partiNo);
                Venue venue = new Venue(venueName, type, capacity);
      
                BookingDetails bookingdetails = new BookingDetails(event, venue);
                bookingList.insert(bookingdetails);
            }

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return bookingList;
    }
    
    // write into file
    public void writer(BookingDetails bookingDetails, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(bookingDetails.toString());
            writer.newLine();

            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    
    // rewrite into file
    public void rewrite(ArrayList<BookingDetails> bookingList, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (int i = 1; i <= bookingList.length(); i++) {
                BookingDetails bookingDetails = bookingList.getEntry(i);
                writer.write(bookingDetails.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
}
