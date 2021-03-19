package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Quah Tze Wei
 */

public class SocietyMemberRegistration implements Comparable<SocietyMemberRegistration>, Serializable {
    private Society society;
    private Student student;
    private String joinedDate;
    private String position;

    public SocietyMemberRegistration() {
    }

    public SocietyMemberRegistration(Student student) {
        this.student = student;
    }
    

    public SocietyMemberRegistration(Society society, Student student, String joinedDate, String position) {
        this.society = society;
        this.student = student;
        this.joinedDate = joinedDate;
        this.position = position;
    }

    public SocietyMemberRegistration(Student student, Society society, String position, String joinedDate) {
        this.student = student;
        this.society = society;
        this.position = position;
        this.joinedDate = joinedDate;
    } 

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return student + "|" + society.getSocietyName() + "|" + position + "|" + joinedDate;
    }

    @Override
    public int compareTo(SocietyMemberRegistration otherReg) {
        return this.student.getName().compareTo(otherReg.student.getName());
    }
    
}

