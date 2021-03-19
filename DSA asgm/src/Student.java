/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Quah Tze Wei
 */
public class Student implements Comparable<Student>, Serializable {
    private String name;
    private String studentID;
    private String contactNo;
    private String programme;


    public Student(String name, String studentID, String contactNo, String programme) {
        this.name = name;
        this.studentID = studentID;
        this.contactNo = contactNo;
        this.programme = programme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentID, other.studentID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "|" + studentID + "|" + contactNo + "|" + programme;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return this.name.compareTo(otherStudent.name);
    }
    
}
