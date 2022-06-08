package c04_FunctionsCharString;

import java.util.Scanner;

public class E0426 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an amount:");
        String amount = input.nextLine();
        int dot = amount.indexOf(".");
        System.out.println(dot);
        System.out.println("The exact amount is " + amount.substring(0, dot) + "."
        + amount.substring(dot+1));

        input.close();
    }    
}
