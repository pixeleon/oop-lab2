package net.pixeleon.khpi.oop.labtwo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class GroupSerialization {


    public static void main(String[] args) {
        StudentsGroup group = new StudentsGroup("KH218eng",
                new Student[]{
                        new Student("Bondarenko", "D", 182),
                        new Student("Makieyev", "M", 187),
                        new Student("Sheveliev", "V", 197)
                });
        binarySerialization(group);
        binaryDeserialization();
        xmlSerialization(group);
        xmlDeserialization();
    }

    private static void xmlDeserialization() {
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream("files3//groupxml.xml"))) {
            System.out.println("Reading data from XML file...");
            StudentsGroup loadedgroup = (StudentsGroup) decoder.readObject();
            //printGroup(loadedgroup);
            System.out.println(loadedgroup.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void xmlSerialization(StudentsGroup group) {
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream("files3//groupxml.xml"))) {
            System.out.println("Writing data to XML file...");
            encoder.writeObject(group);
            encoder.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void binaryDeserialization() {
        try (ObjectInputStream deserial = new ObjectInputStream(new FileInputStream("files3//groupdata.dat"))) {
            System.out.println("Reading data from binary file...");
            StudentsGroup loadedGroup = (StudentsGroup) deserial.readObject();
            //printGroup(loadedGroup);
            System.out.println(loadedGroup.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void binarySerialization(StudentsGroup group) {
        try (ObjectOutputStream serial = new ObjectOutputStream(new FileOutputStream("files3//groupdata.dat"))) {
            System.out.println("Writing data to binary file...");
            serial.writeObject(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printGroup(StudentsGroup loadedgroup) {
        System.out.println("Group " + loadedgroup.getGroupID() + ':');
        for (Student st :
                loadedgroup.getStudents()) {
            System.out.println(st.getStudentID() + " : " + st.getLastname());
        }
    }


}
