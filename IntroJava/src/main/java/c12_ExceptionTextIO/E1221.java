package c12_ExceptionTextIO;/*
(Using two files) Write a program that prompts the user to enter the name of an
author and prints the titles of their books. You can use the method of Programming
Exercise 12.14. Assume that you have a file “authors” and a file “books”
created from Programming Exercise 12.19.
*/
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class E1221 {
    public static void main (String[] args) throws Exception{
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
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the author:");
        String author = userInput.nextLine();

        int index = findInFile(author, authorFile);

        if (index == -1) {
            System.out.println("Author " + author + " is not recorded.");
            System.exit(3);
        }
        //else System.out.println("Author " + author + " is at line: " + index);

        // Find all the lines in book file
        ArrayList<String> list = new ArrayList<>();
        try (Scanner input = new Scanner(bookFile)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                int indexSpace = line.indexOf(' ');
                if (indexSpace >= 0) {
                    if (("" + index).equals(line.substring(0, indexSpace))) {
                        list.add(line.substring(indexSpace + 1) );
                    }
                }
            }
        }
        System.out.println(list.toString());

        userInput.close();
    }

    public static int findInFile(String line, File file) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String name = input.nextLine();
                list.add(name);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            index++;
            if (line.equals(list.get(i))) {
                return index;
            }
        }
        return -1;
    }
}
