package c04_FunctionsCharString;

import java.util.Scanner;

public class E0420 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a social security number DDD-DD-DDDD");
        String ssn = input.nextLine();
        char dash1 = ssn.charAt(3);
        char dash2 = ssn.charAt(6);

        if ((dash1 == '-') && (dash2 == '-')) {
            char d1 = ssn.charAt(0);
            char d2 = ssn.charAt(1);
            char d3 = ssn.charAt(2);
            char d4 = ssn.charAt(4);
            char d5 = ssn.charAt(5);
            char d6 = ssn.charAt(7);
            char d7 = ssn.charAt(8);
            char d8 = ssn.charAt(9);
            char d9 = ssn.charAt(10);

            if ((Character.isDigit(d1)) && (Character.isDigit(d2)) && (Character.isDigit(d3)) && (Character.isDigit(d4)) 
            && (Character.isDigit(d5)) &&(Character.isDigit(d6)) && (Character.isDigit(d7)) && (Character.isDigit(d8)) 
            && (Character.isDigit(d9))) {
                System.out.println(ssn + " is a valid social security number");
            }
            else {
                System.out.println(ssn + " is an invalid social security number");
            }
        }
        else {
                System.out.println(ssn + " is an invalid social security number");
            } 
        input.close();
    }
}
