package net.pixeleon.khpi.oop.labtwo;

import java.io.Serializable;
import java.util.Arrays;

public class StudentsGroup implements Serializable {

    private static final long serialVersionUID = -8703059918591240995L;
    private String groupID;
    private Student[] students;

    public StudentsGroup() {
    }

    public StudentsGroup(String groupID, Student[] students) {
        this.groupID = groupID;
        this.students = students;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "StudentsGroup {" +
                "groupID = '" + groupID + '\'' +
                ", students = " + Arrays.toString(students) +
                '}';
    }
}
