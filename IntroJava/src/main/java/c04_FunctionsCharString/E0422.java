package c04_FunctionsCharString;

import java.util.Scanner;

public class E0422 {
    public static void main(String [] args)    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String s1 = input.nextLine();
        System.out.println("Enter the second string: ");
        String s2 = input.nextLine();

        if (s1.contains(s2)) {
            System.out.println(s2 + " is a substring of " + s1);
        }
        else {
            System.out.println(s2 + " is not a substring of " + s1);
        }

        input.close();
    }
} 
