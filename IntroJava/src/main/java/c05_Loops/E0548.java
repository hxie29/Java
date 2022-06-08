package c05_Loops;

import java.util.Scanner;

public class E0548 {
    public static void main(String[] args) {

        // enter a striing, calculate its length
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String x = input.nextLine();
        int length = x.length();

        // extract each character at even number place
        for (int k = 1; k <= length - 1; k+=2 ){
            char letter = x.charAt(k);
            System.out.print(letter);
        }

        input.close();
    }

}
