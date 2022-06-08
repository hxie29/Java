package c04_FunctionsCharString;

import java.util.Scanner;

public class E0413 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        char letter = input.nextLine().charAt(0);

        String vowel = "aeiouAEIOU";

        if ((Character.toUpperCase(letter) >= 'A') && (Character.toUpperCase(letter) <= 'Z')) {
            if (vowel.contains(letter + "")) {
                System.out.println(letter + " is a vowel.");
            }
            else {
                System.out.println(letter + " is a cosonant.");
            }
        }
        else {
            System.out.println(letter + " is an invalid input.");
        }

        input.close();
    }    
}
