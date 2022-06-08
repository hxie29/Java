package c05_Loops;

import java.util.Scanner;

public class E0529 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the year");
        int year = input.nextInt();
        boolean leap = (year % 4 == 0);
        System.out.println("Enter the first day of the year (0~6 for Sunday to Saturday):");
        int monthFirstDay = input.nextInt();
        int totalDayLastMonth;
        String month = "";
        int monthTotalDay = 0;

        //print out line for each month
        for (int n = 1; n <= 12; n++) {
            // print out month 
            totalDayLastMonth = monthTotalDay;
            switch (n) {
                case 1 -> {
                    month = "January";
                    monthTotalDay = 31;
                }
                case 2 -> {
                    month = "Feburary";
                    monthTotalDay = (leap) ? 29 : 28;
                }
                case 3 -> {
                    month = "March";
                    monthTotalDay = 31;
                }
                case 4 -> {
                    month = "April";
                    monthTotalDay = 30;
                }
                case 5 -> {
                    month = "May";
                    monthTotalDay = 31;
                }
                case 6 -> {
                    month = "June";
                    monthTotalDay = 30;
                }
                case 7 -> {
                    month = "July";
                    monthTotalDay = 31;
                }
                case 8 -> {
                    month = "August";
                    monthTotalDay = 31;
                }
                case 9 -> {
                    month = "September";
                    monthTotalDay = 30;
                }
                case 10 -> {
                    month = "October";
                    monthTotalDay = 31;
                }
                case 11 -> {
                    month = "November";
                    monthTotalDay = 30;
                }
                case 12 -> {
                    month = "December";
                    monthTotalDay = 31;
                }
            }
            monthFirstDay = (monthFirstDay + totalDayLastMonth) % 7;

            //print out title
            System.out.printf("%25s %-4d \n", month, year);
            System.out.println("--------------------------------------------------------");
            System.out.printf("%7s%7s%7s%7s%7s%7s%7s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");

            // find the spot for the first day of the month
            for (int k = monthFirstDay; k > 0; k--) {
                System.out.print("       ");
            }   
            // start from first day of the month
            for (int k = 1; k <= monthTotalDay; k++) {
                System.out.printf("%7d", k);
                // swith a line if item of the line is 7
                if ((k + monthFirstDay) % 7 == 0) {
                    System.out.println();
                }
            }
            //swith line twice for next month calendar
            System.out.println("\n");
        }


        input.close();
    }    
}
