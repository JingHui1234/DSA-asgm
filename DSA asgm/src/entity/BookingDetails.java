package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ang Chia Ling
 */
public class BookingDetails implements Serializable {
    private Event event;
    private String bookedVenue;

    public BookingDetails() {
    }

    public BookingDetails(Event event, String bookedVenue) {
        this.event = event;
        this.bookedVenue = bookedVenue;     
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }

    

    public Event getEvent() {
        return event;
    }

    public String getBookedVenue() {
        return bookedVenue;
    }
  

    public void setBookedVenue(String bookedVenue) {
        this.bookedVenue = bookedVenue;
    }

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.event);
        hash = 89 * hash + Objects.hashCode(this.bookedVenue);
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
        if (!Objects.equals(this.bookedVenue, other.bookedVenue)) {
            return false;
        }    
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        return true;
    }


}
