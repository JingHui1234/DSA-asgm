/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dsa.asgm.Society;
import dsa.asgm.HashSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
/**
 *
 * @author Msi
 */

public class ReadFile {
        
     public HashSet<Society> reader(String fileName) {
        HashSet<Society> societyList = new HashSet<>();
        BufferedReader reader = null;

        try {
            String currentLine;
            reader = new BufferedReader(new FileReader(fileName));

            while ((currentLine = reader.readLine()) != null) {
                String[] societyDetails = currentLine.split("\\|");

                int societyID = Integer.parseInt(societyDetails[0]);
                String societyName = societyDetails[1];
                String dateReg = societyDetails[2];
                double feesPerPerson = Double.parseDouble(societyDetails[3]);
                int members = Integer.parseInt(societyDetails[4]);

                Society society = new Society(societyID, societyName, dateReg, feesPerPerson, members);
                societyList.insert(society);
            }

        } catch (Exception e) {
            societyList = null;
        }
        return societyList;
    }

    // write into file
    public void writer(Society society, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(society.getSocietyID() + "|" + society.getSocietyName() + "|" + society.getDateReg() + 
                    society.getFeesPerPerson() + "|" + society.getMembers());
            writer.newLine();

            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    // rewrite into file
    public void rewrite(HashSet<Society> societyList, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (int i = 1; i <= societyList.length(); i++) {
                Society society = societyList.getEntry(i);

                writer.write(society.getSocietyID() + "|" + society.getSocietyName() + "|" + society.getDateReg() + 
                    society.getFeesPerPerson() + "|" + society.getMembers());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

}
