package entity;


import java.io.Serializable;
import java.util.Objects;

public class Society implements Serializable, Comparable<Society>{

    private int societyID;
    private String societyName;
    private String dateReg;
    private double feesPerPerson;
    private int targetMemNum;

    
    

    public Society(int societyID, String societyName, String dateReg, double feesPerPerson, int numOfMembers) {
        this.societyID = societyID;
        this.societyName = societyName;
        this.dateReg = dateReg;
        this.feesPerPerson = feesPerPerson;
        this.targetMemNum = numOfMembers;
    }

    public Society(int societyID, String societyName, String dateReg, double feesPerPerson, int targetMemNum, int currentMemNum) {
        this.societyID = societyID;
        this.societyName = societyName;
        this.dateReg = dateReg;
        this.feesPerPerson = feesPerPerson;
        this.targetMemNum = targetMemNum;
        
    }
   
    public Society() {
    }

    public int getSocietyID() {
        return societyID;
    }

    public String getSocietyName() {
        return societyName;
    }

    public String getDateReg() {
        return dateReg;
    }

    public double getFeesPerPerson() {
        return feesPerPerson;
    }

    public int getTargetMemNum() {
        return targetMemNum;
    }
 
    public void setSocietyID(int societyID) {
        this.societyID = societyID;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public void setDateReg(String dateReg) {
        this.dateReg = dateReg;
    }

    public void setFeesPerPerson(double feesPerPerson) {
        this.feesPerPerson = feesPerPerson;
    }

    public void setTargetMemNum(int targetMemNum) {
        this.targetMemNum = targetMemNum;
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
        final Society other = (Society) obj;
        if (this.societyID != other.societyID) {
            return false;
        }
        if (Double.doubleToLongBits(this.feesPerPerson) != Double.doubleToLongBits(other.feesPerPerson)) {
            return false;
        }
        if (this.targetMemNum != other.targetMemNum) {
            return false;
        }       
        if (!Objects.equals(this.societyName, other.societyName)) {
            return false;
        }
        if (!Objects.equals(this.dateReg, other.dateReg)) {
            return false;
        }
        return true;
    }
    
     
     
    @Override
    public String toString() {
        return Integer.toString(societyID) + "|" + societyName + "|" +  dateReg + "|" + 
                 Double.toString(feesPerPerson) + "|" +  Integer.toString(targetMemNum);
    }

    @Override
    public int compareTo(Society o) {
        if(this.societyID == o.societyID)
            return 0;
        else if (this.societyID < o.societyID)
            return -1;
        else
            return 1;
    }

    
}
