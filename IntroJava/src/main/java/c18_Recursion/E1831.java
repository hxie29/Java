/*(Find words) Write a program that finds all occurrences of a word in all the files
under a directory, recursively. Pass the parameters from the command line as
follows:
java Exercise18_30 dirName word*/
package c18_Recursion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class E1831 {
    public static void main(String[] args) throws IOException {
        String directory = "/Users/halda/Documents/GitHub/Java/IntroJava_Chap_18/Recursion/src/main/resources/texts/E1831_piano.txt";
        String key = "picasso";
        String newKey = "piano";
        replace(new File(directory), key, newKey);
    }

    private static void replace(File file, String key, String newKey) throws FileNotFoundException {
        if (file.isFile()) {
            // Create a list to store lines modified;
            ArrayList<String> list = new ArrayList<>();
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String line = input.nextLine();
                    if (line.contains(key)) {
                        list.add(line.replaceAll(key, newKey));
                    }
                }
            }
            //  Override file with {stored strings
            try (PrintWriter output = new PrintWriter(file)) {
                for (String line: list) {
                    output.println(line);
                }
            }
        }
        else {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                replace(files[i],key, newKey);
            }
        }
    }
}
