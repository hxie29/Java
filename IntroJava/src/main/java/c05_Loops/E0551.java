package c05_Loops;

import java.util.Scanner;

public class E0551 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // input two strings, check min length
        System.out.println("Enter a string");
        String sen1 = input.nextLine();
        System.out.println("Enter another string");
        String sen2 = input.nextLine();
        int length = Math.min(sen1.length(), sen2.length());
        //System.out.println("Check for string length of " + length);
        
        // find common prefix character by character
        String prefix = "";
        for (int n = 0; n < length; n++) {
            if (sen1.charAt(n) == sen2.charAt(n)) {
                prefix += sen1.charAt(n);
            }
            //the loop should end immediately if a character doesn't match! (otherwise the loop will find other characters at same spots)
            else break;
        }

        // print out results
        if (prefix.length() == 0) {
            System.out.println(sen1 + " and " + sen2 + " has no common prefix.");
        }
        else {
            System.out.println("The common prefix is " + prefix);
        }

        input.close();
    }
}
