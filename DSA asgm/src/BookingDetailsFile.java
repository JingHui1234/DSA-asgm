/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import adt.ArrayList;
import entity.BookingDetails;
import entity.Event;
import entity.Venue;
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

                String society = bookingDetails[0];
                String organizer = bookingDetails[1];
                String name = bookingDetails[2];
                String category = bookingDetails[3];
                LocalDate date = LocalDate.parse(bookingDetails[4]);
                LocalTime startTime = LocalTime.parse(bookingDetails[5]);
                LocalTime endTime = LocalTime.parse(bookingDetails[6]);
                int numOfParticipants = Integer.parseInt(bookingDetails[7]);
                String bookedVenue1 = bookingDetails[8];
                String bookedVenue2 = bookingDetails[9];
                String bookedVenue3 = bookingDetails[10];

                BookingDetails bookingdetails = new BookingDetails(new Event(society, organizer, name, category, date, startTime, endTime, numOfParticipants), bookedVenue1, bookedVenue2, bookedVenue3);
                bookingList.insert(bookingdetails);
            }

        } catch (Exception e) {
            bookingList = null;
        }
        return bookingList;
    }
    
    // write into file
    public void writer(BookingDetails bookingDetails, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(bookingDetails.getEvent().getSociety() + "|" + bookingDetails.getEvent().getOrganizer() + "|" + bookingDetails.getEvent().getName() + "|" + bookingDetails.getEvent().getCategory() + "|" + bookingDetails.getEvent().getDate() + "|" + bookingDetails.getEvent().getStartTime() + "|" + bookingDetails.getEvent().getEndTime() + "|" + bookingDetails.getEvent().getNumOfParticipant() + "|" + bookingDetails.getBookedVenue1() + "|" + bookingDetails.getBookedVenue2() + "|" + bookingDetails.getBookedVenue3());
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
                writer.write(bookingDetails.getEvent().getSociety() + "|" + bookingDetails.getEvent().getOrganizer() + "|" + bookingDetails.getEvent().getName() + "|" + bookingDetails.getEvent().getCategory() + "|" + bookingDetails.getEvent().getDate() + "|" + bookingDetails.getEvent().getStartTime() + "|" + bookingDetails.getEvent().getEndTime() + "|" + bookingDetails.getEvent().getNumOfParticipant() + "|" + bookingDetails.getBookedVenue1() + "|" + bookingDetails.getBookedVenue2() + "|" + bookingDetails.getBookedVenue3());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
}
