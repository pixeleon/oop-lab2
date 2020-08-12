package net.pixeleon.khpi.oop.labtwo.zips;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingFromZip {
    public static void main(String[] args) {
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream("archivedgroup.zip"))) {
            try (DataInputStream dataIn = new DataInputStream(zipIn)) {
                ZipEntry zipEntry;
                while ((zipEntry = zipIn.getNextEntry()) != null) {
                    System.out.print(zipEntry.getName() + ": ");
                    System.out.println(dataIn.readUTF() + ' ' + dataIn.readUTF());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
