package c12_ExceptionTextIO;/* (Reading in a sorted file) Write a method public static int
readInFile(String line, File file) that returns the position number
of a line in the file filename or −1 if there is no such line or file.
We assume that this file contains names of people with a name per line.
Names (and hence lines) are listed in ascending alphabetical order in the file.
We can not find the same line twice.
*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
public class E1214 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println("Usage: java E1214.java line filename");
            System.exit(1);
        }
        String line = args[0];

        File file = new File(args[1]);
        if (!file.exists()) {
            System.out.println(args[1] + " does not exist.");
            System.exit(2);
        }

        System.out.println(line + " in file " + args[1] + " : " + readInFile(line, file));

    }

    public static int readInFile(String line, File file) throws FileNotFoundException {
        int count = 0;
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String name = input.nextLine();
                count++;
                if (line.equals(name)) return count;
            }
        }
        return -1;
    }
}
