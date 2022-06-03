/*  (Computer architecture: bit-level operations) A byte value is stored in 8 bits. Write
a program that prompts the user to enter a byte integer and displays the 8 bits for
the integer. Here are sample runs:
 */

import java.util.Scanner;

public class E0544 {

    public static void main(String[] agrs) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a byte integer:");
    
        byte number = Integer.parseInt(input.nextInt(), 2);
        System.out.println(number);
    }

}
