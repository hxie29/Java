package c12_ExceptionTextIO;/*
(Linking two files) Write a program that prompts the user to enter the name of
an author and the title of one their books. It writes the author’s name to a file
by using the method written in Programming Exercise 12.15. Their book’s title
is written at the end of a file Books.txt with the line number of the author’s
name in Authors.txt inserted before the title. Assume that the title is not
already stored in Books.txt and the author name is already in Authors.txt.
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
public class E1219 {
    public static void main(String[] args) throws Exception {
        
        // Create handle for author file
        File authorFile = new File("Author.txt");
        if (!authorFile.exists()) {
            System.out.println("Author file does not exist.");
            System.exit(1);
        }
        
        // Create handle for book file
        File bookFile = new File("Books.txt");
        if (!bookFile.exists()) {
            System.out.println("Book file does not exist.");
            System.exit(2);
        }

        // Taking input from user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the author:");
        String author = input.nextLine();
        System.out.println("Enter the name of the book:");
        String book = input.nextLine();
        
        //Write the author name in the file
        int index = writeInFile(author, authorFile);
        if (index > 0) System.out.println("Author " + author + " added at line: " + index);
        else if (index == -1) System.out.println("Author " + author + " exists on the list." );

        //Write book name in the file
        writeBookFile(index, book, bookFile);

        input.close();
    }

    public static int writeInFile(String line, File file) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String name = input.nextLine();
                list.add(name);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (line.compareTo(list.get(i)) < 0) {
                index = i;
                list.add(index, line);
                break;
            }
            if (line.compareTo(list.get(i)) == 0) {
                index = -1;
                break;
            }
            if (line.compareTo(list.get(i)) > 0 && i == list.size() - 1) {
                list.add(line);
                index = i+1;
                break;
            }
        }

        try (PrintWriter output = new PrintWriter(file)) {
            for (int i = 0; i < list.size(); i++) {
                output.println(list.get(i));
            }
        }

        return ++index;
    }

    public static void writeBookFile(int index, String book, File bookFile) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner input = new Scanner(bookFile)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                list.add(line);
            }
        }
        list.add("" + index + " " + book);

        try (PrintWriter output = new PrintWriter(bookFile)) {
            for (int i = 0; i < list.size(); i++) {
                output.println(list.get(i));
            }
        }
        System.out.println("Book " + book + " added to Books.txt");
    }
}
