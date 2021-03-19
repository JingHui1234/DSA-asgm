package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ang Chia Ling
 */
public class BookingDetails implements Serializable {

    private Event event;
    private Venue bookedVenue;

    public BookingDetails() {
    }

    public BookingDetails(Event event, Venue bookedVenue) {
        this.event = event;
        this.bookedVenue = bookedVenue;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setBookedVenue(Venue bookedVenue) {
        this.bookedVenue = bookedVenue;
    }

    public Event getEvent() {
        return event;
    }

    public Venue getBookedVenue() {
        return bookedVenue;
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
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        if (!Objects.equals(this.bookedVenue, other.bookedVenue)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return event + "|" + bookedVenue;
    }

}
