package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 *
 * @author jingh
 */
public class Event implements Serializable {

    private MemberRegistration societyMem;
    private String category;
    private String name;
    private LocalDate date;
    private int numOfParticipant;
    private LocalTime startTime;
    private LocalTime endTime;
    private static int minNumOfParticipant = 5;
    private static int maxNumOfParticipant = 500;
    private static LocalTime startTimeLimit = LocalTime.of(8, 0);
    private static LocalTime endTimeLimit = LocalTime.of(23, 0);

    public Event() {
    }

    public Event(MemberRegistration societyMem, String name, String category, LocalDate date, LocalTime startTime, LocalTime endTime, int numOfParticipant) {
        this.societyMem = societyMem;
        this.name = name;
        this.category = category;
        this.date = date;
        this.numOfParticipant = numOfParticipant;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public static int getMinNumOfParticipant() {
        return minNumOfParticipant;
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

    public MemberRegistration getSocietyMem() {
        return societyMem;
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

    public void setSocietyMem(MemberRegistration societyMem) {
        this.societyMem = societyMem;
    }

    public boolean validateParticipantNum(int numOfParticipant) {
        return numOfParticipant >= minNumOfParticipant
                && numOfParticipant <= maxNumOfParticipant;
    }

    public boolean validateEventTime(LocalTime startTime, LocalTime endTime) {
        return !(startTime.isBefore(startTimeLimit)
                || endTime.isAfter(endTimeLimit)
                || endTime.isBefore(startTime)
                || endTime.equals(startTime));
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        if (!Objects.equals(this.societyMem, other.societyMem)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        return Objects.equals(this.endTime, other.endTime);
    }

    @Override
    public String toString() {

        return societyMem + "|" + name + "|"
                + category + "|" + date.toString() + "|" + startTime.toString() + "|"
                + endTime.toString() + "|" + Integer.toString(numOfParticipant);
    }

}
