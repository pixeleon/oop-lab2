package net.pixeleon.khpi.oop.labtwo;

import java.io.File;
import java.util.Scanner;

public class DirectoryFiles {
    public static void main(String[] args) {
        String dirName = new Scanner(System.in).nextLine();
        try {
            File dir = new File(dirName);
            if (!dir.isDirectory()) {
                System.out.println("such directory doesn't exist");
            }
            listFiles(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void listFiles(File file) {
        if(file == null) {
            return;
        }
        if (file.isDirectory()) {
            System.out.println("opening " + file.getName() + " directory...");
            for (File f : file.listFiles()) {
                listFiles(f);
            }
            System.out.println("closing " + file.getName() + " directory");

        } else {
            System.out.println(file.getName());
        }
    }
}
