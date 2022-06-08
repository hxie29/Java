package c05_Loops;

import java.util.Scanner;

public class E0532 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //get guesses 
        System.out.println("Enter your guess for first number:");
        int guess1 = input.nextInt();
        System.out.println("Enter your guess for second number:");
        int guess2 = input.nextInt();

        // generate two different lottery numbers
        int n1 = (int)(Math.random() * 10);
        int n2 = n1;
        while(n1 == n2) {
            n2 = (int)(Math.random() * 10);
        }

        // check result and print
        System.out.println("The lottery numbers are " + n1 + ", " + n2);
        System.out.println(((guess1 == n1) && (guess2 == n2)) ? "You won!" : "Try next time!");

        input.close();
    }
    
}
