/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.DoublyLinkedList;
import entity.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Jing Hui
 */
public class EventFile {
    
    public DoublyLinkedList <Event> reader(String fileName) {
        DoublyLinkedList <Event> eventList = new DoublyLinkedList<>();
        BufferedReader reader = null;
        try {
            String currentLine;
            reader = new BufferedReader(new FileReader(fileName));

            while ((currentLine = reader.readLine()) != null) {
                //read from file and write to eventList
                String[] eventDetails = currentLine.split("\\|"); // separate the string by (|)
                
                // organizer
                String name = eventDetails[0];
                String studentID = eventDetails[1];
                String contactNo = eventDetails[2];
                String programme = eventDetails[3];              
                
               
                 // society         
                int societyID = Integer.parseInt(eventDetails[4]);
                String societyName = eventDetails[5];
                String dateReg = eventDetails[6];
                double feesPerPerson = Double.parseDouble(eventDetails[7]);
                int targetMemNum = Integer.parseInt(eventDetails[8]);  
                
                String position = eventDetails[9];
                String joinedDate = eventDetails[10];

                // event
              
                String eventName = eventDetails[11];
                String category = eventDetails[12];
                LocalDate date = LocalDate.parse(eventDetails[13]);
                LocalTime startTime = LocalTime.parse(eventDetails[14]);
                LocalTime endTime = LocalTime.parse(eventDetails[15]);
                int partiNo = Integer.parseInt(eventDetails[16]);
                
                Student student = new Student(name, studentID, contactNo, programme);
                Society society = new Society(societyID, societyName, dateReg,feesPerPerson,targetMemNum);
                SocietyMember registration = new SocietyMember(student, society, position, joinedDate);
                Event event = new Event(registration, eventName, category, date, startTime, endTime, partiNo);
                eventList.add(event);
            }

        } catch (Exception e) {          
            System.out.println("" + e);
        }
        return eventList;
    }
    
    public void writer(Event event, String filename) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename, true));

            writer.write(event.toString());
            writer.newLine();

            writer.close();

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
  
        public void rewrite(DoublyLinkedList <Event> eventList, String filename) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            
            for (int i = 0; i < eventList.size(); i++) {
                Event event = eventList.getEntry(i+1);
                
                writer.write(event.toString());
                writer.newLine();
            }
           
            writer.close();

        } catch (Exception e) {
            System.out.println("" + e);
        }

    }
}
