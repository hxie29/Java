package c04_FunctionsCharString;

import java.util.Scanner;

public class E0408 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a character:");
        String cha = input.nextLine();
        char ch = cha.charAt(0);

        System.out.println("The ASCII code for character " + cha + " is " + (int)ch );
        
        input.close();
    }
}