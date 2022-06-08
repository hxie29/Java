package c05_Loops;

import java.util.Scanner;

public class E0528 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the year");
        int year = input.nextInt();
        boolean leap = (year % 4 == 0);
        
        System.out.println("Enter the first day of the year (0~6 for Sunday to Saturday):");
        int janDay = input.nextInt();
        int monthDay = 0;

        //print out line for each month
        for (int k = 1; k <= 12; k++) {

            // print out month 
            switch (k) {
                case 1 -> System.out.print("January");
                case 2 -> System.out.print("February");
                case 3 -> System.out.print("March");
                case 4 -> System.out.print("April");
                case 5 -> System.out.print("May");
                case 6 -> System.out.print("June");
                case 7 -> System.out.print("July");
                case 8 -> System.out.print("August");
                case 9 -> System.out.print("September");
                case 10 -> System.out.print("October");
                case 11 -> System.out.print("November");
                case 12 -> System.out.print("December");
            }

            System.out.print(" 1, " + year + " is ");

            // calculate day of following month
            if (k == 1) {
                monthDay = janDay;
            }

            // calculate March after !leap year
            else if ((k == 3) && leap) {
                monthDay += 29;
            }
            else if (k == 3) {
                monthDay +=28;
            }

            // the month after a 30-day month
            else if ((k == 5) || (k == 7) || (k == 10) || (k == 12)) {
                monthDay += 30;
            }

            else {
                monthDay += 31;
            }

            // print out
            switch (monthDay % 7) {
                case 0 -> System.out.println("Sunday");
                case 1 -> System.out.println("Monday");
                case 2 -> System.out.println("Tuesday");
                case 3 -> System.out.println("Wednesday");
                case 4 -> System.out.println("Thursday");
                case 5 -> System.out.println("Friday");
                case 6 -> System.out.println("Saturday");
            }
        }
        input.close();
    }    
}
