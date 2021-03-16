/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author Ang Chia Ling
 */
public class BookingDetails implements Serializable {
    private Event event;
    private String bookedVenue1;
    private String bookedVenue2;
    private String bookedVenue3;

    public BookingDetails() {
    }

    public BookingDetails(Event event, String bookedVenue1, String bookedVenue2, String bookedVenue3) {
        this.event = event;
        this.bookedVenue1 = bookedVenue1;
        this.bookedVenue2 = bookedVenue2;
        this.bookedVenue3 = bookedVenue3;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }

    

    public Event getEvent() {
        return event;
    }

    public String getBookedVenue1() {
        return bookedVenue1;
    }

    public String getBookedVenue2() {
        return bookedVenue2;
    }

    public String getBookedVenue3() {
        return bookedVenue3;
    }

    public void setBookedVenue1(String bookedVenue1) {
        this.bookedVenue1 = bookedVenue1;
    }

    public void setBookedVenue2(String bookedVenue2) {
        this.bookedVenue2 = bookedVenue2;
    }

    public void setBookedVenue3(String bookedVenue3) {
        this.bookedVenue3 = bookedVenue3;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.event);
        hash = 89 * hash + Objects.hashCode(this.bookedVenue1);
        hash = 89 * hash + Objects.hashCode(this.bookedVenue2);
        hash = 89 * hash + Objects.hashCode(this.bookedVenue3);
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
        final BookingDetails other = (BookingDetails) obj;
        if (!Objects.equals(this.bookedVenue1, other.bookedVenue1)) {
            return false;
        }
        if (!Objects.equals(this.bookedVenue2, other.bookedVenue2)) {
            return false;
        }
        if (!Objects.equals(this.bookedVenue3, other.bookedVenue3)) {
            return false;
        }
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        return true;
    }


}
