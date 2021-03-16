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
public class Venue implements Serializable{
    private String venueName;
    private String type;
    private int capacity;

    public Venue() {
    }
    
    public Venue(String venueName, String type, int capacity) {
        this.venueName = venueName;
        this.type = type;
        this.capacity = capacity;
    }
    
    public Venue(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
        final Venue other = (Venue) obj;
        if (this.capacity != other.capacity) {
            return false;
        }
        if (!Objects.equals(this.venueName, other.venueName)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
}
