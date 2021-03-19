/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import adt.SortedLinkedList;
import entity.Society;
import entity.SocietyMemberRegistration;
import entity.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

/**
 *
 * @author Quah Tze Wei
 */
public class MemberRegFile {
    
    public SortedLinkedList<SocietyMemberRegistration> reader (String fileName){
        SortedLinkedList <SocietyMemberRegistration> memberRegistrationList = new SortedLinkedList<>();
        BufferedReader reader = null;
        
        try {
            String currentLine;
            reader = new BufferedReader(new FileReader(fileName));
            
            while ((currentLine = reader.readLine()) != null){
                String[] memberRegDetails = currentLine.split("\\|");
                
                String name = memberRegDetails[0];
                String studentID = memberRegDetails[1];
                String contactNo = memberRegDetails[2];
                String programme = memberRegDetails[3];
                String societyName = memberRegDetails[4];
                String position = memberRegDetails[5];
                String joinedDate = memberRegDetails[6];
                
                Student student = new Student(name, studentID, contactNo, programme);
                Society society = new Society(societyName);
                SocietyMemberRegistration registration = new SocietyMemberRegistration(student, society, position, joinedDate);
                memberRegistrationList.add(registration);
            }
        } catch (Exception e) {
            memberRegistrationList = null;
        }
        return memberRegistrationList;
    }
    
    public void writer(SocietyMemberRegistration registration, String fileName){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(fileName, true));
            
            writer.write(registration.toString());
            writer.newLine();
            
            writer.close();
            
        }catch (Exception e){
            System.out.println("" + e);
        }
    }
    
    public void rewrite(SortedLinkedList<SocietyMemberRegistration> memberRegistrationList, String fileName){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(fileName));
            
            for (int i = 0; i < memberRegistrationList.getLength(); i++){
                SocietyMemberRegistration registration = memberRegistrationList.getEntry(i+1);
                
                writer.write(registration.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e){
            System.out.println("" + e);
        }
    }
}
