/*(Display words in ascending alphabetical order) Rewrite Programming Exercise
20.1 using streams.*/

/*(Display words in descending alphabetical order) Write a program that reads
words from a text file and displays all the words (duplicates allowed) in
descending alphabetical order. The words must start with a letter. The text file
is passed as a command-line argument.*/
package c30_CollectionStreams;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class E3015 {
    public static void main(String[] args) {
        //Read a text file name and create File handle
        Scanner input0 = new Scanner(System.in);
        System.out.println("Enter file path:");
        String path = input0.nextLine();

        File file = new File(path);
        if(!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(1);
        }
        ArrayList<String> wordList = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String word = input.next();
                if (word.length() > 0 && Character.isLetter(word.charAt(0))) {
                    wordList.add(word);
                }
            }
            Stream.of(wordList.toArray()).sorted().forEach(System.out::println);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
