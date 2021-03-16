

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 *
 * @author jingh
 */
public class Event implements Serializable{
    
    private String society;
    private String organizer;
    private String category;
    private String name;
    private LocalDate date;
    private int numOfParticipant;
    private LocalTime startTime;
    private LocalTime endTime;
    private static int minNumOfParticipant = 5;
    private static int maxNumOfParticipant = 500;
    private static LocalTime startTimeLimit = LocalTime.of(8,0);
    private static LocalTime endTimeLimit = LocalTime.of(23,0);
    

    public Event() {
    }

    public Event(String society, String organizer, String name,String category, LocalDate date, LocalTime startTime, LocalTime endTime, int numOfParticipant) {
        this.society = society;
        this.organizer = organizer;
        this.category = category;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numOfParticipant = numOfParticipant;
    }
    
    public Event(String society,String name, LocalDate date, LocalTime startTime, LocalTime endTime, int numOfParticipant){
        this.society = society;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numOfParticipant = numOfParticipant;
    }


    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getNumOfParticipant() {
        return numOfParticipant;
    }

    public static int getMaxNumOfParticipant() {
        return maxNumOfParticipant;
    }

    public static LocalTime getStartTimeLimit() {
        return startTimeLimit;
    }

    public static LocalTime getEndTimeLimit() {
        return endTimeLimit;
    }
   
    
    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getSociety() {
        return society;
    }

    public String getOrganizer() {
        return organizer;
    }

    
    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setNumOfParticipant(int numOfParticipant) {
        this.numOfParticipant = numOfParticipant;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    

    public boolean validateParticipantNum(int numOfParticipant){
        if(numOfParticipant >= minNumOfParticipant && numOfParticipant <= maxNumOfParticipant){
            return true;
        }       
        return false;
    }
    
    public boolean validateStartTime(LocalTime startTime){
        if(startTime.isBefore(startTimeLimit))
            return false;
        
        return true;
    }
    
    public boolean validateEndTime(LocalTime endTime){
        if(endTime.isAfter(endTimeLimit))
            return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.numOfParticipant != other.numOfParticipant) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        return category + name + dateFormat.format(date) + '\n';
    }
    
    
}
