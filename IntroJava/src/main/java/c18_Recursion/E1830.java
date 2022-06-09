/*(Find words) Write a program that finds all occurrences of a word in all the files
under a directory, recursively. Pass the parameters from the command line as
follows:
java Exercise18_30 dirName word*/
package c18_Recursion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class E1830 {
    public static void main(String[] args) throws IOException {
        String directory = "/Users/halda/Desktop/piano score";
        String key = "piano";
        System.out.println(key + " appears " + getOccur(new File(directory), key) + " times.");
    }

    private static int getOccur(File file, String key) throws FileNotFoundException {
        int count = 0;
        if (file.isFile()) {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String word = input.next();
                    if (word.contains(key)) {
                        count++;
                    }
                }
            }
        } else {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                count += getOccur(files[i], key);
            }
        }
        return count;
    }
}
