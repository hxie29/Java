/*(Display words in descending alphabetical order) Write a program that reads
words from a text file and displays all the words (duplicates allowed) in
descending alphabetical order. The words must start with a letter. The text file
is passed as a command-line argument.*/
package c20_ListStackQueue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class E2001 {
    public static void main(String[] args) {
        //Read a text file name and create File handle
        if (args.length != 1) {
            System.out.println("Usage: java E2001 filePath");
            System.exit(1);
        }

        File file = new File(args[0]);
        if(!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(2);
        }
        ArrayList<String> wordList = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String word = input.next();
                if (word.length() > 0 && Character.isLetter(word.charAt(0))) {
                    wordList.add(word);
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        // Reverse order but with cases
        wordList.sort(Comparator.reverseOrder());
        wordList.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // Reverse order ignoring cases
        wordList.sort(String::compareToIgnoreCase);
        Collections.reverse(wordList);
        wordList.forEach(s -> System.out.print(s + " "));
    }
}
