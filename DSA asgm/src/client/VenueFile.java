package client;



import adt.ArrayList;
import entity.Venue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Ang Chia Ling
 */
public class VenueFile {

     // reading file
    public ArrayList<Venue> reader(String fileName) {
        ArrayList<Venue> venueList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            String currentLine;
            reader = new BufferedReader(new FileReader(fileName));

            while ((currentLine = reader.readLine()) != null) {
                String[] venueDetails = currentLine.split("\\|");

                String venueName = venueDetails[0];
                String venueType = venueDetails[1];
                int venueCapacity = Integer.parseInt(venueDetails[2]);

                Venue venue = new Venue(venueName, venueType, venueCapacity);
                venueList.insert(venue);
            }

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return venueList;
    }

    // write into file
    public void writer(Venue venue, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(venue.getVenueName() + "|" + venue.getType() + "|" + venue.getCapacity());
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    // rewrite into file
    public void rewrite(ArrayList<Venue> venueList, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (int i = 1; i <= venueList.length(); i++) {
                Venue venue = venueList.getEntry(i);
                writer.write(venue.getVenueName() + "|" + venue.getType() + "|" + venue.getCapacity());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
}
