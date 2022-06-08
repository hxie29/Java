package c03_Selections;

import java.util.Scanner;

public class E0311 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the month: ");
        int month = input.nextInt();
        System.out.println("Please enter days after year: ");
        int year = input.nextInt();

        switch (month) {
            case 1 -> System.out.print("January");
            case 2 -> System.out.print("Feb");
            case 3 -> System.out.print("March");
            case 4 -> System.out.print("April");
            case 5 -> System.out.print("May");
            case 6 -> System.out.print("June");
            case 7 -> System.out.print("July");
            case 8 -> System.out.print("August");
            case 9 -> System.out.print("Sep");
            case 10 -> System.out.print("Oct");
            case 11 -> System.out.print("November");
            case 12 -> System.out.print("December");
        }

        System.out.print(" " + year + " has");
        if ( (month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12) ) {
                System.out.println("31 days");
            }
        else if (month == 2) {
            if (year % 4 == 0) {
                    System.out.println("29 days");
                }
                else 
                System.out.println("28 days");
            }
        else {
            System.out.println("30 days");
        }  

    input.close();
    }
}

