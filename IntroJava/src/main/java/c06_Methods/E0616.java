package c06_Methods;

import java.util.Scanner;

public class E0616 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the beginning year:");
        int year1 = input.nextInt();
        System.out.println("Enter the end year:");
        int year2 = input.nextInt();

        displayDaysBetween(year1, year2);
        input.close();
    }
    
    public static void displayDaysBetween(int year1, int year2) {
        System.out.printf("%-10s%10s\n", "Year", "Number of days");
        System.out.println("----------------------");
        // print each year
        for (int year = year1; year <= year2; year++){
            System.out.printf("%-10d%10d\n", year, numberOfDays(year));
        }           
    }

    //find days of the year
    public static int numberOfDays(int year) {
        if ((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0)) {
            return 366;
        }
        else return 365;
    }
       
}
