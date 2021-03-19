/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author Quah Tze Wei
 */
public class Society implements Serializable {
   /* private String societyName;
    private int memberCapacity;*/
    
    private int societyID;
    private static int nextSocietyID = 1000;
    private String societyName;
    private String dateReg;
    private String societyCategory;
    private double feesPerPerson;
    private int minMembers;
    private String memberStatus;
    
    public Society(int societyID, String soceityName,String dateReg, String societyCategory,
                        double feesPerPerson, int minMembers, String memberStatus) {
        this.societyID = societyID;
        this.dateReg = dateReg;
        this.societyCategory = societyCategory;
        this.feesPerPerson = feesPerPerson;
        this.minMembers = minMembers;
        this.memberStatus = memberStatus;

    }

    public Society(String societyName) {
        this.societyName = societyName;
        this.societyID = nextSocietyID++;
    }
    

    public int getSocietyID() {
        return societyID;
    }

    public void setSocietyID(int societyID) {
        this.societyID = societyID;
    }

    public static int getNextSocietyID() {
        return nextSocietyID;
    }

    public static void setNextSocietyID(int nextSocietyID) {
        Society.nextSocietyID = nextSocietyID;
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

    public String getSocietyCategory() {
        return societyCategory;
    }

    public void setSocietyCategory(String societyCategory) {
        this.societyCategory = societyCategory;
    }

    public double getFeesPerPerson() {
        return feesPerPerson;
    }

    public void setFeesPerPerson(double feesPerPerson) {
        this.feesPerPerson = feesPerPerson;
    }

    public int getMinMembers() {
        return minMembers;
    }

    public void setMinMembers(int minMembers) {
        this.minMembers = minMembers;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }
   
    
    @Override
    public String toString() {
        return societyID + "|" + societyName + "|" +  dateReg + "|" + 
                societyCategory + "|" +  feesPerPerson + "|" +  minMembers + "|" + 
                memberStatus;
    }

    /* public Society(String societyName) {
        this.societyName = societyName;
    }

    public Society(String societyName, int memberCapacity) {
        this.societyName = societyName;
        this.memberCapacity = memberCapacity;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public int getMemberCapacity() {
        return memberCapacity;
    }

    public void setMemberCapacity(int memberCapacity) {
        this.memberCapacity = memberCapacity;
    }
    */
    
    
    
    
}