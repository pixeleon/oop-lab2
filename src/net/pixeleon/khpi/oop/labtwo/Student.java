package net.pixeleon.khpi.oop.labtwo;

import java.io.Serializable;


public class Student implements Serializable {
    private static final long serialVersionUID = 6150623059696093340L;
    private String lastname;
    private String firstname;
    private int studentID;

    public Student(String lastname, String firstname, int studentID) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.studentID = studentID;
    }

    public Student() {
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Student {" +
                "lastname = '" + lastname + '\'' +
                ", firstname = '" + firstname + '\'' +
                ", studentID = " + studentID +
                '}';
    }
}
