package c06_Methods;

import java.util.Scanner;

public class E0634 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // to enter the year
        System.out.println("Enter a year:");
        int year = input.nextInt();

        // to enter the month
        System.out.println("Enter a month (from 1 to 12):");
        int month = input.nextInt();

        // print calendar
        printCalendar(month, year);
        input.close();
    }
    
    public static int getStartDay(int month, int year) {
        return (26*(month + 1)/10 + 5* (year % 100) /4 + 21* (year /100) / 4) % 7;
    }

    public static void printCalendar(int month, int year) {
        printMonthTitle(month, year);
        printMonthBody(month, year);
    }
    
    
    public static void printMonthTitle(int month, int year) {
        System.out.printf("%25s %-4d\n", getMonthName(month), year);
        System.out.println("-------------------------------------------------------");
        System.out.printf("%7s%7s%7s%7s%7s%7s%7s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
    }
    
    public static String getMonthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "Feburary";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
    }

    public static void printMonthBody(int month, int year) {
        for (int i = getStartDay(month, year); i > 0; i--) {
            System.out.print("       ");
        }
        for (int i = 1; i <= getTotalNumbersOfDaysThisMonth(month, year); i++) {
            System.out.printf("%7d", i);
            // swith a line if item of the line is 7
            if ((i + getStartDay(month, year)) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static int getTotalNumbersOfDaysThisMonth(int month, int year) {
        if ( (month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12) ) {
            return 31;
        }
        if (month == 2) {
            return leapYear(year) ? 29 : 28;
        }
        else return 30;
    }

    public static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 !=0) || (year % 400 == 0);
    }

}
