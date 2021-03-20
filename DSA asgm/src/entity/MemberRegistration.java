package entity;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Quah Tze Wei
 */

public class MemberRegistration implements Comparable<MemberRegistration>, Serializable {
    private Society society;
    private Student student;
    private String joinedDate;
    private String position;

    public MemberRegistration() {
    }

    public MemberRegistration(Student student) {
        this.student = student;
    }
    

    public MemberRegistration(Student student, Society society, String position, String joinedDate) {
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
        return student + "|" + society + "|" + position + "|" + joinedDate;
    }

    @Override
    public int compareTo(MemberRegistration otherReg) {
        return this.student.getName().compareTo(otherReg.student.getName());
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
        final MemberRegistration other = (MemberRegistration) obj;
        if (!Objects.equals(this.joinedDate, other.joinedDate)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.society, other.society)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return true;
    }
    
    
}

