/* (Frequency of characters) Write a program that prompts the user to enter the
name of an ASCII text file and displays the frequency of the characters in the file.
*/

import java.io.*;

public class E1716 {
    public static void main(String[] args) throws IOException {

        //Create a random text file with 1000 characters;
        File file = new File("test.txt");
        try (PrintWriter output = new PrintWriter(file)) {
            for (int i = 0; i < 1000; i++) {
                output.print((char)((int)(Math.random() * 256)));
            }
        }

        //Count character's amount
        int[] count = new int[256];
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
            int r;
            while ((r = input.read()) != -1) {
                count[r]++;
            }
        }
        
        File countFile = new File("test_count.txt");
        try (PrintWriter outputCharacter = new PrintWriter(countFile)) {
            for (int i = 0; i < count.length; i++) {
                outputCharacter.println((char)i + " Times: " + count[i]);
            }
        }


    }  
}
