/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Objects;

public class Society implements Serializable{

    private int societyID;
    private String societyName;
    private String dateReg;
    private static double feesPerPerson;
    private static int minMembers = 20;
    private static int maxMembers = 300;
    private int members;
    
    public Society(int societyID, String societyName, String dateReg, double feesPerPerson, int members) {
        this.societyID = societyID;
        this.societyName = societyName;
        this.dateReg = dateReg;
        this.feesPerPerson = feesPerPerson;
        this.members = members;

    }

    public int getSocietyID() {
        return societyID;
    }

    public void setSocietyID(int societyID) {
        this.societyID = societyID;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getDateReg() {
        return dateReg;
    }

    public void setDateReg(String dateReg) {
        this.dateReg = dateReg;
    }


    public double getFeesPerPerson() {
        return feesPerPerson;
    }

    public static int getMinMembers() {
        return minMembers;
    }

    public static void setMinMembers(int minMembers) {
        Society.minMembers = minMembers;
    }

    public static int getMaxMembers() {
        return maxMembers;
    }

    public static void setMaxMembers(int maxMembers) {
        Society.maxMembers = maxMembers;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    
    public boolean checkMinMem(int minMembers){
        if(members >= minMembers && members <= maxMembers){
            return true;
        }       
        return false;
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
        if (!Objects.equals(this.members, other.members)) {
            return false;
        }    
        return true;
    }
        
    @Override
    public String toString() {
        return societyID + "|" + societyName + "|" +  dateReg + "|" + 
                 feesPerPerson + "|" +  members;
    }

}
