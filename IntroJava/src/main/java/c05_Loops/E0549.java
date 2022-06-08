package c05_Loops;

import java.util.Scanner;

public class E0549 {
    public static void main(String[] args) {

        // enter a striing, calculate its length
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String x = input.nextLine();
        int length = x.length();
        int vowel = 0;
        int consonants = 0;
        String vowelChar = "AEIOUaeiou";
        
        // extract each character at even number place
        for (int k = 0; k <= length - 1; k++ ){
            char letter = x.charAt(k);
            if (Character.isLetter(letter)) {
                if (vowelChar.contains(letter + "")) {
                    vowel++;
                }
                else
                    consonants++;

            }
        }
        System.out.println("The  number of vowels is " + vowel);
        System.out.println("The  number of consonants is " + consonants);

        input.close();
    }
}
