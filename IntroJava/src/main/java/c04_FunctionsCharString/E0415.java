package c04_FunctionsCharString;

import java.util.Scanner;

public class E0415 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        char letter = input.nextLine().charAt(0);
        char capitaLetter = Character.toUpperCase(letter);

        if (capitaLetter <= 'Z' && capitaLetter >= 'A' ) {
            System.out.print( "The corresponding number of " + letter + " is ");
            if ("ABC".contains(capitaLetter + "")) {
                System.out.println(2);
            }
            else if ("DEF".contains(capitaLetter + "")) {
                System.out.println(3);
            }
            else if ("GHI".contains(capitaLetter + "")) {
                System.out.println(4);
            }
            else if ("JKL".contains(capitaLetter + "")) {
                System.out.println(5);
            }
            else if ("MNO".contains(capitaLetter + "")) {
                System.out.println(6);
            }
            else if ("PQRS".contains(capitaLetter+ "")) {
                System.out.println(7);
            }
            else if ("TUV".contains(capitaLetter+ "")) {
                System.out.println(8);
            }
            else if ("WXYZ".contains(capitaLetter+ "")) {
                System.out.println(9);
            }
        }
        else {
            System.out.println(letter + " is an invalid input.");
        }

        input.close();
    }
}
