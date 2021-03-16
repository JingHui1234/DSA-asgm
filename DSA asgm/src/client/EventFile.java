/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.DLList;
import entity.Event;
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
    
    public DLList <Event> reader(String fileName) {
        DLList <Event> eventList = new DLList<>();
        BufferedReader reader = null;
        try {
            String currentLine;
            reader = new BufferedReader(new FileReader(fileName));

            while ((currentLine = reader.readLine()) != null) {
                //read from file and write to eventList
                String[] eventDetails = currentLine.split("\\|"); // separate the string by (|)
                
                //society
//                Society society = new Society(Integer.parseInt(eventDetails[0]), eventDetails[1], 
//                eventDetails[2], eventDetails[3], Double.parseDouble(eventDetails[4]))
//                int societyID;
//                String societyName;
//                String dateReg;
//                String societyCategory;
//                double feesPerPerson;
//                int minMembers;
                // organizer
                
                // event
                String society = eventDetails[0];
                String organizer = eventDetails[1];
                String name = eventDetails[2];
                String category = eventDetails[3];
                LocalDate date = LocalDate.parse(eventDetails[4]);
                LocalTime startTime = LocalTime.parse(eventDetails[5]);
                LocalTime endTime = LocalTime.parse(eventDetails[6]);
                int partiNo = Integer.parseInt(eventDetails[7]);
                
                Event event = new Event(society, organizer, name, category, partiNo, date, startTime, endTime);
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
    //            writer.write(event.getSociety() + "|" + event.getOrganizer() + "|"
//                    + event.getName() + "|" + event.getCategory() + "|" + event.getDate() + "|"
//                    + event.getStartTime() + "|" + event.getEndTime() + "|" + event.getNumOfParticipant());    
        public void rewrite(DLList <Event> eventList, String filename) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            
            for (int i = 0; i < eventList.size(); i++) {
                Event event = eventList.getEntry(i+1);
                
                writer.write(event.getSociety() + "|" + event.getOrganizer() + "|"
                    + event.getName() + "|" + event.getCategory() + "|" + event.getDate() + "|"
                    + event.getStartTime() + "|" + event.getEndTime() + "|" + event.getNumOfParticipant());
                writer.newLine();
            }
           
            writer.close();

        } catch (Exception e) {
            System.out.println("" + e);
        }

    }
}
