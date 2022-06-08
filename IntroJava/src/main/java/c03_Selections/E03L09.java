package c03_Selections;

import java.util.Scanner;

public class E03L09 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = input.nextInt();

        switch (year % 12) {
            case 0 -> System.out.println("The year " + year + " is the year of monkey.");
            case 1 -> System.out.println("The year " + year + " is the year of rooster.");
            case 2 -> System.out.println("The year " + year + " is the year of dog.");
            case 3 -> System.out.println("The year " + year + " is the year of pig.");
            case 4 -> System.out.println("The year " + year + " is the year of rat.");
            case 5 -> System.out.println("The year " + year + " is the year of ox.");
            case 6 -> System.out.println("The year " + year + " is the year of tiger.");
            case 7 -> System.out.println("The year " + year + " is the year of rabbit.");
            case 8 -> System.out.println("The year " + year + " is the year of dragon.");
            case 9 -> System.out.println("The year " + year + " is the year of snake.");
            case 10 -> System.out.println("The year " + year + " is the year of horse.");
            case 11 -> System.out.println("The year " + year + " is the year of sheep.");
        }
    input.close();
    }
    
}
