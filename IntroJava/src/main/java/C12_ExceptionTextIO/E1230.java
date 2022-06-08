/*
(Occurrences of each letter) Write a program that prompts the user to enter a
file name and displays the occurrences of each letter in the file. Letters are case
insensitive. Here is a sample run:
Enter a filename: Lincoln.txt
Number of As: 56
Number of Bs: 134
...
Number of Zs: 9
*/
import java.util.Scanner;
import java.io.File;

public class E1230 {
    public static void main(String[] args) throws Exception{
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a filename:");
        String filename = userInput.nextLine();

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File " + filename + " does not exist.");
            System.exit(1);
        }

        int[] count = new int[26];
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String line = input.nextLine().toUpperCase();
                if (line.length() > 0) {
                    for (int i = 0; i < line.length(); i++) {
                        int number = line.charAt(i) - 'A';
                        if (number >= 0 && number <= 25) count[number]++;
                    }
                }
            }
        }
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) System.out.println("Number of " + (char)('A' + i) + "s: " + count[i]);
        }

        userInput.close();
    }
}
