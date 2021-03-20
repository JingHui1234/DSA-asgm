package client;

import adt.SortedArrayList;
import entity.Society;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
/**
 *
 * @author Msi
 */

public class SocietyFile {
        
     public SortedArrayList<Society> reader(String fileName) {
        SortedArrayList<Society> societyList = new SortedArrayList<>();
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
                int targetMemNum = Integer.parseInt(societyDetails[4]);        

                Society society = new Society(societyID, societyName, dateReg, feesPerPerson, targetMemNum);
                societyList.add(society);
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
            writer.write(society.toString());
            writer.newLine();

            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    // rewrite into file
    public void rewrite(SortedArrayList<Society> societyList, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (int i = 1; i <= societyList.getLength(); i++) {
                Society society = societyList.getEntry(i);

                writer.write(society.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

}
