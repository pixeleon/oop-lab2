package net.pixeleon.khpi.oop.labtwo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SortingFileIntegers {

    public static class NegativeIntegerException extends Exception {

        private final int wrongValue;

        public NegativeIntegerException(int wrongValue) {
            this.wrongValue = wrongValue;
        }

        public int getWrongValue() {
            return wrongValue;
        }
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void sortIntegersByDigitsSum(String fileIn, String fileOutAsc, String fileOutDesc)
            throws NegativeIntegerException, FileNotFoundException, InputMismatchException {
        Scanner scanner = new Scanner(new FileReader(fileIn));
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number < 0) {
                throw new NegativeIntegerException(number);
            }
            list.add(number);
        }
        try (PrintWriter writerAsc = new PrintWriter(fileOutAsc)) {
            list.sort((i1, i2) -> Integer.compare(sumOfDigits(i1), sumOfDigits(i2)));
            for (Integer x : list) {
                writerAsc.print(x + " ");
            }
        }
        try (PrintWriter writerDesc = new PrintWriter(fileOutDesc)) {
            list.sort((i1, i2) -> -Integer.compare(sumOfDigits(i1), sumOfDigits(i2)));
            for (Integer x : list) {
                writerDesc.print(x + " ");
            }
        }
    }

    public static void main(String[] args) {
        try {
            sortIntegersByDigitsSum("files2//input.txt", "files2//output1.txt", "files2//output2.txt");
        } catch (NegativeIntegerException e) {
            e.printStackTrace();
            System.out.println("negative number in file: " + e.getWrongValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("such file cannot be found");
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("non-integer number in file");
        }
    }
}
