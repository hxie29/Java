package c05_Loops;

import java.util.Scanner;

public class E05L12 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the inflation rate:");
        double compound = 1 + input.nextDouble();
        double tuition = 1000;
        int year = 0;
        while (tuition < 2000) {
            tuition *= compound;
            year++;
            }
        System.out.println("At year " + year + " the tuition will be doubled.");   
        System.out.printf("The tuition will be $%.2f in %1d years.", tuition, year);   
        input.close();
        }
    }    
