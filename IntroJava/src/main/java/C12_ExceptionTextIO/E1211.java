/*
(Remove text) Write a program that removes all the occurrences of a specified
string from a text file. For example, invoking java Exercise12_11 John filename
removes the string John from the specified file. Your program should get the
arguments from the command line.
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
public class E1211 {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java RemoveText Filename");
            System.exit(1);
        }

        String key = args[0];
        //System.out.println(key);
        String filename = args[1];
        //System.out.println(filename);
        
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(2);
        }

        Scanner input = new Scanner(file);
        input.useDelimiter(" ");
        ArrayList<String> text = new ArrayList<>();
        while (input.hasNext()) {
            String s1 = input.nextLine();
            String s2 = s1.replaceAll(key, "");
            text.add(s2);
        }
        System.out.println(text.toString());

        try (PrintWriter output = new PrintWriter(file)) {
           for (int i = 0; i < text.size(); i++ ) {
               output.println(text.get(i));
           }
        }

        input.close();

    }

}
