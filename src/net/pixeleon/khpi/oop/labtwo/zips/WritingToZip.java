package net.pixeleon.khpi.oop.labtwo.zips;

import net.pixeleon.khpi.oop.labtwo.Student;
import net.pixeleon.khpi.oop.labtwo.StudentsGroup;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WritingToZip {

    public static void main(String[] args) {
        StudentsGroup group = new StudentsGroup("KH218eng",
                new Student[]{
                        new Student("Bondarenko", "D", 182),
                        new Student("Makieyev", "M", 187),
                        new Student("Sheveliev", "V", 197)
                });

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("archivedgroup.zip"))) {
            try (DataOutputStream dataOut = new DataOutputStream(zipOut)) {
                for (Student st : group.getStudents()) {
                    ZipEntry zipEntry = new ZipEntry(String.valueOf(st.getStudentID()));
                    zipOut.putNextEntry(zipEntry);
                    dataOut.writeUTF(st.getLastname());
                    dataOut.writeUTF(st.getFirstname());
                    zipOut.closeEntry();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
