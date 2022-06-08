package c05_Loops;

import java.util.Scanner;

public class E0546 {
    public static void main(String[] args) {

        // enter a string, calculate its length
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String x = input.nextLine();
        int length = x.length();
        StringBuilder rever = new StringBuilder();
    
        // extract each character from the end and attach to reversed string
        for (int k = 1; k <= length; k++){
            char letter = x.charAt(length - k);
            rever.append(letter);
        }

        // print out reversed string
        System.out.println("The reversed string is " + rever);

        input.close();
    }

}
